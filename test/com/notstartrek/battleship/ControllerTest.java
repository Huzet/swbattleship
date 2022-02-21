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

    @Before
    public void setUp(){
        testController = new Controller(1,5);
    }

    @Test
    public void controllerBuilds(){
        assertEquals(5,testController.getBoardSize());
    }


}