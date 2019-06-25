package Personnages;
import java.util.Scanner;

import Cartes.Coord;
import Equipements.Arme;
import Equipements.Armure;
import Equipements.Objet;
import Monstres.Monstre;

public class Paladin extends Personnage{
	private int parerPaladin;
	
	public Paladin(String nom, char lettre, Objet[] sac) {
		super(nom, lettre, sac);
	}
	
	public void Attaquer(Monstre monstre) {
		System.out.println(this.getNom()+" attaque "+monstre.getNom()+" !");
		int degat;
		char choix;
		Scanner sc=new Scanner(System.in);
		System.out.println("Voulez vous attaquer avec Force ou Magie ? (F ou M)");
		choix=sc.nextLine().charAt(0);
		if(choix=='F') {
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
		else {
			degat=monstre.getPointVie()+monstre.getPointResistance()-this.getPointMana();
			if(monstre.getPointResistance()>this.getPointMana()) {
				degat=monstre.getPointVie();
			}
			if(degat<0) {
				degat=0;
			}
			monstre.setPointVie(degat);
			if(this.getPointMana()-monstre.getPointResistance()>0) {
				System.out.println(monstre.getNom()+" perd "+(this.getPointMana()-monstre.getPointResistance())+" point(s) de vie !");
			}
			else {
				System.out.println(monstre.getNom()+" ne perd pas de point de vie !");
			}	
		}
	}
	
	public void Parer() {
		System.out.println(this.getNom()+" pare !");
		this.setParerPaladin(getParerPaladin()+1);
	}

	public int getParerPaladin() {
		return parerPaladin;
	}

	public void setParerPaladin(int parerPaladin) {
		this.parerPaladin = parerPaladin;
	}
	
}
