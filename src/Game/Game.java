package Game;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

import Classes.Hunter;
import Classes.Mage;
import Classes.Warrior;
import Exceptions.ItemNotFoundException;
import Exceptions.NameNotValidException;
import Exceptions.TargetNotFoundException;
import GUI.CreateCharacter;
import GUI.MainWindow;
import GUI.Prompt;
import GUI.StartScreen;

public class Game {
    protected Player CurrentPlayer;
    private int level;
    private ArrayList<Monster> EnemyList = new ArrayList<>();
    private static int GameID;
    protected MainWindow window;

    public Game(Player player, int level, ArrayList<Monster> eList) {
        this.CurrentPlayer = player;
        this.level = level;
        this.EnemyList = eList;
        GameID++;
        this.window = new MainWindow(500, 500);
        this.window.setVisible(false);
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

        screen.addExistingListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                screen.showWarning();
            }
        });

    }

    public void PlayGame(ArrayList<Item> goblinLoot, ArrayList<Item> trollLoot) {
        for (int i = 0; i < this.level; i++) {
            this.addEnemy(new Goblin(50, 30, goblinLoot));
            this.addEnemy(new Troll(100, 10, trollLoot));
        }
        window.addText("This is level " + this.level);
        window.addText("New enemies have appeared!");
        window.addText(getMonsterNames(this.EnemyList) + " Have appeared!");

        incrementLevel();

    }

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

    public void Attack(Game currentGame) {
        GUI.Prompt choseTarget = new GUI.Prompt();
        Label label1 = new Label("Enter the target name");
        // Text field
        TextField field = new TextField("");
        choseTarget.add(label1);
        choseTarget.add(field);
        choseTarget.addSubmitListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AttackProcess(field.getText(), currentGame);
            }
        });

        choseTarget.activate();

    }

    public void checkHealthBars() {
        for (int i = 0; i < this.EnemyList.size(); i++) {
            if (EnemyList.get(i).getHealth() <= 0) {
                window.addText(EnemyList.get(i).getName() + "Has been killed!");
                try {
                    CurrentPlayer.getCurrentHero().PickUp(EnemyList.get(i).DropLoot());
                    window.addText("Enemy has dropped loot!");
                } catch (ItemNotFoundException e) {
                    window.addText("Items not found!");
                }
                EnemyList.remove(i);
            }
        }
    }

    public void AttackProcess(String target, Game currentGame) {
        try {
            this.CurrentPlayer.getCurrentHero().Attack(target, currentGame);
            checkHealthBars();
            for (int i = 0; i < EnemyList.size(); i++) {
                window.addText(EnemyList.get(i).getName() + " Attacked you! they did " + EnemyList.get(i).getAttack()
                        + " damage!");
                currentGame.CurrentPlayer
                        .setCurrentHero(EnemyList.get(i).AttackHero(currentGame.CurrentPlayer.getCurrentHero()));
            }
            printStats();
        } catch (TargetNotFoundException e) {
            window.clearText();
            window.addText("Target not found");
            window.addText(getMonsterNames(this.EnemyList) + "Are the current enemies in the level");
        }
    }

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

    public void incrementLevel() {
        this.level++;
    }

    public void addEnemy(Monster monster) {
        this.EnemyList.add(monster);
    }

    public String getMonsterNames(ArrayList<Monster> eList) {
        String comString = "";
        for (int i = 0; i < eList.size(); i++) {
            comString += (eList.get(i).getName() + " ");
        }

        return comString;
    }

    public void printStats() {
        window.addText("Your health is:" + CurrentPlayer.getCurrentHero().Health);
        window.addText("Your attack is:" + CurrentPlayer.getCurrentHero().Attack);
        window.addText("Within your inventory you have: ");
        for (int i = 0; i < this.CurrentPlayer.getCurrentHero().Inventory.size(); i++) {
            window.addText(this.CurrentPlayer.getCurrentHero().Inventory.get(i).getName());
        }
    }
}
