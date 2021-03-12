package com.timrabl;

public class DominoPiece {
    int upperNumber;
    int lowerNumber;

    DominoPiece(int upperNumber, int lowerNumber) {
        this.setUpperNumber(upperNumber);
        this.setLowerNumber(lowerNumber);
    }

    public int getLowerNumber() {
        return lowerNumber;
    }

    public int getUpperNumber() {
        return upperNumber;
    }

    public void setLowerNumber(int lowerNumber) {
        this.lowerNumber = lowerNumber;
    }

    public void setUpperNumber(int upperNumber) {
        this.upperNumber = upperNumber;
    }
}
