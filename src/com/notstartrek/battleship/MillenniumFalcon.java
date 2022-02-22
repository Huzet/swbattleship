package com.notstartrek.battleship;

class MillenniumFalcon extends Ship {

    public MillenniumFalcon(int size, ShipType shipType, boolean isSunk, int healthRemaining) {
        super(size, shipType, isSunk, healthRemaining);
    }

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public ShipType getShipType() {
        return ShipType.MILLENNIUM_FALCON;
    }
}