package Personnages;
import Cartes.Coord;
import Equipements.Artefact;

public class Humain extends Perso {
	
	public Humain(String nom, Coord coord, Artefact[] listeArtefact, boolean armure) {
		super(nom, coord, listeArtefact, armure);
		this.criGuerre="A l'attaque !!";
	}
	
	void lancerCriGuerre(String criGuerre) {
		System.out.println(criGuerre);
	}
	
	public boolean Parer(Monstre monstre) {
		System.out.println(this.nom+" tente de parer "+monstre.nom+" !");
		double parer;
		parer=Math.random();
		if(parer<0.5) {
			this.Attaquer(monstre);
			return false;
		}
		else {
			System.out.println(this.nom+" pare "+monstre.nom+" !");
			return true;
		}
	}
	
	public String toString() {
		return "Nom : "+nom +" | Point de vie : "+pointVie+" | Point d'attaque : "+pointAttaque+" | Point de défense : "+pointDefense;
	}
}
