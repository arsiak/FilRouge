package Cartes;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class CarteDonjon extends Carte {

	
	public CarteDonjon(int i ) {
		
		nomCarte = "Donjon" +i;
		
		carte = new char [25][40];

		this.deserializeCarte("src/Cartes/carte" +nomCarte+ ".txt");
		
		ensembleEntreeSortie = new HashMap<String,Coord>();		
		ensembleEntreeSortie.put("Donjon1", new Coord(4,7));
		ensembleEntreeSortie.put("Donjon2", new Coord(16,6));
		ensembleEntreeSortie.put("Donjon3", new Coord(24,6));
		ensembleEntreeSortie.put("Donjon4", new Coord(27,7));
		ensembleEntreeSortie.put("Donjon5", new Coord(42,14));
		ensembleEntreeSortie.put("Donjon6", new Coord(21,22));
		ensembleEntreeSortie.put("Donjon7", new Coord(6,26));
		ensembleEntreeSortie.put("Donjon8", new Coord(41,27));
		ensembleEntreeSortie.put("Donjon9", new Coord(14,32));
		ensembleEntreeSortie.put("Donjon10", new Coord(6,40));
		ensembleEntreeSortie.put("Donjon11", new Coord(23,40));
		ensembleEntreeSortie.put("Donjon12", new Coord(40,38));
		

		try {
			    	
			obstacle_1 = ImageIO.read(new File("src/Images/murDonjon.png"));
			personnage = ImageIO.read(new File("src/Images/personnageHaut.png"));
			sortie = ImageIO.read(new File("src/Images/porte.png"));
			sol = ImageIO.read(new File("src/Images/solDonjon.png"));
			boss = ImageIO.read(new File("src/Images/bossDos.png"));
			tresor = ImageIO.read(new File("src/Images/tresor.png"));
			      
		}
		catch (IOException e) {
		      e.printStackTrace();
		}  
	}
	
	/*public Coord getCoordEntreeSortie() {
		return coordEntreeSortie;
	}*/
	
}
