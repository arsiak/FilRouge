package Cartes;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class CarteMonde extends Carte {

	public CarteMonde() {
		
		carte_nom = "Monde";
		
		carte = new char [47][49];
		
		this.deserializeCarte("src/Cartes/carte" +carte_nom+ ".txt");
		
		carte_coord_entree_sortie = new HashMap<String,Coord>();	
		carte_coord_entree_sortie.put("EntreeVillage", new Coord(5,5));
		carte_coord_entree_sortie.put("EntreeDonjon", new Coord(21,18));	
		carte_coord_entree_sortie.put("Donjon1", new Coord(4,6));
		carte_coord_entree_sortie.put("Donjon2", new Coord(16,5));
		carte_coord_entree_sortie.put("Donjon3", new Coord(24,5));
		carte_coord_entree_sortie.put("Donjon4", new Coord(27,6));
		carte_coord_entree_sortie.put("Donjon5", new Coord(42,13));
		carte_coord_entree_sortie.put("Donjon6", new Coord(21,21));
		carte_coord_entree_sortie.put("Donjon7", new Coord(6,25));
		carte_coord_entree_sortie.put("Donjon8", new Coord(41,26));
		carte_coord_entree_sortie.put("Donjon9", new Coord(14,31));
		carte_coord_entree_sortie.put("Donjon10", new Coord(6,39));
		carte_coord_entree_sortie.put("Donjon11", new Coord(23,39));
		carte_coord_entree_sortie.put("Donjon12", new Coord(40,37));
		
		try {
			
			carte_personnage = ImageIO.read(new File("src/Images/personnageBas.png"));
			carte_pnj_1 = ImageIO.read(new File("src/Images/PoppyDos.png"));
			carte_pnj_2 = ImageIO.read(new File("src/Images/TerribleDragonNoir.png"));
			carte_obstacle_1 = ImageIO.read(new File("src/Images/arbre.png"));
			carte_obstacle_2 = ImageIO.read(new File("src/Images/eau.png"));
			carte_entree_1 = ImageIO.read(new File("src/Images/chateau.png"));
			carte_entree_2 = ImageIO.read(new File("src/Images/maison.png"));
			carte_sol = ImageIO.read(new File("src/Images/terre.png"));
			      
		}
		catch (IOException e) {
		      e.printStackTrace();
		}  
		
	}	

}
