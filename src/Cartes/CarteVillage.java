package Cartes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class CarteVillage extends Carte {
	
	public CarteVillage() {
		
		nomCarte = "Village";
	
		carte = new char [20][20];
	
		this.deserializeCarte("src/Cartes/carte" +nomCarte+ ".txt");
		
		ensembleEntreeSortie = new HashMap<String,Coord>();
		ensembleEntreeSortie.put(nomCarte, new Coord(25,16));
	
		try {
			
			personnage = ImageIO.read(new File("src/Images/personnageDroit.png"));
			obstacle_1 = ImageIO.read(new File("src/Images/buisson.png"));
			obstacle_2 = ImageIO.read(new File("src/Images/maison.png"));
			pnj_1 = ImageIO.read(new File("src/Images/marchandeGauche.png"));
			pnj_2 = ImageIO.read(new File("src/Images/marchande.png"));
			sortie = ImageIO.read(new File("src/Images/porte.png"));
			sol = ImageIO.read(new File("src/Images/terre.png"));
			      
		}
		catch (IOException e) {
		      e.printStackTrace();
		}  

	}

}