package GUI;

import java.awt.event.*;

//actions taken on the x being clicked
public class WindowCloser extends WindowAdapter {
    public void windowClosing(WindowEvent evt) {
        System.exit(0);
    }
}
