package GUI;

import java.awt.*;
import java.awt.event.*;

public class Prompt extends Frame {
    private Label label;
    private TextField input;
    private Button submit;

    // prompt window constructor
    public Prompt() {
        this.setLayout(new GridLayout(0, 2));
        submit = new Button("Submit");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                ((Frame) (evt.getSource())).dispose();
            }
        });
    }

    // Sets the size and makes visible, as well as adding the button with preloaded
    // actions/
    public void activate() {
        this.add(submit);
        this.setVisible(true);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null); // Centers the window on the screen
    }

    // adds a listener
    public void addSubmitListener(ActionListener listener) {
        submit.addActionListener(listener);
    }
}
