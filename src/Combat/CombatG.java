package Combat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.font.TextLayout;
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
import javax.swing.JFrame;
import javax.swing.JPanel;

import Cartes.Carte;
import Cartes.Coord;
import JsonPack.JSONArray;
import JsonPack.JSONObject;
import Monstres.EquipeMonstre;
import Monstres.FactoryMonstre;
import Monstres.Monstre;
import Personnages.*;
import Tresors.Tresor;



public class CombatG extends JPanel {
	
	private Carte carte;
	private Personnage combattant1, combattant2, combattant3;
	private Monstre monstre1, monstre2, monstre3;

	public CombatG(JFrame jf, Equipe equipe, Carte carte) {
		
		jf.setSize(700,470);
		
		this.carte=carte;
		
		combattant1 = equipe.getListePersonnage().get(0);
		switch (equipe.getListePersonnage().size()) {
			case 2 : combattant2 = equipe.getListePersonnage().get(1); break;
			case 3 : combattant2 = equipe.getListePersonnage().get(1); 
					 combattant3 = equipe.getListePersonnage().get(2);
		}
		
		EquipeMonstre equipeMonstre = null;
		try {
			equipeMonstre = this.initMonstre();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monstre1 = equipeMonstre.getListeMonstre().get(0);
		switch (equipeMonstre.getListeMonstre().size()) {
			case 2 : monstre2 = equipeMonstre.getListeMonstre().get(1); break;
			case 3 : monstre2 = equipeMonstre.getListeMonstre().get(1); 
				 	 monstre3 = equipeMonstre.getListeMonstre().get(2);
		}
	}
	
	public EquipeMonstre initMonstre() throws Exception {
		
		EquipeMonstre equipeMonstre = new EquipeMonstre();
		int random = (int)(Math.random()*3+1);
		for (int i=0; i<random; i++) {
			FactoryMonstre monstre = new FactoryMonstre();
			equipeMonstre.getListeMonstre().add(monstre.getTypeMonstre());
		}
		return equipeMonstre;
	}
	
	public void affichageFond(Graphics g) {
		
		 int x=0, y=0;
		
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, 700, 470);
		 for (int i = 0; i < 6; i++) {
			
			for (int j = 0; j < 14; j++) {
			
				g.drawImage(carte.getCarte_sol(), x, y, 50, 50, this);
				x = x + 50;
			}
			
			y = y + 50;
			x = 0;
		 }
	}
	
	public void affichageCombattants(Graphics g) {
		
		try {
			g.drawImage(ImageIO.read(new File("Ressources/Images/personnageDroit.png")), 250, 75, 50, 50, this);
			if (combattant2 != null) {
				g.drawImage(ImageIO.read(new File("Ressources/Images/" +combattant2.getNom()+ "Droit.png")), 250, 150, 50, 50, this);
			}
			if (combattant3 != null) {
				g.drawImage(ImageIO.read(new File("Ressources/Images/" +combattant3.getNom()+ "Droit.png")), 250, 225, 50, 50, this);
			}
			
			g.drawImage(ImageIO.read(new File("Ressources/Images/" +monstre1.getClass().getSimpleName()+ "Gauche.png")), 350, 75, 50, 50, this);
			if (monstre2 != null) {
				g.drawImage(ImageIO.read(new File("Ressources/Images/" +monstre2.getClass().getSimpleName()+ "Gauche.png")), 350, 150, 50, 50, this);
			}
			if (monstre3 != null) {
				g.drawImage(ImageIO.read(new File("Ressources/Images/" +monstre3.getClass().getSimpleName()+ "Gauche.png")), 350, 225, 50, 50, this);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public void affichageCombat(Graphics g) {
		 
		 g.setFont(new Font("TimesRoman", Font.BOLD, 10)); 
		 
		 g.setColor(Color.WHITE);
		 g.fillRect(10, 50, combattant1.toString().length()+215, 12);
		 g.setColor(Color.BLACK);
		 g.drawString(combattant1.toString(), 10, 60);
		 
		 if (combattant2 != null) {
			 g.setColor(Color.WHITE);
			 g.fillRect(10, 125, combattant1.toString().length()+215, 12);
			 g.setColor(Color.BLACK);
			 g.drawString(combattant2.toString(), 10, 135);
		 }
		 if (combattant3 != null) {
			 g.setColor(Color.WHITE);
			 g.fillRect(10, 200, combattant1.toString().length()+215, 12);
			 g.setColor(Color.BLACK);
			 g.drawString(combattant3.toString(), 10, 210);
		 }
		 
		 g.setColor(Color.WHITE);
		 g.fillRect(350, 50, combattant1.toString().length()+250, 12);
		 g.setColor(Color.BLACK);
		 g.drawString(monstre1.toString(), 350, 60);
		 
		 if (monstre2 != null) {
			 g.setColor(Color.WHITE);
			 g.fillRect(350, 125, combattant1.toString().length()+250, 12);
			 g.setColor(Color.BLACK);
			 g.drawString(monstre2.toString(), 350, 135);
		 }
		 if (monstre3 != null) {
			 g.setColor(Color.WHITE);
			 g.fillRect(350, 200, combattant1.toString().length()+250, 12);
			 g.setColor(Color.BLACK);
			 g.drawString(monstre3.toString(), 350, 210);
		 }
	
	 }
	
	 public void paintComponent(Graphics g){
		
		 this.affichageFond(g);
		 this.affichageCombattants(g);
		 this.affichageCombat(g);
		 
	 }
	 

}
