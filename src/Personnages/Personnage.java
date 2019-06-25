package Personnages;

import Cartes.Coord;
import Equipements.Objet;
import Monstres.Monstre;

public class Personnage {
	
	protected String personnage_nom;
	protected char personnage_lettre;
	protected Coord personnage_coord;
	protected int personnage_pointVie=100;
	protected int personnage_pointRage;
	protected int personnage_pointDefense;
	protected int personnage_pointMana;
	protected int personnage_pointResistance;
	protected int personnage_pointVitesse;
	protected String personnage_criGuerre;
	private Objet[] personnage_sac = new Objet[10];
	protected int personnage_level;
	protected int personnage_XP;

	public Personnage() {
		
		this.personnage_pointVie=100;
		this.setPointRage(10);
		this.personnage_pointDefense=5;
		this.personnage_criGuerre="A l'attaque !!";
	}
	/*
	public Personnage(String nom, Coord coord) {
		this.personnage_nom=nom;
		this.personnage_coord=coord;
	}
	*/
	public Personnage(String nom, char lettre, Coord coord) {
		personnage_nom=nom;
		personnage_coord=coord;
		personnage_lettre=lettre;
	}
	
	
	public Personnage(String nom,char lettre,Objet[] sac) {
		this.personnage_nom=nom;
		this.personnage_lettre=lettre;
		this.personnage_pointVie=100;
		this.personnage_pointRage=10;
		this.personnage_pointDefense=5;
		this.personnage_pointMana=10;
		this.personnage_pointResistance=5;
		this.personnage_pointVitesse=5;
		this.personnage_criGuerre="A l'attaque !!";
		this.personnage_sac=sac;
		
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

	/*public Arme[] getSacArme() {
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
	}*/

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

	public void ajouterEquipement(Objet equipement) {
		
		for (int i=0; i<personnage_sac.length; i++) {
			
			if (personnage_sac[i] == null) {
				personnage_sac[i] = equipement;
				i=personnage_sac.length;
			}
		}
		equipement.utiliser(this);
		//System.out.println(Arrays.toString(personnage_sacArme));
		
	}
	
	public void retirerEquipement(Objet equipement) {
		
		for (int i=0; i<personnage_sac.length; i++) {
			
			if (personnage_sac[i].getNom().equals(equipement.getNom())) {
				personnage_sac[i] = null;
				i=personnage_sac.length;
			}
		}
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
	
}