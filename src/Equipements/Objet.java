package Equipements;
import Personnages.Humain;
import Personnages.Personnage;

public class Objet {
	
	public String objet_id;
	
	
	public Objet(String objet_id) {
		this.objet_id=objet_id;
	}
	
	String getId() {
		return objet_id;
	}
}
