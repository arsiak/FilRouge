package Quetes;

import java.util.ArrayList;
import Cartes.Coord;
import Objets.ArmureLegendaire;
import Objets.Objet;
import Objets.ObjetQuete;

public class PnjKaramel extends Pnj {

	public PnjKaramel() {
		
		pnj_nom = "Karamel";
		
		pnj_objet = new ArmureLegendaire();
		
		pnj_numero_quete_actuel = 0 ;
		
		pnj_dialogue_presentation = "Bonjour, moi c'est Karamel, j'ai entendu parler de toi. \n";
		
		pnj_dialogue_boucle_quete = "Est-ce que tu peux m'aider ?";
		
		pnj_dialogue_boucle_sans_quete = "Merci de nous avoir aidé mon frère et moi";
		
		liste_quetes = new ArrayList<Quete>();
		liste_quetes.add(new Quete("Quête 1 de Karamel", 
								   "Mon frère s'est fait attaqué par des pillards, et lui ont volé son bouclier. Ils se sont réfugiés dans un donjon au Sud du village. \n Je t'en prie, récupère-le.",  
								   "Merci beaucoup. Il sera content de le récupérer.",
								   new ObjetQuete("Le Bouclier de Perlin", "Donjon6", "Tresor"),
								   "EXP +20", false));
		liste_quetes.add(new Quete("Quête 2 de Karamel", 
								   "Mon frère est parti dans le Donjon4 au Nord, mais il n'est pas revenu. \n Va t'assures qu'il va bien.", 
								   "Il va bien ? Dieu merci. \n Ce journal me sera utile.",
								   new ObjetQuete("Le journal d'indice", "Donjon4", "Personne"),
								   "EXP +20", false));
		liste_quetes.add(new Quete("Quête 3 de Karamel", 
								   "D'après les indice du journal,le monstre qui a tué nos parents se trouve dans le Donjon1 au Nord-Ouest du village. \n Tue le boss pour venger nos parents.", 
								   "Mes parents ont enfin été venger. \n Merci.",
								   new ObjetQuete("La tête du boss du Donjon1", "Donjon1", "Boss"),
								   "EXP +30", false));
		liste_quetes.add(new Quete("Quête 4 de Karamel", 
								   "J'aimerai décorer la tombe de mes parents.J'ai caché des ornements dorés dans un coffre dans le Sud, au bord d'un lac. \n Ramène moi ces ornements.", 
								   "Parfait, c'est magnifique, les tombes seront bien décorées. \n Merci.",
								   new ObjetQuete("Des ornements dorés", "Monde", "Tresor"),
								   "EXP +10", false));
		liste_quetes.add(new Quete("Quête 5 de Karamel", 
								   "Malheur! Des monstres sont venus pour terrorriser le village pendant mon absence. Il sont originaires du Donjon2 dans le Nord. \n Elimine tous ces monstres. ",
								   "Incroyable ! Tu a réussi. Tu es vraiment très fort.",
								   new ObjetQuete("La preuve du massacre", "Donjon2", "Massacre"),
								   "EXP +30", false));
		
		liste_quetes.add(new Quete("Quête 6 de Karamel", 
				   				   "Il y avait autrefois une ancienne statue de la prospérité au village, désormais dans le donjon11 au Sud. \n Retrouve-la pour nous la rendre. ",
				   				   "Le village vit désormais en paix. \n Merci.",
				   				   new ObjetQuete("L'ancienne statue de la prospérité", "Donjon11", "Tresor"),
				   				   "EXP +20", false));
		
	}	

}
