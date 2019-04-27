import java.io.IOException;
import java.util.ArrayList;

import com.valkryst.VTerminal.Screen;


public class Fenetre {
	
	private Screen screen;	
	private Map map;
	private Zone zone;
	private Feuille feuillePrincipale;
	
	public Fenetre() throws IOException {
		this.screen = new Screen(21,21);
		this.screen.addCanvasToFrame();
		//Feuille.creerMap();
		Map m = new Map();
		//this.feuillePrincipale = genererMapDonjon();
		//this.zone = new Zone(new Coord(0,0), Feuille.getMap(), this.screen);
		this.zone = new Zone(new Coord(0,0), m.getMap(), this.screen);
		this.screen.addComponent(this.zone);
		this.screen.draw();
		
	}
	
	
	/**
	 * Creer la carte du donjon avec les pièces et les couloirs
	 * @return Feuille, la map entière
	 */
	public Feuille genererMapDonjon() {
		ArrayList<Feuille> feuilles = new ArrayList<Feuille>();
		//this.map.afficherMap();
		Feuille feuillePrincipal = new Feuille(0, 0, Map.MAP_SIZE, Map.MAP_SIZE, this.screen);
		feuilles.add(feuillePrincipal);
		
		boolean est_divise = true;
		while(est_divise) {
			est_divise = false;
			ArrayList<Feuille> nouvellesFeuilles = new ArrayList<Feuille>();
			for(Feuille f: feuilles) {
				if(f.enfantDroit == null && f.enfantGauche == null) { //Si la zone n'a pas été divisé
					// Si la zone est trop grosse on diviser ou 1/3 de diviser
					if (f.width > 10 || f.height > 10 || Math.random() > 0.25)
					{
						if (f.diviser()) // on divise la feuille et on l'ajoute à nos feuilles
						{
							// if we did split, push the child leafs to the Vector so we can loop into them next
							nouvellesFeuilles.add(f.enfantGauche);
							nouvellesFeuilles.add(f.enfantDroit);
							est_divise = true;
						}
					}
				}
			}
			feuilles.addAll(nouvellesFeuilles);
		}
		/*for(Feuille f: feuilles) {
			System.out.println(f.toString());
			System.out.println(" x:" + f.x + " y:" + f.y + " width: " + f.width + " height: " + f.height);
		}*/
		feuillePrincipal.createRooms();
		return feuillePrincipal;
	}
	
}
