package Game;

import java.util.ArrayList;

public class Player {

    private ArrayList<Hero> Characters;
    private Hero currentHero;

    public Player(ArrayList<Hero> hList, Hero currentHero) {
        this.Characters = hList;
        this.currentHero = currentHero;
    }

    public void addCharacter(Hero hero) {
        if (this.Characters.size() == 0) {
            System.out.println("Adding");
            this.Characters.add(hero);
        } else {
            for (int i = 0; i < this.Characters.size(); i++) {
                if (this.Characters.get(i).equals(hero)) {
                    System.out.println("Already in list");
                    break;
                } else {
                    System.out.println("Adding");
                    this.Characters.add(hero);
                }
            }
        }

    }

    public ArrayList<Hero> getCharacters() {
        return Characters;
    }

    public Hero getCurrentHero() {
        return currentHero;
    }

    public void setCharacters(ArrayList<Hero> characters) {
        Characters = characters;
    }

    public void setCurrentHero(Hero currentHero) {
        this.currentHero = currentHero;
    }
}
