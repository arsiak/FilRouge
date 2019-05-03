package Personnages;
import java.util.ArrayList;

public class Equipe {
	private String nom;
	private ArrayList<Perso> listePersonnage=new ArrayList<Perso>();
	private int pointVieGlobal;
	
	public Equipe() {
		nom = "L'équipe des héros";
	}
	
	public int CalculerPointVieGlobal() {
		setPointVieGlobal(0);
		for(int i=0; i<getListePersonnage().size(); i++) {
			setPointVieGlobal(getPointVieGlobal()+getListePersonnage().get(i).pointVie);
		}
		return pointVieGlobal;
		
	}

	public void setListePersonnage(ArrayList<Perso> listePersonnage) {
		this.listePersonnage = listePersonnage;
	}

	public ArrayList<Perso> getListePersonnage() {
		// TODO Auto-generated method stub
		return listePersonnage;
	}

	public int getPointVieGlobal() {
		return pointVieGlobal;
	}

	public void setPointVieGlobal(int pointVieGlobal) {
		this.pointVieGlobal = pointVieGlobal;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}

}
