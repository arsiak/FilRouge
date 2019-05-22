package OldProg;
import java.awt.Color;

public enum DecorElement {
    FLOOR((char)' ', Color.yellow),
    WALL((char)'X', Color.green),
    BOUNDS('x', Color.black),
	PLAYER('@', Color.blue);
	
    private char glyph;
    public char glyph() { return glyph; }

    private Color color;
    public Color color() { return color; }

    DecorElement(char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }


	public Color getForegroundColor() {
		return this.color;
	}

}