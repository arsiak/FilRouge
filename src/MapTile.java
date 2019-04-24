import java.awt.Dimension;

import com.valkryst.VTerminal.component.Layer;

import lombok.Data;

@Data
public class MapTile extends Layer {
    private DecorElement sprite = DecorElement.WALL;
    private int movementCost = 1;
    private boolean solid = true;
    private boolean visited = false;
    private boolean visible = false;

    public MapTile() {
    	super(new Dimension(1,100));
    }

    public MapTile(final DecorElement sprite) {
    	super(new Dimension(1,3));
        this.sprite = sprite;	
    }
    
    public DecorElement getSprite() {
    	return this.sprite;
    }

	public boolean isVisible() {
		return this.visible;
	}
}