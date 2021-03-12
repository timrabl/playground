package com.timrabl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> values = Arrays.asList(
                "x5y", "x5,y",
                "x5,01y", "x,53y",
                "x050y", "x00,03y",
                "x5,0y"
        );

        for (String value : values) {
            System.out.println(NumFromString.numFromString(value));
        }
    }
}
