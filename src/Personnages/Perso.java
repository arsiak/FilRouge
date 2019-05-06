package Personnages;
import Cartes.Coord;
import Equipements.Artefact;

public class Perso {
	
	protected String nom;
	protected Coord coord;
	protected int pointVie;
	protected int pointAttaque;
	protected int pointDefense;
	protected String criGuerre;
	private Artefact[] equipement= new Artefact[3];
	public boolean armure;

	public Perso() {

		// lettre = "@";
		this.pointVie=100;
		this.pointAttaque=10;
		this.pointDefense=5;
		this.criGuerre="A l'attaque !!";
		this.setEquipement(null);
		
	}
	
	public Perso(Coord coord) {
		
		this.coord=coord;
	
	}
	
	public Perso(String nom,Coord coord, Artefact[] listeArtefact, boolean armure) {
		this.nom=nom;
		//this.lettre=lettre;
		this.coord=coord;
		this.pointVie=100;
		this.pointAttaque=10;
		this.pointDefense=5;
		this.criGuerre="A l'attaque !!";
		this.setEquipement(listeArtefact);
		this.armure=armure;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	
	public void mvtGauche () {
		coord.setX(-1);
	}

	public void mvtDroite () {
		coord.setX(1);
	}
	
	public void mvtHaut () {
		coord.setY(-1);;
	}
	
	public void mvtBas () {
		coord.setY(1);
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public int getPointVie() {
		return this.pointVie;
	}
	
	public void setPointVie(int pointVie) {
		this.pointVie=pointVie;
	}
	
	public int getPointAttaque() {
		return this.pointAttaque;
	}
	
	public void setPointAttaque(int pointAttaque) {
		this.pointAttaque=pointAttaque;
	}
	
	public int getPointDefense() {
		return this.pointDefense;
	}
	
	public void setPointDefense(int pointDefense) {
		this.pointDefense=pointDefense;
	}
	
	public String getCriGuerre() {
		return criGuerre;
	}
	
	public void setCriGuerre(String criGuerre) {
		this.criGuerre=criGuerre;
	}
	
	public void Attaquer(Monstre monstre) {
		System.out.println(this.nom+" attaque "+monstre.nom+" !");
		int degat;
		degat=monstre.pointVie+monstre.pointDefense-this.pointAttaque;
		if(monstre.pointDefense>this.pointAttaque) {
			degat=monstre.pointVie;
		}
		if(degat<0) {
			degat=0;
		}
		monstre.setPointVie(degat);
		System.out.println(monstre.nom+" perd "+(this.pointAttaque-monstre.pointDefense)+" point(s) de vie !");
	}

	public Artefact[] getEquipement() {
		return equipement;
	}

	public void setEquipement(Artefact[] equipement) {
		this.equipement = equipement;
	}

	public Coord getPosition() {
		// TODO Auto-generated method stub
		return this.coord;
	}

	
}