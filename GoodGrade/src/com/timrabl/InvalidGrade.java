package com.timrabl;

public class InvalidGrade extends Exception {
    public InvalidGrade(int grade) {
        super("Invalid grade: " + grade);
    }
}
