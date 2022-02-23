package com.notstartrek.battleship;
/*
 * This is used for populating and building maps from given size
 */

import java.util.ArrayList;

class BoardSizes {
    // Ship Models
    Ship xWing = new Ship(1, Ship.ShipType.X_WING);
    Ship bomber = new Ship(2, Ship.ShipType.BOMBER);
    Ship starDestroyer = new Ship(3, Ship.ShipType.STAR_DESTROYER);
    Ship MillenniumFalcon = new Ship(4, Ship.ShipType.MILLENNIUM_FALCON);

    public ArrayList<Ship> generateBoardShips() {
        // Creates List of Object Ships
        // Will have this take BoardSizeSpec for now default will be small
        BoardSizeSpec boardSet = BoardSizeSpec.SMALL;

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
                allShips.add(xWing);
            }
        }
        return allShips;
    }

    int generateBoardSize(BoardSizeSpec boardSizeSpec) {
        // Takes in mapSize return size of map
        return boardSizeSpec.getMapSize();
    }

    enum BoardSizeSpec {
        // Used to construct Board and populate ships
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