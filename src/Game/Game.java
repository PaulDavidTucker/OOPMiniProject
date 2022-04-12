package Game;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.Hunter;
import Classes.Mage;
import Classes.Warrior;
import Exceptions.NameNotValidException;

public class Game {
    private Player CurrentPlayer;
    private int level;
    private ArrayList<Monster> EnemyList = new ArrayList<>();
    private static int GameID;

    public Game(Player player, int level, ArrayList<Monster> eList) {
        this.CurrentPlayer = player;
        this.level = level;
        this.EnemyList = eList;
        GameID++;
    }

    public int getGameID() {
        return GameID;
    }

    public int getCurrentLevel() {
        return this.level;
    }

    public ArrayList<Monster> getElist() {
        return this.EnemyList;
    }

    public void selectOrCreateCharacter() throws NameNotValidException {
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
            System.out.println("Please Pick a class: \nMage\nWarrior\nHunter");
            Choice = input.nextLine();
            switch (Choice) {
                case "Mage":
                    System.out.println("What is the name of this mysterious mage?");
                    String name = input.nextLine();
                    selectedHero = createMage(name);
                    break;

                case "Warrior":
                    System.out.println("What is the name of this mysterious Warrior?");
                    name = input.nextLine();
                    selectedHero = createWarrior(name);
                    break;
                case "Hunter":
                    System.out.println("What is the name of this mysterious Hunter?");
                    name = input.nextLine();
                    selectedHero = creatHunter(name);
                    break;

            }
        } else {
            System.out.println("Invalid Input");
            throw new NameNotValidException();
        }

        this.CurrentPlayer.setCurrentHero(selectedHero);

    }

    // Method to create a new mage type
    private Mage createMage(String heroName) {
        // Blank inventory for a new hero
        ArrayList<Item> Inventory = new ArrayList<>();
        // Creates new hero object
        Mage mage = new Mage(heroName, 100, 50, Inventory, false);
        // returns the object
        return mage;
    }

    // Method to create a new Warrior type
    private Warrior createWarrior(String heroName) {
        // Blank inventory for a new hero
        ArrayList<Item> Inventory = new ArrayList<>();
        // Creates new hero object
        Warrior warrior = new Warrior(heroName, 120, 30, Inventory, false);
        // returns the object
        return warrior;
    }

    // Method to create a new Warrior type
    private Hunter creatHunter(String heroName) {
        // Blank inventory for a new hero
        ArrayList<Item> Inventory = new ArrayList<>();
        // Creates new hero object
        Hunter hunter = new Hunter(heroName, 75, 60, Inventory, false);
        // returns the object
        return hunter;
    }
}
