package Items;

import Game.Item;

//subclass of the Item class
public class Sword extends Item {

    // Creates a constructor that uses the name and value of the item
    public Sword(String name, int value) {
        super(name, "Weapon", value);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return this.type;

    }

    @Override
    public int getValue() {
        return this.value;
    }
}
