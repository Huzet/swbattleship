package com.notstartrek.battleship;
/*
 *
 */

class Main {
    public static void main(String[] args) {

        Controller game = new Controller(1,5);
        game.gameRunnerSinglePlayer();
    }
}