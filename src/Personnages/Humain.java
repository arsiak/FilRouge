package Personnages;
import Cartes.Coord;
import Equipements.Equipement;

public class Humain extends Personnage {

	public Humain(String nom, Coord coord, Equipement[] listeArtefact, boolean armure) {
		super(nom, coord, listeArtefact, armure);
		this.personnage_criGuerre="A l'attaque !!";
	}

	void lancerCriGuerre(String criGuerre) {
		System.out.println(criGuerre);
	}

	public boolean parer(Monstre monstre) {
		System.out.println(this.personnage_nom+" tente de parer "+monstre.getNom()+" !");
		double parer;
		parer=Math.random();
		if(parer<0.5) {
			this.attaquer(monstre);
			return false;
		}
		else {
			System.out.println(this.personnage_nom+" pare "+monstre.getNom()+" !");
			return true;
		}
	}

	public String toString() {
		return "Nom : "+personnage_nom +" | Point de vie : "+personnage_pointVie+" | Point d'attaque : "+personnage_pointAttaque+" | Point de défense : "+personnage_pointDefense;
	}
}
