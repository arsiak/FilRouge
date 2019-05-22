package OldProg;

public class testGeneratedMap {

	public static void main(String[] args) {
		Map m = new Map();
		MapTile[][] map = m.getMap();
		for(MapTile[] m1 : map) {
			for(MapTile m2 : m1) {
				System.out.println(m2.getSprite().glyph());
			}
		}
	}

}
