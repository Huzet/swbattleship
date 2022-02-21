package com.notstartrek.battleship;
/*
 * This is used for populating and building maps from given size
 */

enum BoardSizes {
    // enum
    SMALL(5,5),
    MEDIUM(10,10),
    LARGE(20,20);


    // variables
    private int mapSize;
    private int shipByType;


    //Constructor
    BoardSizes(int mapSize, int shipByType){
        this.mapSize = mapSize;
        this.shipByType = shipByType;
    }


    // Getter
    public int getMapSize() {
        return mapSize;
    }
    public int getShipByType() {
        return shipByType;
    }
}