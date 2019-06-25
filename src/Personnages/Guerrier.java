package Personnages;

import Cartes.Coord;
import Monstres.Monstre;


public class Guerrier extends Personnage {
	
	private int parerGuerrier=0;
	
	public Guerrier() {
		personnage_lettre='G';
		personnage_pointVie=120;
	}
	
	public Guerrier(String nom, char lettre, Coord coord) {
		super(nom, lettre,coord);
		personnage_lettre=lettre;
		personnage_pointVie=120;
	}
	
	/*
	public Guerrier(String nom, Objet[] sac) {
		super(nom, sac);
		this.setPointMana(0);
	}
	*/
	
	public void Attaquer(Monstre monstre) {
		System.out.println(this.getNom()+" attaque "+monstre.getNom()+" !");
		int degat;
		degat=monstre.getPointVie()+monstre.getPointDefense()-this.getPointRage();
		if(monstre.getPointDefense()>this.getPointRage()) {
			degat=monstre.getPointVie();
		}
		if(degat<0) {
			degat=0;
		}
		monstre.setPointVie(degat);
		if(this.getPointRage()-monstre.getPointDefense()>0) {
			System.out.println(monstre.getNom()+" perd "+(this.getPointRage()-monstre.getPointDefense())+" point(s) de vie !");
		}
		else {
			System.out.println(monstre.getNom()+" ne perd pas de point de vie !");
		}	
	}
	
	public void Parer() {
		System.out.println(this.getNom()+" pare !");
		this.setParerGuerrier(getParerGuerrier()+1);
	}		

	public int getParerGuerrier() {
		return parerGuerrier;
	}

	public void setParerGuerrier(int parerGuerrier) {
		this.parerGuerrier = parerGuerrier;
	}

}
