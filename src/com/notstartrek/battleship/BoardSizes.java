package com.notstartrek.battleship;
/*
 * This is used for populating and building maps from given size
 */

import java.util.ArrayList;

class BoardSizes {

    public ArrayList<Ship> generateBoardShips() {
        // Will have this class take BoardSizeSpec for now default will be small
        BoardSizeSpec boardSet = BoardSizeSpec.SMALL;

        ArrayList<Ship> allShips = new ArrayList<>();
//        allShips.add(new XWing(1, Ship.ShipType.X_WING,false,1));

        if (boardSet.getXwingCount() >= 1) {
            for (int x = 1; x <= boardSet.getXwingCount(); x++) {
                allShips.add(new XWing());
            }
        }
        if (boardSet.getBomberCount() >= 1) {
            for (int x = 1; x <= boardSet.getBomberCount(); x++) {
                allShips.add(new Bomber());
            }
        }
        if (boardSet.getMillStarCount() >= 1) {
            for (int x = 1; x <= boardSet.getMillStarCount(); x++) {
                allShips.add(new XWing());
            }
        }
//        allShips.add(new XWing());
//        System.out.println(allShips);
        return allShips;
    }

    int generateBoardSize(BoardSizeSpec boardSizeSpec) {
        int mapSize = boardSizeSpec.getMapSize();
        return mapSize;
    }

    enum BoardSizeSpec {
        // MapSize, XWing, Bomber, MilleniumFalcon/Star Destroyer
        SMALL(5, 2, 1, 0),
        MEDIUM(5, 1, 1, 0),
        LARGE(5, 1, 1, 0);


        // variables
        private int mapSize;
        private int xwingCount;
        private int bomberCount;
        private int millStarCount;


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