package Equipements;
public class Armure extends Equipement{

	public Armure(String armure_id) {
		super(armure_id);
		// TODO Auto-generated constructor stub
		this.equipement_defense=5;
	}

	public void utiliserArmure(int pointDefense) {
		setDefense(pointDefense+equipement_defense);
	}

}
