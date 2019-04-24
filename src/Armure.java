
public class Armure extends Artefact{

	public Armure(String identifiant) {
		super(identifiant);
		// TODO Auto-generated constructor stub
		this.defense=5;
	}
	
	public void utiliserArmure(int pointDefense) {
		setDefense(pointDefense+defense);
	}
	
}
