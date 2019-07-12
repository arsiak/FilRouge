package Main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Bdd.ChargementParam;
import Bdd.SauvegardeParam;
import Cartes.*;
import Cartes.Coord;
import Combat.Combat;
import Combat.CombatG;
import Objets.Amulette;
import Objets.Bouclier;
import Objets.Epee;
import Objets.ObjetQuete;
import Objets.PotionVie;
import Panneau.MenuScenario;
import Personnages.Equipe;
import Personnages.Guerrier;
import Personnages.Mage;
import Personnages.Paladin;
import Personnages.Personnage;
import Quetes.Pnj;
import Quetes.PnjKaramel;
import Quetes.PnjMaria;
import Quetes.PnjPerlin;
import Quetes.PnjPoppy;
import Quetes.PnjRomuald;
import Tresors.Tresor;

public class MainInterface extends JFrame implements KeyListener {

	ChargementParam chargement = new ChargementParam();
	SauvegardeParam sauvegarde = new SauvegardeParam();
	Personnage p = new Guerrier("Elias", '@', chargement.getCoordPerso());
	Equipe equipe = new Equipe ("Votre équipe", new ArrayList<Personnage>());
	Pnj pnjKaramel = new PnjKaramel();
	PnjPerlin pnjPerlin = new PnjPerlin();
	Pnj pnjMaria = new PnjMaria();
	PnjPoppy pnjPoppy = new PnjPoppy();
	Pnj pnjRomuald = new PnjRomuald();
	Carte carte = chargement.getCoordCarte();
	MenuScenario scenario = new MenuScenario(this);
	JLabel label = new JLabel();
	CombatG combat;
	Tresor tresor;
	
	int personnage_pas = 0, combat_apparition;
	
	public MainInterface() {   
		
	    this.setTitle("Début de jeux");
	    this.setSize(450, 470);
	    this.setLocationRelativeTo(null); 
	    //this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setContentPane(carte);
	    //this.setContentPane(scenario);
	    equipe.ajouterPersonnage(p);
	 // essai d'équipe
		Paladin poppy = new Paladin("Poppy");
		poppy.ajouterEquipement(new Epee());
		poppy.ajouterEquipement(new Bouclier());
		Mage maria = new Mage("Maria");
		maria.ajouterEquipement(new Amulette());
		maria.ajouterEquipement(new PotionVie());
		//equipe.ajouterPersonnage(poppy);
		//equipe.ajouterPersonnage(maria);
		//fin d'essai
	    carte.setDeplacementPerso(p, equipe);
	    if (carte.getCarte_nom().contains("Donjon")) {
	    	tresor = new Tresor(carte, pnjKaramel, pnjMaria, pnjPerlin, pnjPoppy, pnjRomuald);
	    }
	    
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
					 pnjKaramel.deroulementQuete(this, equipe); 
				  }
				  
				  if (carte.elementCarte(p).equals("Perlin")) {
					  if (pnjKaramel.getListe_quetes().get(1).getActive() || pnjKaramel.getQueteActuel() > 2)
						  pnjPerlin.boucleFinListeQuete(this, equipe, pnjKaramel);
					  else 
						  pnjPerlin.boucleSansQuete(this, p);
				  }
				  if (carte.elementCarte(p).equals("Poppy")) {
					  if (pnjKaramel.getListe_quetes().get(1).getActive() || pnjMaria.getQueteActuel() > 2)
						  pnjPoppy.boucleFinListeQuete(this, equipe, pnjMaria);
					  else 
						  pnjPoppy.boucleSansQuete(this, p);
				  }   
				  if (carte.elementCarte(p).equals("tresor")) {
						 tresor.ouvrir(this, p);
				  }
				  
				  p.mvtBas(); 
			  }
			  break;
		  
		  case KeyEvent.VK_DOWN:
			  carte.setImagePersonnage("Ressources/Images/personnageBas.png");
			  p.mvtBas();
			  if (carte.bloque(p) == true) {
				  if (carte.elementCarte(p).equals("tresor")) {
						 tresor.ouvrir(this, p);
				  }
				  p.mvtHaut();
			  }
		    break;
		  
		  case KeyEvent.VK_LEFT:
			  carte.setImagePersonnage("Ressources/Images/personnageGauche.png");
			  p.mvtGauche();
			  if (carte.bloque(p) == true) { 
				  if (carte.elementCarte(p).equals("Poppy")) {
					  if (pnjMaria.getListe_quetes().get(1).getActive() || pnjMaria.getQueteActuel() > 2)
						  pnjPoppy.boucleFinListeQuete(this, equipe, pnjKaramel);
					  else 
						  pnjPoppy.boucleSansQuete(this, p);
				  }
				  if (carte.elementCarte(p).equals("Romuald")) {
						 pnjRomuald.deroulementQuete(this, equipe); 
				  }
				  if (carte.elementCarte(p).equals("tresor")) {
						 tresor.ouvrir(this, p);
				  }
				  p.mvtDroite(); 
			  }
		    break;
		  
		  case KeyEvent.VK_RIGHT:
			  carte.setImagePersonnage("Ressources/Images/personnageDroit.png");
			  p.mvtDroite();
			  if (carte.bloque(p) == true) { 
				  if (carte.elementCarte(p).equals("Maria")) {
						 pnjMaria.deroulementQuete(this, equipe); 
				  }
				  if (carte.elementCarte(p).equals("tresor")) {
						 tresor.ouvrir(this, p);
				  }
				  p.mvtGauche(); 
			  }
			  if (carte.elementCarte(p).equals("lavande")) {
					 p.ajouterEquipement(new ObjetQuete("Des ornements dorés"));
			  }
		    break;
		    
		  case KeyEvent.VK_ESCAPE:
			  dispose();
			  break;
		  }

		if (carte.estChange(p) == true) {
				
			carte = carte.changementCarte(p);
			this.setTitle(carte.getCarte_nom());
			if (carte.getCarte_nom().contains("Donjon")) {
				tresor = new Tresor(carte, pnjKaramel, pnjMaria, pnjPerlin, pnjPoppy, pnjRomuald);
				personnage_pas = 0;
				//combat_apparition = (int)(Math.floor(Math.random()*5 + 5));
			}
			this.setContentPane(carte); 
			this.setVisible(true);
		}
		carte.setDeplacementPerso(p, equipe);
		carte.repaint();
		
		if (carte.getCarte_nom().contains("Donjon")) {
			
			personnage_pas++;
			if (personnage_pas == combat_apparition) {
				combat = new CombatG(this,equipe, carte);
				this.setContentPane(combat);
				this.setVisible(true);
				this.setTitle("Vous êtes attaqués");
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}  
	
	public void dispose() {
		sauvegarde.saveCoordPerso(p);
		sauvegarde.saveCoordCarte(carte);
		System.exit(0);
	}
	

	public static void main(String[] args) throws IOException {
		MainInterface fen = new MainInterface();
	}

}
