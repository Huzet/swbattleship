package com.notstartrek.battleship.board;
/*
 * Tests Ship Class
 */
import com.notstartrek.battleship.board.BoardSizes;
import com.notstartrek.battleship.board.Ship;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ShipTest {
    BoardSizes testBoardSizes;
    List<Ship> testEnemyShips;

    @Before
    public void setUp(){
        testBoardSizes = new BoardSizes();
        testEnemyShips = testBoardSizes.generateBoardShips();
    }

    @Test
    public void testGetterSettersFor_Ships(){
        assertEquals(1,testEnemyShips.get(0).getSize());
        assertEquals(Ship.ShipType.X_WING,testEnemyShips.get(0).getShipType());
    }
}