package Cartes;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import Equipements.Objet;
import Tresors.Tresor;

public class CarteDonjon extends Carte {
	
	public CarteDonjon(int i ) {
		
		carte_nom = "Donjon" +i;
		
		carte = new char [24][40];

		this.deserializeCarte("Ressources/Cartes/carte" +carte_nom+ ".txt");
		
		carte_coord_entree_sortie = new HashMap<String,Coord>();		
		carte_coord_entree_sortie.put("Donjon1", new Coord(4,7));
		carte_coord_entree_sortie.put("Donjon2", new Coord(16,6));
		carte_coord_entree_sortie.put("Donjon3", new Coord(24,6));
		carte_coord_entree_sortie.put("Donjon4", new Coord(27,7));
		carte_coord_entree_sortie.put("Donjon5", new Coord(42,14));
		carte_coord_entree_sortie.put("Donjon6", new Coord(21,22));
		carte_coord_entree_sortie.put("Donjon7", new Coord(6,26));
		carte_coord_entree_sortie.put("Donjon8", new Coord(41,27));
		carte_coord_entree_sortie.put("Donjon9", new Coord(14,32));
		carte_coord_entree_sortie.put("Donjon10", new Coord(6,40));
		carte_coord_entree_sortie.put("Donjon11", new Coord(23,40));
		carte_coord_entree_sortie.put("Donjon12", new Coord(40,38));
				
		carte_liste_tresor = new ArrayList<Tresor>(); 
		carte_liste_tresor.add(new Tresor("Donjon4",new Objet("La main d'Atlas")));
		carte_liste_tresor.add(new Tresor("Donjon5",new Objet("Le collier de Maria")));
		carte_liste_tresor.add(new Tresor("Donjon6",new Objet("Le Bouclier de Perlin")));
		carte_liste_tresor.add(new Tresor("Donjon7",new Objet("Les assiettes en argent")));
		/*carte_liste_tresor.add(new Tresor("Donjon1",new Armure("Le Vaillant")));
		carte_liste_tresor.add(new Tresor("Donjon1",new Armure("Le Vaillant")));
		carte_liste_tresor.add(new Tresor("Donjon1",new Armure("Le Vaillant")));
		carte_liste_tresor.add(new Tresor("Donjon1",new Armure("Le Vaillant")));
		carte_liste_tresor.add(new Tresor("Donjon1",new Armure("Le Vaillant")));
		carte_liste_tresor.add(new Tresor("Donjon1",new Armure("Le Vaillant")));
		carte_liste_tresor.add(new Tresor("Donjon1",new Armure("Le Vaillant")));
		carte_liste_tresor.add(new Tresor("Donjon1",new Armure("Le Vaillant")));
		carte_liste_tresor.add(new Tresor("Donjon1",new Armure("Le Vaillant")));
		carte_liste_tresor.add(new Tresor("Donjon1",new Armure("Le Vaillant")));*/

		try {
			    	
			carte_obstacle_1 = ImageIO.read(new File("Ressources/Images/murDonjon.png"));
			carte_personnage = ImageIO.read(new File("Ressources/Images/personnageHaut.png"));
			carte_pnj_1 = ImageIO.read(new File("Ressources/Images/PerlinFace.png"));
			carte_sortie = ImageIO.read(new File("Ressources/Images/porte.png"));
			carte_sol = ImageIO.read(new File("Ressources/Images/solDonjon.png"));
			carte_sol_exterieur = ImageIO.read(new File("Ressources/Images/terre.png"));
			carte_boss = ImageIO.read(new File("Ressources/Images/bossDos.png"));
			carte_tresor = ImageIO.read(new File("Ressources/Images/tresor.png"));
			      
		}
		catch (IOException e) {
		      e.printStackTrace();
		}
		
	}
	
	public ArrayList<Tresor> getListe_carte_tresor() {
		return carte_liste_tresor;
	}

}
