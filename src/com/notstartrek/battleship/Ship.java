package com.notstartrek.battleship;

public enum Ship {
    X_WING("X Wing", 2, false),
    BOMBER("Bomber",3, false),
    STAR_DESTROYER("Star Destroyer",4, false),
    MILLENNIUM_FALCON("Millennium Falcon",5, false);
    private final int size;
    private boolean isSunk;
    private int healthRemaining;


    Ship(String type, int size, boolean isSunk) {
        this.isSunk = isSunk;
        this.healthRemaining = healthRemaining;
        this.size = size;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void setSunk(boolean sunk) {
        isSunk = sunk;
    }

    public int getHealthRemaining() {
        return healthRemaining;
    }

    public int getSize() {
        return size;
    }

    public void shipSunk() {
        if (healthRemaining == 0) {
            isSunk = true;
            return;
        } else {
            healthRemaining--;
        }
    }

}