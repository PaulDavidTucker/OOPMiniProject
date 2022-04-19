package GUI;

import java.awt.*;
import java.awt.event.*;

public class MainWindow extends Frame {

    private TextField output;
    private Button attack;
    private Button heal;
    private Button shop;

    public MainWindow(int height, int width) {
        super("Dungeon Master");
        this.setSize(width, height);
        this.setVisible(true);
        WindowCloser wc = new WindowCloser();
        this.addWindowListener(wc);
        this.output = new TextField();
        this.output.setEditable(false);
        this.attack = new Button("Attack");
        this.heal = new Button("Heal");
        this.shop = new Button("Shop");

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

    public void addHealListener(ActionListener listener) {
        this.heal.addActionListener(listener);
    }

    public void addShopListener(ActionListener listener) {
        this.shop.addActionListener(listener);
    }

}
