package com.notstartrek.battleship;
/*
 * Tests Board class
 * Todo check all sizes of map and ships
 * Todo Lookinto Testing out userInputs
 */

import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ControllerTest {
    Controller testController;
//new Scanner(new File("responses/filename"), 1, 5);
    @Before
    public void setUp() throws Exception{
        testController = new Controller(new Scanner(new File("responses/responses_usedForTesting")),1,5);
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
        testController.setBoardSize(10);
        assertEquals(10,testController.getBoardSize());
    }

}