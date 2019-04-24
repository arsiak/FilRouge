import java.util.ArrayList;

public class Equipe {
	String nom;
	ArrayList<Perso> listePersonnage=new ArrayList<Perso>();
	int pointVieGlobal;
	
	public Equipe() {
		this.nom="L'équipe des héros";
	}
	
	public int CalculerPointVieGlobal() {
		pointVieGlobal=0;
		for(int i=0; i<listePersonnage.size(); i++) {
			pointVieGlobal=pointVieGlobal+listePersonnage.get(i).pointVie;
		}
		return pointVieGlobal;
		
	}
}
