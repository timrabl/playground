package com.timrabl;

import java.util.ArrayList;

public class Domino {
    ArrayList<DominoPiece> GamePieces = new ArrayList<DominoPiece>();

    Domino() {
        int minNumber = 0;
        int maxNumber = 6;

        for (int upperNumber = minNumber; upperNumber <= maxNumber; upperNumber ++) {
            for (int lowerNumber = upperNumber; lowerNumber <= maxNumber; lowerNumber ++) {
                GamePieces.add(new DominoPiece(upperNumber, lowerNumber));
            };
        };
    };

    public void PrintGamePiecesToConsole() {
        for (DominoPiece piece : this.getGamePieces()) {
            System.out.print(piece.getLowerNumber() + " - " + piece.getUpperNumber());
        }
    }

    public ArrayList<DominoPiece> getGamePieces() {
        return GamePieces;
    }
}
