package Personnages;
import java.util.ArrayList;

public class EquipeMonstre {
	private String nom;
	private ArrayList<Monstre> listeMonstre=new ArrayList<Monstre>();
	private int pointVieGlobal;
	
	public EquipeMonstre() {
		this.setNom("L'équipe de monstre");
	}
	
	public int CalculerPointVieGlobal() {
		setPointVieGlobal(0);
		for(int i=0; i<getListeMonstre().size(); i++) {
			setPointVieGlobal(getPointVieGlobal()+getListeMonstre().get(i).pointVie);
		}
		return getPointVieGlobal();
		
	}

	public ArrayList<Monstre> getListeMonstre() {
		return listeMonstre;
	}

	public void setListeMonstre(ArrayList<Monstre> listeMonstre) {
		this.listeMonstre = listeMonstre;
	}

	public int getPointVieGlobal() {
		return pointVieGlobal;
	}

	public void setPointVieGlobal(int pointVieGlobal) {
		this.pointVieGlobal = pointVieGlobal;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
