package Personnages;

import java.awt.Image;

import Cartes.Coord;
import Monstres.Monstre;


public class Guerrier extends Personnage {
	
	public Guerrier(String nom) {
		personnage_nom=nom;
		personnage_lettre='G';
		personnage_pointVie=120;
	}
	
	public Guerrier(String nom, char lettre, Coord coord) {
		super(nom, lettre,coord);
		personnage_lettre=lettre;
		personnage_pointVie=120;
	}
	
	public Guerrier(String nom, Image image, Coord coord) {
		super(nom, image,coord);
		personnage_image=image;
		personnage_pointVie=120;
	}
	
	public void attaquer(Monstre monstre) {
		System.out.println(this.getNom()+" attaque "+monstre.getNom()+" !");
		int degat;
		
		if (monstre.getParade()) this.setPointRage(this.getPointRage()/2);
		
		degat=monstre.getPointVie()+monstre.getPointDefense()-this.getPointRage();
		if(monstre.getPointDefense()>this.getPointRage()) {
			degat=monstre.getPointVie();
			monstre.setPointDefense(monstre.getPointDefense()-this.getPointRage());
		}
		if(degat<0) {
			degat=0;
		}
		monstre.setPointVie(degat);
		if(this.getPointRage()-monstre.getPointDefense()>0) {
			System.out.println(monstre.getNom()+" perd "+(this.getPointRage()-monstre.getPointDefense())+" point(s) de vie !");
			monstre.setPointDefense(0);
		}
		else {
			System.out.println(monstre.getNom()+" perd " +(monstre.getPointDefense()-this.getPointRage())+" point(s) de défense !");
		}
		if (monstre.getParade()) {
			this.setPointRage(this.getPointRage()/2);
			monstre.setParade(false);
		}
	}
	
	public void parer() {
		super.parer();
		this.personnage_pointRage++;
	}			

}
