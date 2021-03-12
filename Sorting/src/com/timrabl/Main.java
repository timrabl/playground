package com.timrabl;

public class Main {

    public static void main(String[] args) {
        int[] list = { 3, 6, 1, 2, 3, 2 };
        int len = list.length - 1;

        Sort.sort(list, 0, len);
        for ( int i = 0; i <= len; i++) {
            System.out.println(list[i]);
        }
    }
}
