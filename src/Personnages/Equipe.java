package Personnages;
import java.util.ArrayList;

public class Equipe {
	private String equipe_nom;
	private ArrayList<Personnage> equipe_listePersonnage=new ArrayList<Personnage>();
	private int equipe_pointVieGlobal;

	public Equipe() {
		equipe_nom = "L'équipe des héros";
	}

	public int CalculerPointVieGlobal() {
		setPointVieGlobal(0);
		for(int i=0; i<getListePersonnage().size(); i++) {
			setPointVieGlobal(getPointVieGlobal()+getListePersonnage().get(i).personnage_pointVie);
		}
		return equipe_pointVieGlobal;

	}
	
	public void setNom(String nom) {
		this.equipe_nom = nom;
	}

	public String getNom() {
		// TODO Auto-generated method stub
		return equipe_nom;
	}

	public ArrayList<Personnage> getListePersonnage() {
		return equipe_listePersonnage;
	}

	public void setListePersonnage(ArrayList<Personnage> equipe_listePersonnage) {
		this.equipe_listePersonnage = equipe_listePersonnage;
	}
	
	public int getPointVieGlobal() {
		return equipe_pointVieGlobal;
	}

	public void setPointVieGlobal(int pointVieGlobal) {
		this.equipe_pointVieGlobal = pointVieGlobal;
	}


	
}
