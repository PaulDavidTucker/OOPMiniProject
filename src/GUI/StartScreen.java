package GUI;

import java.awt.*;
import java.awt.event.*;

public class StartScreen extends Frame {

    private Label Text;
    private Button New;
    private Button Existing;
    private Label Warning;

    public StartScreen() {
        super("Dungeon Master");
        this.setLayout(new GridLayout(4, 1));
        Text = new Label("Please either select an existing character or create a new one");
        New = new Button("New Character");
        Existing = new Button("Existing");
        Warning = new Label("Sorry, this feature is a work in progress");
        this.add(Text);
        this.add(New);
        this.add(Existing);
        this.add(Warning);
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
