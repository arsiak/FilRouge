package Personnages;
import Cartes.Coord;
import Equipements.Arme;
import Equipements.Armure;

public class Personnage {
	
	protected String personnage_nom;
	protected Coord personnage_coord;
	protected int personnage_pointVie;
	private int personnage_pointRage;
	protected int personnage_pointDefense;
	private int personnage_pointMana;
	private int personnage_pointResistance;
	private int personnage_pointVitesse;
	protected String personnage_criGuerre;
	public Arme[] personnage_sacArme;
	public Armure[] personnage_armure;
	private int personnage_XP;

	public Personnage() {
		// lettre = "@";
		this.personnage_pointVie=100;
		this.setPointRage(10);
		this.personnage_pointDefense=5;
		this.personnage_criGuerre="A l'attaque !!";
	}
	
	public Personnage(Coord coord) {
		this.personnage_coord=coord;
	}
	
	public Personnage(String nom,Coord coord, Arme[] sacArme, Armure[] armure) {
		this.personnage_nom=nom;
		//this.lettre=lettre;
		this.personnage_coord=coord;
		this.personnage_pointVie=100;
		this.personnage_pointRage=10;
		this.personnage_pointDefense=5;
		this.personnage_pointMana=10;
		this.personnage_pointResistance=5;
		this.personnage_pointVitesse=5;
		this.personnage_criGuerre="A l'attaque !!";
		this.personnage_sacArme=sacArme;
		this.personnage_armure=armure;
		
	}

	public Coord getCoord() {
		return personnage_coord;
	}

	public void setCoord(Coord coord) {
		this.personnage_coord = coord;
	}
	
	public void mvtGauche () {
		personnage_coord.setX(-1);
	}

	public void mvtDroite () {
		personnage_coord.setX(1);
	}
	
	public void mvtHaut () {
		personnage_coord.setY(-1);;
	}
	
	public void mvtBas () {
		personnage_coord.setY(1);
	}
	
	public String getNom() {
		return this.personnage_nom;
	}
	
	public void setNom(String nom) {
		this.personnage_nom=nom;
	}
	
	public int getPointVie() {
		return this.personnage_pointVie;
	}
	
	public void setPointVie(int pointVie) {
		this.personnage_pointVie=pointVie;
	}
	
	public int getPointAttaque() {
		return this.getPointRage();
	}
	
	public void setPointAttaque(int pointAttaque) {
		this.setPointRage(pointAttaque);
	}
	
	public int getPointDefense() {
		return this.personnage_pointDefense;
	}
	
	public void setPointDefense(int pointDefense) {
		this.personnage_pointDefense=pointDefense;
	}
	
	public String getCriGuerre() {
		return personnage_criGuerre;
	}
	
	public void setCriGuerre(String criGuerre) {
		this.personnage_criGuerre=criGuerre;
	}
	
	public void attaquer(Monstre monstre) {
		System.out.println(this.personnage_nom+" attaque "+monstre.getNom()+" !");
		int degat;
		degat=monstre.getPointVie()+monstre.getPointDefense()-this.getPointRage();
		if(monstre.getPointDefense()>this.getPointRage()) {
			degat=monstre.getPointVie();
		}
		if(degat<0) {
			degat=0;
		}
		monstre.setPointVie(degat);
		System.out.println(monstre.getNom()+" perd "+(this.getPointRage()-monstre.getPointDefense())+" point(s) de vie !");
	}

	public Coord getPosition() {
		// TODO Auto-generated method stub
		return this.personnage_coord;
	}

	public int getPointRage() {
		return personnage_pointRage;
	}

	public void setPointRage(int personnage_pointRage) {
		this.personnage_pointRage = personnage_pointRage;
	}

	public int getPointMana() {
		return personnage_pointMana;
	}

	public void setPointMana(int personnage_pointMana) {
		this.personnage_pointMana = personnage_pointMana;
	}

	public int getPointResistance() {
		return personnage_pointResistance;
	}

	public void setPointResistance(int personnage_pointResistance) {
		this.personnage_pointResistance = personnage_pointResistance;
	}

	public int getPointVitesse() {
		return personnage_pointVitesse;
	}

	public void setPointVitesse(int personnage_pointVitesse) {
		this.personnage_pointVitesse = personnage_pointVitesse;
	}

	public Arme[] getSacArme() {
		return personnage_sacArme;
	}

	public void setSacArme(Arme[] personnage_sacArme) {
		this.personnage_sacArme = personnage_sacArme;
	}

	public Armure[] getArmure() {
		return personnage_armure;
	}

	public void setArmure(Armure[] personnage_armure) {
		this.personnage_armure = personnage_armure;
	}

	public int getXP() {
		return personnage_XP;
	}

	public void setXP(int personnage_XP) {
		this.personnage_XP = personnage_XP;
	}

	
}