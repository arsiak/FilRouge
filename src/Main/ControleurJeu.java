package Main;

import java.io.IOException;
import java.util.Scanner;

import Bdd.ChargementParam;
import Cartes.Carte;
import Combat.Combat;
import Panneau.Menu;
import Personnages.Equipe;
import Personnages.Personnage;
import Quetes.Pnj;

import Bdd.ChargementParam;
import Cartes.*;
import Combat.Combat;
import Equipements.Amulette;
import Equipements.Bombe;
import Equipements.Bouclier;
import Equipements.Casque;
import Equipements.Epee;
import Equipements.Objet;
import Panneau.Menu;
import Panneau.MenuEquipe;
import Personnages.Equipe;
import Personnages.Guerrier;
import Personnages.Paladin;
import Personnages.Personnage;
import Quetes.Pnj;
import Quetes.PnjKaramel;

public class ControleurJeu {
//	
//	public ControleurJeu() {}
//	// TODO Auto-generated constructor stub
//	
//	
//	ChargementParam param = new ChargementParam();
//	Personnage perso = new Guerrier("Elias",'@', param.getCoordPerso());
//	perso.ajouterEquipement(new Epee());
//	//perso.ajouterEquipement(new Amulette());
//	perso.ajouterEquipement(new Casque());
//	Equipe equipe = new Equipe ("Votre équipe", perso);
//	equipe.ajouterPersonnage(new Paladin("Poppy",'P', new Objet[] {new Epee(), new Bouclier()}));
//	Pnj pnjKaramel = new PnjKaramel();
//	Carte carte = param.getCoordCarte();
//	Combat combat;
//
//	carte.setDeplacementPerso(perso);
//	//carte.afficher();
//
//	Scanner sc = new Scanner(System.in);
//	
//	
//	
//	char saisie;
//	int personnage_pas = 0, combat_apparition = (int)(Math.floor(Math.random()*5 + 5));;
//
//	boolean mouvement = true;
//
//	while (mouvement == true) {
//
//		carte.placer(perso.getCoord(), '@');
//		carte.afficher();
//		carte.enlever(perso.getCoord());
//
//		switch (saisie = sc.nextLine().charAt(0)) {
//
//		case 'z':
//			perso.mvtHaut();
//			if (carte.bloque(perso)) { 
//				if (carte.elementCarte(perso).equals("Karamel")) {
//					 pnjKaramel.deroulementQueteC(perso);
//				  }
//				perso.mvtBas(); }
//			break;
//
//		case 's':
//			perso.mvtBas();
//			if (carte.bloque(perso)) { perso.mvtHaut(); }
//			break;
//
//		case 'q':
//			perso.mvtGauche();
//			if (carte.bloque(perso)) { perso.mvtDroite(); }
//			break;
//
//		case 'd':
//			perso.mvtDroite();
//			if (carte.bloque(perso)) { perso.mvtGauche(); }
//			break;
//		
//		case 't': 
//			param.saveCoordPerso(perso);
//			param.saveCoordCarte(carte);
//			System.out.println("Partie sauvegardée.");
//			break;
//			
//		case 'm':
//			new Menu(equipe);
//			break;
//		}
//		
//
//		//carte.setDeplacementPerso(p);
//		if (carte.estChange(perso) == true) { 
//			if (carte.getCarte_nom().contains("Donjon")) {
//				
//				personnage_pas = 0;
//				combat_apparition = (int)(Math.floor(Math.random()*5 + 5));
//			}
//			carte = carte.changementCarte(perso);
//			System.out.println("Vous entrez sur la carte" +carte.getCarte_nom());
//			carte.setDeplacementPerso(perso);
//			
//		}
//		if (carte.getCarte_nom().contains("Donjon")) {
//			
//			personnage_pas++;
//			if (personnage_pas == combat_apparition) {
//				try {
//					combat = new Combat(equipe);
//					if (combat.getGameOver() == true) {
//						mouvement = false;
//					}
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				personnage_pas = 0;
//				combat_apparition = (int)(Math.floor(Math.random()*5 + 5));
//			}
//		}
//	}
//	sc.close();
//
//		
//}
}

