import java.awt.event.KeyEvent;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws Exception {
		
		Perso p = new Perso();
		CarteMonde cm = new CarteMonde();
		//Console r = System.console();
		
		
		Scanner sc = new Scanner(System.in);
		char saisie;
		
		
		boolean mouvement = true;
		
		while (mouvement) {
				
			/*try {
				Runtime r = Runtime.getRuntime();
				Process pross = r.exec(cmd);
				pross.waitFor();
			}
			catch (Exception e) {
				e.printStackTrace();
			}*/
			cm.pseudoClear();
			
			cm.placerObjet("@",p.getPositionX(),p.getPositionY());
			cm.seDevoileA(p);
			cm.enleverObjet(p.getPositionX(),p.getPositionY());
			
				switch (saisie = sc.nextLine().charAt(0)) {
				
				  case 'z':
					  p.mvtHaut();
					  break;
				  
				  case 's':
					  p.mvtBas();
				    break;
				  
				  case 'q':
					  p.mvtGauche();
				    break;
				  
				  case 'd':
					  p.mvtDroite();
				    break;
				  }
			
		}
		sc.close();
		
		
	}
	
	/*static void ComDos() {
	  String cmd="cls";
      try 
      {
              Runtime r = Runtime.getRuntime();
              Process p = r.exec(cmd);
              
              p.waitFor(); 
      }
      catch(Exception e) 
      {
              e.printStackTrace();
      }
	}*/
	
}
		
		
		/*
		JLabel texte =new JLabel("Mon texte dans JLabel");
		pan.add(texte);
		texte.setOpaque(true);
		texte.setBackground(Color.red);
		
		JButton bt1 = new JButton("Exit");
		pan.add(bt1);
		bt1.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		bt1.setSize(200,100);
		bt1.setVisible(true);
		
		JTextField  TexteARecuperer = new JTextField ("");
		pan.add(TexteARecuperer);*/
		
		/*final JEditorPane editeur;

		//JPanel pannel = new JPanel();
			try {
				editeur = new JEditorPane(new URL("http://google.fr"));
				editeur.setEditable(false);
				editeur.addHyperlinkListener(new HyperlinkListener() {
					public void hyperlinkUpdate(HyperlinkEvent e) {
						if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
							URL url = e.getURL();
							if (url == null)
								return;
							try {
								editeur.setPage(e.getURL());
							} 
							catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
				});
				pan.add(editeur);
			} 
			catch (Exception e1) {
				e1.printStackTrace();
			}
		
		*/

