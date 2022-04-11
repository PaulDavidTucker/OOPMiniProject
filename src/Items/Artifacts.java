package Items;

import Game.Item;

public class Artifacts extends Item {

    public Artifacts(String name, String type, int value) {
        super(name, "Artifact", value);
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
