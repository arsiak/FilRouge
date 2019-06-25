package Panneau;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.JPanel;

import Equipements.Objet;
import Personnages.Equipe;

public class MenuInventaire extends JPanel {

	Equipe equipe;
	boolean menuOuvert = true;
	
	public MenuInventaire(Equipe equipe) {
		this.equipe=equipe;
	}
	
	public char deroulementMenu() {
		
		
		Scanner sc = new Scanner(System.in);
		char retourMenu = ' ';
		
		while (menuOuvert == true) {
			
			this.affichageMenu();
			switch (retourMenu = sc.nextLine().charAt(0)) {

				case 'a': menuOuvert = false;
						  break;
				
				case 'm': menuOuvert = false; 
						  retourMenu = 'm';
						  break;
				default:
			}
		}
		return retourMenu;
		
	}
	
	
	public void affichageMenu() {
		
		System.out.print("-----------------------------------------------------------------------------\n" + 
				 		 "|                Equipe (A)              |         *  Inventaire (I)        |\n" + 
				 		 "-----------------------------------------------------------------------------\n");
			
		for (int i=0; i<equipe.getListePersonnage().get(0).getSac().length; i++) {
			Objet objet = equipe.getListePersonnage().get(0).getSac()[i];
			try {
				System.out.print("| " +objet.getPresentationMenu()+ "                                                                |\n");
				System.out.print("|     Decription : " +objet.getDescription()+ "                                        |\n");
			} catch (NullPointerException e) {
				
			}
		}
		System.out.println("-----------------------------------------------------------------------------\n");		   
				 		   
	}

}
