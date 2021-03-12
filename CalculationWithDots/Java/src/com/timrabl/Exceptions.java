package com.timrabl;

/* InvalidPointName exception class */
class InvalidPointName extends Exception {
    public InvalidPointName(String name) {
        super("Invalid point name was provided: " + name + " !");
    }
}

/* InfiniteCoordinate exception class */
class InfiniteCoordinate extends Exception {
    public InfiniteCoordinate (double coordinate) {
        super("Coordinate can not be infinite: " + coordinate + " !");
    }
}

