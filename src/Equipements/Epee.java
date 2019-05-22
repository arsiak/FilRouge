package Equipements;

import Personnages.Personnage;

public class Epee extends Equipement {
	public Epee(String identifiant) {
		super(identifiant);
		// TODO Auto-generated constructor stub
		this.equipement_attaque=4;
	}

	public void utiliserArmure(Personnage personnage) {
		setDefense(personnage.getPointAttaque()+equipement_attaque);
	}
}
