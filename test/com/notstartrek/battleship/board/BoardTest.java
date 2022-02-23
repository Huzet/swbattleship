package com.notstartrek.battleship.board;
/*
 * Tests Board class
 * Todo check all sizes of map, ships, playerCount
 *
 */

import com.notstartrek.battleship.board.Board;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BoardTest {
    Board testBoard;
    Board testBoard2;

    @Before
    public void setUp(){
        testBoard = new Board(7);
        testBoard2 = new Board(5);
        testBoard.generateMap();
        testBoard2.generateMap();
    }

    @Test
    public void boardCreatedSuccessfully(){
        assertEquals(7,testBoard.getBoardSize());
    }
    @Test
    public void generateMapSize_CreatesCorrectSizeMap(){
        assertEquals(49,testBoard.generateMap().size());
        assertEquals(25,testBoard2.generateMap().size());
    }
    @Test
    public void printMap_printsMapForUserCorrectly(){
        assertEquals(373,testBoard.printMap().length());
        assertEquals(233,testBoard2.printMap().length());
    }
    @Test
    public void placeShipsOnBoard_placesShipsOnBoard(){
        testBoard.placeShipsOnBoard();
        assertTrue(testBoard.board.containsValue("$"));

    }
}

