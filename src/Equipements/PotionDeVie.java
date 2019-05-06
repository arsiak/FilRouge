package Equipements;
public class PotionDeVie extends Artefact {
	
	public PotionDeVie(String identifiant) {
		super(identifiant);
		// TODO Auto-generated constructor stub
		this.sante=5;
	}
	
	public void utiliserBouclier(int pointVie) {
		setSante(pointVie+sante);
	}
}
