package OldProg;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import com.valkryst.VTerminal.Screen;
import com.valkryst.VTerminal.Tile;
import com.valkryst.VTerminal.component.Layer;
import com.valkryst.VTerminal.printer.RectanglePrinter;
import com.valkryst.VTerminal.printer.RectangleType;

public class Feuille extends Layer {
	
	private int TAILLE_MINIMUM_RECTANGLE = 12;
	public int y, x, width, height; //Position du rectangle
	public static MapTile[][] map = new MapTile[Map.MAP_SIZE][Map.MAP_SIZE]; //Carte totale
	public Feuille enfantGauche; // the Leaf's left child Leaf
    public Feuille enfantDroit; // the Leaf's right child Leaf
    public Rectangle room; //pièce sur la feuille
    public static ArrayList<Rectangle> halls = new ArrayList<Rectangle>();
    private Screen s;
	
	public Feuille(int x, int y, int width, int height, Screen s)
    {
		super(new Dimension(s.getWidth(),s.getHeight()));
        // initialize our leaf
		this.s = s;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
	
	public void afficherMap() {
		for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
            	System.out.print(map[i][j].getSprite().glyph());
            }
            System.out.println();
        }
	}
	
	public static void creerMap() {
		for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
            	map[i][j] = new MapTile(DecorElement.WALL);
            }
        }
	}
	
	public void afficherTuiles() {
		final RectanglePrinter printer = new RectanglePrinter();
        printer.setRectangleType(RectangleType.THIN);
        printer.setHeight(this.room.height);
        printer.setWidth(this.room.width);
        printer.setFillChar('#');
        printer.printFilled(this.s.getTiles(), new Point((int)this.room.getMinX(), (int)this.room.getMinY()));
	}
	
	/** Updates the Map's Layer, so that any changes made to the Map's tiles are displayed on the Layer. */
    public void updateLayerTiles() {
        for (int x = 0 ; x < this.width ; x++) {
            for (int y = 0 ; y <  this.height ; y++) {
                final MapTile mapTile = map[x][y];
                final DecorElement mapTileSprite = mapTile.getSprite();
                final Tile layerTile = super.tiles.getTileAt(x, y);
                layerTile.setCharacter(mapTileSprite.glyph());
            }
        }
    }
	

	
	public boolean diviser()
    {
        // On sépare la carte en deux enfant
        if (this.enfantGauche != null || enfantDroit != null) {
            return false; // La carte est déja divisé en deux
        }
 
        //On determine la division
        // Si la largeur est 25% plus large que la heuteur est haute on divise verticalement
        // Si la hauteur est 25% plus large que la largeur , on divise horizontalement
        // otherwise we split randomly
        boolean diviseHauteur = Math.random() > 0.5;
        if (width > height && (width / height) >= 1.25) {
            diviseHauteur = false;
        }else if (height > width && height / width >= 1.25) {
            diviseHauteur = true;
        }
        
        //Choix de la hauteur ou de la largeur en random pour diviser
        int divisionChoice=0;
        if(diviseHauteur) {
        	divisionChoice = height;
        }else {
        	divisionChoice = width;
        }
        int max = divisionChoice - TAILLE_MINIMUM_RECTANGLE; // On determine la hauteur ou la largeur à diviser
        if (max <= TAILLE_MINIMUM_RECTANGLE) {
            return false; // On ne peut plus diviser c'est trop petit
        }
 
        int diviserPosition = TAILLE_MINIMUM_RECTANGLE + (int)(Math.random() * ((max - TAILLE_MINIMUM_RECTANGLE) + 1)); //L'endroit de la division
        // On créer nos deux zones basé sur la division de la largeur ou de la hauteur
        if (diviseHauteur)
        {
            this.enfantGauche = new Feuille(x, y, width, diviserPosition,this.s);
            this.enfantDroit = new Feuille(x, y + diviserPosition, width, height - diviserPosition,this.s);
        }
        else
        {
        	this.enfantGauche = new Feuille(x, y, diviserPosition, height,this.s);
        	this.enfantDroit = new Feuille(x + diviserPosition, y, width - diviserPosition, height,this.s);
        }
        return true; // division réussi
    }
	
	public void createRooms()
	{
		
		// Génère les pièces et les couloirs pour la feuille et ses enfants
		if (enfantGauche != null || enfantDroit != null)
		{
			// La feuille a été divisier donc on va diviser ses enfants
			if (enfantGauche != null)
			{
				enfantGauche.createRooms();
			}
			if (enfantDroit != null)
			{
				enfantDroit.createRooms();
			}
			if (enfantGauche != null && enfantDroit != null)
			{
				createHall(enfantGauche.getRoom(), enfantDroit.getRoom());
			}
		}
		else
		{
			// On peut faire une pièce dans la zone
			Point roomSize;
			Point roomPos;
			// the room can be between 3 x 3 tiles to the size of the leaf - 2.
			// 3*3 minimum taille et Largeur - 2 * Hauteur - 2 maximum tailler
			int x = 3 + (int)(Math.random() * (((width-2) - 3) + 1));
			int y = 3 + (int)(Math.random() * (((height-2) - 3) + 1));
			roomSize = new Point(x, y);
			// Placer la piece à un endroit random dans le feuille
			// Ne pas mettre contre les bords de la zone
			x = 1 + (int)(Math.random() * (((width-roomSize.x- 1) - 1) + 1));
			y = 1 + (int)(Math.random() * (((height-roomSize.y- 1) - 1) + 1));
			roomPos = new Point(x, y);
			this.room = new Rectangle(this.x + roomPos.x, this.y + roomPos.y, roomSize.x, roomSize.y);
			//printRoom();
			for(int i = (int)room.getMinX(); i<=(int)room.getMinX() + room.width; i++) {
				for(int j = (int)room.getMinY(); j<=(int)room.getMinY()+ room.height; j++) {
					map[i][j] = new MapTile(DecorElement.FLOOR);
				}
			}
			
		}
	}
	
	public Rectangle getRoom()
	{
		// iterate all the way through these leafs to find a room, if one exists.
		if (room != null)
			return room;
		else
		{
			Rectangle lRoom = null;
			Rectangle rRoom = null;
			if (enfantGauche != null)
			{
				lRoom = enfantGauche.getRoom();
			}
			if (enfantDroit != null)
			{
				rRoom = enfantDroit.getRoom();
			}
			if (lRoom == null && rRoom == null)
				return null;
			else if (rRoom == null)
				return lRoom;
			else if (lRoom == null)
				return rRoom;
			else if (Math.random() > .5)
				return lRoom;
			else
				return rRoom;
		}
	}
	
	public void createHall(Rectangle l, Rectangle r)
	{
	    // On connecte deux pièces avec des couloirs 
		
	    //ArrayList<Rectangle> halls = new ArrayList<Rectangle>();
	    //halls = new ArrayList<Rectangle>();
	    Point point1 = new Point((int)(l.getMinX() + Math.random() * ((l.getMaxX() -2) - (l.getMinX() + 1))), (int)(l.getMinY() + Math.random() * ((l.getMaxY() -2) - (l.getMinY() + 1))));
	    Point point2 = new Point((int)(r.getMinX() + Math.random() * ((r.getMaxX() -2) - (r.getMinX() + 1))), (int)(r.getMinY() + Math.random() * ((r.getMaxY() -2) - (r.getMinY() + 1))));
	    int w = point2.x - point1.x;
	    int h = point2.y - point1.y;
	    if (w < 0)
	    {
	        if (h < 0)
	        {
	            if (Math.random() < 0.5)
	            {
	                halls.add(new Rectangle(point2.x, point1.y, Math.abs(w), 1));
	                halls.add(new Rectangle(point2.x, point2.y, 1, Math.abs(h)));
	            }
	            else
	            {
	                halls.add(new Rectangle(point2.x, point2.y, Math.abs(w), 1));
	                halls.add(new Rectangle(point1.x, point2.y, 1, Math.abs(h)));
	            }
	        }
	        else if (h > 0)
	        {
	            if (Math.random() < 0.5)
	            {
	                halls.add(new Rectangle(point2.x, point1.y, Math.abs(w), 1));
	               halls.add(new Rectangle(point2.x, point1.y, 1, Math.abs(h)));
	            }
	            else
	            {
	                halls.add(new Rectangle(point2.x, point2.y, Math.abs(w), 1));
	                halls.add(new Rectangle(point1.x, point1.y, 1, Math.abs(h)));
	            }
	        }
	        else // if (h == 0)
	        {
	            halls.add(new Rectangle(point2.x, point2.y, Math.abs(w), 1));
	        }
	    }
	    else if (w > 0)
	    {
	        if (h < 0)
	        {
	            if (Math.random() < 0.5)
	            {
	                halls.add(new Rectangle(point1.x, point2.y, Math.abs(w), 1));
	                halls.add(new Rectangle(point1.x, point2.y, 1, Math.abs(h)));
	            }
	            else
	            {
	                halls.add(new Rectangle(point1.x, point1.y, Math.abs(w), 1));
	                halls.add(new Rectangle(point2.x, point2.y, 1, Math.abs(h)));
	            }
	        }
	        else if (h > 0)
	        {
	            if (Math.random() < 0.5)
	            {
	                halls.add(new Rectangle(point1.x, point1.y, Math.abs(w), 1));
	                halls.add(new Rectangle(point2.x, point1.y, 1, Math.abs(h)));
	            }
	            else
	            {
	                halls.add(new Rectangle(point1.x, point2.y, Math.abs(w), 1));
	               halls.add(new Rectangle(point1.x, point1.y, 1, Math.abs(h)));
	            }
	        }
	        else // if (h == 0)
	        {
	            halls.add(new Rectangle(point1.x, point1.y, Math.abs(w), 1));
	        }
	    }
	    else // if (w == 0)
	    {
	        if (h < 0)
	        {
	            halls.add(new Rectangle(point2.x, point2.y, 1, Math.abs(h)));
	        }
	        else if (h > 0)
	        {
	            halls.add(new Rectangle(point1.x, point1.y, 1, Math.abs(h)));
	        }
	    }
	    for(Rectangle hall : halls) {
	    	System.out.println(hall.getMinX() + " " + hall.getMinY() + " " + (this.x + hall.width) + " " +(this.y + hall.height));
	    	for(int i = (int)hall.getMinX(); i<= (int)hall.getMinX() + hall.width; i++) {
	    		for(int j = (int)hall.getMinY(); j<=(int)hall.getMinY() + hall.height; j++) {
	    			map[i][j] = new MapTile(DecorElement.FLOOR);
	    		}
	    	}
	    }
	    //printHalls();
	}
	
	public void printHalls() {
		for(Rectangle hall : halls) {
			// Pour chaque couloir ajouter dans la map la decoration
	    	final RectanglePrinter printer = new RectanglePrinter();
	        printer.setRectangleType(RectangleType.THIN);
	        printer.setHeight(hall.height+1);
	        printer.setWidth(hall.width+1);
	        printer.setFillChar('#');
	        printer.printFilled(this.s.getTiles(), new Point((int)hall.getMinX(), (int)hall.getMinY()));
	    }
	}
	
	public void printFeuille() {
		final RectanglePrinter printer = new RectanglePrinter();
        printer.setRectangleType(RectangleType.THIN);
        printer.setHeight(height+1);
        printer.setWidth(width+1);
        printer.setFillChar('#');
        printer.printFilled(this.s.getTiles(), new Point(x, y));
	}
	
	public void printRoom() {
		final RectanglePrinter printer = new RectanglePrinter();
        printer.setRectangleType(RectangleType.THIN);
        printer.setHeight(this.room.height);
        printer.setWidth(this.room.width);
        printer.setFillChar('#');
        printer.printFilled(this.s.getTiles(), new Point((int)this.room.getMinX(), (int)this.room.getMinY()));
	}

	public static MapTile[][] getMap() {
		return map;
	}
	

	
	
	
	
}