import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import java.util.Scanner;

import com.valkryst.VTerminal.component.Layer;

public class Map{
	
	public static final int MAP_SIZE = 100;
	private MapTile[][] map;
	
	public Map() {
       creerMap();
	}
	
	public void creerMap() {
		Random rand = new Random();
		this.map = new MapTile[MAP_SIZE][MAP_SIZE];
		for(int i = 0; i < MAP_SIZE; i++) {
            for(int j = 0; j < MAP_SIZE; j++) {
            	if(i == 0 || i == MAP_SIZE-1 || j == MAP_SIZE-1 || j == 0) {
            		map[i][j] =new MapTile(DecorElement.WALL);
            	}else {
            		int randomNumber = rand.nextInt(5);
            		if(randomNumber == 3) {
            			map[i][j] = new MapTile(DecorElement.WALL);            			
            		}else {
            			map[i][j] = new MapTile(DecorElement.FLOOR);   
            		}
            	}
            }
        }
	}
	
	public void afficherMap() {
		for(int i = 0; i < MAP_SIZE; i++) {
            for(int j = 0; j < MAP_SIZE; j++) {
            	System.out.print(map[i][j].getSprite().glyph());
            }
            System.out.println();
        }
	}
	
	public MapTile[][] getMap() {
		return this.map;
	}
	
	public MapTile getDecorElement(int x, int y){
           return map[x][y];
    }
	
	public Color color(int x, int y){
        return getDecorElement(x, y).getSprite().color();
    }
	
	public DecorElement getElementByCoord(Coord pos) {
		MapTile element;
		DecorElement decorElement = null;
		try {
			decorElement = this.map[pos.getX()][pos.getY()].getSprite();
		} catch(IndexOutOfBoundsException e) {
			decorElement = DecorElement.FLOOR;
		}
		return decorElement;
	}

	


}
