package Panneau;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoutonPerso extends JButton {

	public BoutonPerso(String txt, String icon) {
        super(txt);
        setForeground(Color.WHITE);
         
        //setOpaque(false);
        setContentAreaFilled(false); // On met � false pour emp�cher le composant de peindre l'int�rieur du JButton.
        setBorderPainted(false); // De m�me, on ne veut pas afficher les bordures.
        setFocusPainted(false); // On n'affiche pas l'effet de focus.
         

         
        //setIcon(new ImageIcon(icon));
        //setRolloverIcon(new ImageIcon(icon));
    
	}
}
