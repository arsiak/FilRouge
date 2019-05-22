package Personnages;
import Cartes.Coord;
import Equipements.Equipement;

public class Orc extends Personnage{
	private int parerOrc;

	public Orc(String nom,Coord coord, Equipement[] listeArtefact, boolean armure) {
		super(nom, coord, listeArtefact, armure);
		this.personnage_pointVie=90;
		this.personnage_pointAttaque=12;
		this.personnage_pointDefense=7;
		this.personnage_criGuerre="A l'attaque";
		this.setParerOrc(0);
	}

	void lancerCriGuerre(String criGuerre) {
		System.out.println(criGuerre);
	}

	public void Parer(Monstre monstre) {
		System.out.println(this.personnage_nom+" pare "+monstre.getNom()+" !");
		this.setParerOrc(getParerOrc()+1);
	}

	public String toString() {
		return "Nom : "+personnage_nom +" | Point de vie : "+personnage_pointVie+" | Point d'attaque : "+personnage_pointAttaque+" | Point de défense : "+personnage_pointDefense;
	}

	public int getParerOrc() {
		return parerOrc;
	}

	public void setParerOrc(int parerOrc) {
		this.parerOrc = parerOrc;
	}
}
