package Cartes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

import Monstres.Assassin;
import Monstres.Chamane;
import Monstres.Monstre;
import Monstres.Necromancien;
import Objets.*;
import Quetes.Quete;
import Tresors.Tresor;

public class CarteDonjon extends Carte {
	
	public CarteDonjon(int i) {
		
		carte_nom = "Donjon" +i;
		
		carte = new char [24][40];

		this.deserializeCarte("Ressources/Cartes/carte" +carte_nom+ ".txt");
		
		carte_coord_entree_sortie = new HashMap<String,Coord>();		
		carte_coord_entree_sortie.put("Donjon1", new Coord(4,7));
		carte_coord_entree_sortie.put("Donjon2", new Coord(16,6));
		carte_coord_entree_sortie.put("Donjon3", new Coord(24,6));
		carte_coord_entree_sortie.put("Donjon4", new Coord(27,7));
		carte_coord_entree_sortie.put("Donjon5", new Coord(42,14));
		carte_coord_entree_sortie.put("Donjon6", new Coord(21,22));
		carte_coord_entree_sortie.put("Donjon7", new Coord(6,26));
		carte_coord_entree_sortie.put("Donjon8", new Coord(41,27));
		carte_coord_entree_sortie.put("Donjon9", new Coord(14,32));
		carte_coord_entree_sortie.put("Donjon10", new Coord(6,40));
		carte_coord_entree_sortie.put("Donjon11", new Coord(23,40));
		carte_coord_entree_sortie.put("Donjon12", new Coord(40,38));
		
		carte_boss = new HashMap<String,Monstre>();		
		carte_boss.put("Donjon1", new Assassin("Timon Le Borgne", 'B', new Objet[]{new Epee()}, 200,7, 0, 0, 0, 0, "Tu vas déguster"));
		carte_boss.put("Donjon2", new Necromancien("Ghoul L'infâme", 'B', new Objet[]{new Epee()}, 200,7, 0, 0, 0, 0, "Tu vas rejoindre ma collection de cadavre"));
		carte_boss.put("Donjon3", new Chamane("Molan L'une des soeurs jumelles", 'B', new Objet[]{new Amulette(), new PotionVie()}, 200,7, 0, 0, 0, 0, "Touche pas à ma soeur"));
		carte_boss.put("Donjon4", new Chamane("Noïran L'une des soeurs jumelles", 'B', new Objet[]{new Amulette(), new PotionVie()}, 200,7, 0, 0, 0, 0, "Touche pas à ma soeur"));
		carte_boss.put("Donjon5", new Necromancien("Rapia Le grand fou", 'B', new Objet[]{new Epee()}, 200,7, 0, 0, 0, 0, "Tu vas rejoindre ma collection de cadavre"));
		carte_boss.put("Donjon6", new Necromancien("Kao Le manipulateur d'âme", 'B', new Objet[]{new Epee()}, 200,50, 10, 10, 10, 5, "Je vais te montrer ce qu'est la folie"));
		carte_boss.put("Donjon7", new Assassin("Lourou La muraille", 'B', new Objet[]{new Epee()}, 200,7, 0, 0, 0, 0, "Tu vas te casser les dents sur mon corp"));
		carte_boss.put("Donjon8", new Chamane("Yoll Le fanatique", 'B', new Objet[]{new Epee()}, 200,7, 0, 0, 0, 0, "Je vais prendre soin de toi. Non, je rigole"));
		carte_boss.put("Donjon9", new Assassin("Bauror Le faiseur de veuve", 'B', new Objet[]{new Epee()}, 200,7, 0, 0, 0, 0, "Personne ne mérite de vivre, toi encore moins"));
		carte_boss.put("Donjon10", new Assassin("Vidal Le Sanguinaire", 'B', new Objet[]{new Epee()}, 200,7, 0, 0, 0, 0, "Je vais extraire tout ton sang de ton petit être"));
		carte_boss.put("Donjon11", new Necromancien("Escap Le presqu'mort", 'B', new Objet[]{new Epee()}, 200,7, 0, 0, 0, 0, "J'ai survécu à bien pire que toi"));
		carte_boss.put("Donjon12", new Chamane("Garakol L'ensorcelleuse", 'B', new Objet[]{new Epee()}, 200,7, 0, 0, 0, 0, "Ton destin est scellé, je vois ta défaite"));

		try {
			    	
			carte_obstacle_1 = ImageIO.read(new File("Ressources/Images/murDonjon.png"));
			carte_personnage = ImageIO.read(new File("Ressources/Images/personnageHaut.png"));
			carte_pnj_1 = ImageIO.read(new File("Ressources/Images/PerlinFace.png"));
			carte_sortie = ImageIO.read(new File("Ressources/Images/porte.png"));
			carte_sol = (ImageIO.read(new File("Ressources/Images/solDonjon.png")));
			carte_sol_exterieur = ImageIO.read(new File("Ressources/Images/terre.png"));
			carte_img_tresor = ImageIO.read(new File("Ressources/Images/tresor.png"));
			carte_img_boss = carte_boss.get(carte_nom).getImage();
			      
		}
		catch (IOException e) {
		      e.printStackTrace();
		}
		
	}

}
