package Quetes;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Objets.Objet;
import Objets.ObjetQuete;
import Personnages.Equipe;
import Personnages.Personnage;

public class PnjPoppy extends Pnj {
	
	public PnjPoppy() {
		
		pnj_nom = "Poppy";
		
		pnj_objet = new ObjetQuete("Le poisson de Poppy");
		
		//pnj_coord = new Coord(8,9);
		
		pnj_numero_quete_actuel = 0 ;
		
		pnj_dialogue_boucle_quete = "Merci de m'avoir rapporter cette lettre. J'ai vu un brochet de 6 mètres ce matin, je te jure ! \n Tiens ramène ce poisson à ma femme.";
		
		pnj_dialogue_boucle_sans_quete = "Pour l'instant les poissons ne mordent pas beaucoup. Mais je reste vigilant.";
		
	}
	
	
	public void boucleFinListeQuete(JFrame jf, Equipe equipe, Pnj maria) {
		
		if (maria.getQueteActuel() > 2) {
			this.rejoindreEquipe(jf, equipe);
		}
		else {
			super.boucleFinListeQuete(jf, equipe.getListePersonnage().get(0));
		}
	}
	
	public void boucleFinListeQuete(Equipe equipe, Pnj maria) {
		
		if (maria.getQueteActuel() > 2) {
			this.rejoindreEquipe(equipe);
		}
		else {
			super.boucleFinListeQuete(equipe.getListePersonnage().get(0));
		}
	}
	

}