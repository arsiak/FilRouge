package Panneau;

import java.util.Scanner;

import Personnages.Equipe;

public class Menu {

	boolean menuOuvert = true;
	MenuEquipe menuEquipe;
	MenuInventaire menuInventaire;
	
	
	public Menu(Equipe equipe) {
		
		
		char retourMenu = ' ';
		
		
		while (menuOuvert == true) {
			
			menuEquipe = new MenuEquipe(equipe);
			menuInventaire = new MenuInventaire(equipe);
			retourMenu = menuEquipe.deroulementMenu();
			
			if (retourMenu == 'i') retourMenu = menuInventaire.deroulementMenu();
			if (retourMenu == 'm') menuOuvert = false;
			
				
		}
	}
}
