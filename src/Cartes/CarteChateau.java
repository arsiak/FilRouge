package Cartes;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CarteChateau extends Carte {

	
	public CarteChateau() {
		
		coordEntreeSortie = new Coord(3,4);
		
		carte = new char [13][16];

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
			    	
			      obstacle = ImageIO.read(new File("Images/murDonjon.png"));
			      personnage = ImageIO.read(new File("Images/prince.png"));
			      //entree = ImageIO.read(new File("Images/sac.png"));
			      sol = ImageIO.read(new File("Images/solDonjon.png"));
			      
			 }
			 catch (IOException e) {
		      e.printStackTrace();
			 }  
	}
	
	public Coord getCoordEntreSortie() {
		return coordEntreeSortie;
	}
	
}
