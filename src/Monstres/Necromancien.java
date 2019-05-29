package Monstres;

import Cartes.Coord;
import Equipements.Arme;
import Equipements.Armure;
import Personnages.Personnage;

public class Necromancien extends Monstre{
	
	public Necromancien(String nom, String lettre, Coord coord, Arme[] sacArme, Armure[] armure) {
		super(nom, lettre, coord, sacArme, armure);
		this.monstre_pointRage=0;
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
	
	public String toString() {
		return "Nom : "+getNom() +" | Vie : "+monstre_pointVie+" | Rage : "+monstre_pointRage+" | Défense : "+monstre_pointDefense+" | Mana : "+monstre_pointMana+" | Résistance : "+monstre_pointResistance+" | Vitesse : "+monstre_pointVitesse;
	}

}
