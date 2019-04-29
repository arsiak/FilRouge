import java.awt.Color;
import java.util.Random;

public class Map{
	
	public static final int MAP_SIZE = 100;
	private MapTile[][] map;
	double chanceToHaveFloor = 0.7;
	private int deathLimit= 5;
	private int birthLimit = 6 ;
	private int numberOfSteps= 2;
	
	public Map() {
		//initialiseMap();
		generateMap();
	}
	
	public void initialiseMap(){
		this.map = new MapTile[MAP_SIZE][MAP_SIZE];
	    for(int x=0; x<MAP_SIZE; x++){
	        for(int y=0; y<MAP_SIZE; y++){
	            if(Math.random() < chanceToHaveFloor){
	                this.map[x][y] = new MapTile(DecorElement.FLOOR);
	            }else {
	            	this.map[x][y] = new MapTile(DecorElement.WALL);
	            	
	            }
	        }
	    }
	    //return map;
	}

	public void initMap() {
		this.map = new MapTile[MAP_SIZE][MAP_SIZE];
		 for(int x=0; x<MAP_SIZE; x++){
		      for(int y=0; y<MAP_SIZE; y++){
		          if(Math.random() < chanceToHaveFloor){
		              this.map[x][y] = new MapTile(DecorElement.FLOOR);
		          }else {
		        	  this.map[x][y] = new MapTile(DecorElement.WALL);
		          }
		      }
		  }
	}
	
	public void generateMap(){
	    //Create a new map
	    this.map = new MapTile[MAP_SIZE][MAP_SIZE];
	    //Set up the map with random values
	    initialiseMap();
	    //And now run the simulation for a set number of steps
	    for(int i=0; i<numberOfSteps; i++){
	        doSimulationStep();
	    }
	}
	
	//Returns the number of cells in a ring around (x,y) that are alive.
	public int countAliveNeighbours(int x, int y){
	    int count = 0;
	    //if(x > 0 && x < this.map.length-1 && y > 0 && y < this.map.length-1  ) {
	    for(int i=-1; i<2; i++){
	        for(int j=-1; j<2; j++){
	            int neighbour_x = x+i;
	            int neighbour_y = y+j;
	            
	            //If we're looking at the middle point
	            if(i == 0 && j == 0){
	                //Do nothing, we don't want to add ourselves in!
	            }
	            //In case the index we're looking at it off the edge of the map
	            else if(neighbour_x < 0 || neighbour_y < 0 || neighbour_x >= this.map.length || neighbour_y >= this.map[0].length){
	                count = count + 1;
	            }
	            //Otherwise, a normal check of the neighbour
	            else if(this.map[neighbour_x][neighbour_y].getSprite() == DecorElement.FLOOR){
	                count = count + 1;
	            }
	        }
	   // }
	    }
	    return count;
	}
	
	public void doSimulationStep(){
	    MapTile[][] newMap = new MapTile[MAP_SIZE][MAP_SIZE];
	    //Loop over each row and column of the map
	    for(int x=0; x<this.map.length; x++){
	        for(int y=0; y<this.map[x].length; y++){
	            int nbs = countAliveNeighbours(x, y);
	            //The new value is based on our simulation rules
	            //First, if a cell is alive but has too few neighbours, kill it.
	            if(this.map[x][y].getSprite() == DecorElement.FLOOR){
	                if(nbs < deathLimit){
	                    newMap[x][y] = new MapTile(DecorElement.WALL);
	                }
	                else{
	                    newMap[x][y] = new MapTile(DecorElement.FLOOR);
	                }
	            } //Otherwise, if the cell is dead now, check if it has the right number of neighbours to be 'born'
	            else{
	                if(nbs > birthLimit){
	                    newMap[x][y] = new MapTile(DecorElement.FLOOR);
	                }
	                else{
	                    newMap[x][y] = new MapTile(DecorElement.WALL);
	                }
	            }
	        }
	    }
	    this.map = newMap;
	    //return newMap;
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
