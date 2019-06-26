package Personnages;
import java.util.ArrayList;

public class Equipe {
	private String equipe_nom;
	private ArrayList<Personnage> equipe_listePersonnage=new ArrayList<Personnage>();
	private int equipe_pointVieGlobal;

	public Equipe() {}
	
	public Equipe(String nom, Personnage perso) {
		equipe_nom = nom;
		equipe_listePersonnage.add(perso);
		equipe_pointVieGlobal = perso.getPointVie();
	}
	
	public Equipe(String nom, ArrayList<Personnage> listePersonnage) {
		equipe_nom = nom;
		equipe_listePersonnage = listePersonnage;
		this.CalculerPointVieGlobal();
	}

	public int CalculerPointVieGlobal() {
		setPointVieGlobal(0);
		for(int i=0; i<equipe_listePersonnage.size(); i++) {
			setPointVieGlobal(getPointVieGlobal()+equipe_listePersonnage.get(i).getPointVie());
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

	public String ajouterPersonnage(Personnage personnage) {
		equipe_listePersonnage.add(personnage);
		return personnage.getNom() + " a rejoint votre équipe.";
	}


	
}
