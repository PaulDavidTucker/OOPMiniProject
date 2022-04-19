package Game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

import GUI.MainWindow;
import Items.Potion;
import Items.Shield;
import Items.Sword;

public class DungeonMaster {
    public static void main(String[] args) throws Exception {
        // Will add file I/O to allow for
        ArrayList<Hero> hList = new ArrayList<>();
        ArrayList<Monster> eList = new ArrayList<>();
        Player mainPlayer = new Player(hList);
        Game NewGame = new Game(mainPlayer, 1, eList);
        // updates the player object within this instance of the game to have the
        // character selected
        NewGame.selectOrCreateCharacter();

        ArrayList<Item> TrollLoot = generateTrollLoot();
        ArrayList<Item> GoblinLoot = generateGoblinLoot();
        NewGame.PlayGame(GoblinLoot, TrollLoot);
        System.out.println("Here");

    }

    public static ArrayList<Item> generateGoblinLoot() {
        Random rand = new Random(5);
        int randint = rand.nextInt();
        ArrayList<Item> GoblinLoot = new ArrayList<>();
        Item potion = new Potion("Potion of healing", "heal", 100);
        Item sword = new Sword("Sword of valor", 50);
        Item shield = new Shield("Shield of unbreaking", "shield", 120);

        for (int i = 0; i < randint; i++) {
            GoblinLoot.add(potion);
            GoblinLoot.add(sword);
            GoblinLoot.add(shield);
        }

        return GoblinLoot;
    }

    public static ArrayList<Item> generateTrollLoot() {
        Random rand = new Random(5);
        int randint = rand.nextInt();
        ArrayList<Item> TrollLoot = new ArrayList<>();
        Item potion = new Potion("Potion of healing", "heal", 100);
        Item sword = new Sword("Sword of destiny", 70);
        Item shield = new Shield("Shield of ice", "shield", 80);

        for (int i = 0; i < randint; i++) {
            TrollLoot.add(potion);
            TrollLoot.add(sword);
            TrollLoot.add(shield);
        }

        return TrollLoot;
    }

}
