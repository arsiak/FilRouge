package Panneau;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.font.TextLayout;
import java.awt.image.ImageProducer;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import JsonPack.JSONArray;
import JsonPack.JSONObject;
import Personnages.*;
import Tresors.Tresor;



public class MenuScenario extends JPanel {
	
	JFrame jf;
	String cheminImg = "Ressources/Images/eau.png";
	BoutonPerso button = new BoutonPerso("Jouer", cheminImg);
	
	String[] scenario = {"Bienvenue dans le monde de Imahyra ",
						 "Aidez votre personnage Elias a retrouver",
						 "l anneau de son defunt pere. ",
						 "Vous allez affronter de multiples monstres,",
						 "des assassins, des necromanciens, des chamanes.",
						 "A travers differentes quetes, faites evoluer ",
						 "Elias dans sa recherche de vengeance.",
						 "Bonne chance jeune aventurier "};

	public MenuScenario() { }
	
	public MenuScenario(JFrame jf) {
		this.setLayout(new BorderLayout());
		
		this.jf=jf;
		button.setPreferredSize(new Dimension(150,40));
		button.setText("Jouer");
		button.setAlignmentY(jf.getHeight()-100);
		this.add(button, BorderLayout.SOUTH);
	}
	
	
	 public void paintComponent(Graphics g){
		
		 String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		 for (int i=0; i<fonts.length;i++) System.out.println(fonts[i]);
		 
		 Graphics2D g1 = (Graphics2D) g;
		 
		 try {
			 	g1.setComposite(AlphaComposite.SrcOver.derive(0.9f));
				g1.drawImage(ImageIO.read(new File("Ressources/Images/eau.png")), 0, 0, jf.getWidth(), jf.getHeight(), this);
				g1.setComposite(AlphaComposite.SrcOver.derive(1f));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 int ecartBordH = 70, ecartPhrase = 30, taille = 25, taille2 = 12;

		 for (int i=0; i<scenario.length; i++) {
			 
			if (i!=0) {ecartBordH=120; taille=18; taille2=9;}
		
		    TextLayout textLayout = new TextLayout(scenario[i], new Font("Balonku",Font.BOLD,taille), g1.getFontRenderContext());
		    g1.setPaint(new Color(150, 150, 150));
		    textLayout.draw(g1, (jf.getWidth()-scenario[i].length()*taille2)/2+2, ecartBordH + 2 +i*ecartPhrase);

		    g1.setPaint(Color.RED);
		    textLayout.draw(g1, (jf.getWidth()-scenario[i].length()*taille2)/2, ecartBordH +i*ecartPhrase);
			
		 }
		    
	 }

	public void afficher() {
		
		for (int i=0; i< scenario.length; i++) {
			System.out.println(scenario[i]);
		}
		
	}

}
