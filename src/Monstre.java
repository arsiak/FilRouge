import java.util.Scanner;

public class Monstre {
	String nom;
	int pointVie;
	int pointAttaque;
	int pointDefense;
	protected int pointMagie;
	protected int pointResistance;
	protected int pointVitesse;
	String criGuerre;
	Artefact[] equipement=new Artefact[3];
	boolean armure;
	Metier metier;
	
	public Monstre(String nom, Artefact[] equipement, boolean armure) {
		this.nom=nom;
		this.pointVie=100;
		this.pointAttaque=10;
		this.pointDefense=5;
		this.pointMagie=10;
		this.pointResistance=5;
		this.pointVitesse=5;
		this.criGuerre="mlll wwouogrouroulou !!";
		this.equipement=equipement;
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
	
	Integer getPointAttaque() {
		return pointAttaque;
	}
	
	void setPointAttaque(int pointAttaque) {
		this.pointAttaque=pointAttaque;
	}
	
	Integer getPointDefense() {
		return pointDefense;
	}
	
	void setPointDefense(int pointDefense) {
		this.pointDefense=pointDefense;
	}
	
	public int getPointMagie() {
		return this.pointMagie;
	}
	
	public void setPointMagie(int pointMagie) {
		this.pointMagie=pointMagie;
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
	
	void Attaquer(Perso personnage) {
		System.out.println(this.nom+" attaque "+personnage.nom+" !");
		int degat;
		double choix;
		choix=Math.random();
		if(choix<0.5) {
			degat=personnage.pointVie+personnage.pointDefense-this.pointAttaque;
			if(personnage.pointDefense>this.pointAttaque) {
				degat=personnage.pointVie;
			}
			if(degat<0) {
				degat=0;
			}
		}
		else {
			degat=personnage.pointVie+personnage.pointResistance-this.pointMagie;
			if(personnage.pointResistance>this.pointMagie) {
				degat=personnage.pointVie;
			}
			if(degat<0) {
				degat=0;
			}
		}
		personnage.setPointVie(degat);
		if(this.pointAttaque-personnage.pointDefense>0) {
			System.out.println(personnage.nom+" perd "+(this.pointAttaque-personnage.pointDefense)+" point(s) de vie !");
		}
		else {
			System.out.println(personnage.nom+" ne perd pas de point de vie !");
		}	
	}
	
	public String toString() {
		return "Nom : "+nom +" | Vie : "+pointVie+" | Attaque : "+pointAttaque+" | Défense : "+pointDefense+" | Magie : "+pointMagie+" | Résistance : "+pointResistance+" | Vitesse : "+pointVitesse;
	}
}
