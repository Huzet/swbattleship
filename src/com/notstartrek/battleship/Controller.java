package com.notstartrek.battleship;

/*
 * Controller plays the game.
 *    -  Creates Board
 *    -  Registers hits
 *    -  Takes User input
 *    -  Runs the game with gameRunnerSinglePlayer()
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
    void gameRunnerSinglePlayer(){
        // runs the game
        boolean gameNotOver = false;
        gameSetUp();
        while (!gameNotOver){
            int turns = getTurnCount();
            System.out.println(playerRadar.printMap());
            promptUser();

            turns = turns + 1;
            setTurnCount(turns);

            // Game ends when there is no more ships
            if(!enemyBoard.board.containsValue("$")){
                System.out.println("You WON!!!!");
                gameNotOver = true;
            }
        }
    }

    private void promptUser(){
        //prompts user for coordinate

        //set up regex
        String boardSizeString = String.valueOf(getBoardSize());
        int boardSizeInt = getBoardSize();
        String regex = "";
        // small map 5x5
        if (enemyBoard.getBoardSize() < 10){
            regex = "[1-"+boardSizeString+"][a-"+playerRadar.column[(boardSizeInt -1)]+"]";
        }
        // medium map 10x10
        else if (boardSizeInt == 10){
            regex = "[1-9][a-j]|10[a-j]";
        }
        else{
            //else its a 20x20 map
            regex = "[1-9][a-t]|1[0-9][a-t]|20[a-t]";
        }

        String coordinate = "";
        boolean validInput = false;
        while (!validInput) {
            System.out.println("enter valid coordinate");
            coordinate = userResponse.nextLine().toLowerCase();
            Console.clear();
            if (!coordinate.matches(regex)){
                System.out.println(playerRadar.printMap());
            }
            if (coordinate.matches(regex)){
                validInput = true;
                mark(coordinate);
            }
        }
    }

    private void mark(String coordinate){
        // Places hit Markers on boards and lets user know outcome
        if (enemyBoard.board.get(coordinate).equals("$") && enemyBoard.shipCount() > 1){
            String hitBanner = null;
            try {
                hitBanner = Files.readString(Path.of("resources/hitBanner.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(hitBanner);
            enemyBoard.board.put(coordinate, "X");
            playerRadar.board.put(coordinate, "X");
        }
        else if (enemyBoard.board.get(coordinate).equals("$") && enemyBoard.shipCount() == 1){
            String winBanner = null;
            try {
                winBanner = Files.readString(Path.of("resources/winBanner.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(winBanner);
            enemyBoard.board.put(coordinate, "X");
            playerRadar.board.put(coordinate, "X");
        }
        else if(enemyBoard.board.get(coordinate).equals("*")){
            String missBanner = null;
            try {
                missBanner = Files.readString(Path.of("resources/missBanner.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(missBanner);
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