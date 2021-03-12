package com.timrabl;

public class Sort {

    public static void sort(int[] list, int start, int end) {
        if ( start < end ) {
            sort(list, start + 1, end);

            if ( list[start] <= list[end] ) {
                sort(list, start, end - 1);
            } else if ( list[start] > list[end]) {
                int hlp = list[start];
                list[start] = list[end];
                list[end] = hlp;
                sort(list, start, end - 1);
            }
        } else if (start == end) {
            return;
        }
    }
}
