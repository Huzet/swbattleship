package com.notstartrek.battleship;

class XWing extends Ship {
    private int size=1;
    private ShipType shipType = ShipType.X_WING;
    private boolean isSunk = false;
    private int healthRemaining = 1;

    public XWing() {
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