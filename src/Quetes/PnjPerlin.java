package Quetes;

import javax.swing.JFrame;

import Objets.Objet;
import Objets.ObjetQuete;
import Personnages.Equipe;

public class PnjPerlin extends Pnj {
	
	public PnjPerlin() {
		
		pnj_nom = "Perlin";
		
		pnj_objet = new ObjetQuete("Le journal d'indice");

		pnj_numero_quete_actuel = 0 ;
		
		pnj_dialogue_boucle_quete = "Oh, ma soeur s'inquiète pour moi. Rassure-la, je fais attention à moi. Tiens ramène lui ceci.";
		
		pnj_dialogue_boucle_sans_quete = "Je protège le village en nettoyant ce donjon des monstres, mais il reviennent sans cesse.";
		
	}
	
	public void boucleFinListeQuete(JFrame jf, Equipe equipe, Pnj maria) {
		
		if (maria.getQueteActuel() > 1) {
			this.rejoindreEquipe(jf, equipe);
		}
		else {
			super.boucleFinListeQuete(jf, equipe.getListePersonnage().get(0));
		}
	}
	
	public void boucleFinListeQuete(Equipe equipe, Pnj maria) {
		
		if (maria.getQueteActuel() > 1) {
			this.rejoindreEquipe(equipe);
		}
		else {
			super.boucleFinListeQuete(equipe.getListePersonnage().get(0));
		}
	}

}