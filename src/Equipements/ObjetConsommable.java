package Equipements;

import Monstres.Monstre;
import Personnages.Personnage;

public abstract class ObjetConsommable extends Objet {

	
	
	protected String objetConsommable_nom, objetConsommable_description;
	protected int objetConsommable_rage, objetConsommable_defense, objetConsommable_mana, objetConsommable_resistance, objetConsommable_vie, objetConsommable_vitesse;
	
	public ObjetConsommable() {
		
	}
	
	public ObjetConsommable(String nom, String desc, int rage, int def, int mana, int res, int vie, int vit) {
		objetConsommable_nom=nom;
		objetConsommable_description=desc;
		objetConsommable_rage=rage;
		objetConsommable_defense=def;
		objetConsommable_mana=mana;
		objetConsommable_resistance=res;
		objetConsommable_vie=vie;
		objetConsommable_vitesse=vit;
		
	}

	public String getName() {
		return objetConsommable_nom;
	}

	public void setName(String nom) {
		objetConsommable_nom = nom;
	}

	public String getDescription() {
		return objetConsommable_description;
	}

	public void setDescription(String description) {
		objetConsommable_description = description;
	}
	
	public String getPresentationMenu() {
		return (objet_nom);
	}

	public int getRage() {
		return objetConsommable_rage;
	}

	public void setRage(int rage) {
		objetConsommable_rage = rage;
	}

	public int getDefense() {
		return objetConsommable_defense;
	}

	public void setDefense(int defense) {
		objetConsommable_defense = defense;
	}

	public int getMana() {
		return objetConsommable_mana;
	}

	public void setMana(int mana) {
		objetConsommable_mana = mana;
	}

	public int getResistance() {
		return objetConsommable_resistance;
	}

	public void setResistance(int resistance) {
		objetConsommable_resistance = resistance;
	}

	public int getVie() {
		return objetConsommable_vie;
	}

	public void setVie(int vie) {
		objetConsommable_vie = vie;
	}

	public int getVitesse() {
		return objetConsommable_vitesse;
	}

	public void setVitesse(int vitesse) {
		objetConsommable_vitesse = vitesse;
	}
	
	public void Utiliser(Personnage personnage) {
		personnage.setPointRage(personnage.getPointRage() + objetConsommable_rage);
		personnage.setPointDefense(personnage.getPointDefense() + objetConsommable_defense);
		personnage.setPointVie(personnage.getPointVie() + objetConsommable_vie);
		personnage.setPointMana(personnage.getPointMana() + objetConsommable_mana);
		personnage.setPointResistance(personnage.getPointResistance() + objetConsommable_resistance);
		personnage.setPointVitesse(personnage.getPointVitesse() + objetConsommable_vitesse);
	}
	
	public void Utiliser(Monstre monstre) {
		monstre.setPointRage(monstre.getPointRage() + objetConsommable_rage);
		monstre.setPointDefense(monstre.getPointDefense() + objetConsommable_defense);
		monstre.setPointVie(monstre.getPointVie() + objetConsommable_vie);
		monstre.setPointMana(monstre.getPointMana() );
		monstre.setPointResistance(monstre.getPointResistance() + objetConsommable_resistance);
		monstre.setPointVitesse(monstre.getPointVitesse() + objetConsommable_vitesse);
	}

}
