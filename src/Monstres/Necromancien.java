package Monstres;

import Equipements.Objet;
import Personnages.Personnage;

public class Necromancien extends Monstre{
	
	public Necromancien(String nom, String lettre, Objet[] sac) {
		super(nom, lettre, sac);
		this.monstre_pointRage=0;
		monstre_pointVie=70;
	}
	
	public void Attaquer(Personnage personnage) {
		System.out.println(this.getNom()+" attaque "+personnage.getNom()+" !");
		int degat;
		degat=personnage.getPointVie()+personnage.getPointResistance()-this.getPointMana();
		if(personnage.getPointResistance()>this.getPointMana()) {
			degat=personnage.getPointVie();
		}
		if(degat<0) {
			degat=0;
		}
		personnage.setPointVie(degat);
		if(this.getPointMana()-personnage.getPointResistance()>0) {
			System.out.println(personnage.getNom()+" perd "+(this.getPointMana()-personnage.getPointResistance())+" point(s) de vie !");
		}
		else {
			System.out.println(personnage.getNom()+" ne perd pas de point de vie !");
		}	
	}

}
