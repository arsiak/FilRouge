package OldProg;
import java.util.Scanner;

import Cartes.CarteMonde;

/*
public class OldMain2 {

public static void main(String[] args) throws Exception {
		
		Perso p = new Perso();
		Carte carte = new CarteMonde();
		//Console r = System.console();
		
		
		Scanner sc = new Scanner(System.in);
		char saisie;
		
		p.setPositionX(carte.getXPerso());
		p.setPositionY(carte.getYPerso());
		boolean mouvement = true;
		
		while (mouvement) {
			
			carte.placerObjet(p.getLettre(),p.getPositionX(),p.getPositionY());
			carte.seDevoileA(p);
			carte.enleverObjet(p.getPositionX(), p.getPositionY());
			
				switch (saisie = sc.nextLine().charAt(0)) {
				
				  case 'z':
					  p.mvtHaut();
					  if (carte.testBlocage(p)) { p.mvtBas(); }
					  break;
				  
				  case 's':
					  p.mvtBas();
					  if (carte.testBlocage(p)) { p.mvtHaut(); }
				    break;
				  
				  case 'q':
					  p.mvtGauche();
					  if (carte.testBlocage(p)) { p.mvtDroite(); }
				    break;
				  
				  case 'd':
					  p.mvtDroite();
					  if (carte.testBlocage(p)) { p.mvtGauche(); }
				    break;
				  }
			
			//carte.setDeplacementPerso(p);
			if (carte.testChangementCarte(p) == true) { 
				carte = carte.changementCarte(p);
				System.out.println(carte.getXPerso());
				p.setPositionX(carte.getXPerso());
				System.out.println(p.getPositionX());
				p.setPositionY(carte.getYPerso());
			}
		}
		sc.close();
	}

}
*/
