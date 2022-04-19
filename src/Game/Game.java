package Game;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

import Classes.Hunter;
import Classes.Mage;
import Classes.Warrior;
import Exceptions.NameNotValidException;
import GUI.CreateCharacter;
import GUI.StartScreen;

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
        GUI.StartScreen screen = new GUI.StartScreen();
        ArrayList<Item> invt = new ArrayList<>();
        screen.addNewListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                screen.setVisible(false);
                GUI.CreateCharacter createCharacter = new GUI.CreateCharacter(500, 500);
                createCharacter.addCreateListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        final String Choice = createCharacter.getSelectorItem();
                        final String Name = createCharacter.getName();
                        switch (Choice) {
                            case "Mage":
                                createPlayableHero(createMage(Name));
                                break;

                            case "Warrior":
                                createPlayableHero(createWarrior(Name));
                                break;
                            case "Hunter":
                                createPlayableHero(createHunter(Name));
                                break;

                        }
                    }
                });

            }
        });

        screen.addExistingListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                screen.showWarning();
            }
        });

    }

    private void createPlayableHero(Hero hero) {
        this.CurrentPlayer.setCurrentHero(hero);
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
    private Hunter createHunter(String heroName) {
        // Blank inventory for a new hero
        ArrayList<Item> Inventory = new ArrayList<>();
        // Creates new hero object
        Hunter hunter = new Hunter(heroName, 75, 60, Inventory, false);
        // returns the object
        return hunter;
    }

    public void incrementLevel() {
        this.level++;
    }
}
