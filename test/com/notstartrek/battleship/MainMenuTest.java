package com.notstartrek.battleship;

import com.apps.util.Prompter;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {
    MainMenu testMenu;

    @Before
    public void setUp() throws Exception {
        Prompter prompter = new Prompter(new Scanner(new File("responses/mainMenuResponses")));
        testMenu = new MainMenu(prompter);
    }

    @Test(expected=java.util.NoSuchElementException.class)
    public void execute() throws Exception {
        testMenu.execute();
    }

    @Test
    public void getPreviousScore() {
        assertEquals(0, testMenu.getPreviousScore());
        testMenu.setPreviousScore(5);
        assertEquals(5, testMenu.getPreviousScore());
    }

}