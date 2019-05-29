package Personnages;
import Cartes.Coord;
import Equipements.Arme;
import Equipements.Armure;
import Monstres.Monstre;

public class Mage extends Personnage{
	private int parerMage;
	
	public Mage(String nom, Coord coord, Arme[] sacArme, Armure[] armure) {
		super(nom, coord, sacArme, armure);
		this.setPointRage(0);
	}
	
	public void Attaquer(Monstres.Monstre monstre) {
		System.out.println(this.getNom()+" attaque "+monstre.getNom()+" !");
		int degat;
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
	
	public void Parer() {
		System.out.println(this.getNom()+" pare !");
		this.setParerMage(getParerMage()+1);
	}
	
	public String toString() {
		return "Nom : "+this.getNom() +" | Vie : "+this.getPointVie()+" | Rage : "+this.getPointRage()+" | D�fense : "+this.getPointDefense()+" | Mana : "+this.getPointMana()+" | R�sistance : "+this.getPointResistance()+" | Vitesse : "+this.getPointVitesse();
	}

	public int getParerMage() {
		return parerMage;
	}

	public void setParerMage(int parerMage) {
		this.parerMage = parerMage;
	}
}
