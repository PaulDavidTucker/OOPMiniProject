package Items;

import Game.Item;

//subclass of the Item class
public class Shield extends Item {

    public Shield(String name, String type, int value) {
        super(name, "Shield", value);
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
