package Panneau;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.JPanel;

import Objets.Objet;
import Personnages.Equipe;

public class MenuInventaire extends JPanel {

	Equipe equipe;
	MenuInventaireDetail menuInventaireDetail;
	boolean menuOuvert = true;
	
	public MenuInventaire(Equipe equipe) {
		this.equipe=equipe;
	}
	
	public char deroulementMenu() {
		
		
		Scanner sc = new Scanner(System.in);
		char retourMenu = ' ';
		int select = 0, taille = 0;
		
		while (menuOuvert == true) {
			
			taille = affichageMenu(select, taille);
			switch (retourMenu = sc.nextLine().charAt(0)) {

				case 'v': menuInventaireDetail = new MenuInventaireDetail(equipe);
						  menuInventaireDetail.deroulementMenu(select);
					      break;
			
				case 'z': if (select != 0) {
						  	select--;
						  }
					      break;
					      
				case 's': if (select != taille-1) {
						  	select++;
						  }
						  break;
			      
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
	
	
	public int affichageMenu(int select, int taille) {
		
		String fleche = "";
		int selectActu = 0;
		
		System.out.print("-----------------------------------------------------------------------------\n" + 
				 		 "|                Equipe (a)              |         *  Inventaire (i)        |\n" + 
				 		 "-----------------------------------------------------------------------------\n");
			
		for (int j=0; j<equipe.getListePersonnage().size(); j++) {
			
			for (int i=0; i<equipe.getListePersonnage().get(j).getSac().length; i++) {
				Objet objet = equipe.getListePersonnage().get(j).getSac()[i];
				if (select == selectActu) { fleche = "<-"; }
				else { fleche = "  "; };
				try {
					System.out.print("| " +objet.getPresentationMenu()+ " (" +equipe.getListePersonnage().get(j).getNom()+ ")");
					for (int k=0; k<47-objet.getPresentationMenu().length(); k++) { System.out.print(" "); } 
					
					System.out.print(fleche+ "                 |\n"
									+"|     Description : " +objet.getDescription());
					for (int k=0; k<56-objet.getDescription().length(); k++) { System.out.print(" "); } 
					System.out.print("|\n");
					taille++;
					selectActu++;
				} catch (NullPointerException e) {
					
				}
			}
		}
		System.out.println("-----------------------------------------------------------------------------\n");	
		System.out.println("\n| z : haut | s : bas | v : valider");
		//System.out.println(selectActu);
		//System.out.println(select);
		return taille;
	}

}
