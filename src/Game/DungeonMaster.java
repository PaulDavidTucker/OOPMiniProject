package Game;

import java.util.ArrayList;
import java.util.Random;
import java.awt.event.*;

import Items.Potion;
import Items.Shield;
import Items.Sword;

public class DungeonMaster {
    public static void main(String[] args) throws Exception {
        // Will add file I/O to allow for games to be imported
        ArrayList<Hero> hList = new ArrayList<>();
        ArrayList<Monster> eList = new ArrayList<>();
        Player mainPlayer = new Player(hList);
        Game NewGame = new Game(mainPlayer, 1, eList);
        // updates the player object within this instance of the game to have the
        // character selected
        NewGame.selectOrCreateCharacter();

        // creates an inventory for each enemy
        ArrayList<Item> TrollLoot = generateTrollLoot();
        ArrayList<Item> GoblinLoot = generateGoblinLoot();
        // starts game on this instance of the game object
        NewGame.PlayGame(GoblinLoot, TrollLoot);

        // Starter text
        NewGame.window.addText("Welcome to the dungeons, my brave hero!");

        // This adds an action for the attack button
        NewGame.window.addAttackListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Runs the attack method utilising the game object to destructively edit the
                // game
                NewGame.Attack(NewGame);
                NewGame.checkHealthBars();
                // Prints new game to the console
                NewGame.window
                        .addText(NewGame.getMonsterNames(NewGame.getElist()) + "Are the current enemies in the level");

                // Checks to see if a new game is needed
                if (NewGame.getElist().isEmpty()) {
                    NewGame.spawnEnemies(GoblinLoot, TrollLoot);
                }
                // Checks whether the game is ended or not
                if (NewGame.CurrentPlayer.getCurrentHero().Health <= 0) {
                    NewGame.window.clearText();
                    NewGame.window.addText("YOU HAVE BEEN SLAIN! game over");
                    System.exit(0);
                }
            }
        });

        // Action for the heal button, i want to intertwine the inventory and the
        // potions within the inventory to make healing mechanics
        NewGame.window.addHealListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // At the moment you can simply be healed, later want to make it so it uses
                // potions from inventory
                NewGame.window.clearText();
                NewGame.window.addText("You have been healed");
                NewGame.CurrentPlayer.getCurrentHero().Heal();

                // Checks whether the game is ended or not
                if (NewGame.CurrentPlayer.getCurrentHero().Health <= 0) {
                    NewGame.window.clearText();
                    NewGame.window.addText("YOU HAVE BEEN SLAIN! game over");
                    System.exit(0);
                }
            }
        });

        // Action for the shop button, want to add a currency system to the game and
        // allow items to be bought
        NewGame.window.addShopListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NewGame.window.clearText();
                NewGame.window.addText("New feature to be added");

                // Checks whether the game is ended or not
                if (NewGame.CurrentPlayer.getCurrentHero().Health <= 0) {
                    NewGame.window.clearText();
                    NewGame.window.addText("YOU HAVE BEEN SLAIN! game over");
                    System.exit(0);
                }
            }
        });

    }

    // Generates loot for each of the enemy classes
    public static ArrayList<Item> generateGoblinLoot() {
        // Using random object
        Random rand = new Random();
        int randint = rand.nextInt(5);
        // New arraylist created
        ArrayList<Item> GoblinLoot = new ArrayList<>();
        // Three base items, will have more added in later verisons of the game
        Item potion = new Potion("Potion of healing", "heal", 100);
        Item sword = new Sword("Sword of valor", 50);
        Item shield = new Shield("Shield of unbreaking", "shield", 120);

        // Adds a random amount of each item to the game, plan to use static unique IDs
        // for each item, and the random number will determine the id of items used.
        // potentially will use file io here
        for (int i = 0; i < randint; i++) {
            GoblinLoot.add(potion);
            GoblinLoot.add(sword);
            GoblinLoot.add(shield);
        }

        return GoblinLoot;
    }

    // Generates loot for each of the enemy classes
    public static ArrayList<Item> generateTrollLoot() {
        // random object
        Random rand = new Random();
        int randint = rand.nextInt(5);
        ArrayList<Item> TrollLoot = new ArrayList<>();
        // Creating base items
        Item potion = new Potion("Potion of healing", "heal", 100);
        Item sword = new Sword("Sword of destiny", 70);
        Item shield = new Shield("Shield of ice", "shield", 80);

        // Adds a random amount of each item to the game, plan to use static unique IDs
        // for each item, and the random number will determine the id of items used.
        // potentially will use file io here
        for (int i = 0; i < randint; i++) {
            TrollLoot.add(potion);
            TrollLoot.add(sword);
            TrollLoot.add(shield);
        }

        return TrollLoot;
    }

}
