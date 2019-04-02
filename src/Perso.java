
public class Perso {

	private String lettre;
	private int positionX, positionY;

	public Perso() {
		lettre = "@";
		positionX = 6;
		positionY = 8;
	}
	
	public Perso(String lettre, int positionX, int positionY) {
		this.lettre=lettre;
		this.positionX=positionX;
		this.positionY=positionY;
	}
	
	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public String getLettre() {
		return lettre;
	}

	public void setLettre(String lettre) {
		this.lettre = lettre;
	}

	public void mvtGauche () {
		positionY--;
	}

	public void mvtDroite () {
		positionY++;
	}
	
	public void mvtHaut () {
		positionX--;
	}
	
	public void mvtBas () {
		positionX++;
	}
	
	
}