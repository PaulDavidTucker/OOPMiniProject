package Classes;

import java.util.ArrayList;

import Game.Hero;
import Game.Item;

public class Mage extends Hero {

    public Mage(String heroName, int Health, int Attack, ArrayList<Item> Inventory, boolean specialUsed) {
        super(heroName, Health, Attack, Inventory, specialUsed);
    }

    @Override
    public void Special() {
        if (isSpecialUsed()) {
            System.out.println("Sorry, your special move has already been used this game!");
        } else {
            // Prints out a message to the user
            System.out.println("SPECIAL MOVE ACTIVATED! BONUS ATTACK BUFF HAS BEEN PROVIDED");
            this.Attack += this.Attack + 30;
        }
    }

}
