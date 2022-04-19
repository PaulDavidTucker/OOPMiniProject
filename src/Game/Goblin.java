package Game;

import java.util.ArrayList;

//subclass of monster
public class Goblin extends Monster {

    public Goblin(int health, int attack, ArrayList<Item> loot) {
        super("Goblin", health, attack, loot);
    }

    // Methods are in monster superclass to avoid code duplication

}
