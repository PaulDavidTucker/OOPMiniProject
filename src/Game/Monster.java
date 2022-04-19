package Game;

import java.util.ArrayList;

public class Monster implements MonsterActions {

    // Unfinished class
    private String Name;
    private int Health;
    private int Attack;
    private ArrayList<Item> Loot;

    public Monster(String name, int health, int attack, ArrayList<Item> loot) {
        this.Name = name;
        this.Health = health;
        this.Attack = attack;
        this.Loot = loot;
    }

    public String getName() {
        return this.Name;
    }

    public ArrayList<Item> DropLoot() {
        return this.Loot;
    }

    @Override
    public void Heal(int amount) {
        this.Health += amount;
    }

    @Override
    public Hero AttackHero(Hero hero) {
        // TODO write method to implement attacking a hero and returning the modified
        // object to the game object.
        return null;
    }

    @Override
    public void takeDamage(int amount) {
        this.Health -= amount;
    }

    public int getHealth() {
        return this.Health;
    }

}
