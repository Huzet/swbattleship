package com.notstartrek.battleship.board;

/*
 * Tests Board class
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    Board testBoard;
    Board testBoard2;

    @Before
    public void setUp(){
        testBoard = new Board(BoardSizes.BoardSizeSpec.SMALL);
        testBoard2 = new Board(BoardSizes.BoardSizeSpec.LARGE);
        testBoard.generateMap();
        testBoard2.generateMap();
    }

    @Test
    public void boardCreatedSuccessfully(){
        assertEquals(5,testBoard.getBoardSize());
    }
    @Test
    public void generateMapSize_CreatesCorrectSizeMap(){
        assertEquals(25,testBoard.generateMap().size());
        assertEquals(400,testBoard2.generateMap().size());
    }
    @Test
    public void printMap_printsMapForUserCorrectly(){
        assertEquals(233,testBoard.printMap().length());
        assertEquals(2258,testBoard2.printMap().length());
    }
    @Test
    public void placeShipsOnBoard_placesShipsOnBoard(){
        testBoard.placeShipsOnBoard();
        assertTrue(testBoard.board.containsValue("$"));

    }
}

