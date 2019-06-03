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
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import JsonPack.JSONArray;
import JsonPack.JSONObject;
import Personnages.*;
import Tresors.Tresor;



public class Carte extends JPanel {
	
	protected String carte_nom;
	protected Personnage perso = new Personnage();
	protected char [][] carte;
	protected HashMap<String,Coord> carte_coord_entree_sortie;
	protected ArrayList<Tresor> carte_liste_tresor;
	protected Image carte_sol,carte_sol_exterieur, carte_obstacle_1, carte_obstacle_2, carte_entree_1, carte_entree_2, carte_sortie, carte_pnj_1, carte_pnj_2, carte_pnj_3, carte_boss, carte_tresor, carte_personnage;
	protected int carte_largeurCarte, carte_longueurCarte;


	public Carte() {

	}
	
	public String getCarte_nom() {
		return carte_nom;
	}
	
	public ArrayList<Tresor> getCarte_liste_tresor() {
		return carte_liste_tresor;
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
	         System.out.println("Problème de sérialisation");
	      }
	       
	}  
	
	public void setImagePersonnage(String cheminImage) {
		try {
			carte_personnage = ImageIO.read(new File(cheminImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Boolean bloque(Personnage perso) {

		Boolean bloque = false;
		if (carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'X' || carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'O' || // Obstacle
			carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'K' || carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'M' || // Pnj
			carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'R' || carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'P' ||
			carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'Y' ||
			carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'T' || carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'B'){  // Trésor et Boss
			bloque = true; 
		}
		return bloque;
	}
	
	public String elementCarte(Personnage perso) {

		String element_nom = "";
		switch (carte[perso.getCoord().getY()][perso.getCoord().getX()]) {
			case 'K': element_nom = "Karamel"; break;
			case 'M': element_nom = "Maria"; break;
			case 'R': element_nom = "Romuald"; break;
			case 'P': if (this.carte_nom.equals("Monde")) {
					  	element_nom = "Poppy"; 
					  	break;
					  }
					  else if (this.carte_nom.equals("Donjon4")) {
						  element_nom = "Perlin"; 
						  break;
					  }
			case 'T': element_nom = "tresor"; break;
			case 'B': element_nom = "Boss"; break;
		}
		return element_nom;
	}

	public Boolean estChange(Personnage perso) {

		Boolean change = false;
		if (carte[perso.getCoord().getY()][perso.getCoord().getX()] ==  'D' || carte[perso.getCoord().getY()][perso.getCoord().getX()] ==  'V' ||
			carte[perso.getCoord().getY()][perso.getCoord().getX()] ==  'S') { 
			change = true; 
		}
		return change;

	}
	
	public Carte changementCarte(Personnage perso) {
		
		if (carte[perso.getCoord().getY()][perso.getCoord().getX()] ==  'V') {
			this.perso.setCoord(carte_coord_entree_sortie.get("EntreeVillage"));
			perso.setCoord(carte_coord_entree_sortie.get("EntreeVillage"));
			return new CarteVillage();
		}
		else if (carte[perso.getCoord().getY()][perso.getCoord().getX()] ==  'D') {
			for (int i=0; i<carte_coord_entree_sortie.size();i++) {
				if (this.perso.getCoord().equals(carte_coord_entree_sortie.get("Donjon" +(i+1)))) {
					this.perso.setCoord(carte_coord_entree_sortie.get("EntreeDonjon"));
					perso.setCoord(carte_coord_entree_sortie.get("EntreeDonjon"));
					return new CarteDonjon(i+1);
				}
			}
		}
		else if (carte[perso.getCoord().getY()][perso.getCoord().getX()] ==  'S') {
			this.perso.setCoord(carte_coord_entree_sortie.get(carte_nom));
			perso.setCoord(carte_coord_entree_sortie.get(carte_nom));
			return new CarteMonde();
		}
		
		return null;
		
	}

	public void placer(Coord coord, char lettre) {

		carte[coord.getY()][coord.getX()] = lettre;
	}

	public void enlever(Coord coord) {

		carte[coord.getY()][coord.getX()] = ' ';
	}
	
	 public void setDeplacementPerso(Personnage perso) {
		 
		 this.perso.setCoord(perso.getCoord());
		 
	 }
	 
	 public ArrayList<Tresor> getListe_carte_tresor() {
			return null;
		}
	
	 public void paintComponent(Graphics g){
		
			    int cadreGauche = perso.getCoord().getX() - 4, cadreDroit = perso.getCoord().getX() + 4;
				int cadreHaut = perso.getCoord().getY() - 4, cadreBas = perso.getCoord().getY() + 4;
				
				int x=0, y=0;
			
				
						
					for(int i = cadreHaut; i <= cadreBas; i++ ){  
						
						for(int j = cadreGauche; j <= cadreDroit; j++){  
							
							try {
								
								g.drawImage(carte_sol,x ,y, 50, 50, this);
								if (carte[i][j] == 'X') { g.drawImage(carte_obstacle_1, x, y, 50, 50, this); } 
								if (carte[i][j] == 'O') { g.drawImage(carte_obstacle_2, x, y, 50, 50, this); }
								if (carte[i][j] == 'D') { g.drawImage(carte_entree_1, x, y, 50, 50, this); } 
								if (carte[i][j] == 'V') { g.drawImage(carte_entree_2, x, y, 50, 50, this); } 
								if (carte[i][j] == 'S') { g.drawImage(carte_sortie, x, y, 50, 50, this); }
								if (carte[i][j] == 'P' || carte[i][j] == 'K') { g.drawImage(carte_pnj_1, x, y, 50, 50, this); }
								if (carte[i][j] == 'M') { g.drawImage(carte_pnj_2, x, y, 50, 50, this); }
								if (carte[i][j] == 'R') { g.drawImage(carte_pnj_3, x, y, 50, 50, this); }
								if (carte[i][j] == 'T') { g.drawImage(carte_tresor, x, y, 50, 50, this); }
								if (carte[i][j] == 'B') { g.drawImage(carte_boss, x, y, 50, 50, this); }
							
							}
							catch (Exception e){ 
									
									g.drawImage(carte_sol_exterieur,x ,y, 50, 50, this);
					
							}
							x+=50;
							
						}
						y+=50;
						x=0;
						
					}				
			  
		      g.drawImage(carte_personnage, 200, 200, 50, 50, this);
		    
	 }

	public void afficher() {
		
		int cadreGauche = perso.getCoord().getX() - 15, cadreDroit = perso.getCoord().getX() + 15;
		int cadreHaut = perso.getCoord().getY() - 10, cadreBas = perso.getCoord().getY() + 10;
		
		System.out.println();

		for (int i = cadreHaut; i < cadreBas; i++) {
			for (int j = cadreGauche; j < cadreDroit; j++) {
				try {
				System.out.print(carte[i][j]);
				}
				catch (Exception e){ 
				System.out.print(' ');
				}
				
			}
			//if (i%10 == 1) {System.out.print("j'écris du texte en plus");}
			System.out.println();
		}
		System.out.println();

	}

}
