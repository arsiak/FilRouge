package Personnages;
import Cartes.Coord;
import Equipements.Artefact;

public class Orc extends Perso{
	private int parerOrc;
	
	public Orc(String nom,Coord coord, Artefact[] listeArtefact, boolean armure) {
		super(nom, coord, listeArtefact, armure);
		this.pointVie=90;
		this.pointAttaque=12;
		this.pointDefense=7;
		this.criGuerre="A l'attaque";
		this.setParerOrc(0);
	}
	
	void lancerCriGuerre(String criGuerre) {
		System.out.println(criGuerre);
	}
	
	public void Parer(Monstre monstre) {
		System.out.println(this.nom+" pare "+monstre.nom+" !");
		this.setParerOrc(getParerOrc()+1);
	}
	
	public String toString() {
		return "Nom : "+nom +" | Point de vie : "+pointVie+" | Point d'attaque : "+pointAttaque+" | Point de défense : "+pointDefense;
	}

	public int getParerOrc() {
		return parerOrc;
	}

	public void setParerOrc(int parerOrc) {
		this.parerOrc = parerOrc;
	}
}
