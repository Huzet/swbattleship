package com.notstartrek.battleship;
/*
 * Main Method for Ship
 */

import com.apps.util.Prompter;

import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args){
//
//        Controller game = new Controller(1,5);
//        game.gameRunnerSinglePlayer();


//        BoardSizes boardSizes = new BoardSizes();
//        ArrayList<Ship> enemyShips = boardSizes.generateBoardShips();
////        System.out.println(enemyShips.size());
//        for (int x = 0; x <= enemyShips.size() - 1; x++) {
//            boolean roomForShip = true;
//            int lengthOfShip = enemyShips.get(x).getSize();
//            System.out.println(lengthOfShip);
//            System.out.println( enemyShips.get(x).getShipType());

        MainMenu menu = new MainMenu(new Prompter(new Scanner(System.in)));
        try {
            menu.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
