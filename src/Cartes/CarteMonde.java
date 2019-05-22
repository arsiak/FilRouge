package Cartes;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import Personnages.Perso;

public class CarteMonde extends Carte {
	
	
	public CarteMonde() {
		
		nomCarte = "Monde";
		
		carte = new char [47][49];
		
		this.deserializeCarte("src/Cartes/carte" +nomCarte+ ".txt");
		
		ensembleEntreeSortie = new HashMap<String,Coord>();	
		ensembleEntreeSortie.put("EntreeVillage", new Coord(5,5));
		ensembleEntreeSortie.put("EntreeDonjon", new Coord(21,18));	
		ensembleEntreeSortie.put("Donjon1", new Coord(4,6));
		ensembleEntreeSortie.put("Donjon2", new Coord(16,5));
		ensembleEntreeSortie.put("Donjon3", new Coord(24,5));
		ensembleEntreeSortie.put("Donjon4", new Coord(27,6));
		ensembleEntreeSortie.put("Donjon5", new Coord(42,13));
		ensembleEntreeSortie.put("Donjon6", new Coord(21,21));
		ensembleEntreeSortie.put("Donjon7", new Coord(6,25));
		ensembleEntreeSortie.put("Donjon8", new Coord(41,26));
		ensembleEntreeSortie.put("Donjon9", new Coord(14,31));
		ensembleEntreeSortie.put("Donjon10", new Coord(6,39));
		ensembleEntreeSortie.put("Donjon11", new Coord(23,39));
		ensembleEntreeSortie.put("Donjon12", new Coord(40,37));
		
		try {
			
			personnage = ImageIO.read(new File("src/Images/personnageBas.png"));
			obstacle_1 = ImageIO.read(new File("src/Images/arbre.png"));
			obstacle_2 = ImageIO.read(new File("src/Images/eau.png"));
			entree_1 = ImageIO.read(new File("src/Images/chateau.png"));
			entree_2 = ImageIO.read(new File("src/Images/maison.png"));
			sol = ImageIO.read(new File("src/Images/terre.png"));
			      
		}
		catch (IOException e) {
		      e.printStackTrace();
		}  
		
	}	
	
	/*public Carte changementCarte(Perso perso) {
		
		//if (carte[perso.getCoord().getY()][perso.getCoord().getX()] ==  'D') {
			/*for (int i=1; i<this.getEnsembleEntreeSortie().size(); i++) {
				if (perso.getCoord().equals(this.getEnsembleEntreeSortie().get(i-1))) {
					return new CarteDonjon(i);
				}
			}
			return new CarteDonjon(1);
		
	}*/
	
}
