package Exceptions;

import Game.Item;

//exception
public class ItemNotFoundException extends Exception {
    private Item item;

    public ItemNotFoundException(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return this.item;
    }
}
