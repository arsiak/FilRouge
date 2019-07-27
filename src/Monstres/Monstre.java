package Monstres;

import java.awt.Image;

import Cartes.Coord;
import Objets.Objet;
import Personnages.Personnage;

public class Monstre {
	protected String monstre_nom;
	protected char monstre_lettre;
	protected Image monstre_image;
	protected Coord monstre_coord;
	protected int monstre_pointVie;
	protected int monstre_pointRage;
	protected int monstre_pointDefense;
	protected int monstre_pointMana;
	protected int monstre_pointResistance;
	protected int monstre_pointVitesse;
	protected String monstre_criGuerre="mlll wwouogrouroulou !!";
	protected Objet[] monstre_sac;
	protected boolean monstre_parade;
	protected boolean monstre_estVivant;
	
	/*public Monstre(String nom, Image image, Objet[] sac, int vie, int rage, int def, int mana, int res, int vit, String cri) {
		this.monstre_nom=nom;
		this.monstre_image=image;
		this.monstre_pointVie=vie;
		this.monstre_pointRage=rage;
		this.monstre_pointDefense=def;
		this.monstre_pointMana=mana;
		this.monstre_pointResistance=res;
		this.monstre_pointVitesse=vit;
		this.monstre_criGuerre=cri;
		this.monstre_sac=sac;
		this.setEstVivant(true);
	}*/
	
	public Monstre() { }
	
	public Monstre(String nom, char lettre, Objet[] sac) {
		this.setNom(nom);
		this.monstre_lettre=lettre;
		this.monstre_pointVie=60;
		this.monstre_pointRage=10;
		this.monstre_pointDefense=5;
		this.monstre_pointMana=10;
		this.monstre_pointResistance=5;
		this.monstre_pointVitesse=5;
		this.monstre_sac=sac;
		this.setEstVivant(true);
	}
	
	public Monstre(String nom, Image image, Objet[] sac) {
		this.setNom(nom);
		this.monstre_image=image;
		this.monstre_pointVie=60;
		this.monstre_pointRage=10;
		this.monstre_pointDefense=5;
		this.monstre_pointMana=10;
		this.monstre_pointResistance=5;
		this.monstre_pointVitesse=5;
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
	
	public Image getImage() {
		return monstre_image;
	}
	
	public void setImage(Image image) {
		this.monstre_image=image;
	}

	public char getLettre() {
		return monstre_lettre;
	}
	
	public void setLettre(char lettre) {
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
	
	public boolean getParade() {
		return monstre_parade;
	}

	public void setParade(boolean parade) {
		monstre_parade=parade;
	}

	public boolean getEstVivant() {
		return monstre_estVivant;
	}

	public void setEstVivant(boolean estVivant) {
		this.monstre_estVivant = estVivant;
	}
	
	public void retirerEquipement(Objet equipement) {
		
		for (int i=0; i<monstre_sac.length; i++) {
			
			if (monstre_sac[i].getNom().equals(equipement.getNom())) {
				monstre_sac[i] = null;
				i=monstre_sac.length;
			}
		}
		//System.out.println(Arrays.toString(equipements));
		
	}
	
	public void attaquer(Personnage personnage) {
		
	}
	
	public int nombreObjetDansSac() {
		
		int nombreObjet = 0;
		for (int i=0; i<monstre_sac.length; i++) {

			try {
				if (!(monstre_sac[i] == null)) {
					nombreObjet++;
				}
			}catch (NullPointerException e) {}
		}
		return nombreObjet;
	}
}
