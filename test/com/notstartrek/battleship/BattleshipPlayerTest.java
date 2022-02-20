package com.notstartrek.battleship;
/*
 *
 */

import org.junit.Test;

public class BattleshipPlayerTest {
    BattleshipPlayer board = new BattleshipPlayer(1);

    @Test
    public void myTests(){
        System.out.println(board.generateMap());
        System.out.println(board.printMap());
        // Manual input
        board.mark("1j");
        System.out.println(board.printMap());

    }

}