package Cartes;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import JsonPack.JSONArray;
import JsonPack.JSONObject;
import Personnages.*;



public class Carte extends JPanel {

	protected Perso perso = new Perso();
	protected Coord coordEntreeSortie;
	protected char [][] carte;
	protected int largeurCarte, longueurCarte;
	protected Image personnage, obstacle, sol, pnj, entree, eau;
	
	public Carte() {
		
		try {
			personnage = ImageIO.read(new File("src/Images/prince.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deserializeCarte(String path) {
		
		int nbcol, nbligne=0;
		
	      try{
	         
	         FileReader read = new FileReader(path);
	         BufferedReader brreader =new BufferedReader(read);
	         String currentLine;
	         
	         char [] c;
	         while((currentLine = brreader.readLine()) != null ) {
	 			c = currentLine.toCharArray();
	 			
	 			for (nbcol=0; nbcol <c.length; nbcol++) {
	 				carte[nbligne][nbcol]=c[nbcol];
	 				
	 			}
	 			nbligne++;
	 		}
	         brreader.close();
	      }    
	      catch (Exception e){
	         e.toString();
	         System.out.println("plouf");
	      }
	       
	}      
 
	public Boolean bloque(Perso perso) {
		
		Boolean bloque = false;
		if (carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'X' || carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'O' ) { 
			bloque = true; 
		}
		return bloque;
	}
	
	public Boolean estChange(Perso perso) {
		
		Boolean change = false;
		if (carte[perso.getCoord().getY()][perso.getCoord().getX()] ==  'D') { 
			change = true; 
		}
		return change;
		
	}
	
	public void placer(Coord coord, char lettre) {
		
		carte[coord.getY()][coord.getX()] = lettre;
	}
	
	public void enlever(Coord coord) {
		
		carte[coord.getY()][coord.getX()] = ' ';
	}
	
	 public void setDeplacementPerso(Perso perso) {
		 
		 this.perso.setCoord(perso.getCoord());
		 
	 }
	
	 public void paintComponent(Graphics g){
		
			    int cadreGauche = perso.getCoord().getX() - 2, cadreDroit = perso.getCoord().getX() + 2;
				int cadreHaut = perso.getCoord().getY() - 2, cadreBas = perso.getCoord().getY() + 2;
				
				int x=0, y=0;
		      
				System.out.println(perso.getCoord().getX());
				//this.afficher();
				for(int i = cadreHaut; i <= cadreBas; i++ ){  
					
					for(int j = cadreGauche; j <= cadreDroit; j++){  
						
						g.drawImage(sol,x ,y, 100, 100, this);
						if (carte[i][j] == 'X') { g.drawImage(obstacle, x, y, 100, 100, this); } 
						if (carte[i][j] == 'D') { g.drawImage(entree, x, y, 100, 100, this); } 
						if (carte[i][j] == 'O') { g.drawImage(eau, x, y, 100, 100, this); }
						x+=100;
						
					}
					y+=100;
					x=0;
				}
			  
		      g.drawImage(personnage, 200, 200, 100, 100, this);
		    
		     
		  }

	public Coord getCoordEntreeSortie() {
		// TODO Auto-generated method stub
		return coordEntreeSortie;
	} 
	
	public void afficher() {
		
	int cadreGauche = perso.getCoord().getX() - 3, cadreDroit = perso.getCoord().getX() + 3;
	int cadreHaut = perso.getCoord().getY() - 3, cadreBas = perso.getCoord().getY() + 3;
	
		System.out.println();
		
		for (int i = cadreHaut; i < cadreBas; i++) {
			for (int j = cadreGauche; j < cadreDroit; j++) {
				System.out.print(carte[i][j]);
			}
		System.out.println();
		}
		System.out.println();
	}
	 
}
