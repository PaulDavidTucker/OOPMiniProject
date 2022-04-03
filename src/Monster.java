import java.util.ArrayList;

public class Monster implements MonsterActions {

    // Unfinished class
    private int Health;
    private int Attack;
    private ArrayList<Item> Loot;

    public Monster(int health, int attack, ArrayList<Item> loot) {
        this.Health = health;
        this.Attack = attack;
        this.Loot = loot;
    }

    public ArrayList<Item> DropLoot() {
        return null;
    }

    @Override
    public void Heal() {
        // TODO write method to implement monster healing

    }

    @Override
    public Hero AttackHero(Hero hero) {
        // TODO write method to implement attacking a hero and returning the modified
        // object to the game object.
        return null;
    }

}
