package GUI;

import java.awt.*;

public class MainWindow extends Frame {
    public MainWindow(int height, int width) {
        super("Dungeon Master");
        this.setSize(width, height);
        this.setVisible(true);
        WindowCloser wc = new WindowCloser();
        this.addWindowListener(wc);
    }
}
