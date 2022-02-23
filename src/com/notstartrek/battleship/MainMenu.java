package com.notstartrek.battleship;

/*
 * Player Main Menu
 */

import com.apps.util.Prompter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

class MainMenu {
    private Controller player;
    private int previousScore;

    private Prompter prompter;

    // CONSTRUCTOR
    MainMenu(Prompter prompter){
        this.prompter = prompter;
    }
    public void execute() throws IOException {
        welcome();
        createPlayer();
        promptToPlay();
        player = new Controller(new Scanner(System.in),1,5);
        player.gameRunnerSinglePlayer();
        replay();
        player.gameRunnerSinglePlayer();
    }

    private void welcome() throws IOException {
        String banner = Files.readString(Path.of("resources/banner.txt"));
        System.out.println(banner);
    }
    private void createPlayer() {
        String name = prompter.prompt("Please enter player's name: ");
        System.out.println("Welcome to Star Wars Battleship " +  name);
    }

    private void promptToPlay() {
        boolean validInput = false;
        while (!validInput) {
            String play = prompter.prompt("Please enter [S]tart Game to continue or [Q]uit to exit the game: ").toUpperCase(Locale.ROOT);
            if (play.matches("S|Q")) { //any digits, one or two times - now proceed
                validInput = true;
                if ("S".equals(play)) {
                    continue;
                } else {
                    System.exit(0);
                }
            }
        }
    }
    public void replay() {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Congratulations you score is " + player.getTurnCount() +
                    " your last score was " + getPreviousScore());
            setPreviousScore(player.getTurnCount());
            String play = prompter.prompt("Please enter [P]lay again to play again or [Q]uit to exit the game: ").toUpperCase(Locale.ROOT);
            if (play.matches("P|Q")) { //any digits, one or two times - now proceed
                validInput = true;
                if ("P".equals(play)) {
                    continue;
                } else {
                    System.exit(0);
                }
            }
        }
    }

    public int getPreviousScore() {
        return previousScore;
    }

    public void setPreviousScore(int previousScore) {
        this.previousScore = previousScore;
    }
}
