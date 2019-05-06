package Experiment;

import com.valkryst.VTerminal.Screen;
import com.valkryst.VTerminal.component.Layer;
import lombok.NonNull;

import java.awt.*;

public class View extends Layer {
    /**
     * Construit une vue qui prend tout l'�cran
     *
     * @param screen
     *          L'�cran sur lequel la vue est affich�e
     *
     * @throws NullPointerException
     *          Si il n'y a pas d'�cran
     */
    public View(Screen screen) {
        super(new Dimension(screen.getWidth(), screen.getHeight()));
    }
}