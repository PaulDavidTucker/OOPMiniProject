package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JComboBox;

public class CreateCharacter extends Frame {

    private Label name;
    private TextField area;
    private JComboBox selector;
    private Button submit;

    public CreateCharacter(int height, int width) {
        super("Create Character");
        this.setSize(width, height);
        WindowCloser wc = new WindowCloser();
        this.addWindowListener(wc);
        final String[] itemList = { "Warrior", "Mage", "Hunter" };
        Panel p1 = new Panel();
        p1.setLayout(new GridLayout(4, 1));
        this.name = new Label("Enter the name of your hero");
        this.area = new TextField();
        this.selector = new JComboBox<>(itemList);
        this.submit = new Button("Create");
        p1.add(this.name);
        p1.add(this.area);
        p1.add(this.selector);
        p1.add(this.submit);
        this.setLayout(new BorderLayout());
        this.add(p1, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void addCreateListener(ActionListener listener) {
        this.submit.addActionListener(listener);
    }

}
