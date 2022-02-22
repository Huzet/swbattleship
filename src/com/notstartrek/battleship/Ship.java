package com.notstartrek.battleship;

public abstract class Ship {
    private final int size;
    private final ShipType shipType;
    private boolean isSunk;
    private int healthRemaining;

    public Ship(int size, ShipType shipType, boolean isSunk, int healthRemaining) {
        this.size = size;
        this.shipType = shipType;
        this.isSunk = false;
        this.healthRemaining = healthRemaining;
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

    public ShipType getShipType() {
        return shipType;
    }

    public void shipSunk() {
        if (healthRemaining == 0) {
            isSunk = true;
            return;
        } else {
            healthRemaining--;
        }
    }

    public enum ShipType{
    X_WING("X Wing"),
    BOMBER("Bomber"),
    STAR_DESTROYER("Star Destroyer"),
    MILLENNIUM_FALCON("Millennium Falcon");
    private String type;

        ShipType(String type) {
            this.type = type;
        }
        public String toString() {
            return type;
        }
    }
}