package Quetes;

import java.util.ArrayList;
import Cartes.Coord;
import Equipements.Objet;

public class PnjMaria extends Pnj {

	public PnjMaria() {
		
		pnj_nom = "Maria";
		
		//pnj_coord = new Coord(8,9);
		
		pnj_objet = new Objet("L'épée légendaire");
		
		pnj_numero_quete_actuel = 0 ;
		
		pnj_dialogue_presentation = "Bonjour jeune homme, mon âge m'empêche de faire beaucoup de chose. \n";
		
		pnj_dialogue_boucle_quete = "Prêt à m'aider ?";
		
		pnj_dialogue_boucle_sans_quete = "Merci au nom de l'ensemble du village.";
		
		liste_quetes = new ArrayList<Quete>();
		liste_quetes.add(new Quete("Quête 1 de Maria", 
								   "Des pillards ont cambriolé ma maison et ont volé mon collier. Ces pillards sont venu du Donjon5 à l'Est du village. \n Ramène le moi.",  
								   "Tu l'a retrouvé. Merci.",
								   new Objet("Le collier de Maria"),
								   "EXP +20", false));
		liste_quetes.add(new Quete("Quête 2 de Maria", 
								   "Va voir mon mari Poppy pêche au lac Tial, à l'Ouest, et remet lui cette lettre.", 
								   "J'espère qu'il ne t'a pas trop ennuyer avec ces histoires de pêches. \n Merci d'avoir rapporté ce joli poisson.\r\n", 
								   new Objet("Le poisson de Poppy"),
								   "EXP +10", false));
		liste_quetes.add(new Quete("Quête 3 de Maria", 
								   "Les chenapans, ils m'ont même volés mes assiettes en argent. Ils doivent être dans le donjon7 vers l'Ouest. \n Rapporte les pour que je puisse préparer le poisson.", 
								   "Les voilà. Le poisson pourra enfin être dégusté. \n ",
								   new Objet("Les assiettes en argent"),
								   "EXP +20", false));
		liste_quetes.add(new Quete("Quête 4 de Maria", 
								   "Il existe un monstre dans le donjon10 dans le Sud. Mon mari l'a combattu dans le passé, mais sans le vaincre. \n Achève-le.", 
								   "Tu as réussis là où mon mari a échoué ! \n Chapeau.",
								   new Objet("La tête du boss10"),
								   "EXP +30", false));
		liste_quetes.add(new Quete("Quête 5 de Maria", 
								   "La chute du boss du donjon10  a mis le boss du donjon9 en colère. \n Tue-le avant qu'il se venge sur le village.",
								   "Grâce à toi le village est en sûreté. \n Prend cet épée, elle appartenait à l'ancien héros du village.",
								   new Objet("La tête du boss9"),
								   "EXP +30", false));
		
	}	

}
