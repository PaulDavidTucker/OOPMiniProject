import java.lang.invoke.VarHandle.AccessMode;
import java.util.ArrayList;
import java.util.Scanner;

public class DungeonMaster {
    public static void main(String[] args) throws Exception {
        // Will add file I/O to allow for
        ArrayList<Hero> hList = new ArrayList<>();
        Hero currentHero = selectCharacter();
        Player mainPlayer = new Player(hList, currentHero);
        mainPlayer.addCharacter(currentHero);
        // Testing, Proves method works
        System.out.println(mainPlayer.getCharacters());

    }

    public static Hero selectCharacter() {
        System.out.println(
                "Would you like to pick an existing character or create a new character?\nType Existing for and existing Character\nType New for a new character");
        Scanner input = new Scanner(System.in);
        ArrayList<Item> invt = new ArrayList<>();
        Hero selectedHero = new Hero("", 0, 0, invt, false);
        String Choice = input.nextLine();

        if (Choice.equalsIgnoreCase("Existing")) {
            // Work in progress when IO is added
            System.out.println("Currently a feature that is a work in progress");
        } else if (Choice.equalsIgnoreCase("New")) {
            System.out.println("Please Pick a class: \nMage\nWarrior");
            Choice = input.nextLine();
            switch (Choice) {
                case "Mage":
                    System.out.println("What is the name of this mysterious mage?");
                    String name = input.nextLine();
                    selectedHero = createMage(name);
                    break;

                case "Warrior":
                    System.out.println("What is the name of this mysterious mage?");
                    name = input.nextLine();
                    selectedHero = createWarrior(name);
                    break;

            }
        } else {
            System.out.println("Invalid Input");
            System.exit(0);
        }

        return selectedHero;
    }

    // Method to create a new mage type
    public static Mage createMage(String heroName) {
        // Blank inventory for a new hero
        ArrayList<Item> Inventory = new ArrayList<>();
        // Creates new hero object
        Mage mage = new Mage(heroName, 100, 50, Inventory, false);
        // returns the object
        return mage;
    }

    // Method to create a new hero type
    public static Mage createWarrior(String heroName) {
        // Blank inventory for a new hero
        ArrayList<Item> Inventory = new ArrayList<>();
        // Creates new hero object
        Mage warrior = new Mage(heroName, 120, 30, Inventory, false);
        // returns the object
        return warrior;
    }
}
