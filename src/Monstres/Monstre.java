package Monstres;

import Cartes.Coord;
import Equipements.Objet;
import Personnages.Personnage;

public class Monstre {
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
	public Objet[] monstre_sac;
	private boolean estVivant;
	
	public Monstre(String nom, String lettre, Objet[] sac) {
		this.setNom(nom);
		this.monstre_lettre=lettre;
		this.monstre_pointVie=60;
		this.monstre_pointRage=10;
		this.monstre_pointDefense=5;
		this.monstre_pointMana=10;
		this.monstre_pointResistance=5;
		this.monstre_pointVitesse=5;
		this.monstre_criGuerre="mlll wwouogrouroulou !!";
		this.monstre_sac=sac;
		this.setEstVivant(true);
	}
	
	public String toString() {
		return this.getNom()+ " (" +this.getClass().getSimpleName()+ ") Vie: "+monstre_pointVie+" Rage: "+monstre_pointRage+" Def: "+monstre_pointDefense+" Mana: "+monstre_pointMana+" Res: "+monstre_pointResistance+" Vit: "+monstre_pointVitesse;
	}
	
	public String getNom() {
		return monstre_nom;
	}
	
	public void setNom(String nom) {
		this.monstre_nom=nom;
	}
	

	public String getLettre() {
		return monstre_lettre;
	}
	
	public void setLettre(String lettre) {
		this.monstre_lettre=lettre;
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

	public Objet[] getSac() {
		return monstre_sac;
	}

	public void setSac(Objet[] sac) {
		monstre_sac = sac;
	}

	public boolean getEstVivant() {
		return estVivant;
	}

	public void setEstVivant(boolean estVivant) {
		this.estVivant = estVivant;
	}
	
	public void Attaquer(Personnage personnage) {
		
	}
	
}
