package Monstres;

import Equipements.Objet;

public class FactoryMonstre {
	
	public FactoryMonstre() {
	
	}
	
	
	public Monstre getTypeMonstre() throws Exception {
		
		int randomType = (int)(Math.random()*3+1);
		int randomNom = (int)(Math.random()*9);
		int randomObjet = (int)(Math.random()*9);
		
		
		String listeNomMonstre[] = {"kali","hora","taco","zipe","borg","polo", "druk", "joum", "omil", "bark"};
		
		switch (randomType) {
			case 1: 
				return new Assassin(listeNomMonstre[randomNom], "A", new Objet[]{});
			case 2:
				return new Chamane(listeNomMonstre[randomNom], "C", new Objet[]{});
			case 3:
				return new Necromancien(listeNomMonstre[randomNom], "N", new Objet[]{});	
		}
		return null;
	}

}