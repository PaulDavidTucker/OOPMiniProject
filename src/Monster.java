import java.util.ArrayList;

public class Monster {

    // Unfinished class
    private int Health;
    private int Attack;
    private ArrayList<Item> Loot;

    public Monster(int health, int attack, ArrayList<Item> loot) {
        this.Health = health;
        this.Attack = attack;
        this.Loot = loot;
    }

    public void Attack(String target) {

    }

    public void Heal(int amount) {

    }

    public ArrayList<Item> DropLoot() {
        return null;
    }

}
