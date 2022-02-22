package com.notstartrek.battleship;

class XWing extends Ship {

    public XWing(int size, ShipType shipType, boolean isSunk, int healthRemaining) {
        super(size, shipType, isSunk, healthRemaining);
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public ShipType getShipType() {
        return ShipType.X_WING;
    }
}