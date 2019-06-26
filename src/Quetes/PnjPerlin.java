package Quetes;

import Equipements.Objet;
import Equipements.ObjetQuete;

public class PnjPerlin extends Pnj {
	
	public PnjPerlin() {
		
		pnj_nom = "Perlin";
		
		pnj_objet = new ObjetQuete("Le journal d'indice");
		
		//pnj_coord = new Coord(8,9);
		
		pnj_numero_quete_actuel = 0 ;
		
		pnj_dialogue_boucle_quete = "Oh, ma soeur s'inquiète pour moi. Rassure-la, je fais attention à moi. Tiens ramène lui ceci.";
		
		pnj_dialogue_boucle_sans_quete = "Je protège le village en nettoyant ce donjon des monstres, mais il reviennent sans cesse.";
		
	}

}