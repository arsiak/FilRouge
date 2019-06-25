package Panneau;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoutonPerso extends JButton {

	public BoutonPerso(String txt, String icon) {
        super(txt);
        setForeground(Color.WHITE);
         
        //setOpaque(false);
        setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
        setBorderPainted(false); // De même, on ne veut pas afficher les bordures.
        setFocusPainted(false); // On n'affiche pas l'effet de focus.
         

         
        //setIcon(new ImageIcon(icon));
        //setRolloverIcon(new ImageIcon(icon));
    
	}
}
