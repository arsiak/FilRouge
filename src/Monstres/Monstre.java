package Monstres;

import Cartes.Coord;
import Equipements.Arme;
import Equipements.Armure;

public class Monstre<Armure> {
	private String monstre_nom;
	protected String monstre_lettre;
	protected Coord monstre_coord;
	protected int monstre_pointVie;
	protected int monstre_pointRage;
	protected int monstre_pointDefense;
	protected int monstre_pointMana;
	protected int monstre_pointResistance;
	protected int monstre_pointVitesse;
	protected String monstre_criGuerre;
	public Arme[] monstre_sacArme;
	public Armure[] monstre_armure;
	private boolean estVivant;
	
	public Monstre(String nom, String lettre, Coord coord, Arme[] sacArme, Armure[] armure) {
		this.setNom(nom);
		this.monstre_lettre=lettre;
		this.monstre_coord=coord;
		this.monstre_pointVie=100;
		this.monstre_pointRage=10;
		this.monstre_pointDefense=5;
		this.monstre_pointMana=10;
		this.monstre_pointResistance=5;
		this.monstre_pointVitesse=5;
		this.monstre_criGuerre="mlll wwouogrouroulou !!";
		this.monstre_sacArme=sacArme;
		this.monstre_armure=armure;
		this.setEstVivant(true);
	}
	
	public String getNom() {
		return monstre_nom;
	}
	
	public void setNom(String nom) {
		this.monstre_nom=nom;
	}
	
	public Integer getPointVie() {
		return monstre_pointVie;
	}
	
	public void setPointVie(int pointVie) {
		this.monstre_pointVie=pointVie;
	}
	
	public Integer getPointRage() {
		return monstre_pointRage;
	}
	
	public void setPointRage(int pointRage) {
		this.monstre_pointRage=pointRage;
	}
	
	public Integer getPointDefense() {
		return monstre_pointDefense;
	}
	
	public void setPointDefense(int pointDefense) {
		this.monstre_pointDefense=pointDefense;
	}
	
	public int getPointMana() {
		return this.monstre_pointMana;
	}
	
	public void setPointMana(int pointMana) {
		this.monstre_pointMana=pointMana;
	}
	
	public int getPointResistance() {
		return this.monstre_pointResistance;
	}
	
	public void setPointResistance(int pointResistance) {
		this.monstre_pointResistance=pointResistance;
	}
	
	public int getPointVitesse() {
		return this.monstre_pointVitesse;
	}
	
	public void setPointVitesse(int pointVitesse) {
		this.monstre_pointVitesse=pointVitesse;
	}
	
	public String getCriGuerre() {
		return monstre_criGuerre;
	}
	
	public void setCriGuerre(String criGuerre) {
		this.monstre_criGuerre=criGuerre;
	}

	public Arme[] getSacArme() {
		return monstre_sacArme;
	}

	public void setSacArme(Arme[] monstre_sacArme) {
		this.monstre_sacArme = monstre_sacArme;
	}

	public Armure[] getArmure() {
		return monstre_armure;
	}

	public void setArmure(Armure[] monstre_armure) {
		this.monstre_armure = monstre_armure;
	}

	public boolean getEstVivant() {
		return estVivant;
	}

	public void setEstVivant(boolean estVivant) {
		this.estVivant = estVivant;
	}
	
}
