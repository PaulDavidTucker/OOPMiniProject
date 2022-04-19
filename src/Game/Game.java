package Game;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import Classes.Hunter;
import Classes.Mage;
import Classes.Warrior;
import Exceptions.ItemNotFoundException;
import Exceptions.NameNotValidException;
import Exceptions.TargetNotFoundException;
import GUI.MainWindow;

public class Game {
    protected Player CurrentPlayer;
    private int level;
    private ArrayList<Monster> EnemyList = new ArrayList<>();
    private static int GameID;
    protected MainWindow window;

    // Constructor
    public Game(Player player, int level, ArrayList<Monster> eList) {
        this.CurrentPlayer = player;
        this.level = level;
        this.EnemyList = eList;
        GameID++;
        this.window = new MainWindow(500, 500);
        this.window.setVisible(false);
    }

    // gets game id
    public int getGameID() {
        return GameID;
    }

    // Gets current level
    public int getCurrentLevel() {
        return this.level;
    }

    // GEts the list of enemies
    public ArrayList<Monster> getElist() {
        return this.EnemyList;
    }

    // Select a new character method
    public void selectOrCreateCharacter() throws NameNotValidException {
        // creates a new GUI
        GUI.StartScreen screen = new GUI.StartScreen();
        ArrayList<Item> invt = new ArrayList<>();

        // Adds a listener for the new character
        screen.addNewListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                screen.setVisible(false);
                // Opens create character method
                GUI.CreateCharacter createCharacter = new GUI.CreateCharacter(500, 500);
                // Adds action to the create character
                createCharacter.addCreateListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        final String Choice = createCharacter.getSelectorItem();
                        final String Name = createCharacter.getName();
                        // actions for each of the classes
                        switch (Choice) {
                            case "Mage":
                                createPlayableHero(createMage(Name));
                                createCharacter.setVisible(false);
                                break;

                            case "Warrior":
                                createPlayableHero(createWarrior(Name));
                                createCharacter.setVisible(false);
                                break;
                            case "Hunter":
                                createPlayableHero(createHunter(Name));
                                createCharacter.setVisible(false);
                                break;

                        }
                    }
                });

            }
        });

        // Will implement file io to allow for permemenant storage of the game
        screen.addExistingListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                screen.showWarning();
            }
        });

    }

    // Creates new enemies and starts the game at level 1
    public void PlayGame(ArrayList<Item> goblinLoot, ArrayList<Item> trollLoot) {
        for (int i = 0; i < this.level; i++) {
            // Adds enemies to the array lsit
            this.addEnemy(new Goblin(50, 30, goblinLoot));
            this.addEnemy(new Troll(100, 10, trollLoot));
        }
        // Adds enemy list to the window
        window.addText("This is level " + this.level);
        window.addText("New enemies have appeared!");
        window.addText(getMonsterNames(this.EnemyList) + " Have appeared!");

        // Adds level
        incrementLevel();

    }

    // Spawns enemies and adds them to the list
    public void spawnEnemies(ArrayList<Item> goblinLoot, ArrayList<Item> trollLoot) {
        window.clearText();
        for (int i = 0; i < this.level; i++) {
            this.addEnemy(new Goblin(50, 20, goblinLoot));
            this.addEnemy(new Troll(100, 10, trollLoot));
        }
        window.addText("This is level " + this.level);
        window.addText("New enemies have appeared!");
        window.addText(getMonsterNames(this.EnemyList) + " Have appeared!");

        incrementLevel();
    }

    // Attack looks at target name to damage an objects health.
    public void Attack(Game currentGame) {
        // Creates a prompt object
        GUI.Prompt choseTarget = new GUI.Prompt();
        Label label1 = new Label("Enter the target name");
        // Text field
        TextField field = new TextField("");
        choseTarget.add(label1);
        choseTarget.add(field);
        // Added all the components, change behaviour of the button
        choseTarget.addSubmitListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AttackProcess(field.getText(), currentGame);
            }
        });

        // sets it visible and sets size
        choseTarget.activate();

    }

    // checks health of all enemies
    public void checkHealthBars() {
        // loops through array
        for (int i = 0; i < this.EnemyList.size(); i++) {
            // checks health of current enemy
            if (EnemyList.get(i).getHealth() <= 0) {
                window.addText(EnemyList.get(i).getName() + "Has been killed!");
                // Checks items, if none throw new item not found exception
                try {
                    // uses drop loot
                    CurrentPlayer.getCurrentHero().PickUp(EnemyList.get(i).DropLoot());
                    window.addText("Enemy has dropped loot!");
                } catch (ItemNotFoundException e) {
                    window.addText("Items not found!");
                }
                // removes dead enemy
                EnemyList.remove(i);
            }
        }
    }

    // Attack progress involves checking health bars
    public void AttackProcess(String target, Game currentGame) {
        // can throw targetnot found exception if there is an issue
        try {
            // uses method in the hero class that targets and enemy and does damage based on
            // the class
            this.CurrentPlayer.getCurrentHero().Attack(target, currentGame);
            checkHealthBars();
            // Runs through each of the enemies
            for (int i = 0; i < EnemyList.size(); i++) {
                window.addText(EnemyList.get(i).getName() + " Attacked you! they did " + EnemyList.get(i).getAttack()
                        + " damage!");
                currentGame.CurrentPlayer
                        .setCurrentHero(EnemyList.get(i).AttackHero(currentGame.CurrentPlayer.getCurrentHero()));
            }
            // prints stats to the window
            printStats();
        } catch (TargetNotFoundException e) {
            // Shows error message
            window.clearText();
            window.addText("Target not found");
            window.addText(getMonsterNames(this.EnemyList) + "Are the current enemies in the level");
        }
    }

    // private method to create a playable hero
    private void createPlayableHero(Hero hero) {
        this.CurrentPlayer.setCurrentHero(hero);
        this.window.setVisible(true);
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

    // increments object level
    public void incrementLevel() {
        this.level++;
    }

    // adds an enemy to the list
    public void addEnemy(Monster monster) {
        this.EnemyList.add(monster);
    }

    // Gets the names of all the monsters
    public String getMonsterNames(ArrayList<Monster> eList) {
        String comString = "";
        for (int i = 0; i < eList.size(); i++) {
            comString += (eList.get(i).getName() + " ");
        }

        return comString;
    }

    // Prints stats to the console
    public void printStats() {
        window.addText("Your health is:" + CurrentPlayer.getCurrentHero().Health);
        window.addText("Your attack is:" + CurrentPlayer.getCurrentHero().Attack);
        window.addText("Within your inventory you have: ");
        for (int i = 0; i < this.CurrentPlayer.getCurrentHero().Inventory.size(); i++) {
            window.addText(this.CurrentPlayer.getCurrentHero().Inventory.get(i).getName());
        }
    }
}
