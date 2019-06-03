package Main;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Cartes.*;
import Cartes.Coord;
import Equipements.Equipement;
import Personnages.Personnage;
import Quetes.Pnj;
import Quetes.PnjKaramel;
import Quetes.PnjMaria;
import Quetes.PnjPerlin;
import Quetes.PnjPoppy;
import Quetes.PnjRomuald;
import Tresors.Tresor;

public class MainInterface extends JFrame implements KeyListener {

	Personnage p = new Personnage(new Coord(22, 14));
	Pnj pnjKaramel = new PnjKaramel();
	Pnj pnjPerlin = new PnjPerlin();
	Pnj pnjMaria = new PnjMaria();
	Pnj pnjPoppy = new PnjPoppy();
	Pnj pnjRomuald = new PnjRomuald();
	Tresor tresor = new Tresor("Donjon4", new Equipement("Le Bouclier de Perlin"));
	Carte carte = new CarteMonde();
	
	public MainInterface() {   
		
	    this.setTitle("Test de map");
	    this.setSize(450, 470);
	    this.setLocationRelativeTo(null); 
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setContentPane(carte);
	    carte.setDeplacementPerso(p);
	    
	    carte.repaint();
	    
	    
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
			  carte.setImagePersonnage("src/Images/personnageHaut.png");
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
			  carte.setImagePersonnage("src/Images/personnageBas.png");
			  p.mvtBas();
			  if (carte.bloque(p) == true) { 
				  p.mvtHaut();
			  }
		    break;
		  
		  case KeyEvent.VK_LEFT:
			  carte.setImagePersonnage("src/Images/personnageGauche.png");
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
			  carte.setImagePersonnage("src/Images/personnageDroit.png");
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
		  }

		if (carte.estChange(p) == true) { 
			carte = carte.changementCarte(p);
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

	public static void main(String[] args) throws IOException {
		MainInterface fen = new MainInterface();
	}

}
