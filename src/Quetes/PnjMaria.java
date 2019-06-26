package Quetes;

import java.util.ArrayList;
import Cartes.Coord;
import Equipements.Objet;
import Equipements.ObjetQuete;

public class PnjMaria extends Pnj {

	public PnjMaria() {
		
		pnj_nom = "Maria";
		
		//pnj_coord = new Coord(8,9);
		
		pnj_objet = new ObjetQuete("L'�p�e l�gendaire");
		
		pnj_numero_quete_actuel = 0 ;
		
		pnj_dialogue_presentation = "Bonjour jeune homme, mon �ge m'emp�che de faire beaucoup de chose. \n";
		
		pnj_dialogue_boucle_quete = "Pr�t � m'aider ?";
		
		pnj_dialogue_boucle_sans_quete = "Merci au nom de l'ensemble du village.";
		
		liste_quetes = new ArrayList<Quete>();
		liste_quetes.add(new Quete("Qu�te 1 de Maria", 
								   "Des pillards ont cambriol� ma maison et ont vol� mon collier. Ces pillards sont venu du Donjon5 � l'Est du village. \n Ram�ne le moi.",  
								   "Tu l'a retrouv�. Merci.",
								   new ObjetQuete("Le collier de Maria"),
								   "EXP +20", false));
		liste_quetes.add(new Quete("Qu�te 2 de Maria", 
								   "Va voir mon mari Poppy p�che au lac Tial, � l'Ouest, et remet lui cette lettre.", 
								   "J'esp�re qu'il ne t'a pas trop ennuyer avec ces histoires de p�ches. \n Merci d'avoir rapport� ce joli poisson.\r\n", 
								   new ObjetQuete("Le poisson de Poppy"),
								   "EXP +10", false));
		liste_quetes.add(new Quete("Qu�te 3 de Maria", 
								   "Les chenapans, ils m'ont m�me vol�s mes assiettes en argent. Ils doivent �tre dans le donjon7 vers l'Ouest. \n Rapporte les pour que je puisse pr�parer le poisson.", 
								   "Les voil�. Le poisson pourra enfin �tre d�gust�. \n ",
								   new ObjetQuete("Les assiettes en argent"),
								   "EXP +20", false));
		liste_quetes.add(new Quete("Qu�te 4 de Maria", 
								   "Il existe un monstre dans le donjon10 dans le Sud. Mon mari l'a combattu dans le pass�, mais sans le vaincre. \n Ach�ve-le.", 
								   "Tu as r�ussis l� o� mon mari a �chou� ! \n Chapeau.",
								   new ObjetQuete("La t�te du boss10"),
								   "EXP +30", false));
		liste_quetes.add(new Quete("Qu�te 5 de Maria", 
								   "La chute du boss du donjon10  a mis le boss du donjon9 en col�re. \n Tue-le avant qu'il se venge sur le village.",
								   "Gr�ce � toi le village est en s�ret�. \n Prend cet �p�e, elle appartenait � l'ancien h�ros du village.",
								   new ObjetQuete("La t�te du boss9"),
								   "EXP +30", false));
		
	}	

}
