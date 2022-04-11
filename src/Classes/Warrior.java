package Classes;

import java.util.ArrayList;

import Game.Hero;
import Game.Item;

public class Warrior extends Hero {

    public Warrior(String heroName, int Health, int Attack, ArrayList<Item> Inventory, boolean specialUsed) {
        super(heroName, Health, Attack, Inventory, specialUsed);
    }

    // Each hero has a special move that can be used once per game.
    // Warrior adds additional Health to the player's Character.
    @Override
    public void Special() {
        if (isSpecialUsed()) {
            System.out.println("Sorry, your special move has already been used this game!");
        } else {
            System.out.println("SPECIAL MOVE ACTIVATED! BONUS HEALTH HAS BEEN AWARDED");
            // Adds 45 healthpoints to the health of the warrior
            this.Health = this.Health += 45;
        }
    }

}
