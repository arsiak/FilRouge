import java.util.Scanner;

public class Perso {
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
	public int XP;

	/**public Perso() {
		lettre = "@";
		positionX = 6;
		positionY = 8;
		this.pointVie=100;
		this.pointRage=10;
		this.pointDefense=5;
		this.pointMana=10;
		this.pointResistance=5;
		this.criGuerre="A l'attaque !!";
	}**/
	
	public Perso(String nom, String lettre, int positionX, int positionY, Arme[] sacArme, Armure[] armure) {
		this.nom=nom;
		this.lettre=lettre;
		this.positionX=positionX;
		this.positionY=positionY;
		this.pointVie=100;
		this.pointRage=10;
		this.pointDefense=5;
		this.pointMana=10;
		this.pointResistance=5;
		this.criGuerre="A l'attaque !!";
		this.sacArme=sacArme;
		this.armure=armure;
		this.XP=0;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public String getLettre() {
		return lettre;
	}

	public void setLettre(String lettre) {
		this.lettre = lettre;
	}

	public void mvtGauche () {
		positionY--;
	}

	public void mvtDroite () {
		positionY++;
	}
	
	public void mvtHaut () {
		positionX--;
	}
	
	public void mvtBas () {
		positionX++;
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
	
	public int getPointRage() {
		return this.pointRage;
	}
	
	public void setPointRage(int pointRage) {
		this.pointRage=pointRage;
	}
	
	public int getPointDefense() {
		return this.pointDefense;
	}
	
	public void setPointDefense(int pointDefense) {
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
	
	public String getCriGuerre() {
		return criGuerre;
	}
	
	public void setCriGuerre(String criGuerre) {
		this.criGuerre=criGuerre;
	}
}