import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;

import com.valkryst.VTerminal.Screen;
import com.valkryst.VTerminal.Tile;


public class Fenetre {
	
	private Screen screen;
	private Map map;
	private Zone zone;
	
	public Fenetre() throws IOException {
		this.screen = new Screen(10,10);
		this.screen.addCanvasToFrame();
		this.map = new Map();
		//this.map.afficherMap();
		this.zone = new Zone(new Coord(0,0), this.map.getMap(), this.screen);
		this.screen.addComponent(zone);
		this.screen.draw();
	}
	
}
