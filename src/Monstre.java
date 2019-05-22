import java.util.Scanner;

public class Monstre {
	protected String nom;
	protected String lettre;
	protected int positionX;
	protected int positionY;
	protected int pointVie;
	protected int pointRage;
	protected int pointDefense;
	protected int pointMana;
	protected int pointResistance;
	protected int pointVitesse;
	protected String criGuerre;
	protected Arme[] sacArme = new Arme[3];
	protected Armure[] armure = new Armure[3];
	
	public Monstre(String nom, String lettre, int positionX, int positionY, Arme[] sacArme, Armure[] armure) {
		this.nom=nom;
		this.lettre=lettre;
		this.positionX=positionX;
		this.positionY=positionY;
		this.pointVie=100;
		this.pointRage=10;
		this.pointDefense=5;
		this.pointMana=10;
		this.pointResistance=5;
		this.pointVitesse=5;
		this.criGuerre="mlll wwouogrouroulou !!";
		this.sacArme=sacArme;
		this.armure=armure;
	}
	
	String getNom() {
		return nom;
	}
	
	void setNom(String nom) {
		this.nom=nom;
	}
	
	Integer getPointVie() {
		return pointVie;
	}
	
	void setPointVie(int pointVie) {
		this.pointVie=pointVie;
	}
	
	Integer getPointRage() {
		return pointRage;
	}
	
	void setPointRage(int pointRage) {
		this.pointRage=pointRage;
	}
	
	Integer getPointDefense() {
		return pointDefense;
	}
	
	void setPointDefense(int pointDefense) {
		this.pointDefense=pointDefense;
	}
	
	public int getPointMana() {
		return this.pointMana;
	}
	
	public void setPointMana(int pointMana) {
		this.pointMana=pointMana;
	}
	
	public int getPointResistance() {
		return this.pointResistance;
	}
	
	public void setPointResistance(int pointResistance) {
		this.pointResistance=pointResistance;
	}
	
	public int getPointVitesse() {
		return this.pointVitesse;
	}
	
	public void setPointVitesse(int pointVitesse) {
		this.pointVitesse=pointVitesse;
	}
	
	String getCriGuerre() {
		return criGuerre;
	}
	
	void setCriGuerre(String criGuerre) {
		this.criGuerre=criGuerre;
	}
	
}
