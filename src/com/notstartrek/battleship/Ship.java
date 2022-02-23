package com.notstartrek.battleship;

/*
 * Used to make Models of ships
 */

public class Ship {
    private int size;
    private ShipType shipType;
    private boolean isSunk = false;
    private int healthRemaining;

    public Ship(int size, ShipType shipType) {
        this.size = size;
        this.shipType = shipType;
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