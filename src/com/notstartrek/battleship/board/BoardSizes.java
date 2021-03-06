package com.notstartrek.battleship.board;
/*
 * This is used for populating and building maps from given size
 *  -   Builds ships objects from ship class and places them in Array so we can access them
 *  -   BoardSizeSpec Enum holds configuration for what map sizes are and how many different fighters go into each map
 */

import com.notstartrek.battleship.board.Ship;

import java.util.ArrayList;

public class BoardSizes {
    // Ship Models
    private Ship xWing = new Ship(1, Ship.ShipType.X_WING);
    private Ship bomber = new Ship(2, Ship.ShipType.BOMBER);
    private Ship starDestroyer = new Ship(3, Ship.ShipType.STAR_DESTROYER);
    private Ship MillenniumFalcon = new Ship(4, Ship.ShipType.MILLENNIUM_FALCON);

    ArrayList<Ship> generateBoardShips(BoardSizes.BoardSizeSpec boardSet) {
        // Creates List of Object Ships

        ArrayList<Ship> allShips = new ArrayList<>();

        if (boardSet.getXwingCount() >= 1) {
            for (int x = 1; x <= boardSet.getXwingCount(); x++) {
                allShips.add(xWing);
            }
        }
        if (boardSet.getBomberCount() >= 1) {
            for (int x = 1; x <= boardSet.getBomberCount(); x++) {
                allShips.add(bomber);
            }
        }
        if (boardSet.getMillStarCount() >= 1) {
            for (int x = 1; x <= boardSet.getMillStarCount(); x++) {
                allShips.add(starDestroyer);
            }
        }
        return allShips;
    }

    int generateBoardSize(BoardSizeSpec boardSizeSpec) {
        // Takes in mapSize return size of map
        return boardSizeSpec.getMapSize();
    }

    public enum BoardSizeSpec {
        // Used to model Board and populate ships
        // MapSize, XWing, Bomber, MilleniumFalcon/Star Destroyer
        SMALL(5, 2, 1, 0),
        MEDIUM(10, 5, 2, 1),
        LARGE(20, 10, 4, 2);


        // variables
        private final int mapSize;
        private final int xwingCount;
        private final int bomberCount;
        private final int millStarCount;


        //Constructor
        BoardSizeSpec(int mapSize, int xwingCount, int bomberCount, int millStarCount) {
            this.mapSize = mapSize;
            this.xwingCount = xwingCount;
            this.bomberCount = bomberCount;
            this.millStarCount = millStarCount;

        }

        // Getter
        public int getMapSize() {
            return mapSize;
        }

        public int getXwingCount() {
            return xwingCount;
        }

        public int getBomberCount() {
            return bomberCount;
        }

        public int getMillStarCount() {
            return millStarCount;
        }
    }
}