
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import com.valkryst.VTerminal.Screen;
import com.valkryst.VTerminal.Tile;
import com.valkryst.VTerminal.component.Layer;

public class Zone extends Layer implements KeyListener{
	private Coord coinHautGauche;
	private int zoneWidth;
	private int zoneHeight;
	private Personnage p;
	private MapTile[][] zone;
	private MapTile[][] map;
	private Screen s;
	
	public Zone(Coord positionHautGauche, MapTile[][] mapTiles, Screen s) throws IOException {
		super(new Dimension(s.getWidth(),s.getHeight()));
		this.s = s;
		this.map = mapTiles;
		this.zoneWidth = s.getWidth();
		this.zoneHeight = s.getHeight();
		this.coinHautGauche = positionHautGauche;
		// Initialize the MapTiles array.
		
		//La zone ne fait que la taille de l'écran
		
		this.zone = new MapTile[s.getWidth()][s.getHeight()];
		//Ajouter le personnage dans la premiere case vide
		
		ajouterPersonnage(new Personnage(getCenter()));
	    this.updateZone(mapTiles);
	    this.updateLayerTiles();
	    this.s.addListener(this);
	    this.s.draw();
	}
	
	
	/** Updates the Map's Layer, so that any changes made to the Map's tiles are displayed on the Layer. */
    public void updateLayerTiles() {
        for (int x = 0 ; x < this.zoneWidth ; x++) {
            for (int y = 0 ; y <  this.zoneHeight ; y++) {
                final MapTile mapTile = this.zone[x][y];
                final DecorElement mapTileSprite = mapTile.getSprite();
                final Tile layerTile = super.tiles.getTileAt(x, y);
                layerTile.setCharacter(mapTileSprite.glyph());
            }
        }
    }
    
    public int getViewWidth() {
        return super.tiles.getWidth();
    }
   
    public int getViewHeight() {
        return super.tiles.getHeight();
    }
	
	public Personnage getPersonnage() {
		return this.p;
	}

	public Coord getCoinHautGauche() {
		return this.coinHautGauche;
	}

	public void setCoinHautGauche(Coord coinHautGauche) {
		this.coinHautGauche = coinHautGauche;
	}
	
	public Coord getCenter() {
		return new Coord((this.zoneWidth) / 2, (this.zoneHeight) / 2 );
	}
	
	public void ajouterPersonnage(Personnage p ) {
		this.p = p;
		this.zone[p.getPosition().getX()][p.getPosition().getY()] = new MapTile(DecorElement.PLAYER);
	}
	
	public void updateZone(MapTile[][] mapTiles) {
		this.zone = new MapTile[this.zoneWidth][];
	    for (int i = 0; i < this.zoneWidth; i++) {
	        this.zone[i] = new MapTile[this.zoneHeight];
	        for(int j= 0; j<this.zoneHeight; j++) {
	        	try {
	        		this.zone[i][j] = mapTiles[this.coinHautGauche.getX() + j][this.coinHautGauche.getY()+i];
	        	} catch(IndexOutOfBoundsException exception) {
	        		this.zone[i][j] = new MapTile(DecorElement.WALL);
	        	}
	        }
	    }
	    this.zone[p.getPosition().getX()][p.getPosition().getY()] = new MapTile(DecorElement.PLAYER);
	}
	
	public MapTile[][] getZoneAffichage(){
		for(int i=0; i<this.zone.length; i++) {
			for(int j = 0; j < this.zone[i].length; j++) {
				System.out.print(this.zone[i][j].getSprite().glyph());
			}
			System.out.println();
		}
		return this.zone;
		
	}	@Override
	public void keyTyped(KeyEvent e) {
        
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		   int codeDeLaTouche = e.getKeyCode();
	        Coord caseSuivante = null;
	        //Personnage personnage = getPersonnage();
	        try {
	        switch (codeDeLaTouche) // Les valeurs sont contenue dans KeyEvent. Elles commencent par VK_ et finissent par le nom de la touche
	        {
	        
	       // case KeyEvent.VK_Z:
	            case KeyEvent.VK_UP: // si la touche enfoncée est celle du haut
	            	caseSuivante = new Coord(getCoinHautGauche().getX()+getCenter().getX()-1, getCoinHautGauche().getY()+getCenter().getY());
					if(this.map[caseSuivante.getX()][caseSuivante.getY()].getSprite().glyph() != DecorElement.WALL.glyph()) {
						this.coinHautGauche.setX(-1);
					}
	                break;
	            case KeyEvent.VK_LEFT: // si la touche enfoncée est celle de gauche
	            	  caseSuivante = new Coord(getCoinHautGauche().getX()+getCenter().getX(), getCoinHautGauche().getY()+getCenter().getY()-1);
					    if(this.map[caseSuivante.getX()][caseSuivante.getY()].getSprite().glyph() !=  DecorElement.WALL.glyph()) {
						this.coinHautGauche.setY(-1);
					    }
	                break;
	            case KeyEvent.VK_RIGHT: // si la touche enfoncée est celle de droite
	            	caseSuivante = new Coord(getCoinHautGauche().getX()+getCenter().getX(),getCoinHautGauche().getY()+getCenter().getY()+1);
					if(this.map[caseSuivante.getX()][caseSuivante.getY()].getSprite().glyph() !=  DecorElement.WALL.glyph()) {
						this.coinHautGauche.setY(1);
					}
	                break;
	            case KeyEvent.VK_DOWN: // si la touche enfoncée est celle du bas
	            	caseSuivante = new Coord(getCoinHautGauche().getX()+getCenter().getX()+1, getCoinHautGauche().getY()+getCenter().getY());
					if(this.map[caseSuivante.getX()][caseSuivante.getY()].getSprite().glyph() != '#') {
						this.coinHautGauche.setX(1);
					}
	                break;
	        }}
	        catch(ArrayIndexOutOfBoundsException e1) {
	        	e1.getMessage();
	        }
	        this.updateZone(this.map);
	        this.updateLayerTiles();
	        this.s.draw();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
