package com.notstartrek.battleship;
/*
 * Tests Board class
 * Todo check all sizes of map and ships
 * Todo Lookinto Testing out userInputs
 */

import org.junit.Before;
import org.junit.Test;

// Jay prompter imports
//import com.apps.util.Prompter;
//import org.junit.Test;
//import java.io.File;
//import java.util.Scanner;
//import static org.junit.Assert.*;
//
//import java.io.File;
//import java.util.Scanner;

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
//    @Test
//    public void promptUser() throws Exception {
//        Prompter prompter = new Prompter(new Scanner(new File("responses/responses_usedForTesting")));
//        String name = prompter.prompt("enter valid coordinate");
//        Controller testController2 = new Controller(1,5);
//        testController.promptUser();
//    }

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