package com.timrabl;

import java.util.ArrayList;
import java.util.List;

// PrimeFactorization class
public class PrimeFactorization {

    // --- Initialize --- //

    // Initialize n //
    private int n;

    // Initialize result list //
    private List<Integer> result;

    // --- Constructor functions --- //

    // Empty constructor function //
    PrimeFactorization() {}

    // Constructor function with arguments //
    public PrimeFactorization(int n) {
        this.n = n;
    }

    // --- Getter / Setter functions --- //

    // n setter functions //
    public void setN(int n) {
        this.n = n;
    }

    // n getter function //
    public int getN() {
        return this.n;
    }

    // result getter function //
    public List<Integer> getResult() {
        this.calculate();
        return this.result;
    }

    // --- Fucntions --- //

    // calculate function //
    private void calculate() {
        int num = this.n;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }
        this.result = factors;
    }
}
