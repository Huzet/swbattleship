package com.notstartrek.battleship;
/*
 * This is the player board. This is where the player plays the game
 *  •	String marker
    •	[X] Map
    •	[ ] Boolean yourTurn
    •	[x] Integer player1TurnCount
    -	[~] mark() <-- need to add validation for
    -	[X] generateMap()
    -	[X] printMap()
    -	[X] promptUser()
    -	[~] Game()
    -	[x] incrementTurnCount()
    -	[x] getTurnCount()
    *  TODO from user spec size map
    *  TODO move map stuff to PlayerBoard

 *
 */

import java.util.LinkedHashMap;
import java.util.Scanner;

class BattleshipPlayer {
    // INSTANCE VARIABLES
    int playerCount = 1;
    private final Scanner userResponse = new Scanner(System.in);
    // map stuff
    LinkedHashMap<String,String> board = new LinkedHashMap<>();
    int rows = 10;
    String[] column = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    int turnCount = 0;

    // CONSTRUCTOR
    BattleshipPlayer(int playerCount){
        setPlayerCount(playerCount);
    }

    // BUSINESS METHODS
    public void game(){
        boolean gameNotOver = false;
        generateMap();
        while (!gameNotOver){
            int turns = getTurnCount();
            System.out.println(printMap());
            promptUser();

            turns = turns + 1;
            setTurnCount(turns);

            if(turns >= 3){

                gameNotOver = true;
            }
        }
    }

    public void promptUser(){
        //prompts user for coordinate
        String coordinate = "";
        boolean validInput = false;
        while (!validInput) {
            System.out.println("enter valid coordinate");
            coordinate = userResponse.nextLine().toLowerCase();
            // TODO adjust to use regex for any size board
            // matches 1-99
            if (coordinate.matches("^\\d++[a-z]")){
                // TODO check if player already tried that spot
                validInput = true;
                mark(coordinate);
//                System.out.println(coordinate);
            }
        }
    }

    public LinkedHashMap<String,String> generateMap(){
        // Creates initial board Map
        for (int x = 1; x <= rows; x++){
            for (String y : column){
                board.put(String.valueOf(x) + y,"*");
            }
        }
        return board;
    }

    public String printMap(){
        // pretty prints map

        //variables
        StringBuilder currentRow = new StringBuilder();
        StringBuilder map;
        map = new StringBuilder();
        String topCoordinates = "   ";

        // for loop that constructs map for user
        for (int x = 1; x<=rows; x++){
            // if else used to keep spacing same between single digit and multi digit characters
            if (x < 10){
                currentRow.append(String.valueOf(" " + x + "  "));
            }
            else{
                currentRow.append(String.valueOf(x + "  "));
            }
            for (String y : column){
                //if first loop generate top coordinates for user
                if (x ==1){
                    topCoordinates = topCoordinates + "   " + y + " ";
                }
                currentRow.append("| ").append(board.get(String.valueOf(x) + y)).append(" |");
            }
            map.append("\n").append(currentRow);
            currentRow = new StringBuilder();
        }
        return topCoordinates + map + "\n" + "------------------------------------------------------";
    }
    // TODO once user prompt full incorporated use make private
    public void mark(String coordinate){
        // marks the board
        board.put(coordinate,"X");
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

    // toString()
}