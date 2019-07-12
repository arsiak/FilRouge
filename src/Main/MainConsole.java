package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Bdd.ChargementParam;
import Bdd.SauvegardeParam;
import Cartes.*;
import Combat.Combat;
import Objets.*;
import Panneau.Menu;
import Panneau.MenuEquipe;
import Panneau.PanneauInitialisation;
import Personnages.Equipe;
import Personnages.Guerrier;
import Personnages.Mage;
import Personnages.Paladin;
import Personnages.Personnage;
import Quetes.Pnj;
import Quetes.PnjKaramel;
import Quetes.PnjMaria;
import Quetes.PnjPerlin;
import Quetes.PnjPoppy;
import Quetes.PnjRomuald;
import Tresors.Tresor;

public class MainConsole {

	public static void main(String[] args) throws IOException {

		
		Carte carte = new Carte();
		Pnj pnjKaramel = new PnjKaramel();
		Pnj pnjMaria = new PnjMaria();
		Pnj pnjRomuald = new PnjRomuald();
		PnjPerlin pnjPerlin = new PnjPerlin();
		PnjPoppy pnjPoppy = new PnjPoppy();
		
		//ChargementParam chargement = new ChargementParam();
		//SauvegardeParam sauvegarde = new SauvegardeParam();
		//PanneauInitialisation init = new PanneauInitialisation(chargement);
		PanneauInitialisation init = new PanneauInitialisation();
		Personnage perso = new Guerrier("Elias",'@', new Coord(20,14));
		perso.ajouterEquipement(new PotionVitesse());
		perso.ajouterEquipement(new Epee());
		Equipe equipe = new Equipe ("Votre équipe", perso);
		//Test de différent équipement et différents membres d'équipe
			//perso.ajouterEquipement(new PotionVie());
			//perso.ajouterEquipement(new Bombe());
			//Paladin poppy = new Paladin("Poppy");
			//poppy.ajouterEquipement(new Epee());
			//poppy.ajouterEquipement(new Bouclier());
			//Mage maria = new Mage("Maria");
			//maria.ajouterEquipement(new Amulette());
			//maria.ajouterEquipement(new PotionVie());
			//equipe.ajouterPersonnage(poppy);
			//equipe.ajouterPersonnage(maria);		
		
		//init.accueil();
		//init.demarrage(perso,carte);
		init.scenario();
		//carte = chargement.getCoordCarte();
		carte = new CarteMonde();
		Combat combat;
		Tresor tresor = new Tresor(carte, pnjKaramel, pnjMaria, pnjPerlin, pnjPoppy, pnjRomuald);;

		carte.setDeplacementPerso(perso, equipe);

		Scanner sc = new Scanner(System.in);
		char saisie;
		int personnage_pas = 0, combat_apparition = (int)(Math.floor(Math.random()*5 + 5));

		boolean mouvement = true;

		while (mouvement == true) {

			carte.placer(perso.getCoord(), '@');
			carte.afficher();
			carte.enlever(perso.getCoord());

			try {
				
				switch (saisie = sc.nextLine().charAt(0)) {
	
				case 'z':
					perso.mvtHaut();
					if (carte.bloque(perso)) { 
						if (carte.elementCarte(perso).equals("Karamel")) {
							 pnjKaramel.deroulementQuete(equipe);
						  }
						if (carte.elementCarte(perso).equals("Perlin")) {
							if (pnjKaramel.getListe_quetes().get(1).getActive() || pnjKaramel.getQueteActuel() > 2)
								  pnjPerlin.boucleFinListeQuete(equipe, pnjKaramel);
							else  
								pnjPerlin.boucleSansQuete(perso);
						}
						if (carte.elementCarte(perso).equals("tresor")) {
							tresor.ouvrir(perso);
						}
						if (carte.elementCarte(perso).equals("boss")) {
							try {
								combat = new Combat(equipe, carte);
								if (combat.getGameOver() == true) {
									mouvement = false;
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						perso.mvtBas(); }
					break;
	
				case 's':
					perso.mvtBas();
					if (carte.bloque(perso)) { 
						if (carte.elementCarte(perso).equals("tresor")) {
							tresor.ouvrir(perso);
						}
						if (carte.elementCarte(perso).equals("boss")) {
							try {
								combat = new Combat(equipe, carte);
								if (combat.getGameOver() == true) {
									mouvement = false;
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						perso.mvtHaut(); }
					break;
	
				case 'q':
					perso.mvtGauche();
					if (carte.bloque(perso)) {
						if (carte.elementCarte(perso).equals("Romuald")) {
							 pnjRomuald.deroulementQuete(equipe);
						}
						if (carte.elementCarte(perso).equals("Poppy")) {
							if (pnjMaria.getListe_quetes().get(1).getActive() || pnjMaria.getQueteActuel() > 2)
								  pnjPoppy.boucleFinListeQuete(equipe, pnjMaria);
							else  
								pnjPoppy.boucleSansQuete(perso);
						}
						if (carte.elementCarte(perso).equals("tresor")) {
							tresor.ouvrir(perso);
						}
						if (carte.elementCarte(perso).equals("boss")) {
							try {
								combat = new Combat(equipe, carte);
								if (combat.getGameOver() == true) {
									mouvement = false;
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						perso.mvtDroite(); }
					break;
	
				case 'd':
					perso.mvtDroite();
					if (carte.bloque(perso)) { 
						if (carte.elementCarte(perso).equals("Maria")) {
							 pnjMaria.deroulementQuete(equipe);
						}
						if (carte.elementCarte(perso).equals("tresor")) {
							tresor.ouvrir(perso);
						}
						if (carte.elementCarte(perso).equals("boss")) {
							try {
								combat = new Combat(equipe, carte);
								if (combat.getGameOver() == true) {
									mouvement = false;
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						perso.mvtGauche(); }
					break;
				
				case 't': 
					//sauvegarde.saveCoordPerso(perso);
					//sauvegarde.saveCoordCarte(carte);
					System.out.println("Partie sauvegardée.");
					break;
					
				case 'm':
					new Menu(equipe);
					break;
					
				}
			}catch(StringIndexOutOfBoundsException e) {
				
			}
			
			//carte.setDeplacementPerso(p);
			if (carte.estChange(perso) == true) { 
				
				carte = carte.changementCarte(perso);
				System.out.println("Vous entrez sur la carte" +carte.getCarte_nom());
				if (carte.getCarte_nom().contains("Donjon")) {
					
					tresor = new Tresor(carte, pnjKaramel, pnjMaria, pnjPerlin, pnjPoppy, pnjRomuald);
					personnage_pas = 0;
					combat_apparition = (int)(Math.floor(Math.random()*5 + 5));
					
				}
				carte.setDeplacementPerso(perso, equipe);
				
			}
			if (carte.getCarte_nom().contains("Donjon")) {
				
				personnage_pas++;
				if (personnage_pas == combat_apparition) {
					
					try {
						combat = new Combat(sc, equipe);
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
