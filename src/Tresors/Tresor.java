package Tresors;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Cartes.Carte;
import Cartes.Coord;
import Objets.Epee;
import Objets.FactoryObjet;
import Objets.Objet;
import Objets.ObjetQuete;
import Personnages.Personnage;
import Quetes.Pnj;
import Quetes.PnjKaramel;
import Quetes.PnjMaria;
import Quetes.PnjPerlin;
import Quetes.PnjPoppy;
import Quetes.PnjRomuald;

public class Tresor {

	private Carte tresor_carte;
	private Objet tresor_contenu;
	private boolean tresor_ouvert = false;
	private Pnj karamel, maria, perlin, poppy, romuald;
	
	public Tresor(Carte carte, Pnj k, Pnj m, Pnj pl, Pnj pp, Pnj r) {
		tresor_carte=carte;
		karamel=k;
		maria=m;
		perlin=pl;
		poppy=pp;
		romuald=r;
		this.creationObjet();
	}
	
	public void ouvrir(JFrame jf,Personnage perso) {
		
		if (tresor_ouvert == false) {
			JOptionPane.showMessageDialog(jf,
					  tresor_contenu.getNom(),
					  "Le coffre contient : ",
					  JOptionPane.PLAIN_MESSAGE);
			perso.ajouterEquipement(tresor_contenu);
			tresor_ouvert = true;
		}
		else {
			JOptionPane.showMessageDialog(jf,
					  " Vide",
					  "Le coffre contient : ",
					  JOptionPane.PLAIN_MESSAGE);
		}
		
		//System.out.println(perso.getEquipement());
	}
	
	public void ouvrir(Personnage perso) {
		
		if (tresor_ouvert == false) {
			System.out.println("Le coffre contient " +tresor_contenu.getNom());
			perso.ajouterEquipement(tresor_contenu);
			tresor_ouvert = true;
		}
		else {
			System.out.println("Le coffre ne contient plus rien");
		}
		//System.out.println(perso.getEquipement());
	}
	
	public void creationObjet() {
		
		boolean creation = false;
		Pnj[] allPnj = {karamel, maria, romuald};
		
		for (int j=0; j<allPnj.length; j++) {
			
			for (int i=0; i<allPnj[j].getListe_quetes().size(); i++) {
				if (allPnj[j].getListe_quetes().get(i).getObjet().getDestination().equals("Tresor") 
					&& tresor_carte.getCarte_nom().equals(allPnj[j].getListe_quetes().get(i).getObjet().getCarte_nom()) 
					&& allPnj[j].getListe_quetes().get(i).getActive()) {
						tresor_contenu = allPnj[j].getListe_quetes().get(i).getObjet();
						creation = true;
						i=allPnj[j].getListe_quetes().size();
				}
			}
		}
		
		if (creation == false) {
			tresor_contenu = new FactoryObjet().getObjet();
		}
	}
	
}
