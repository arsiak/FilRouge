package Objets;

public class ObjetQuete extends Objet {

	private String objet_nom;
	protected String objet_type = "Quete";
	private String objet_carte_nom;
	private String objet_destination;
	
	public ObjetQuete(String nom, String carte_nom, String destination) {
		// TODO Auto-generated constructor stub
		objet_nom=nom;
		objet_carte_nom=carte_nom;
		objet_destination=destination;
	}
	
	public ObjetQuete(String nom) {
		// TODO Auto-generated constructor stub
		objet_nom=nom;
	}

	public String getNom() {
		return objet_nom;
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return objet_type;
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
	
	public String getCarte_nom() {
		return objet_carte_nom;
	}
	
	// l'objet est lié à : soit un Tresor, soit un Boss, soit une Personne, soit un massacre (élimination de 10 monstres du donjon)
	public String getDestination() {
		return objet_destination;
	}

}
