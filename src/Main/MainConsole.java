package Main;
import java.io.IOException;
import java.util.Scanner;

import Cartes.Carte;
import Cartes.CarteDonjon;
import Cartes.CarteMonde;
import Cartes.CarteVillage;
import Cartes.Coord;
import Personnages.Personnage;

public class MainConsole {

	public static void main(String[] args) throws IOException {

		Personnage perso = new Personnage(new Coord(22, 14));
		Carte carte = new CarteMonde();

		carte.setDeplacementPerso(perso);
		carte.afficher();

		Scanner sc = new Scanner(System.in);
		char saisie;

		boolean mouvement = true;

		while (mouvement) {

			carte.placer(perso.getCoord(), '@');
			carte.afficher();
			carte.enlever(perso.getCoord());

			switch (saisie = sc.nextLine().charAt(0)) {

			case 'z':
				perso.mvtHaut();
				if (carte.bloque(perso)) { perso.mvtBas(); }
				break;

			case 's':
				perso.mvtBas();
				if (carte.bloque(perso)) { perso.mvtHaut(); }
				break;

			case 'q':
				perso.mvtGauche();
				if (carte.bloque(perso)) { perso.mvtDroite(); }
				break;

			case 'd':
				perso.mvtDroite();
				if (carte.bloque(perso)) { perso.mvtGauche(); }
				break;
			}

			//carte.setDeplacementPerso(p);
			if (carte.estChange(perso) == true) { 
				
				carte = carte.changementCarte(perso);
				carte.setDeplacementPerso(perso);
				
			}
		}
		sc.close();

	}

}
