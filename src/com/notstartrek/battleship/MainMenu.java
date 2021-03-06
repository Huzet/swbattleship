package com.notstartrek.battleship;

/*
 * Player Main Menu
 */

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.notstartrek.battleship.board.BoardSizes;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


class MainMenu {
    // INSTANCE VARIABLES
    private Controller player;
    private int previousScore;

    private Prompter prompter;
    private ArrayList<Integer> scoreBoard;
    private String name;
    private BoardSizes.BoardSizeSpec mapSize;

    // CONSTRUCTOR
    MainMenu(Prompter prompter){
        this.prompter = prompter;
    }

    void execute() throws IOException {
        boolean runGame = true;
            scoreBoard = new ArrayList<>();
            welcome();
            createPlayer();
            promptToPlay();

        while (runGame) {
            pickMapSize();
            player = new Controller(new Scanner(System.in), 1, mapSize);
            player.gameRunnerSinglePlayer();
            replay();
        }
    }

    private void pickMapSize() {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("\n");
            String boardSize = prompter.prompt("Please enter your desired board size. [S]mall, [M]edium, [L]arge: ").toUpperCase(Locale.ROOT);
            System.out.println(boardSize);
            if (boardSize.matches("S|M|L")) { // SML
                validInput = true;
                if ("S".equals(boardSize)) {
                    this.mapSize = BoardSizes.BoardSizeSpec.SMALL;
                    Console.clear();
                }
                if ("M".equals(boardSize)) {
                    this.mapSize = BoardSizes.BoardSizeSpec.MEDIUM;
                    Console.clear();
                }
                if ("L".equals(boardSize)) {
                    this.mapSize = BoardSizes.BoardSizeSpec.LARGE;
                    Console.clear();
                }
            }
        }
    }


    private void welcome() throws IOException {
        String banner = Files.readString(Path.of("resources/banner2.txt"));
        System.out.println(banner);
    }

    private void createPlayer() {
        System.out.println("\n");
        String name = prompter.prompt("Please enter player's name: ");
        System.out.println("Welcome to Star Wars Battleship " +  name);
        this.name = name;
    }

    private void promptToPlay() {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("\n");
            String play = prompter.prompt("Please enter [S]tart Game to continue or [Q]uit to exit the game: ").toUpperCase(Locale.ROOT);
            if (play.matches("S|Q")) { //any digits, one or two times - now proceed
                validInput = true;
                if ("S".equals(play)) {
                    Console.clear();
                    continue;

                } else {
                    System.exit(0);
                }
            }
        }
    }
    private void replay() {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Congratulations you score is " + player.getTurnCount() +
                    " your last score was " + getPreviousScore());

            scoreBoard.add(player.getTurnCount());

            System.out.println("Star Wars Battleship Score Board");
            System.out.println("________________________________");
            System.out.println("Name       |     Score");
            for (int i=0; i<scoreBoard.size(); i++){
                System.out.println(name + "      |     " + scoreBoard.get(i));
                System.out.println("________________________________");
            }

            setPreviousScore(player.getTurnCount());

            String play = prompter.prompt("Please enter [P]lay again to play again or [Q]uit to exit the game: ").toUpperCase(Locale.ROOT);
            if (play.matches("P|Q")) { //any digits, one or two times - now proceed
                validInput = true;
                if ("P".equals(play)) {
                    Console.clear();
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
