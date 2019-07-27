package Monstres;

import java.io.File;

import javax.imageio.ImageIO;

import Objets.FactoryObjet;
import Objets.Objet;

public class FactoryMonstre {
	
	FactoryObjet factoryObjet;
	
	public FactoryMonstre() {
	
	}
	
	public Monstre getTypeMonstre() throws Exception {
		
		int randomType = (int)(Math.random()*3+1);
		int randomNom = (int)(Math.random()*9);		
		
		String listeNomMonstre[] = {"kali","hora","taco","zipe","borg","polo", "druk", "joum", "omil", "bark"};
		
		switch (randomType) {
			case 1: 
				return new Assassin(listeNomMonstre[randomNom], 'A', new FactoryObjet().getObjets());
			case 2:
				return new Chamane(listeNomMonstre[randomNom], 'C', new FactoryObjet().getObjets());
			case 3:
				return new Necromancien(listeNomMonstre[randomNom], 'N', new FactoryObjet().getObjets());	
		}
		return null;
	}
	
	public Monstre getTypeMonstreG() throws Exception {
		
		int randomType = (int)(Math.random()*3+1);
		int randomNom = (int)(Math.random()*9);		
		
		String listeNomMonstre[] = {"kali","hora","taco","zipe","borg","polo", "druk", "joum", "omil", "bark"};
		
		switch (randomType) {
			case 1: 
				return new Assassin(listeNomMonstre[randomNom], ImageIO.read(new File("Ressources/Images/AssassinGauche.png")), new FactoryObjet().getObjets());
			case 2:
				return new Chamane(listeNomMonstre[randomNom], ImageIO.read(new File("Ressources/Images/ChamanGauche.png")), new FactoryObjet().getObjets());
			case 3:
				return new Necromancien(listeNomMonstre[randomNom], ImageIO.read(new File("Ressources/Images/NecromancienGauche.png")), new FactoryObjet().getObjets());	
		}
		return null;
	}

}