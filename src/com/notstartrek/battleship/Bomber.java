package com.notstartrek.battleship;

class Bomber extends Ship {

    public Bomber(int size, ShipType shipType, boolean isSunk, int healthRemaining) {
        super(size, shipType, isSunk, healthRemaining);
    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public ShipType getShipType() {
        return ShipType.BOMBER;
    }
}