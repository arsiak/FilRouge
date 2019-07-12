package Objets;

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
	  
	protected String objet_nom, objet_description;
	protected String objet_type = "Armure";
	protected int objet_defense, objet_resistance;
	  
	   
	//Constructeur
	public Armure() {
		
	}
	
	public Armure (String nom, String description, int  defense, int resistance){
		objet_description = description;
	    objet_defense = defense;
	    objet_resistance=resistance;
	}
	
	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return objet_nom;
	}
	
	@Override
	public void setNom(String nom) {
		// TODO Auto-generated method stub
		objet_nom=nom;
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return objet_type;
	}
	  
	public String getPresentationMenu(){
		return (objet_nom+ " Def " +objet_defense+ " Res " +objet_resistance);
	}
	
	public String getDescription(){
		return objet_description;
	}

	public int getDefense(){
		return objet_defense;
	}
	
	public int getResistance() {
		return objet_resistance;
	}
	
	public void utiliser(Personnage personnage) {
		personnage.setPointDefense(personnage.getPointDefense() + objet_defense);
		personnage.setPointResistance(personnage.getPointResistance() + objet_resistance);
	}
	
	public void desutiliser(Personnage personnage) {
		personnage.setPointDefense(personnage.getPointDefense() - objet_defense);
		personnage.setPointResistance(personnage.getPointResistance() - objet_resistance);
	}
	
	public void utiliser(Monstre monstre) {
		monstre.setPointDefense(monstre.getPointDefense() + objet_defense);
		monstre.setPointResistance(monstre.getPointResistance() + objet_resistance);
	}
	  
}
