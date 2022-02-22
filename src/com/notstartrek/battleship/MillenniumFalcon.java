package com.notstartrek.battleship;

class MillenniumFalcon extends Ship {
    private int size=3;
    private ShipType shipType = ShipType.MILLENNIUM_FALCON;
    private boolean isSunk = false;
    private int healthRemaining = 1;

    public MillenniumFalcon() {
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