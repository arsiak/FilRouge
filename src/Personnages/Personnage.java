package Personnages;

import java.awt.Image;
import java.util.Arrays;

import Cartes.Coord;
import Monstres.Monstre;
import Objets.Objet;

public class Personnage {
	
	protected String personnage_nom;
	protected char personnage_lettre;
	protected Image personnage_image;
	protected Coord personnage_coord;
	protected int personnage_pointVie=100;
	protected int personnage_pointRage;
	protected int personnage_pointDefense;
	protected int personnage_pointMana;
	protected int personnage_pointResistance;
	protected int personnage_pointVitesse;
	protected String personnage_criGuerre="A l'attaque !!";
	private Objet[] personnage_sac = new Objet[15];
	protected int personnage_level;
	protected int personnage_XP;
	protected boolean personnage_parade = false;
	protected boolean personnage_estVivant = true;

	public Personnage() { }
	
	public Personnage(String nom, char lettre, Coord coord) {
		personnage_nom=nom;
		personnage_coord=coord;
		personnage_lettre=lettre;
		personnage_pointVie=100;
		personnage_pointRage=10;
		personnage_pointDefense=5;
		personnage_pointMana=10;
		personnage_pointResistance=5;
		personnage_pointVitesse=5;
		personnage_level=0;
		personnage_XP=0;
	}
	
	public Personnage(String nom,Image image, Coord coord) {
		personnage_nom=nom;
		personnage_image=image;
		personnage_pointVie=100;
		personnage_pointRage=10;
		personnage_pointDefense=5;
		personnage_pointMana=10;
		personnage_pointResistance=5;
		personnage_pointVitesse=5;	
		personnage_level=0;
		personnage_XP=0;
	}
	
	public String toString() {
		return "Vit: " +this.getPointVitesse()+ " Res: " +this.getPointResistance()+ " Mana: " +this.getPointMana()+ " Def: " +this.getPointDefense()+ " Rage: " +this.getPointRage()+ " Vie: " +this.getPointVie()+ " (" +this.getClass().getSimpleName()+ ") " +this.getNom();
	}
	
	public String toStringMenu() {
		return personnage_nom+ ": Att " +personnage_pointRage+ " Def " +personnage_pointDefense+ " PV " +personnage_pointVie+ " Mana " +personnage_pointMana+ " Res " +personnage_pointResistance+ " Vit " +personnage_pointVitesse+ " Level " +personnage_level+ " Exp " +personnage_XP+ "/100";
	}

	public Coord getCoord() {
		return personnage_coord;
	}

	public void setCoord(Coord coord) {
		this.personnage_coord = coord;
	}
	
	public char getLettre() {
		return personnage_lettre;
	}

	public void setLettre(char lettre) {
		personnage_lettre=lettre;
	}
	
	public void setImage(Image image) {
		this.personnage_image=image;
	}
	
	public void mvtGauche () {
		personnage_coord.setX(-1);
	}

	public void mvtDroite () {
		personnage_coord.setX(1);
	}
	
	public void mvtHaut () {
		personnage_coord.setY(-1);
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
	
	public boolean getEstVivant() {
		return personnage_estVivant;
	}

	public void setEstVivant(boolean estVivant) {
		this.personnage_estVivant = estVivant;
	}
	
	public void attaquer(Monstre monstre) {
		System.out.println(this.personnage_nom+" attaque "+monstre.getNom()+" !");
		int degat;
		
		degat=monstre.getPointVie()+monstre.getPointDefense()-this.getPointRage();
		if(monstre.getPointDefense()>this.getPointRage()) {
			monstre.setPointDefense(monstre.getPointDefense()-this.getPointRage());
		}
		else {
			degat=monstre.getPointVie();
			monstre.setPointDefense(0);
		}
		if(degat<0) {
			degat=0;
		}
		monstre.setPointVie(degat);
		System.out.println(monstre.getNom()+" perd "+(this.getPointRage()-monstre.getPointDefense())+" point(s) de vie !");
	}
	
	public boolean fuir() {
		
		double randomFuite = Math.random();
		boolean fuite = false;
		
		if (randomFuite>0.5) {
			fuite = true;
		}
		return fuite;
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

	public int getLevel() {
		return personnage_level;
	}

	public void setLevel(int personnage_level) {
		this.personnage_level = personnage_level;
	}
	
	public int getXP() {
		return personnage_XP;
	}

	public void setXP(int personnage_XP) {
		this.personnage_XP = personnage_XP;
	}
	
	public boolean getParade() {
		return this.personnage_parade;
	}
	
	public void setParade(boolean parade) {
		this.personnage_parade=parade;
	}

	public void ajouterEquipement(Objet equipement) {
		
		for (int i=0; i<personnage_sac.length; i++) {
			
			if (personnage_sac[i] == null) {
				personnage_sac[i] = equipement;
				i=personnage_sac.length;
				
			}
		}
		if (equipement.getType().equals("Arme") || equipement.getType().equals("Armure")) 
			equipement.utiliser(this);
		
	}
	
	public void retirerEquipement(Objet equipement) {
		
		for (int i=0; i<personnage_sac.length; i++) {
			
			if (personnage_sac[i].getNom().equals(equipement.getNom())) {
				personnage_sac[i] = null;
				i=personnage_sac.length;
			}
		}
		equipement.desutiliser(this);
		//System.out.println(Arrays.toString(equipements));
		
	}
	
	public Boolean verifieEquipement(Objet equipement) {
		
		Boolean verification = false;
		for (int i=0; i<personnage_sac.length; i++) {
			
			try {
				if (personnage_sac[i].getNom().equals(equipement.getNom())) {
					verification = true;
				}
			
			}catch (NullPointerException e) {}
			
		}
		return verification;
	}

	public void setSac(Objet[] equipements) {
		personnage_sac = equipements;
	}
	
	public Objet[] getSac() {
		return personnage_sac;
	}
	
	public int nombreObjetDansSac() {
		
		int nombreObjet = 0;
		for (int i=0; i<personnage_sac.length; i++) {

			try {
				if (!(personnage_sac[i] == null)) {
					nombreObjet++;
				}
			}catch (NullPointerException e) {}
		}
		return nombreObjet;
	}
	
	public void levelUp() {
		this.personnage_level++;
		this.personnage_XP = this.personnage_XP-100;
		this.personnage_pointRage = this.personnage_pointRage+2;
		this.personnage_pointMana = this.personnage_pointMana+2;
		this.personnage_pointDefense = this.personnage_pointDefense+2;
		this.personnage_pointResistance = this.personnage_pointResistance+2;
		this.personnage_pointVie = this.personnage_pointVie+5;
	}

	public void parer() {
		
		System.out.println(this.getNom()+" pare ! (Diminue de moitié l'attaque ennemi)");
		this.personnage_parade = true;
		
	}
	
}