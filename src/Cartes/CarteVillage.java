package Cartes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import Personnages.Personnage;

public class CarteVillage extends Carte {
	
	public CarteVillage() {
		
		carte_nom = "Village";
	
		carte = new char [20][20];
	
		this.deserializeCarte("Ressources/Cartes/carte" +carte_nom+ ".txt");
		
		carte_coord_entree_sortie = new HashMap<String,Coord>();
		carte_coord_entree_sortie.put(carte_nom, new Coord(25,16));
	
		try {
			
			carte_personnage = ImageIO.read(new File("Ressources/Images/personnageDroit.png"));
			carte_obstacle_1 = ImageIO.read(new File("Ressources/Images/buisson.png"));
			carte_obstacle_2 = ImageIO.read(new File("Ressources/Images/maison.png"));
			carte_pnj_1 = ImageIO.read(new File("Ressources/Images/KaramelFace.png"));
			carte_pnj_2 = ImageIO.read(new File("Ressources/Images/MariaGauche.png"));
			carte_pnj_3 = ImageIO.read(new File("Ressources/Images/RomualdDroit.png"));
			carte_sortie = ImageIO.read(new File("Ressources/Images/porte.png"));
			carte_sol = (ImageIO.read(new File("Ressources/Images/terre.png")));
			      
		}
		catch (IOException e) {
		      e.printStackTrace();
		}  

	}

}