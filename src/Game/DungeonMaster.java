package Game;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

import GUI.MainWindow;

public class DungeonMaster {
    public static void main(String[] args) throws Exception {
        // Will add file I/O to allow for
        ArrayList<Hero> hList = new ArrayList<>();
        ArrayList<Monster> eList = new ArrayList<>();
        Player mainPlayer = new Player(hList);
        Game NewGame = new Game(mainPlayer, 0, eList);
        // updates the player object within this instance of the game to have the
        // character selected
        // NewGame.selectOrCreateCharacter();

        GUI.MainWindow mainWindow = new GUI.MainWindow(500, 500);
        mainWindow.addAttackListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mainWindow.addText("Helloooo");
            }
        });

        // GUI.CreateCharacter create = new GUI.CreateCharacter(500, 500);
    }

}
