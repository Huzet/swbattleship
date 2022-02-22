package com.notstartrek.battleship;

class StarDestroyer extends Ship {

    public StarDestroyer(int size, ShipType shipType, boolean isSunk, int healthRemaining) {
        super(size, shipType, isSunk, healthRemaining);
    }

    @Override
    public int getSize() {
        return 3;
    }

    @Override
    public ShipType getShipType() {
        return ShipType.STAR_DESTROYER;
    }
}