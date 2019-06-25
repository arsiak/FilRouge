package Panneau;

import java.util.Scanner;

import Bdd.ChargementParam;
import Cartes.Carte;
import Equipements.Casque;
import Equipements.Epee;
import Personnages.Guerrier;
import Personnages.Personnage;

public class MenuInitialisation {
	
	ChargementParam param;
	MenuScenario menuScenario = new MenuScenario();
	Scanner sc;
	String pseudo;
	
	public MenuInitialisation(ChargementParam param ) { 
		this.param=param;
		sc=new Scanner(System.in);
	}
	
	public void attente() {
		for (int j=0; j<100;j++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("-");
		}
		System.out.println();
	}
	
	public void accueil() {
		
		String password;
		System.out.print("Veuillez vous identifier :\n" 
						  +"Pseudo : ");
		pseudo = sc.next();
		System.out.print("Mot de passe : ");
		password = sc.next();
		System.out.print("\nVérification\n");
		attente();
		if (param.getPseudo().equals(pseudo) && param.getPassword().equals(password)) {
			System.out.println("Joueur valide.");
		}
		else {
			this.nonInscrit();
		}
		
	}
	
	public void nonInscrit() {
		
		System.out.println("Joueur non inscrit. Veuiller vous inscrire sur le site http://192.168.17.12");
		System.exit(0);
	}
	
	public void demarrage(Personnage perso, Carte carte) {
		
		System.out.println("Nouvelle partie : N");
		System.out.println("Charger une partie : C");
		
		
		if (sc.next().equals("N")) {
			this.scenario();
		} else if (sc.next().equals("C")) {
			
		}

	}
	
	public void scenario() {
		
		menuScenario.afficher();
		this.attente();
	}
	
}
