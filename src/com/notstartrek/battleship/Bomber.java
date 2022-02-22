package com.notstartrek.battleship;

class Bomber extends Ship {
    private int size=2;
    private ShipType shipType = ShipType.BOMBER;
    private boolean isSunk = false;
    private int healthRemaining = 1;


    public Bomber(){
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