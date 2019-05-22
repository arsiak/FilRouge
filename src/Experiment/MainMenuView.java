package Experiment;
import com.valkryst.VTerminal.Screen;
import com.valkryst.VTerminal.builder.ButtonBuilder;
import com.valkryst.VTerminal.component.Button;

public class MainMenuView extends View {
    private Button button_new;
    private Button button_exit;
    private Screen screen;

    /**
     *
     * @param screen
     *          Ecran
     */
    public MainMenuView(final Screen screen) {
        super(screen);
        this.screen = screen;
        initializeComponents();

        this.addComponent(button_new);
        this.addComponent(button_exit);
    }

    /** Initialise les composants de la vue. */
    private void initializeComponents() {
        final ButtonBuilder buttonBuilder = new ButtonBuilder();
        buttonBuilder.setText("New Game");
        buttonBuilder.setPosition(this.screen.getWidth()/2-5, this.screen.getHeight()/2-1);
        button_new = buttonBuilder.build();

        buttonBuilder.setText("Exit");
        buttonBuilder.setPosition(this.screen.getWidth()/2-5, this.screen.getHeight()/2+1);
        button_exit = buttonBuilder.build();
    }
    
    public Button getButtonNew() {
    	return this.button_new;
    }
    
    public Button getButtonExit() {
    	return this.button_exit;
    }
}