public interface Actions {
    // Have some way of using items that can alter the health of the current hero
    public void Heal();

    // Have some sort of way to target an item, for example, list nearby items to
    // the player and have the option to target specific items.
    public void PickUp(String target);

    // Use a targeting system to deal damage to a player.
    public void Attack(String target);

    // Allow a player to move the hero
    public void Move(String Direction);
}
