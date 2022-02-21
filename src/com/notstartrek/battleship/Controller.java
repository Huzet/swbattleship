package com.notstartrek.battleship;
/*
 * Controller plays the game.
 * Creates Board
 * Runs the game
 *
 * todo use player count to setup boards differently
 * todo get Boardsize Constructor to work
 *
 * Class done by Tomas
 */

import java.util.Scanner;

class Controller {

    // INSTANCE VARIABLES
    private final Scanner userResponse = new Scanner(System.in);
    private int playerCount;
    private int turnCount;
    private int boardSize;
    // I think this is the issue Jay please help
    private Board playerRadar;
    private Board enemyBoard;


    // CONSTRUCTOR
    Controller (int playerCount, int boardSize){
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
        gameSetUp();
        // runs the game
        boolean gameNotOver = false;
        while (!gameNotOver){
            int turns = getTurnCount();
            System.out.println(playerRadar.printMap());
            promptUser();

            turns = turns + 1;
            setTurnCount(turns);
//            System.out.print("\033[H\033[2J");
//            System.out.flush();

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
        else{
            regex = "[1-"+boardSizeString+"][a-"+playerRadar.column[(boardSizeInt -1)]+
                    "]||[1-9][0-"+boardSizeString+"][a-"+playerRadar.column[(boardSizeInt -1)]+"]";
        }

        String coordinate = "";
        boolean validInput = false;
        while (!validInput) {
            System.out.println("enter valid coordinate");
            coordinate = userResponse.nextLine().toLowerCase();
            // TODO adjust to use regex for any size board
            // matches 1-99
//            if (coordinate.matches("^\\d++[a-z]")){
            if (coordinate.matches(regex)){
                validInput = true;
                mark(coordinate);
//                System.out.println(coordinate);
            }
        }
    }

    public void mark(String coordinate){
        if (enemyBoard.board.get(coordinate).equals("$")){
            System.out.println("you got a hit!!!");
            enemyBoard.board.put(coordinate, "X");
            playerRadar.board.put(coordinate, "X");
//            bryan.ships.containsValue(coordinate);
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

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    // toString()
}