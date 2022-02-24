package com.notstartrek.battleship.board;

/*
 * Creates, prints and populates Battleship Board with ships
 *  -   Creates Board
 *  -   Populates Board
 *  -   Prints pretty map for user
 *  -   Creates EnemyShips based off of BordSizes and Ships model
 */

import java.util.*;

public class Board {
    // INSTANCE VARIABLES
    public HashMap<String,String> board = new LinkedHashMap<>();
    private int boardSize; // = BoardSizes.BoardSizeSpec.SMALL.getMapSize();
    public String[] column = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l" , "m", "n", "o", "p", "q", "r", "s", "t"};
    private Random random = new Random();
    private BoardSizes boardSpecsEnemy;
    private List<Ship> enemyShips;


    // CONSTRUCTOR
    public Board(BoardSizes.BoardSizeSpec boardSize){
        setBoardSize(boardSize);
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

    public int shipCount() {
        int count = 0;
        for (String ship : board.values()) {
            if (ship.equals("$")) {
                count++;
            }
        }
        return count;
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

        // Run through list of ship objects and place each one on map
        for (int x = 0; x <= enemyShips.size() - 1; x++) {
            boolean roomForShip = true;
            int lengthOfShip = enemyShips.get(x).getSize();

            // Pick random location on map (starting point of ship)
            int shipXCoordinateInt = random.nextInt(boardSize);
            String shipXCoordinateString = column[shipXCoordinateInt];
            int shipYCoordinate = random.nextInt(boardSize) + 1;

            // Check if starting coordinate is eligible
            String possibleShipLocation = shipYCoordinate + String.valueOf(shipXCoordinateString);

            // check if starting point is empty (*) if not regenerate next point line 128
            if ((board.get(possibleShipLocation)).equals("*")) {
                // if ship is one block ship just place it
                if (enemyShips.get(x).getSize() == 1) {
                    System.out.println("(ONLY FOR DEMO) " + enemyShips.get(x).getShipType() + " " + possibleShipLocation);
                    board.put(possibleShipLocation, "$");
                }
                // ship has 1 or more block that it takes up
                else{
                    while (roomForShip) {
                        // Make sure ship will not go off of the Board starting point plus block size should be less than boardsize
                        if (shipXCoordinateInt + (enemyShips.get(x).getSize() + 1) <= boardSize) {
                            // for the length of ship check if spots next is taken aka another ship is there if so generate another ship position=
                            for (int possibleSpot = 1; possibleSpot <= enemyShips.get(x).getSize(); possibleSpot++) {
                                if ((board.get(shipYCoordinate + String.valueOf(column[shipXCoordinateInt + possibleSpot])).equals("$"))) {
                                    x = x - 1;
                                    roomForShip = false;
                                    break;
                                }
                                // Place the ship since spots are empty next to ship and ship will not go off of board
                                else{
                                    possibleSpot = enemyShips.get(x).getSize();
                                    for (int placeHere = 1; placeHere <= enemyShips.get(x).getSize(); placeHere++) {
                                        System.out.println("(ONLY FOR DEMO) " +enemyShips.get(x).getShipType() + " " + shipYCoordinate + String.valueOf(column[shipXCoordinateInt + (placeHere - 1)]));
                                        board.put(shipYCoordinate + String.valueOf(column[shipXCoordinateInt + (placeHere - 1)]), "$");
                                        roomForShip = false;
                                    }
                                }
                            }
                        }
                        else{
                            // Ship will go off of the board, Try to find new empty spot and then try to place ship again
                            roomForShip = false;
                            x = x-1;
                        }
                    }
                }
            }
            // Ship random starting spot is taken by another ship, Try to find new empty spot and then try to place ship again
            else {
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