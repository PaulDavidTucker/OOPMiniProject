package GUI;

import java.awt.*;
import java.awt.event.*;

public class Prompt extends Frame {
    private Label label;
    private TextField input;
    private Button submit;

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

    public void activate() {
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null); // Centers the window on the screen
    }

    public void addSubmitListener(ActionListener listener) {
        submit.addActionListener(listener);
    }
}
