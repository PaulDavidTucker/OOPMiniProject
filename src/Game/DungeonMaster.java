package Game;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.Mage;

public class DungeonMaster {
    public static void main(String[] args) throws Exception {
        // Will add file I/O to allow for
        ArrayList<Hero> hList = new ArrayList<>();
        ArrayList<Monster> eList = new ArrayList<>();
        Player mainPlayer = new Player(hList);
        Game NewGame = new Game(mainPlayer, 0, eList);
        // updates the player object within this instance of the game to have the
        // character selected
        NewGame.selectOrCreateCharacter();
        System.out.println(mainPlayer.getCurrentHero().HeroName);

    }

}
