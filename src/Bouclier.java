
public class Bouclier extends Artefact{

	public Bouclier(String identifiant) {
		super(identifiant);
		// TODO Auto-generated constructor stub
		this.defense=2;
	}
	
	public void utiliserBouclier(int pointDefense) {
		setDefense(pointDefense+defense);
	}

}
