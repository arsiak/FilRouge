package Personnages;
import java.util.ArrayList;

import Objets.Objet;

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
		return personnage.getNom() + " a rejoint votre �quipe.";
	}
	
	public String remplacerPersonnage(int position, Personnage personnage) {
		Personnage persoARemplacer = equipe_listePersonnage.get(position);
		equipe_listePersonnage.set(position, personnage);
		return persoARemplacer.getNom() + " a �t� remplac� par " +personnage.getNom()+ " votre �quipe.";
	}
	
	public Boolean verifiePersonnage(String personnage_nom) {
		
		Boolean verification = false;
		for (int i=0; i<equipe_listePersonnage.size(); i++) {
			
			try {
				if (equipe_listePersonnage.get(i).getNom().equals(personnage_nom)) {
					verification = true;
				}
			
			}catch (NullPointerException e) {}
			
		}
		return verification;
	}


	
}
