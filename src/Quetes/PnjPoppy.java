package Quetes;

import Equipements.Objet;

public class PnjPoppy extends Pnj {
	
	public PnjPoppy() {
		
		pnj_nom = "Poppy";
		
		pnj_objet = new Objet("Le poisson de Poppy");
		
		//pnj_coord = new Coord(8,9);
		
		pnj_numero_quete_actuel = 0 ;
		
		pnj_dialogue_boucle_quete = "Merci de m'avoir rapporter cette lettre. J'ai vu un brochet de 6 m�tres ce matin, je te jure ! \n Tiens ram�ne ce poisson � ma femme.";
		
		pnj_dialogue_boucle_sans_quete = "Pour l'instant les poissons ne mordent pas beaucoup. Mais je reste vigilant.";
		
	}

}