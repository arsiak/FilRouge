package Equipements;

import Monstres.Monstre;
import Personnages.Personnage;

public abstract class Armure extends Objet {
	

	//Objets directement construits
	/*
	Casque("Casque", "Protège la tête ", 0,+5,0,0,0,0),
	Bouclier("Bouclier", "Protège des coups d'attaque ", +3,+5,0,0,0,0),
	Plastron("Plastron", "protège des coups d'épées et poignard", 0,+5,0,0,0,0),
	BouclierMagique("Bouclier Magique","Protège de la magie",0,0,0,+3,0,0);
	*/
	  
	protected String armure_nom = "";
	protected String armure_description = "";
	protected int armure_defense = 0, armure_resistance = 0;
	  
	   
	//Constructeur
	public Armure() {
		
	}
	
	public Armure (String nom, String description, int  defense, int resistance){
	    armure_description = description;
	    armure_defense = defense;
	    armure_resistance=resistance;
	}
	
	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return armure_nom;
	}
	
	@Override
	public void setNom(String nom) {
		// TODO Auto-generated method stub
		armure_nom=nom;
	}
	  
	public String getPresentationMenu(){
		return (objet_nom+ " Def " +armure_defense+ " Res " +armure_resistance);
	}
	
	public String getDescription(){
		return armure_description;
	}

	public int getDefense(){
		return armure_defense;
	}
	
	public int getResistance() {
		return armure_resistance;
	}
	
	public void Utiliser(Personnage personnage) {
		personnage.setPointDefense(personnage.getPointDefense() + armure_defense);
		personnage.setPointResistance(personnage.getPointResistance() + armure_resistance);
	}
	
	public void Utiliser(Monstre monstre) {
		monstre.setPointDefense(monstre.getPointDefense() + armure_defense);
		monstre.setPointResistance(monstre.getPointResistance() + armure_resistance);
	}
	  
}
