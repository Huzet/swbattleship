package com.notstartrek.battleship;
/*
 * Main Method for Ship
 */

import com.apps.util.Prompter;

import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args){

        MainMenu menu = new MainMenu(new Prompter(new Scanner(System.in)));
        try {
            menu.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
