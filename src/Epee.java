
public class Epee extends Artefact {
	public Epee(String identifiant) {
		super(identifiant);
		// TODO Auto-generated constructor stub
		this.attaque=4;
	}
	
	public void utiliserArmure(Perso personnage) {
		setDefense(personnage.pointAttaque+attaque);
	}
}
