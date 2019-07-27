package Objets;

import Monstres.Monstre;
import Personnages.Personnage;

public abstract class ObjetConsommable extends Objet {


	protected String objet_nom, objet_description;
	protected String objet_type = "Consommable";
	protected int objet_rage, objet_defense, objet_mana, objet_resistance, objet_vie, objet_vitesse;
	
	public ObjetConsommable() {
		
	}
	
	public ObjetConsommable(String nom, String desc, int rage, int def, int mana, int res, int vie, int vit) {
		objet_nom=nom;
		objet_description=desc;
		objet_rage=rage;
		objet_defense=def;
		objet_mana=mana;
		objet_resistance=res;
		objet_vie=vie;
		objet_vitesse=vit;
		
	}
	
	public String getNom() {
		return objet_nom;
	}

	public void setNom(String nom) {
		objet_nom = nom;
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return objet_type;
	}
	
	public String getDescription() {
		return objet_description;
	}

	public void setDescription(String description) {
		objet_description = description;
	}
	
	public String getPresentationMenu() {
		return objet_nom;
	}

	public int getRage() {
		return objet_rage;
	}

	public void setRage(int rage) {
		objet_rage = rage;
	}

	public int getDefense() {
		return objet_defense;
	}

	public void setDefense(int defense) {
		objet_defense = defense;
	}

	public int getMana() {
		return objet_mana;
	}

	public void setMana(int mana) {
		objet_mana = mana;
	}

	public int getResistance() {
		return objet_resistance;
	}

	public void setResistance(int resistance) {
		objet_resistance = resistance;
	}

	public int getVie() {
		return objet_vie;
	}

	public void setVie(int vie) {
		objet_vie = vie;
	}

	public int getVitesse() {
		return objet_vitesse;
	}

	public void setVitesse(int vitesse) {
		objet_vitesse = vitesse;
	}
	
	public void utiliser(Personnage personnage) {
		personnage.setPointRage(personnage.getPointRage() + objet_rage);
		personnage.setPointDefense(personnage.getPointDefense() + objet_defense);
		personnage.setPointVie(personnage.getPointVie() + objet_vie);
		personnage.setPointMana(personnage.getPointMana() + objet_mana);
		personnage.setPointResistance(personnage.getPointResistance() + objet_resistance);
		personnage.setPointVitesse(personnage.getPointVitesse() + objet_vitesse);
		
	}
	
	public void utiliser(Monstre monstre) {
		monstre.setPointRage(monstre.getPointRage() + objet_rage);
		monstre.setPointDefense(monstre.getPointDefense() + objet_defense);
		monstre.setPointVie(monstre.getPointVie() + objet_vie);
		monstre.setPointMana(monstre.getPointMana() + objet_mana);
		monstre.setPointResistance(monstre.getPointResistance() + objet_resistance);
		monstre.setPointVitesse(monstre.getPointVitesse() + objet_vitesse);
		
	}

}
