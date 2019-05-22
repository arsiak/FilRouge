package Experiment;
import com.valkryst.VTerminal.Screen;
import lombok.Getter;
import lombok.NonNull;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController extends Controller<MainMenuView> {

    /**
     * @param screen
     *          The screen on which the view is displayed.
     *
     * @throws NullPointerException
     *          If the screen is null.
     */
    public GameController(Screen screen) {
        super(new MainMenuView(screen));
        screen.addComponent(super.getView());
        screen.draw();
        
    }
}