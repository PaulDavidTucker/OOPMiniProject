package GUI;

import java.awt.*;
import java.awt.event.*;

public class StartScreen extends Frame {

    private Label Text;
    private Button New;
    private Button Existing;
    private Label Warning;

    // Start screen to allow for creating a character
    public StartScreen() {
        // uses super constructor
        super("Dungeon Master");
        // defines the layout
        this.setLayout(new GridLayout(4, 1));
        this.setSize(500, 500);
        // adds an action for the window closing
        WindowCloser wc = new WindowCloser();
        this.addWindowListener(wc);
        // New components
        Text = new Label("Please either select an existing character or create a new one");
        New = new Button("New Character");
        Existing = new Button("Existing");
        Warning = new Label("Sorry, this feature is a work in progress");
        this.add(Text);
        this.add(New);
        this.add(Existing);
        this.add(Warning);
        // sets to be visible
        Warning.setVisible(false);
        this.setVisible(true);
    }

    // method to alter the actions of each of the buttons
    public void addNewListener(ActionListener listener) {
        this.New.addActionListener(listener);
    }

    // method to alter the actions of each of the buttons
    public void addExistingListener(ActionListener listener) {
        this.Existing.addActionListener(listener);
    }

    public void showWarning() {
        this.Warning.setVisible(true);
    }

}
