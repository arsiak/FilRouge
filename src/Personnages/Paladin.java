package Personnages;
import java.awt.Image;
import java.util.Scanner;

import Cartes.Coord;
import Monstres.Monstre;
import Objets.Arme;
import Objets.Armure;
import Objets.Objet;

public class Paladin extends Personnage{
	
	private int parerPaladin;
	
	public Paladin(String nom) {
		personnage_nom=nom;
		personnage_lettre='P';
	}
	
	public Paladin(String nom, char lettre, Coord coord) {
		super(nom, lettre,coord);
		personnage_nom=nom;
		personnage_lettre=lettre;
		personnage_coord=coord;
	}
	
	public Paladin(String nom, Image image, Coord coord) {
		super(nom, image,coord);
		personnage_nom=nom;
		personnage_image=image;
		personnage_coord=coord;
	}
	
	public void attaquer(Monstre monstre) {
		System.out.println(this.getNom()+" attaque "+monstre.getNom()+" !");
		int degat;
		
		if (monstre.getParade()) {
			this.setPointRage(this.getPointRage()/2);
			this.setPointMana(this.getPointMana()/2);
		}
		
		char choix;
		Scanner sc=new Scanner(System.in);
		System.out.println("Voulez vous attaquer avec Force ou Magie ? (F ou M)");
		choix=sc.nextLine().charAt(0);
		if(choix=='F') {
			degat=monstre.getPointVie()+monstre.getPointDefense()-this.getPointRage();
			if(monstre.getPointDefense()>this.getPointRage()) {
				degat=monstre.getPointVie();
				monstre.setPointDefense(monstre.getPointDefense()-this.getPointRage());
			}
			if(degat<0) {
				degat=0;
			}
			monstre.setPointVie(degat);
			if(this.getPointRage()>monstre.getPointDefense()) {
				System.out.println(monstre.getNom()+" perd "+(this.getPointRage()-monstre.getPointDefense())+" point(s) de vie !");
				monstre.setPointDefense(0);
			}
			else {
				System.out.println(monstre.getNom()+" perd " +(monstre.getPointDefense()-this.getPointRage())+" point(s) de défense !");
			}	
		}
		else {
			degat=monstre.getPointVie()+monstre.getPointResistance()-this.getPointMana();
			if(monstre.getPointResistance()>this.getPointMana()) {
				degat=monstre.getPointVie();
				monstre.setPointResistance(monstre.getPointResistance()-this.getPointMana());
			}
			if(degat<0) {
				degat=0;
			}
			monstre.setPointVie(degat);
			if(this.getPointMana()-monstre.getPointResistance()>0) {
				System.out.println(monstre.getNom()+" perd "+(this.getPointMana()-monstre.getPointResistance())+" point(s) de vie !");
				monstre.setPointResistance(0);
			}
			else {
				System.out.println(monstre.getNom()+" perd " +(monstre.getPointResistance()-this.getPointMana())+" point(s) de résistance !");
			}	
		}
		if (monstre.getParade()) {
			this.setPointRage(this.getPointRage()*2);
			this.setPointMana(this.getPointMana()*2);
			monstre.setParade(false);
		}
	}
	
	public void parer() {
		super.parer();
		this.personnage_pointRage++;
	}
	
}
