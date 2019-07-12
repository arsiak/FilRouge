package Panneau;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

import Objets.Objet;
import Personnages.Equipe;

public class MenuEquipe extends JPanel {

	Equipe equipe;
	boolean menuOuvert = true;
	
	public MenuEquipe(Equipe equipe) {
		this.equipe=equipe;
	}
	
	public char deroulementMenu() {
		
		Scanner sc = new Scanner(System.in);
		char retourMenu = ' ';
		int select = 0;
		
		while (menuOuvert == true) {
			
			this.affichageMenu(select);
			switch (retourMenu = sc.nextLine().charAt(0)) {

				case 'z': if (select != 0) {
						  	select--;
						  }
					      break;
	
				case 's': if (select != equipe.getListePersonnage().size()-1) {
						  	select++;
						  }
						  break;	
						  
				case 'm': menuOuvert = false; 
						  retourMenu = 'm';
						  break;
				
				case 'i': menuOuvert = false;
						  retourMenu = 'i';
						  break;				  
				default:
			}
		}
		return retourMenu; 
		
	}
	
	public void affichageMenu(int select) {
		
		String fleche = "";
		
		System.out.print("----------------------------------------------------------------------------------\n" + 
				 		 "|             *  Equipe (A)              |            Inventaire (I)             |\n" + 
				 		 "----------------------------------------------------------------------------------\n"
						+"| " +equipe.getNom()+ "                                                                   |\n");
		for (int i=0; i<(equipe.getListePersonnage().size()); i++) {
			
			if (select == i) { fleche = "->"; }
			else { fleche = "  "; };
			
			System.out.print("|                                                                                |\n"
							+"| " +fleche+ " " +equipe.getListePersonnage().get(i).toStringMenu());
			for (int j=0; j<76-equipe.getListePersonnage().get(i).toStringMenu().length(); j++) { System.out.print(" "); } 
			System.out.print("|\n"
							  +"|                                                                                |\n");	 		
		}		 		   
				 		   		   
		System.out.print("----------------------------------------------------------------------------------\n");
		for (int i=0; i<equipe.getListePersonnage().get(select).getSac().length; i++) {
			Objet objet = equipe.getListePersonnage().get(select).getSac()[i];
			try {
				System.out.print("| " +objet.getPresentationMenu());
				for (int j=0; j<79-objet.getPresentationMenu().length(); j++) { System.out.print(" "); } 
				System.out.print("|\n"
								+"|     Decription : " +objet.getDescription());
				for (int j=0; j<62-objet.getDescription().length(); j++) { System.out.print(" "); } 
				System.out.print("|\n");
			} catch (NullPointerException e) {
				
			}
		}
		System.out.println("----------------------------------------------------------------------------------\n");	
		System.out.println("\n| z : haut | s : bas | ");
				 		   
	}

}
