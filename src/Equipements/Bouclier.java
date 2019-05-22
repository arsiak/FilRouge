package Equipements;
public class Bouclier extends Equipement{

	public Bouclier(String bouclier_id) {
		super(bouclier_id);
		// TODO Auto-generated constructor stub
		this.equipement_defense=2;
	}

	public void utiliserBouclier(int pointDefense) {
		setDefense(pointDefense+equipement_defense);
	}

}
