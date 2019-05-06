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
     *          Model et vue à null
     */
    public Controller(V view) {
        this.view = view;
    }

    /**
     * Ajoute la vue à l'écran après avoir supprimé tous le contenu de l'écran
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
     * Supprime la vue de l'écran
     *
     * @param screen
     *          l'écran
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