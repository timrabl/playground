package com.timrabl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number that should be split in primes:");
        int num = scanner.nextInt();

        PrimeFactorization pf = new PrimeFactorization(num);
        System.out.print("Prime factorization for number: " + pf.getN() + "\n>> ");
        for (Integer i : pf.getResult()) {
            System.out.print(i + " ");
        }
    }
}