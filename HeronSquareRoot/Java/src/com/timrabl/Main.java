package com.timrabl;

public class Main {
    public static void main(String[] args) {
        double x = 131;

        try {
            System.out.println(
                    "The square root of " + x + " is " + Heron.sqrt(x) + "!"
            );
        }
        catch (InvalidRadiant ex) {
            ex.printStackTrace();
        }
    }
}