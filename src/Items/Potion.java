package Items;

import Game.Item;

public class Potion extends Item {

    public Potion(String name, String type, int value) {
        super(name, "Potion", value);
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
