package Equipements;

public class ObjetQuete extends Objet {

	private String objet_nom;
	
	public ObjetQuete(String objet_nom) {
		// TODO Auto-generated constructor stub
		this.objet_nom=objet_nom;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "objet de quête";
	}

	@Override
	public String getPresentationMenu() {
		// TODO Auto-generated method stub
		return objet_nom;
	}

}
