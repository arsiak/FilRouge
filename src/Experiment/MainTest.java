package Experiment;

import java.io.IOException;

import com.valkryst.VTerminal.Screen;

public class MainTest {
	public static void main(String[] args) throws IOException {
		Screen screen = new Screen(21,21);
		screen.addCanvasToFrame();
		//Feuille.creerMap();
		//Map m = new Map();
		//this.feuillePrincipale = genererMapDonjon();
		//this.zone = new Zone(new Coord(0,0), Feuille.getMap(), this.screen);
		//this.zone = new Zone(new Coord(0,0), m.getMap(), this.screen);
		
        GameController controller = new GameController(screen);
        controller.addToScreen(screen);
	}
}
