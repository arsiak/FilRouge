public class Carte {

	protected int xPerso;
	protected int yPerso;
	protected String [][] carte;
	
	public int getXPerso() {
		return xPerso;
	}
	
	public void setXPerso(int x) {
		xPerso=x;
	}
	
	public int getYPerso() {
		return yPerso;
	}
	
	public void setYPerso(int y) {
		yPerso=y;
	}
	
	public void placerObjet (String lettre, int x, int y) {
		carte[x][y] = lettre;
	}
	
	public void enleverObjet (int x, int y) {
		carte[x][y] = " ";
	}
		
	public Boolean testBlocage(Perso type) {
		Boolean blocage = false;
		if (carte[type.getPositionX()][type.getPositionY()] == "X" ) { blocage = true; }
		if (carte[type.getPositionX()][type.getPositionY()] == "O" ) { blocage = true; }
		return blocage;
	}
	
	public Boolean testChangementCarte(Perso type) {
		Boolean changementCarte = false;
		if (carte[type.getPositionX()][type.getPositionY()] == "D" ) { changementCarte = true; }
		return changementCarte;
	}
	
	public Carte changementCarte(Perso type) {
		
		int x = type.getPositionX();
		int y = type.getPositionY();
		Carte newCarte = new Carte();
		
		if (x == 5 && y == 4) { newCarte = new CarteDonjonTest(); }
		else if (x == 5 && y == 15) { newCarte = new CarteDonjonTest(); }
		else if (x == 4 && y == 23) { newCarte = new CarteDonjonTest(); }
		else if (x == 5 && y == 26) { newCarte = new CarteDonjonTest(); }
		else if (x == 12 && y == 42) { newCarte = new CarteDonjonTest(); }
		else if (x == 24 && y == 5) { newCarte = new CarteDonjonTest(); }
		else if (x == 20 && y == 20) { newCarte = new CarteDonjonTest(); }
		else if (x == 25 && y == 40) { newCarte = new CarteDonjonTest(); }
		else if (x == 30 && y == 13) { newCarte = new CarteDonjonTest(); }
		else if (x == 38 && y == 5) { newCarte = new CarteDonjonTest(); }
		else if (x == 38 && y == 22) { newCarte = new CarteDonjonTest(); }
		else if (x == 36 && y == 39) { newCarte = new CarteDonjonTest(); }
		else {
			System.out.println("c'est pas bon");
		}
		//else if (y == 14 && x == 24) { newCarte = new CarteVillage(); }
		return newCarte;
	}
	
	
	 public void setDeplacementPerso(Perso type) {
		 xPerso = type.getPositionX();
		 yPerso = type.getPositionY();
	 }
		
		public void seDevoileA(Perso type) {
			
			int x = type.getPositionX();
			int y = type.getPositionY();
			for(int i =  (x - 3); i <= (x + 3); i++ ){  
				for(int j = (y - 3); j <= (y + 3); j++){   
					System.out.print(carte[i][j]); 
				} 
			System.out.println(); 
			}  
			
		}
		
		public void pseudoClear() {
			for (int i=0; i<15; i++) System.out.println();
		}
	
}
