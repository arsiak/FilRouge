package Experiment;
import com.valkryst.VTerminal.Screen;
import com.valkryst.VTerminal.component.Component;

import java.util.EventListener;

public class Controller<V extends View> {
   private final V view; // La vue


    /**
     *
     * @param view
     *          The view.
     *
     * @param model
     *          The model.
     *
     * @throws NullPointerException
     *          Model et vue � null
     */
    public Controller(V view) {
        this.view = view;
    }

    /**
     * Ajoute la vue � l'�cran apr�s avoir supprim� tous le contenu de l'�cran
     *
     * @param screen
     *          Ecran
     */
    public void addToScreen(final Screen screen) {
        if (screen == null) {
            return;
        }
        screen.addComponent(view);
    }

    /**
     * Supprime la vue de l'�cran
     *
     * @param screen
     *          l'�cran
     */
    public void removeFromScreen(final Screen screen) {
        if (screen == null) {
            return;
        }
        screen.removeComponent(view);
    }

	public Component getView() {
		// TODO Auto-generated method stub
		return this.view;
	}
}