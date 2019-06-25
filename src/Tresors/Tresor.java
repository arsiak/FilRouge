package Tresors;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Cartes.Coord;
import Equipements.Objet;
import Personnages.Personnage;

public class Tresor {

	protected Coord tresor_coord;
	protected String tresor_carte_nom;
	protected Objet tresor_contenu;
	
	public Tresor(String carte_nom, Objet objet) {
		tresor_carte_nom=carte_nom;
		tresor_contenu=objet;
	}
	
	public Tresor(Coord coord, String carte_nom, Objet objet) {
		tresor_coord=coord;
		tresor_carte_nom=carte_nom;
		tresor_contenu=objet;
	}
	
	public Coord getCoord() {
		return tresor_coord;
	}
	
	public String getCarte_nom() {
		return tresor_carte_nom;
	}
	
	public void ouvrir(JFrame jf,Personnage perso) {
		
		if (!(Arrays.asList(perso.getSac()).contains(tresor_contenu))) {
			JOptionPane.showMessageDialog(jf,
					  tresor_contenu.getNom(),
					  "Le coffre contient : ",
					  JOptionPane.PLAIN_MESSAGE);
			perso.ajouterEquipement(tresor_contenu);
		}
		else {
			JOptionPane.showMessageDialog(jf,
					  "        vide",
					  "Le coffre contient : ",
					  JOptionPane.PLAIN_MESSAGE);
		}
		
		//System.out.println(perso.getEquipement());
	}
}
