package Quetes;

import java.util.ArrayList;
import Cartes.Coord;
import Equipements.Equipement;
import Equipements.Objet;

public class PnjRomuald extends Pnj {

	public PnjRomuald() {
		
		pnj_nom = "Maria";
		
		//pnj_coord = new Coord(8,9);
		
		pnj_objet = new Objet("La couronne légendaire");
		
		pnj_numero_quete_actuel = 0 ;
		
		pnj_dialogue_presentation = "Désolé, mais j'ai trop peur. Je peux pas te parler tout haut.\n";
		
		pnj_dialogue_boucle_quete = "Peux-tu approcher ton oreille ?";
		
		pnj_dialogue_boucle_sans_quete = "Merci au nom de l'ensemble du village.";
		
		liste_quetes = new ArrayList<Quete>();
		liste_quetes.add(new Quete("Quête 1 de Romuald", 
								   "Je sais des choses sur l'anneau de ton père, mais j'ai peur que les boss apprennent que je t'aide. \n Tant que tous les boss des Donjons ne sont morts, je ne pourrais rien te dire.",  
								   "Tu les as tous défait. Incroyable. \n Tiens, prends cette couronne. Il te revient de la porter.",
								   new Objet("Collier de dents des 12 boss"),
								   "EXP +20", false));
		
		liste_quetes.add(new Quete("Quête 2 de Romuald", 
				   				   "Je possède l'anneau de ton père, et je veux bien faire un échange. Au Sud, vit le Grand Chaman. \n Rapporte-moi sa tête et je te donne ton anneau. \n Je te conseille d'avoir trois équipements légendaires avant de l'affronter.",  
				   				   "Tu les as tous défait. Incroyable. \n Tiens, prends cette couronne. Il te revient de la porter.",
				   				   new Objet("Collier de dents des 12 boss"),
				   				   "EXP +20", false));
		
	}	

}
