package Cartes;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CarteDonjon extends Carte {


	public CarteDonjon() {

		carte_coordEntreeSortie = new Coord(4,5);

		carte = new char [15][18];

		this.deserializeCarte("src/Cartes/carteDonjon.txt");
		/*
		carte = new String[][] {{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"},
			  					{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"}, 
			  					{"X","X","X","X"," "," "," "," "," "," "," "," "," ","X","X","X"},
			  					{"X","X","X"," "," "," "," "," "," ","X","X"," "," "," ","X","X"},
			  					{"X","X","X"," "," "," "," "," ","X","X","X"," "," "," ","X","X"},
			  					{"X","X","X","X","X","X","X","X","X","X","X","X"," "," ","X","X"},
			  					{"X","X"," "," ","X"," "," "," "," "," "," "," "," ","X","X","X"},
			  					{"X","X"," "," "," "," "," "," "," ","X"," "," "," "," ","X","X"},
			  					{"X","X"," "," ","X"," "," "," "," ","X"," "," "," "," ","X","X"},
			  					{"X","X","X"," ","X"," ","X"," "," ","X","X","X","X"," ","X","X"},
			  					{"X","X","X"," ","X","X","X","X"," ","X","X","X","X","X","X","X"},
			  					{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"},
			  					{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"}};
		 */  
		try {

			carte_obstacle = ImageIO.read(new File("src/Images/murDonjon.png"));
			carte_personnage = ImageIO.read(new File("src/Images/prince.png"));
			//entree = ImageIO.read(new File("Images/sac.png"));
			carte_sol = ImageIO.read(new File("src/Images/solDonjon.png"));

		}
		catch (IOException e) {
			e.printStackTrace();
		}  
	}

	public Coord getCoordEntreSortie() {
		return carte_coordEntreeSortie;
	}

}
