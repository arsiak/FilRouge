package Experiment;

import com.valkryst.VTerminal.Screen;
import com.valkryst.VTerminal.component.Layer;
import lombok.NonNull;

import java.awt.*;

public class View extends Layer {
    /**
     * Construit une vue qui prend tout l'écran
     *
     * @param screen
     *          L'écran sur lequel la vue est affichée
     *
     * @throws NullPointerException
     *          Si il n'y a pas d'écran
     */
    public View(Screen screen) {
        super(new Dimension(screen.getWidth(), screen.getHeight()));
    }
}