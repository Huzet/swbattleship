package com.notstartrek.battleship.board;
/*
 * Tests BoardSizesTest
 */

import com.notstartrek.battleship.board.BoardSizes;
import com.notstartrek.battleship.board.Ship;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class BoardSizesTest {
    BoardSizes testBoardSizes;
    List<Ship> testEnemyShips;

    @Before
    public void setUp(){
        testBoardSizes = new BoardSizes();
        testEnemyShips = testBoardSizes.generateBoardShips(BoardSizes.BoardSizeSpec.SMALL);
    }

    @Test
    public void generateBoardShips_withSmallSpec(){
        assertEquals(3,testEnemyShips.size());
    }

    @Test
    public void generateBoardSize_takesSizeReturnsValue(){
        assertEquals(5,testBoardSizes.generateBoardSize(BoardSizes.BoardSizeSpec.SMALL));
        assertEquals(10,testBoardSizes.generateBoardSize(BoardSizes.BoardSizeSpec.MEDIUM));
        assertEquals(20,testBoardSizes.generateBoardSize(BoardSizes.BoardSizeSpec.LARGE));
    }

    @Test
    public void testGetterSettersFor_BoardSizeSpec_SMALL(){
        assertEquals(2,BoardSizes.BoardSizeSpec.SMALL.getXwingCount());
        assertEquals(1,BoardSizes.BoardSizeSpec.SMALL.getBomberCount());
        assertEquals(0,BoardSizes.BoardSizeSpec.SMALL.getMillStarCount());
        assertEquals(5,BoardSizes.BoardSizeSpec.SMALL.getMapSize());

    }

    @Test
    public void testGetterSettersFor_BoardSizeSpec_MEDIUM(){
        assertEquals(5,BoardSizes.BoardSizeSpec.MEDIUM.getXwingCount());
        assertEquals(2,BoardSizes.BoardSizeSpec.MEDIUM.getBomberCount());
        assertEquals(1,BoardSizes.BoardSizeSpec.MEDIUM.getMillStarCount());
        assertEquals(10,BoardSizes.BoardSizeSpec.MEDIUM.getMapSize());

    }

    @Test
    public void testGetterSettersFor_BoardSizeSpec_LARGE(){
        assertEquals(10,BoardSizes.BoardSizeSpec.LARGE.getXwingCount());
        assertEquals(4,BoardSizes.BoardSizeSpec.LARGE.getBomberCount());
        assertEquals(2,BoardSizes.BoardSizeSpec.LARGE.getMillStarCount());
        assertEquals(20,BoardSizes.BoardSizeSpec.LARGE.getMapSize());

    }




}