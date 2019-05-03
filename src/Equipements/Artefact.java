package Equipements;
import Personnages.Humain;
import Personnages.Perso;

public class Artefact {
	public String identifiant;
	public int attaque;
	public int defense;
	public int sante;
	
	public Artefact(String identifiant) {
		this.identifiant=identifiant;
		this.attaque=0;
		this.defense=0;
		this.sante=0;
	}
	
	int getAttaque() {
		return attaque;
	}
	
	void setAttaque(int attaque) {
		this.attaque=attaque;
	}
	
	int getDefense() {
		return defense;
	}
	
	void setDefense(int defense) {
		this.defense=defense;
	}
	
	int getSante() {
		return sante;
	}
	
	void setSante(int sante) {
		this.sante=sante;
	}
	
	public void utiliser(Perso personnage) {
		if(personnage instanceof Humain) {
			if(attaque>0) {
				personnage.setPointAttaque(personnage.getPointAttaque()+attaque+1);
			}
			if(defense>0) {
				personnage.setPointDefense(personnage.getPointDefense()+defense+1);
			}
			if(sante>0) {
				personnage.setPointVie(personnage.getPointVie()+sante+1);
			}
		}
		else{personnage.setPointAttaque(personnage.getPointAttaque()+attaque);
		personnage.setPointDefense(personnage.getPointDefense()+defense);
		personnage.setPointVie(personnage.getPointVie()+sante);
		}
	}
}
