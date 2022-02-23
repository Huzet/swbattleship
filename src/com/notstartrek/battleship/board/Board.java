package com.notstartrek.battleship.board;
/*
 * Creates, prints and populates Battleship Board with ships
 */

import java.util.*;

public class Board {
    // INSTANCE VARIABLES
    public HashMap<String,String> board = new LinkedHashMap<>();
    int boardSize; // = BoardSizes.BoardSizeSpec.SMALL.getMapSize();
    public String[] column = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l" , "m", "n", "o", "p", "q", "r", "s", "t"};
    Random random = new Random();
    BoardSizes boardSpecsEnemy;
    List<Ship> enemyShips;


    // CONSTRUCTOR
    public Board(BoardSizes.BoardSizeSpec boardSize){
        setBoardSize(boardSize);

        System.out.println("Creating Board with " + getBoardSize());
        System.out.println("Board " + boardSize);
        // TODO figure out where to put boardSpecsEnemy
        boardSpecsEnemy = new BoardSizes();
        enemyShips = boardSpecsEnemy.generateBoardShips(boardSize);
    }

    // BUSINESS METHODS
    public HashMap<String,String> generateMap(){
        // Creates initial board Map
        for (int x = 1; x <= boardSize; x++){
            for (int y = 0; y <= (boardSize - 1); y++)
                board.put(x + column[y],"*");
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

    public void placeShipsOnBoard() {
        // Place ships on board randomly
        // TODO place ships based off of map size each map will have a given number of ships it can take
        // TODO place ships based off of ship size
        // TODO reverse order of ships being placed
        for (int x = 0; x <= enemyShips.size() - 1; x++) {
            boolean roomForShip = true;
            int lengthOfShip = enemyShips.get(x).getSize();

            // Pick random location on map
            int shipXCoordinateInt = random.nextInt(boardSize);
            String shipXCoordinateString = column[shipXCoordinateInt];
            int shipYCoordinate = random.nextInt(boardSize) + 1;

            // Check if starting coordinate is eligible
            String possibleShipLocation = shipYCoordinate + String.valueOf(shipXCoordinateString);
            System.out.println("Map gird starting point " + possibleShipLocation);

            if ((board.get(possibleShipLocation)).equals("*")) {
                if (enemyShips.get(x).getSize() == 1) {
                    System.out.println("placing Tie Fighter");
                    System.out.println(possibleShipLocation);
                    board.put(possibleShipLocation, "$");

                }
                else{
                    while (roomForShip) {
                        System.out.println("trying to place bomber");
                        if (shipXCoordinateInt + (enemyShips.get(x).getSize() + 1) <= boardSize) {
                            System.out.println("Ship will not go off of board");
                            for (int possibleSpot = 1; possibleSpot <= enemyShips.get(x).getSize(); possibleSpot++) {
                                if ((board.get(shipYCoordinate + String.valueOf(column[shipXCoordinateInt + possibleSpot])).equals("$"))) {
                                    x = x - 1;
                                    roomForShip = false;
                                    break;
                                }
                                else{
                                    possibleSpot = enemyShips.get(x).getSize();
                                    for (int placeHere = 1; placeHere <= enemyShips.get(x).getSize(); placeHere++) {
                                        System.out.println(shipYCoordinate + String.valueOf(column[shipXCoordinateInt + (placeHere - 1)]));
                                        board.put(shipYCoordinate + String.valueOf(column[shipXCoordinateInt + (placeHere - 1)]), "$");
                                        roomForShip = false;
                                    }
                                }
                            }
                        }
                        else{
                            roomForShip = false;
                            x = x-1;
                            System.out.println("should see new bomber");
                        }
                    }
                }
            }
            else {
                System.out.println("making new ship");
                x = x - 1;
            }
        }
    }

    // ACCESSOR METHODS
    public int getBoardSize() {
        return boardSize;
    }
    public void setBoardSize(BoardSizes.BoardSizeSpec boardSize) {
        this.boardSize = boardSize.getMapSize();
    }
}