import java.util.ArrayList;

public class EquipeMonstre {
	String nom;
	ArrayList<Monstre> listeMonstre=new ArrayList<Monstre>();
	int pointVieGlobal;
	
	public EquipeMonstre() {
		this.nom="L'équipe de monstre";
	}
	
	public int CalculerPointVieGlobal() {
		pointVieGlobal=0;
		for(int i=0; i<listeMonstre.size(); i++) {
			pointVieGlobal=pointVieGlobal+listeMonstre.get(i).pointVie;
		}
		return pointVieGlobal;
		
	}
}
