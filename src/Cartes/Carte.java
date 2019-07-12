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
import Monstres.Monstre;
import Objets.Objet;
import Objets.ObjetQuete;
import Personnages.*;
import Quetes.Pnj;
import Quetes.PnjKaramel;
import Quetes.PnjMaria;
import Quetes.PnjPerlin;
import Quetes.PnjPoppy;
import Quetes.PnjRomuald;
import Quetes.Quete;
import Tresors.Tresor;



public class Carte extends JPanel {
	
	protected String carte_nom;
	protected Personnage perso = new Personnage();
	protected Equipe equipe = new Equipe();
	protected char [][] carte;
	protected HashMap<String,Coord> carte_coord_entree_sortie;
	protected HashMap<String,Monstre> carte_boss;
	protected Tresor carte_tresor;
	protected ArrayList<Tresor> carte_liste_tresor;
	protected Image carte_sol;
	protected Image carte_sol_exterieur;
	protected Image carte_obstacle_1;
	protected Image carte_obstacle_2;
	protected Image carte_entree_1;
	protected Image carte_entree_2;
	protected Image carte_sortie;
	protected Image carte_pnj_1;
	protected Image carte_pnj_2;
	protected Image carte_pnj_3;
	protected Image carte_img_boss;
	protected Image carte_img_tresor;
	protected Image carte_personnage;
	protected int carte_largeurCarte, carte_longueurCarte;


	public Carte() {

	}
	
	public String getCarte_nom() {
		return carte_nom;
	}
	
	public HashMap<String, Monstre> getCarte_boss() {
		return carte_boss;
	}
	
	public Tresor getCarte_tresor() {
		return carte_tresor;
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

		this.perso=perso;
		Boolean bloque = false;
		if (carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'X' || carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'O' || // Obstacle
			(carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'K' && !equipe.verifiePersonnage((new PnjKaramel()).getNom()))       || // Pnj
			(carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'M' && !equipe.verifiePersonnage((new PnjMaria()).getNom()))         || 
			(carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'R' && !equipe.verifiePersonnage((new PnjRomuald()).getNom()))       ||
			(carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'P' && !equipe.verifiePersonnage((new PnjPerlin()).getNom()))        ||
			(carte[perso.getCoord().getY()][perso.getCoord().getX()] == 'Y' && !equipe.verifiePersonnage((new PnjPoppy()).getNom()))         ||
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
			case 'P': element_nom = "Perlin"; break;
			case 'Y': element_nom = "Poppy"; break;
			case 'T': element_nom = "tresor"; break;
			case 'B': element_nom = "boss"; break;
			case 'L': element_nom = "lavande"; break;
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
	
	 public void setDeplacementPerso(Personnage perso, Equipe equipe) {
		 
		 this.perso.setCoord(perso.getCoord());
		 this.equipe=equipe;
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
								
								g.drawImage(getCarte_sol(),x ,y, 50, 50, this);
								if (carte[i][j] == 'X') { g.drawImage(carte_obstacle_1, x, y, 50, 50, this); } 
								if (carte[i][j] == 'O') { g.drawImage(carte_obstacle_2, x, y, 50, 50, this); }
								if (carte[i][j] == 'D') { g.drawImage(carte_entree_1, x, y, 50, 50, this); } 
								if (carte[i][j] == 'V') { g.drawImage(carte_entree_2, x, y, 50, 50, this); } 
								if (carte[i][j] == 'S') { g.drawImage(carte_sortie, x, y, 50, 50, this); }
								if ((carte[i][j] == 'Y' && !equipe.verifiePersonnage((new PnjPoppy()).getNom())) || 
									(carte[i][j] == 'C' && !equipe.verifiePersonnage((new PnjPerlin()).getNom())) ||
									(carte[i][j] == 'K' && !equipe.verifiePersonnage((new PnjKaramel()).getNom()))) 
									{ g.drawImage(carte_pnj_1, x, y, 50, 50, this); }
								if (carte[i][j] == 'M'  && !equipe.verifiePersonnage((new PnjMaria()).getNom())) 
									{ g.drawImage(carte_pnj_2, x, y, 50, 50, this); }
								if (carte[i][j] == 'R'  && !equipe.verifiePersonnage((new PnjRomuald()).getNom())) 
									{ g.drawImage(carte_pnj_3, x, y, 50, 50, this); }
								if (carte[i][j] == 'T') { g.drawImage(carte_img_tresor, x, y, 50, 50, this); }
								if (carte[i][j] == 'B' && carte_boss.get(this.getCarte_nom()).getEstVivant()) { g.drawImage(carte_img_boss, x, y, 50, 50, this); }
								if (carte[i][j] == 'L' && !perso.verifieEquipement(new ObjetQuete("Des ornements dorés"))) { g.drawImage(ImageIO.read(new File("Ressources/Images/lavande.png")), x, y, 50, 50, this); }
							
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
		int affichage = 0;
		
		System.out.println();

		for (int i = cadreHaut; i < cadreBas; i++) {
			for (int j = cadreGauche; j < cadreDroit; j++) {
				try {
					if (carte[i][j] == 'K' && equipe.verifiePersonnage("Karamel") || 
						carte[i][j] == 'M' && equipe.verifiePersonnage("Maria")   || 
						carte[i][j] == 'R' && equipe.verifiePersonnage("Romuald") || 
						carte[i][j] == 'P' && equipe.verifiePersonnage("Perlin")  || 
						carte[i][j] == 'Y' && equipe.verifiePersonnage("Poppy")   || 
						carte[i][j] == 'B' && !this.carte_boss.get(this.carte_nom).getEstVivant()) {
						
						System.out.print(' ');
					}
					else {
						System.out.print(carte[i][j]);
					}
					
				}
				catch (Exception e){ 
				//System.out.print(' ');
				}
				
			}
			/*
			switch (affichage) {
			case 0: System.out.print("      z : haut "); break;
			case 1: System.out.print("      s : bas "); break;
			case 2: System.out.print("      q : gauche "); break;
			case 3: System.out.print("      d : droite "); break;
			case 4: System.out.print("      m : menu "); break;
			case 5: System.out.print("      t : sauvegarder "); break;
			}
			affichage++;
			*/
			
			System.out.println();
		}		
		System.out.println("\n| z : haut | s : bas | q : gauche | d : droite | m : menu | t : sauvegarder");
		
	}

	public Image getCarte_sol() {
		return carte_sol;
	}
	
}
