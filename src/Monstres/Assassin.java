package Monstres;

import Equipements.Objet;
import Personnages.Personnage;

public class Assassin extends Monstre {
	
	public Assassin(String nom, String lettre, Objet[] sac) {
		super(nom, lettre, sac);
		this.monstre_pointMana=0;
	}
	
	public void Attaquer(Personnage personnage) {
		System.out.println(this.getNom()+" attaque "+personnage.getNom()+" !");
		int degat;
		degat=personnage.getPointVie()+personnage.getPointDefense()-this.getPointRage();
		if(personnage.getPointDefense()>this.getPointRage()) {
			degat=personnage.getPointVie();
		}
		if(degat<0) {
			degat=0;
		}
		personnage.setPointVie(degat);
		if(this.getPointRage()-personnage.getPointDefense()>0) {
			System.out.println(personnage.getNom()+" perd "+(this.getPointRage()-personnage.getPointDefense())+" point(s) de vie !");
		}
		else {
			System.out.println(personnage.getNom()+" ne perd pas de point de vie !");
		}	
	}

}
