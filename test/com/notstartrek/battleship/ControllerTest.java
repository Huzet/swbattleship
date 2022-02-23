package com.notstartrek.battleship;
/*
 * Tests Board class
 */

import com.notstartrek.battleship.board.BoardSizes;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ControllerTest {
    Controller testController;
    @Before
    public void setUp() throws Exception{
        testController = new Controller(new Scanner(new File("responses/responses_usedForTesting")),1, BoardSizes.BoardSizeSpec.SMALL);
    }

    @Test
    public void controllerBuilds(){
        assertEquals(5,testController.getBoardSize());
    }
    @Test(expected=java.util.NoSuchElementException.class)
    public void promptUser() throws Exception {
        // Mark 1a coordinate and error out
        testController.gameRunnerSinglePlayer();
    }

    @Test
    public void getPlayerCount_shouldReturn1(){
        assertEquals(1,testController.getPlayerCount());
    }

    @Test
    public void getTurnCountTest_setTurnCount_getTurn(){
        testController.setTurnCount(2);
        assertEquals(2,testController.getTurnCount(),.001);
    }

    @Test
    public void setBoardSize_getBoardSize(){
        assertEquals(5, testController.getBoardSize());
        testController.setBoardSize(BoardSizes.BoardSizeSpec.MEDIUM);
        assertEquals(10,testController.getBoardSize());
    }
}