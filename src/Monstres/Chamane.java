package Monstres;

import Equipements.Objet;
import Personnages.Personnage;

public class Chamane extends Monstre{

	public Chamane(String nom, String lettre, Objet[] sac) {
		super(nom, lettre, sac);
	}
	
	public void Attaquer(Personnage personnage) {
		System.out.println(this.getNom()+" attaque "+personnage.getNom()+" !");
		int degat;
		double choix;
		choix = Math.random();
		if(choix<0.5) {
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
		else {
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

}
