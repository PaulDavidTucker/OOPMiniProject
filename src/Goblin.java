import java.util.ArrayList;

public class Goblin extends Monster {

    public Goblin(int health, int attack, ArrayList<Item> loot) {
        super(health, attack, loot);
    }

    @Override
    public void Attack(String target) {

    }

    @Override
    public void Heal(int amount) {

    }

    @Override
    public ArrayList<Item> DropLoot() {
        return null;
    }

}
