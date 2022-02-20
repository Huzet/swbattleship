package com.notstartrek.battleship;
/*
 *
 */

class Main {
    public static void main(String[] args) {

        // Using since scanner not working in test
        BattleshipPlayer board = new BattleshipPlayer(1);
        board.game();

    }
}