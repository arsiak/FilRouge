import lombok.Data;

@Data
public class MapTile {
    private DecorElement sprite = DecorElement.WALL;
    private int movementCost = 1;
    private boolean solid = true;
    private boolean visited = false;
    private boolean visible = false;

    public MapTile() {}

    public MapTile(final DecorElement sprite) {
        this.sprite = sprite;	
    }
    
    public DecorElement getSprite() {
    	return this.sprite;
    }

	public boolean isVisible() {
		return this.visible;
	}
}