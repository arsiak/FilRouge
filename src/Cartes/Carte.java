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
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import JsonPack.JSONArray;
import JsonPack.JSONObject;
import Personnages.*;



public class Carte extends JPanel {

	protected Perso perso = new Perso();
	public String nomCarte;
	protected char [][] carte;
	protected HashMap<String,Coord> ensembleEntreeSortie;
	protected Coord coordEntreeSortie;
	protected Image sol, obstacle_1, obstacle_2, entree_1,entree_2, sortie, pnj_1, pnj_2, boss, tresor, personnage;
	
	public Carte() {
		
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
	
	public void setImagePersonnage(String cheminImage) {
		try {
			personnage = ImageIO.read(new File(cheminImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		if (carte[perso.getCoord().getY()][perso.getCoord().getX()] ==  'D' || carte[perso.getCoord().getY()][perso.getCoord().getX()] ==  'V' ||
			carte[perso.getCoord().getY()][perso.getCoord().getX()] ==  'S') { 
			change = true; 
		}
		return change;
		
	}
	
	public Carte changementCarte(Perso perso) {
		
		if (carte[perso.getCoord().getY()][perso.getCoord().getX()] ==  'V') {
			this.perso.setCoord(ensembleEntreeSortie.get("EntreeVillage"));
			perso.setCoord(ensembleEntreeSortie.get("EntreeVillage"));
			return new CarteVillage();
		}
		else if (carte[perso.getCoord().getY()][perso.getCoord().getX()] ==  'D') {
			for (int i=0; i<ensembleEntreeSortie.size();i++) {
				if (this.perso.getCoord().equals(ensembleEntreeSortie.get("Donjon" +(i+1)))) {
					this.perso.setCoord(ensembleEntreeSortie.get("EntreeDonjon"));
					perso.setCoord(ensembleEntreeSortie.get("EntreeDonjon"));
					return new CarteDonjon(i+1);
				}
			}
		}
		else if (carte[perso.getCoord().getY()][perso.getCoord().getX()] ==  'S') {
			this.perso.setCoord(ensembleEntreeSortie.get(nomCarte));
			perso.setCoord(ensembleEntreeSortie.get(nomCarte));
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
	
	 public void setDeplacementPerso(Perso perso) {
		 
		 this.perso.setCoord(perso.getCoord());
		 
	 }
	
	 public void paintComponent(Graphics g){
		
			    int cadreGauche = perso.getCoord().getX() - 4, cadreDroit = perso.getCoord().getX() + 4;
				int cadreHaut = perso.getCoord().getY() - 4, cadreBas = perso.getCoord().getY() + 4;
				
				int x=0, y=0;
			
				for(int i = cadreHaut; i <= cadreBas; i++ ){  
					
					for(int j = cadreGauche; j <= cadreDroit; j++){  
						
						g.drawImage(sol,x ,y, 50, 50, this);
						if (carte[i][j] == 'X') { g.drawImage(obstacle_1, x, y, 50, 50, this); } 
						if (carte[i][j] == 'O') { g.drawImage(obstacle_2, x, y, 50, 50, this); }
						if (carte[i][j] == 'D') { g.drawImage(entree_1, x, y, 50, 50, this); } 
						if (carte[i][j] == 'V') { g.drawImage(entree_2, x, y, 50, 50, this); } 
						if (carte[i][j] == 'S') { g.drawImage(sortie, x, y, 50, 50, this); }
						if (carte[i][j] == 'M') { g.drawImage(pnj_1, x, y, 50, 50, this); }
						if (carte[i][j] == 'N') { g.drawImage(pnj_2, x, y, 50, 50, this); }
						if (carte[i][j] == 'T') { g.drawImage(tresor, x, y, 50, 50, this); }
						if (carte[i][j] == 'B') { g.drawImage(boss, x, y, 50, 50, this); }
						
						x+=50;
						
					}
					y+=50;
					x=0;
				}
			  
		      g.drawImage(personnage, 200, 200, 50, 50, this);
		    
		     
		  }

	public HashMap<String,Coord> getEnsembleEntreeSortie() {
		// TODO Auto-generated method stub
		return ensembleEntreeSortie;
	} 
	
	public void afficher() {
		
		int cadreGauche = perso.getCoord().getX() - 10, cadreDroit = perso.getCoord().getX() + 10;
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
		System.out.println();
		}
		System.out.println();

	}
	 
}
