
import javax.swing.JPanel;

public class CarteMonde extends JPanel {

	
		String carteMonde [][] = {{"X","X","X","X","X","X"," ","X","X","X","X"," ","X","X","X"}, // x, i
								  {"X","X","X","X"," "," "," "," "," "," "," "," "," ","X","X"},
								  {"X","X","X"," "," ","P"," "," "," ","X","X"," "," "," ","X"},
								  {"X","X","X"," "," "," "," "," ","X","X","X"," "," "," "," "},
								  {"X","X"," "," ","X","X"," "," "," "," "," "," "," "," ","X"},
								  {" "," "," "," ","X"," "," "," "," "," ","V"," "," ","X","X"},
								  {"X","X"," "," "," ","C"," "," "," "," "," "," "," "," ","X"},
								  {"X","X"," "," "," "," "," "," "," "," "," "," "," "," ","X"},
								  {"X","X","X"," "," "," ","X"," "," "," ","X","X","X"," "," "},
								  {"X","X","X"," ","X","X","X","X"," ","X","X","X","X","X","X"},
								  {"X","X","X"," ","X","X","X","X"," ","X","X","X","X","X","X"},
								  {"X","X","X"," ","X","X","X","X"," ","X","X","X","X","X","X"}};
	    						 // y, j
		
		
		public void placerObjet (String lettre, int x, int y) {
			carteMonde[x][y] = lettre;
		}
		
		public void enleverObjet (int x, int y) {
			carteMonde[x][y] = " ";
		}
		
		public void seDevoileA(Perso type) {
			
			int x = type.getPositionX();
			int y = type.getPositionY();
			for(int i =  (x - 3); i <= (x + 3); i++ ){  
				for(int j = (y -3); j <= (y + 3); j++){   
					System.out.print(carteMonde[i][j]); 
		    } 
			System.out.println(); 
			}  
		}
		
		public void pseudoClear() {
			for (int i=0; i<15; i++) System.out.println();
		}
	
}
