package Equipements;
import Personnages.Humain;
import Personnages.Personnage;

public class Equipement extends Objet {
	
	public String equipement_id;
	public int equipement_attaque;
	public int equipement_defense;
	public int equipement_sante;
	
	public Equipement(String equipement_id) {
		super(equipement_id);
		this.equipement_id=equipement_id;
		this.equipement_attaque=0;
		this.equipement_defense=0;
		this.equipement_sante=0;
	}
	
	String getId() {
		return equipement_id;
	}
	
	int getAttaque() {
		return equipement_attaque;
	}
	
	void setAttaque(int attaque) {
		this.equipement_attaque=attaque;
	}
	
	int getDefense() {
		return equipement_defense;
	}
	
	void setDefense(int defense) {
		this.equipement_defense=defense;
	}
	
	int getSante() {
		return equipement_sante;
	}
	
	void setSante(int sante) {
		this.equipement_sante=sante;
	}
	
	public void utiliser(Personnage personnage) {
		if(personnage instanceof Humain) {
			if(equipement_attaque>0) {
				personnage.setPointAttaque(personnage.getPointAttaque()+equipement_attaque+1);
			}
			if(equipement_defense>0) {
				personnage.setPointDefense(personnage.getPointDefense()+equipement_defense+1);
			}
			if(equipement_sante>0) {
				personnage.setPointVie(personnage.getPointVie()+equipement_sante+1);
			}
		}
		else{personnage.setPointAttaque(personnage.getPointAttaque()+equipement_attaque);
		personnage.setPointDefense(personnage.getPointDefense()+equipement_defense);
		personnage.setPointVie(personnage.getPointVie()+equipement_sante);
		}
	}
}
