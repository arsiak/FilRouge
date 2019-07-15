package Main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Bdd.ChargementParam;
import Cartes.*;
import Cartes.Coord;
import Panneau.MenuScenario;
import Personnages.Equipe;
import Personnages.Guerrier;
import Personnages.Personnage;
import Quetes.Pnj;
import Quetes.PnjKaramel;
import Quetes.PnjMaria;
import Quetes.PnjPerlin;
import Quetes.PnjPoppy;
import Quetes.PnjRomuald;
import Tresors.Tresor;

public class MainInterface extends JFrame implements KeyListener {

	//ChargementParam param = new ChargementParam();
	Personnage p = new Guerrier("Elias", '@', new Coord(20,14));
	Equipe equipe = new Equipe ("Votre équipe", new ArrayList<Personnage>());
	Pnj pnjKaramel = new PnjKaramel();
	Pnj pnjPerlin = new PnjPerlin();
	Pnj pnjMaria = new PnjMaria();
	Pnj pnjPoppy = new PnjPoppy();
	Pnj pnjRomuald = new PnjRomuald();
	Carte carte = new CarteMonde();
	MenuScenario scenario = new MenuScenario(this);
	JLabel label = new JLabel();
	
	public MainInterface() {   
		
	    this.setTitle("Début de jeux");
	    this.setSize(450, 470);
	    this.setLocationRelativeTo(null); 
	    //this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setContentPane(carte);
	    //this.setContentPane(scenario);
	    equipe.ajouterPersonnage(p);
	    carte.setDeplacementPerso(p);
	    
	    carte.repaint();
	    this.setTitle(carte.getCarte_nom());
	    
	    addKeyListener (this);
	    
	    this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		int key = e.getKeyCode();

		switch (key) {
		
		  case KeyEvent.VK_UP:
			  carte.setImagePersonnage("Ressources/Images/personnageHaut.png");
			  p.mvtHaut();
			  if (carte.bloque(p) == true) { 
				  //System.out.println(carte.elementCarte(p));
				  if (carte.elementCarte(p).equals("Karamel")) {
					 pnjKaramel.deroulementQuete(this, p); 
				  }
				  
				  if (carte.elementCarte(p).equals("Perlin")) {
					  if (pnjKaramel.getListe_quetes().get(1).getActive())
						  pnjPerlin.boucleQuete(this, p);
					  else 
						  pnjPerlin.boucleSansQuete(this, p);
				  }
				  if (carte.elementCarte(p).equals("Poppy")) {
					  if (pnjKaramel.getListe_quetes().get(1).getActive())
						  pnjPoppy.boucleQuete(this, p);
					  else 
						  pnjPoppy.boucleSansQuete(this, p);
				  } 
					  
				  if (carte.elementCarte(p).equals("tresor")) {
					  for (int i=0; i<carte.getCarte_liste_tresor().size(); i++) {
						  if (carte.getCarte_liste_tresor().get(i).getCarte_nom().equals(carte.getCarte_nom()))
							  carte.getCarte_liste_tresor().get(i).ouvrir(this, p);
				      }
				  }
				  p.mvtBas(); 
			  }
			  break;
		  
		  case KeyEvent.VK_DOWN:
			  carte.setImagePersonnage("Ressources/Images/personnageBas.png");
			  p.mvtBas();
			  if (carte.bloque(p) == true) { 
				  p.mvtHaut();
			  }
		    break;
		  
		  case KeyEvent.VK_LEFT:
			  carte.setImagePersonnage("Ressources/Images/personnageGauche.png");
			  p.mvtGauche();
			  if (carte.bloque(p) == true) { 
				  if (carte.elementCarte(p).equals("Poppy")) {
					  if (pnjMaria.getListe_quetes().get(1).getActive())
						  pnjPoppy.boucleQuete(this, p);
					  else 
						  pnjPoppy.boucleSansQuete(this, p);
				  }
				  if (carte.elementCarte(p).equals("Romuald")) {
						 pnjRomuald.deroulementQuete(this, p); 
				  }
				  if (carte.elementCarte(p).equals("tresor")) {
					  for (int i=0; i<carte.getCarte_liste_tresor().size(); i++) {
						  if (carte.getCarte_liste_tresor().get(i).getCarte_nom().equals(carte.getCarte_nom()))
							  carte.getCarte_liste_tresor().get(i).ouvrir(this, p);
				      }
				  }
				  p.mvtDroite(); 
			  }
		    break;
		  
		  case KeyEvent.VK_RIGHT:
			  carte.setImagePersonnage("Ressources/Images/personnageDroit.png");
			  p.mvtDroite();
			  if (carte.bloque(p) == true) { 
				  if (carte.elementCarte(p).equals("Maria")) {
						 pnjMaria.deroulementQuete(this, p); 
				  }
				  if (carte.elementCarte(p).equals("tresor")) {
					  for (int i=0; i<carte.getCarte_liste_tresor().size(); i++) {
						  if (carte.getCarte_liste_tresor().get(i).getCarte_nom().equals(carte.getCarte_nom()))
							  carte.getCarte_liste_tresor().get(i).ouvrir(this, p);
				      }
				  }
				  p.mvtGauche(); 
			  }
		    break;
		    
		  case KeyEvent.VK_ESCAPE:
			  //dispose();
			  break;
		  }

		if (carte.estChange(p) == true) { 
			carte = carte.changementCarte(p);
			this.setTitle(carte.getCarte_nom());
			this.setContentPane(carte); 
			this.setVisible(true);
		}
		carte.setDeplacementPerso(p);
		carte.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}  
	
//	public void dispose() {
//		param.saveCoordPerso(p);
//		  param.saveCoordCarte(carte);
//		  System.exit(0);
//	}
	

	public static void main(String[] args) throws IOException {
		MainInterface fen = new MainInterface();
	}

}
