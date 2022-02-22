package com.notstartrek.battleship;

class StarDestroyer extends Ship {
    private int size=4;
    private ShipType shipType = ShipType.STAR_DESTROYER;
    private boolean isSunk = false;
    private int healthRemaining = 1;

    public StarDestroyer() {
    }

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public ShipType getShipType() {
        return ShipType.STAR_DESTROYER;
    }
}