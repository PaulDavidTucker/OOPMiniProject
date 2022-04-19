package Game;

public interface MonsterActions {

    // Create a method that will target a hero and have certain effects on them,
    // returning the hero type after
    public Hero AttackHero(Hero hero);

    // Write a method to add health to the monster.
    public void Heal(int amount);
}
