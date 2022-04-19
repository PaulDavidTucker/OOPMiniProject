package Game;

import java.util.ArrayList;

import Exceptions.ItemNotFoundException;
import Exceptions.TargetNotFoundException;

public interface PlayerActions {
    // Have some way of using items that can alter the health of the current hero
    public void Heal();

    // Have some sort of way to target an item, for example, list nearby items to
    // the player and have the option to target specific items.
    public void PickUp(ArrayList<Item> items) throws ItemNotFoundException;

    // Use a targeting system to deal damage to a player.
    public void Attack(String target, Game currentGame) throws TargetNotFoundException;

    // Activate a special move for the player.
    public void Special();

}
