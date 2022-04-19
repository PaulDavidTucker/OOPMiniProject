package GUI;

import java.awt.*;
import java.awt.event.*;

//Main game window
public class MainWindow extends Frame {

    private TextField output;
    private Button attack;
    private Button heal;
    private Button shop;

    public MainWindow(int height, int width) {
        // Uses superclass to built in class frame
        super("Dungeon Master");
        this.setSize(width, height);
        this.setVisible(true);
        // adds an action for the window closing
        WindowCloser wc = new WindowCloser();
        this.addWindowListener(wc);
        this.output = new TextField();
        this.output.setEditable(false);
        // creates new buttons
        this.attack = new Button("Attack");
        this.heal = new Button("Heal");
        this.shop = new Button("Shop");

        // Creates panels and adds components to the panel
        Panel p1 = new Panel();
        Panel p2 = new Panel();
        p1.setLayout(new BorderLayout());
        p1.add("Center", output);
        p2.setLayout(new GridLayout(1, 3));
        p2.add(attack);
        p2.add(heal);
        p2.add(shop);
        this.add(p1);
        this.add(p2);
        // Sets the window layout and adds panels
        this.setLayout(new GridLayout(2, 1));

    }

    // Method to edit current text on the screen with new text.
    public void addText(String Text) {
        String oldText = this.output.getText();
        this.output.setText(oldText + "\n" + Text);
    }

    // method to clear the window
    public void clearText() {
        this.output.setText("");
    }

    // method to alter the actions of each of the buttons
    public void addAttackListener(ActionListener listener) {
        this.attack.addActionListener(listener);
    }

    // Action for healing
    public void addHealListener(ActionListener listener) {
        this.heal.addActionListener(listener);
    }

    public void addShopListener(ActionListener listener) {
        this.shop.addActionListener(listener);
    }

}
