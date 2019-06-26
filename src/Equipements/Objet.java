package Equipements;

import Monstres.Monstre;
import Personnages.Personnage;

public abstract class Objet {
	
	protected String objet_nom;
	
	public String getNom() {
		return objet_nom;
	}
	
	public abstract String getPresentationMenu();
	
	public abstract String getDescription();
	
	public void setNom(String objet_nom) {
		this.objet_nom=objet_nom;
	}
	
	public void utiliser(Personnage personnage) {
		// TODO Auto-generated method stub
	}
	
	public void utiliser(Monstre monstre) {
		// TODO Auto-generated method stub
	}

}
