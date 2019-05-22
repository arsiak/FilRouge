package Cartes;

public class Coord {
	
	private int x;
	private int y;
	
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x += x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y += y;
	}
	
	public boolean equals(Coord otherCoord) {
		
		if (otherCoord == null) return false;
	    if (otherCoord.getX() == this.x && otherCoord.getY() == this.y) {
	    	return true;
	    }
	    else {
	    	return false;	    	
	    }
	}
}
