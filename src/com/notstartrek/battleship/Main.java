package com.notstartrek.battleship;
/*
 * Main Method for Ship
 */

import java.io.IOException;

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

        MainMenu menu = new MainMenu();
        try {
            menu.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
