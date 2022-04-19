package Game;

import java.util.ArrayList;

public class Troll extends Monster {
    public Troll(int health, int attack, ArrayList<Item> loot) {
        super("Troll", health, attack, loot);
    }

    // Methods for monster are defined in superclass
}
