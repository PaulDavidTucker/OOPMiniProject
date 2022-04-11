package Game;

import java.util.ArrayList;

public class Hero implements PlayerActions {
    protected String HeroName;
    protected int Health;
    protected int Attack;
    private ArrayList<Item> Inventory = new ArrayList<Item>();
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
    }

    @Override
    public void PickUp(String target) {
        // Use the targeted string as the name for item, pick up item and add to
        // inventory

    }

    @Override
    public void Attack(String target) {
        // Do damage to a monster, have a monster superclass and create subclasses

    }

    @Override
    public void Move(String Direction) {
        // Move somewhere

    }

    public boolean isSpecialUsed() {
        return this.specialUsed;
    }

    public void Special() {

    }

}
