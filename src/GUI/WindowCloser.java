package GUI;

import java.awt.*;
import java.awt.event.*;

public class WindowCloser extends WindowAdapter {
    public void windowClosing(WindowEvent evt) {
        System.exit(0);
    }
}
