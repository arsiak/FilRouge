package Equipements;
public class PotionDeVie extends Equipement {
	
	public PotionDeVie(String potionDeVie_id) {
		super(potionDeVie_id);
		// TODO Auto-generated constructor stub
		this.equipement_sante=5;
	}
	
	public void utiliserBouclier(int pointVie) {
		setSante(pointVie+equipement_sante);
	}
}
