package Personnages;
import Cartes.Coord;
import Equipements.Arme;
import Equipements.Armure;
import Monstres.Monstre;


public class Guerrier extends Personnage {
	private int parerGuerrier=0;
	
	public Guerrier(String nom, Coord coord, Arme[] sacArme, Armure[] armure) {
		super(nom, coord, sacArme, armure);
		this.setPointMana(0);
	}
	
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
	
	public String toString() {
		return "Nom : "+this.getNom() +" | Vie : "+this.getPointVie()+" | Rage : "+this.getPointRage()+" | Défense : "+this.getPointDefense()+" | Mana : "+this.getPointMana()+" | Résistance : "+this.getPointResistance()+" | Vitesse : "+this.getPointVitesse();
	}

	public int getParerGuerrier() {
		return parerGuerrier;
	}

	public void setParerGuerrier(int parerGuerrier) {
		this.parerGuerrier = parerGuerrier;
	}

}
