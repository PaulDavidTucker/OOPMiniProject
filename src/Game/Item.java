package Game;

public abstract class Item {
    protected String name;
    protected String type;
    protected int value;

    public Item(String name, String type, int value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    // Implement these in the items actual class
    public abstract String getName();

    public abstract String getType();

    public abstract int getValue();
}
