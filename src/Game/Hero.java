package Game;

import java.util.ArrayList;

import Exceptions.ItemNotFoundException;
import Exceptions.TargetNotFoundException;

public class Hero implements PlayerActions {
    protected String HeroName;
    protected int Health;
    protected int Attack;
    protected ArrayList<Item> Inventory = new ArrayList<Item>();
    protected boolean specialUsed;

    // Constructor allows hero class classes to edit the specific values for that
    // class
    public Hero(String heroName, int Health, int Attack, ArrayList<Item> Inventory, boolean specialUsed) {
        this.HeroName = heroName;
        this.Health = Health;
        this.Attack = Attack;
        this.Inventory = Inventory;
        this.specialUsed = specialUsed;
    }

    @Override
    public void Heal() {
        // Check inventory for health giving items, then if you have one, use the
        // highest health giver first. Then use increase health method
        this.Health += 30;
    }

    @Override
    public void PickUp(ArrayList<Item> items) throws ItemNotFoundException {
        // Use the targeted array as the name for item, pick up item and add to
        // inventory
        for (int i = 0; i < items.size(); i++) {
            this.Inventory.add(items.get(i));
        }

    }

    @Override // Overrides from interface and is used in subclasses. destructively edits
    public void Attack(String target, Game currentGame) throws TargetNotFoundException {
        boolean found = false;
        for (int j = 0; j < currentGame.getElist().size(); j++) {
            // Looks at the target and makes it take damage
            if (currentGame.getElist().get(j).getName().equalsIgnoreCase(target)) {
                currentGame.getElist().get(j).takeDamage(getAttack());
                currentGame.window.addText(target + "Took damage!");
                found = true;
            }
            if (found) {

            } else {
                // otherwise throw exception
                throw new TargetNotFoundException();
            }

        }

    }

    // checks to see if special moves are used
    public boolean isSpecialUsed() {
        return this.specialUsed;
    }

    // Adds an item to the inventory. This is a destructive method
    public void addItem(Item item) {
        this.Inventory.add(item);
    }

    @Override
    public void Special() {
        // Method is overridden in the subclasses hunter, mage and warrior
    }

    // gets the attack of the class
    public int getAttack() {
        return this.Attack;
    }

}
