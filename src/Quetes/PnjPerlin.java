package Quetes;

import Equipements.Objet;
import Equipements.ObjetQuete;

public class PnjPerlin extends Pnj {
	
	public PnjPerlin() {
		
		pnj_nom = "Perlin";
		
		pnj_objet = new ObjetQuete("Le journal d'indice");
		
		//pnj_coord = new Coord(8,9);
		
		pnj_numero_quete_actuel = 0 ;
		
		pnj_dialogue_boucle_quete = "Oh, ma soeur s'inqui�te pour moi. Rassure-la, je fais attention � moi. Tiens ram�ne lui ceci.";
		
		pnj_dialogue_boucle_sans_quete = "Je prot�ge le village en nettoyant ce donjon des monstres, mais il reviennent sans cesse.";
		
	}

}