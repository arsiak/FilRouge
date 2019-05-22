package Cartes;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class CarteDonjon extends Carte {
	
	public CarteDonjon(int i ) {
		
		carte_nom = "Donjon" +i;
		
		carte = new char [25][40];

		this.deserializeCarte("src/Cartes/carte" +carte_nom+ ".txt");
		
		carte_entree_sortie = new HashMap<String,Coord>();		
		carte_entree_sortie.put("Donjon1", new Coord(4,7));
		carte_entree_sortie.put("Donjon2", new Coord(16,6));
		carte_entree_sortie.put("Donjon3", new Coord(24,6));
		carte_entree_sortie.put("Donjon4", new Coord(27,7));
		carte_entree_sortie.put("Donjon5", new Coord(42,14));
		carte_entree_sortie.put("Donjon6", new Coord(21,22));
		carte_entree_sortie.put("Donjon7", new Coord(6,26));
		carte_entree_sortie.put("Donjon8", new Coord(41,27));
		carte_entree_sortie.put("Donjon9", new Coord(14,32));
		carte_entree_sortie.put("Donjon10", new Coord(6,40));
		carte_entree_sortie.put("Donjon11", new Coord(23,40));
		carte_entree_sortie.put("Donjon12", new Coord(40,38));
		

		try {
			    	
			carte_obstacle_1 = ImageIO.read(new File("src/Images/murDonjon.png"));
			carte_personnage = ImageIO.read(new File("src/Images/personnageHaut.png"));
			carte_sortie = ImageIO.read(new File("src/Images/porte.png"));
			carte_sol = ImageIO.read(new File("src/Images/solDonjon.png"));
			carte_boss = ImageIO.read(new File("src/Images/bossDos.png"));
			carte_tresor = ImageIO.read(new File("src/Images/tresor.png"));
			      
		}
		catch (IOException e) {
		      e.printStackTrace();
		}
		
	}

}
