package com.notstartrek.battleship;
/*
 *
 */

import java.util.LinkedHashMap;
import java.util.Random;

class Board {
    // INSTANCE VARIABLES
    LinkedHashMap<String,String> board = new LinkedHashMap<>();
    int boardSize = 5;
    String[] column = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l" , "m", "n", "o", "p", "q", "r", "s", "t"};
    Random random = new Random();

    // CONSTRUCTOR
    Board(int boardSize){
//        setBoardSize(boardSize);
        this.boardSize = boardSize;
    }

    // BUSINESS METHODS
    public LinkedHashMap<String,String> generateMap(){
        // Creates initial board Map
        for (int x = 1; x <= boardSize; x++){
            for (int y = 0; y <= (boardSize - 1); y++)
                board.put(String.valueOf(x) + column[y],"*");
        }
        return board;
    }

    public String printMap(){
        // pretty prints map for user

        //variables
        StringBuilder currentRow = new StringBuilder();
        StringBuilder map;
        map = new StringBuilder();
        String topCoordinates = "   ";

        // for loop that constructs map for user
        for (int x = 1; x<=boardSize; x++){
            // if else used to keep spacing same between single digit and multi digit characters
            if (x < 10){
                currentRow.append(String.valueOf(" " + x + "  "));
            }
            else{
                currentRow.append(String.valueOf(x + "  "));
            }
            for (int y = 0; y <= (boardSize - 1); y++){
                //if first loop generate top coordinates for user
                if (x ==1){
                    topCoordinates = topCoordinates + "   " + column[y] + " ";
                }
                currentRow.append("| ").append(board.get(String.valueOf(x) + column[y])).append(" |");
            }
            map.append("\n").append(currentRow);
            currentRow = new StringBuilder();
        }
        return topCoordinates + map + "\n" + "------------------------------------------------------";
    }

    public void placeShipsOnBoard(){
        // Place ships on board randomly
        // TODO place ships based off of map size each map will have a given number of ships it can take
        // TODO place ships based off of ship size
        // Maybe do a do-while loop???
        for (int x = 1; x<=4 ; x++){
            // Pick random location on map
            String shipXCoordinate = column[random.nextInt(boardSize)];
            int shipYCoordinate = random.nextInt(boardSize) + 1;

            // Check if that coordinate is eligible
            String possibleShipLocation = shipYCoordinate + String.valueOf(shipXCoordinate);
            if ((board.get(possibleShipLocation)).equals("*")){
                board.put(possibleShipLocation, "$");
//                System.out.println(shipYCoordinate + String.valueOf(shipXCoordinate));
            }
            // If coordinate is not eligible try again
            else {
                x = x - 1;
            }
        }
    }
    // TODO once user prompt full incorporated use make private
    public void mark(String coordinate){
        // marks the board
        board.put(coordinate,"X");
    }

    // ACCESSOR METHODS
    public int getBoardSize() {
        return boardSize;
    }
    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    // toString()
}