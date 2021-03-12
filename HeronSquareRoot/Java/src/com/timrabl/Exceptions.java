package com.timrabl;

class InvalidRadiant extends Exception {
    public InvalidRadiant(double radiant) {
        super("Invalid radiant: " + radiant + " passed !");
    }
}