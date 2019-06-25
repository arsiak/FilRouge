package Quetes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Cartes.Coord;
import Equipements.Objet;
import Personnages.Equipe;
import Personnages.Personnage;

public class Pnj {

	protected String pnj_nom;
	protected Coord pnj_coord;
	protected Objet pnj_objet;
	protected int pnj_numero_quete_actuel;
	protected String pnj_dialogue_presentation;
	protected String pnj_dialogue_boucle_quete;
	protected String pnj_dialogue_boucle_sans_quete;
	protected boolean pnj_rejoindreEquipe;
	protected ArrayList<Quete> liste_quetes = new ArrayList<Quete>();
	
	public Pnj() { }
		public Pnj (String nom, Coord coord, ArrayList<Quete> liste) {
		pnj_nom=nom;
		pnj_coord=coord;
		liste_quetes=liste;
		pnj_rejoindreEquipe = false;
	}
	
	public String getNom() {
		return pnj_nom;
	}

	public void setNom(String nom) {
		pnj_nom=nom;
	}
	
	public void donnerObjet(JFrame jf,Personnage perso) {
		
		JOptionPane.showMessageDialog(jf,
				  pnj_objet.getNom(),
				  this.pnj_nom +" donne : ",
				  JOptionPane.PLAIN_MESSAGE);
		perso.ajouterEquipement(pnj_objet);
	}
	
	public void deroulementQuete(JFrame jf, Personnage perso) {
		
		 if (pnj_numero_quete_actuel == 0 && liste_quetes.get(0).getActive() == false) {
			 
			  this.getPresentation(jf);
		 }
		 else if (pnj_numero_quete_actuel<liste_quetes.size()) {
		
			  if (this.verifieQuete(perso) == true) {
				  perso.retirerEquipement(liste_quetes.get(pnj_numero_quete_actuel).getObjet());
				  this.finQuete(jf, perso);
			  }
			  else {
				  this.debutQuete(jf);
			  }
		  }
		 else {
			  
			  this.boucleSansQuete(jf, perso);
		 }
	
	}
	
	public void deroulementQueteC(Personnage perso) {
		
		 if (pnj_numero_quete_actuel == 0 && liste_quetes.get(0).getActive() == false) {
			  this.getPresentationC();
		  }
		 else {
			 
			 if (this.verifieQuete(perso) == true) {
			  this.finQueteC();
			 }
			 else if (pnj_numero_quete_actuel<liste_quetes.size()){
			  this.debutQueteC();
			 }
		  }
		  /*else {
			  this.boucleSansQueteC();
		  }*/
		 
	}
	
	public void getPresentation(JFrame jf) {
	
		int reponse = JOptionPane.showConfirmDialog(jf,
			    					 this.pnj_dialogue_presentation + this.pnj_dialogue_boucle_quete,
			    					 this.pnj_nom,
			    					 JOptionPane.YES_NO_OPTION);

		if (reponse == JOptionPane.YES_OPTION) {
			this.debutQuete(jf);
		}
		
	}
	
	public void getPresentationC() {
		
		System.out.println(this.pnj_nom +" dit : "+ this.pnj_dialogue_presentation +"\n");
		System.out.println(this.pnj_nom +" dit : "+ liste_quetes.get(pnj_numero_quete_actuel).getDialogue_initial());
		
		System.out.println(pnj_nom +" demande : "+ this.pnj_dialogue_boucle_quete);
		System.out.println("Saisissez : 'oui' ou 'non'");
		Scanner sc = new Scanner(System.in);
		String saisie = sc.next();

		if (saisie.equals("oui")) {
			this.debutQueteC();
		}		
		
	}
	
	public int getQueteActuel() {
		return pnj_numero_quete_actuel;
	}

	public void setQueteActuel(int numero) {
		pnj_numero_quete_actuel=numero;
	}
	
	public Coord getCoord() {
		return pnj_coord;
	}

	public void setCoord(Coord coord) {
		pnj_coord=coord;
	}
	
	public ArrayList<Quete> getListe_quetes() {
		return liste_quetes;
	}

	/*public void setListe_quetes(ArrayList<Quete> liste) {
		liste_quetes=liste;
	}*/
	
	public void ajouterQuete(Quete quete) {
		liste_quetes.add(quete);
	}
	
	public void supprimerQuete(int emplacement) {
		liste_quetes.remove(emplacement);
	}
	
	public void debutQuete(JFrame jf) {
		JOptionPane.showMessageDialog(jf,
			    					  liste_quetes.get(pnj_numero_quete_actuel).getDialogue_initial(),
			    					  liste_quetes.get(pnj_numero_quete_actuel).getNom(),
			    					  JOptionPane.PLAIN_MESSAGE);
		liste_quetes.get(pnj_numero_quete_actuel).setActive(true);
	}
	
	public void debutQueteC() {
		
		System.out.println(liste_quetes.get(pnj_numero_quete_actuel).getNom() + "\n");
		System.out.println(pnj_nom +" dit : "+ liste_quetes.get(pnj_numero_quete_actuel).getDialogue_initial());  
		liste_quetes.get(pnj_numero_quete_actuel).setActive(true);
	}
	
	
	public Boolean verifieQuete(Personnage perso) {
		Boolean verification =false;
		
		if (perso.verifieEquipement(liste_quetes.get(pnj_numero_quete_actuel).getObjet())) {
					
			verification = true;
			//perso.retirerEquipement(liste_quetes.get(pnj_numero_quete_actuel).getObjet());
			// vide le sac
		}
		return verification;
	}
	
	public void finQuete(JFrame jf, Personnage perso) {
		
		JOptionPane.showMessageDialog(jf,
				  					  liste_quetes.get(pnj_numero_quete_actuel).getDialogue_final(),
				  					  liste_quetes.get(pnj_numero_quete_actuel).getNom() + " terminé",
				  					  JOptionPane.PLAIN_MESSAGE);
		
		int reponse = JOptionPane.showConfirmDialog(jf,
				 this.pnj_dialogue_boucle_quete,
				 this.pnj_nom,
				 JOptionPane.YES_NO_OPTION);

		if (reponse == JOptionPane.YES_OPTION) {
			liste_quetes.get(pnj_numero_quete_actuel).setActive(false);
			pnj_numero_quete_actuel++;
			this.debutQuete(jf);
		}
		else { 
			perso.ajouterEquipement(liste_quetes.get(pnj_numero_quete_actuel).getObjet());
		}

	}
	
	
	public void boucleQuete(JFrame jf, Personnage perso) {
		
		JOptionPane.showMessageDialog(jf,
				  this.pnj_dialogue_boucle_quete,
				  this.pnj_nom,
				  JOptionPane.PLAIN_MESSAGE);
		this.donnerObjet(jf,perso);
		if (!(Arrays.asList(perso.getSac()).contains(pnj_objet)))
			perso.ajouterEquipement(pnj_objet);
	}
	
	public void boucleSansQuete(JFrame jf, Personnage perso) {
		
		JOptionPane.showMessageDialog(jf,
				  this.pnj_dialogue_boucle_sans_quete,
				  this.pnj_nom,
				  JOptionPane.PLAIN_MESSAGE);
	}
	
	public void finQueteC() {
		
		System.out.println(liste_quetes.get(pnj_numero_quete_actuel).getNom() + " terminé");
		System.out.println(pnj_nom +" dit : "+ liste_quetes.get(pnj_numero_quete_actuel).getDialogue_final());
		
		System.out.println(pnj_nom +" demande : "+ this.pnj_dialogue_boucle_quete);
		System.out.println("Saisissez : 'oui' ou 'non'");
		Scanner sc = new Scanner(System.in);
		String saisie = sc.next();

		if (saisie.equals("oui")) {
			liste_quetes.get(pnj_numero_quete_actuel).setActive(false);
			pnj_numero_quete_actuel++;
			this.debutQueteC();
		}		
	}
	
	public void rejoindreEquipe(JFrame jf, Equipe equipe) {
		equipe.ajouterPersonnage(new Personnage());
		JOptionPane.showMessageDialog(jf,
				  this.pnj_nom + " a rejoint votre équipe.",
				  this.pnj_nom,
				  JOptionPane.PLAIN_MESSAGE);
	}
	
}
