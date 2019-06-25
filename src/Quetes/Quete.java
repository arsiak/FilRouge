package Quetes;

import Equipements.Objet;

public class Quete {

	protected String quete_nom;
	protected String quete_dialogue_initial;
	protected String quete_dialogue_final;
	protected Objet quete_objet;
	protected String quete_recompense;
	protected Boolean quete_active;
	
	public Quete(String nom, String dial_init, String dial_final, Objet objet, String recompense, Boolean active) {
		
		quete_nom = nom;
		quete_dialogue_initial = dial_init;
		quete_dialogue_final = dial_final;
		quete_objet = objet;
		quete_recompense = recompense;
		quete_active = active;
	
	}
	
	/*public Quete(String nom, String dial_init, String dial_final, String recompense, Boolean active) {
		
		quete_nom = nom;
		quete_dialogue_initial = dial_init;
		quete_dialogue_final = dial_final;
		quete_recompense = recompense;
		quete_active = active;
	
	}*/
	
	public String getNom() {
		return quete_nom;
	}

	public void setNom(String nom) {
		quete_nom=nom;
	}
	
	public String getDialogue_initial() {
		return quete_dialogue_initial;
	}

	public void setDialogue_initial(String dial) {
		quete_dialogue_initial=dial;
	}
	
	public String getDialogue_final() {
		return quete_dialogue_final;
	}

	public Objet getObjet() {
		return quete_objet;
	}

	public void setObjet(Objet objet) {
		quete_objet=objet;
	}

	public void setDialogue_final(String dial) {
		quete_dialogue_final=dial;
	}
	
	public String getRecompense() {
		return quete_recompense;
	}

	public void setRecompense(String recompense) {
		quete_recompense=recompense;
	}
	
	public Boolean getActive() {
		return quete_active;
	}

	public void setActive(Boolean active) {
		quete_active=active;
	}
	
}
