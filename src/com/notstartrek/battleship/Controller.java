package com.notstartrek.battleship;
/*
 * Controller plays the game.
 * Creates Board
 * Runs the game
 *
 * todo use player count to setup boards differently
 *
 */

import com.apps.util.Console;
import com.notstartrek.battleship.board.Board;
import com.notstartrek.battleship.board.BoardSizes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

class Controller {

    // INSTANCE VARIABLES
    private final Scanner userResponse;
    private int playerCount;
    private int turnCount;
    private int boardSize;
    Board playerRadar;
    Board enemyBoard;

    // CONSTRUCTOR
    Controller (Scanner userResponse, int playerCount, BoardSizes.BoardSizeSpec boardSize){
        this.userResponse = userResponse;
        setPlayerCount(playerCount);
        playerRadar = new Board(boardSize);
        enemyBoard = new Board(boardSize);
        setBoardSize(boardSize);
    }

    // BUSINESS METHODS
    private void gameSetUp(){
        // Sets Up boards

        // build player board
        playerRadar.generateMap();

        // build enemy computer board
        enemyBoard.generateMap();
        enemyBoard.placeShipsOnBoard();

    }
    public void gameRunnerSinglePlayer(){
        // runs the game
        boolean gameNotOver = false;
        gameSetUp();
        while (!gameNotOver){
            int turns = getTurnCount();
            System.out.println(playerRadar.printMap());
            promptUser();

            turns = turns + 1;
            setTurnCount(turns);

            if(!enemyBoard.board.containsValue("$")){
                System.out.println("You WON!!!!");
                gameNotOver = true;
            }
        }
    }

    public void promptUser(){
        //prompts user for coordinate

        //set up regex
        String boardSizeString = String.valueOf(getBoardSize());
        int boardSizeInt = getBoardSize();
        String regex = "";
        if (enemyBoard.getBoardSize() < 10){
            regex = "[1-"+boardSizeString+"][a-"+playerRadar.column[(boardSizeInt -1)]+"]";
        }
        else if (boardSizeInt == 10){
            regex = "[1-9][a-j]|10[a-j]";
            System.out.println("Medium map");
        }
        else{
            //else its a 20x20 map
            regex = "[1-9][a-t]|1[0-9][a-t]|20[a-t]";
            System.out.println("Large map");
        }

        String coordinate = "";
        boolean validInput = false;
        while (!validInput) {
            System.out.println("enter valid coordinate");
            coordinate = userResponse.nextLine().toLowerCase();
            Console.clear();
            if (coordinate.matches(regex)){
                validInput = true;
                mark(coordinate);
            }
        }
    }

    public void mark(String coordinate){
        // Places hit Markers on boards and lets user know outcome
        if (enemyBoard.board.get(coordinate).equals("$")){
            String banner = null;
            try {
                banner = Files.readString(Path.of("resources/banner.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(banner);
            enemyBoard.board.put(coordinate, "X");
            playerRadar.board.put(coordinate, "X");
        }
        else if(enemyBoard.board.get(coordinate).equals("*")){
            System.out.println("miss");
            enemyBoard.board.put(coordinate, "M");
            playerRadar.board.put(coordinate, "M");
        }
        else{
            System.out.println("You already tried there try again");
        }
    }

    // ACCESSOR METHODS
    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public Integer getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(Integer turnCount) {
        this.turnCount = turnCount;
    }
    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(BoardSizes.BoardSizeSpec boardSize) {
        this.boardSize = boardSize.getMapSize();
    }
}