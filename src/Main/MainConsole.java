package Main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Bdd.ChargementParam;
import Cartes.*;
import Combat.Combat;
import Equipements.Amulette;
import Equipements.Bombe;
import Equipements.Bouclier;
import Equipements.Casque;
import Equipements.Epee;
import Equipements.Objet;
import Equipements.ObjetQuete;
import Panneau.Menu;
import Panneau.MenuEquipe;
import Panneau.MenuInitialisation;
import Personnages.Equipe;
import Personnages.Guerrier;
import Personnages.Mage;
import Personnages.Paladin;
import Personnages.Personnage;
import Quetes.Pnj;
import Quetes.PnjKaramel;
import Quetes.PnjPerlin;
import Quetes.PnjPoppy;
import Quetes.PnjRomuald;

public class MainConsole {

	public static void main(String[] args) throws IOException {

		Personnage perso = new Personnage();
		Carte carte = new Carte();
		Pnj pnjKaramel = new PnjKaramel();
		Pnj pnjMaria = new PnjKaramel();
		Pnj pnjRomuald = new PnjRomuald();
		Pnj pnjPerlin = new PnjPerlin();
		Pnj pnjPoppy = new PnjPoppy();
		
		ChargementParam param = new ChargementParam();
		MenuInitialisation init = new MenuInitialisation(param);
		perso = new Guerrier("Elias",'@', param.getCoordPerso());
		perso.ajouterEquipement(new Epee());
		perso.ajouterEquipement(new Casque());
		perso.ajouterEquipement(new ObjetQuete("blablabla"));
		Equipe equipe = new Equipe ("Votre équipe", perso);
		//init.accueil();
		init.demarrage(perso,carte);
		Paladin poppy = new Paladin("Poppy",'P');
		poppy.ajouterEquipement(new Epee());
		poppy.ajouterEquipement(new Bouclier());
		Mage maria = new Mage("Maria",'M');
		maria.ajouterEquipement(new Amulette());
		equipe.ajouterPersonnage(poppy);
		equipe.ajouterPersonnage(maria);
		carte = param.getCoordCarte();
		Combat combat;

		carte.setDeplacementPerso(perso);
		
		
		

		Scanner sc = new Scanner(System.in);
		char saisie;
		int personnage_pas = 0, combat_apparition = (int)(Math.floor(Math.random()*5 + 5));;

		boolean mouvement = true;

		while (mouvement == true) {

			carte.placer(perso.getCoord(), '@');
			carte.afficher();
			carte.enlever(perso.getCoord());

			switch (saisie = sc.nextLine().charAt(0)) {

			case 'z':
				perso.mvtHaut();
				if (carte.bloque(perso)) { 
					if (carte.elementCarte(perso).equals("Karamel")) {
						 pnjKaramel.deroulementQueteC(perso);
					  }
					perso.mvtBas(); }
				break;

			case 's':
				perso.mvtBas();
				if (carte.bloque(perso)) { perso.mvtHaut(); }
				break;

			case 'q':
				perso.mvtGauche();
				if (carte.bloque(perso)) {
					if (carte.elementCarte(perso).equals("Romuald")) {
						 pnjRomuald.deroulementQueteC(perso);
					}
					perso.mvtDroite(); }
				break;

			case 'd':
				perso.mvtDroite();
				if (carte.bloque(perso)) { 
					if (carte.elementCarte(perso).equals("Maria")) {
						 pnjMaria.deroulementQueteC(perso);
					}
					perso.mvtGauche(); }
				break;
			
			case 't': 
				param.saveCoordPerso(perso);
				param.saveCoordCarte(carte);
				System.out.println("Partie sauvegardée.");
				break;
				
			case 'm':
				new Menu(equipe);
				break;
			}
			

			//carte.setDeplacementPerso(p);
			if (carte.estChange(perso) == true) { 
				if (carte.getCarte_nom().contains("Donjon")) {
					
					personnage_pas = 0;
					combat_apparition = (int)(Math.floor(Math.random()*5 + 5));
				}
				carte = carte.changementCarte(perso);
				System.out.println("Vous entrez sur la carte" +carte.getCarte_nom());
				carte.setDeplacementPerso(perso);
				
			}
			if (carte.getCarte_nom().contains("Donjon")) {
				
				personnage_pas++;
				if (personnage_pas == combat_apparition) {
					try {
						combat = new Combat(equipe);
						if (combat.getGameOver() == true) {
							mouvement = false;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					personnage_pas = 0;
					combat_apparition = (int)(Math.floor(Math.random()*5 + 5));
				}
			}
		}
		sc.close();

	}

}
