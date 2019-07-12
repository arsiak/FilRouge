package Personnages;
import java.awt.Image;

import Cartes.Coord;
import Monstres.Monstre;
import Objets.Arme;
import Objets.Armure;
import Objets.Objet;

public class Mage extends Personnage {

	public Mage(String nom) {
		personnage_nom=nom;
		personnage_lettre='M';
		this.setPointRage(0);
	}
	
	public Mage(String nom, char lettre, Coord coord) {
		super(nom, lettre,coord);
		personnage_nom=nom;
		personnage_lettre=lettre;
		personnage_coord=coord;
		this.setPointRage(0);
	}
	
	public Mage(String nom, Image image, Coord coord) {
		super(nom, image,coord);
		personnage_nom=nom;
		personnage_image=image;
		personnage_coord=coord;
		this.setPointRage(0);
	}
	
	public void attaquer(Monstres.Monstre monstre) {
		System.out.println(this.getNom()+" attaque "+monstre.getNom()+" !");
		int degat;
		
		if (monstre.getParade()) this.setPointMana(this.getPointMana()/2);
		
		degat=monstre.getPointVie()+monstre.getPointResistance()-this.getPointMana();
		if(monstre.getPointResistance()>this.getPointMana()) {
			degat=monstre.getPointVie();
			monstre.setPointResistance(monstre.getPointResistance()-this.getPointMana());
		}
		if(degat<0) {
			degat=0;
		}
		monstre.setPointVie(degat);
		if(this.getPointMana()>monstre.getPointResistance()) {
			System.out.println(monstre.getNom()+" perd "+(this.getPointMana()-monstre.getPointResistance())+" point(s) de vie !");
			monstre.setPointResistance(0);
		}
		else {
			System.out.println(monstre.getNom()+" perd " +(monstre.getPointResistance()-this.getPointMana())+" point(s) de résistance !");
		}
		if (monstre.getParade()) {
			this.setPointMana(this.getPointMana()/2);
			monstre.setParade(false);
		}
	}
	
	public void parer() {
		super.parer();
		this.personnage_pointRage++;
		this.personnage_pointMana++;
	}

}
