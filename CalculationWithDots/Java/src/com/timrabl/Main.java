package com.timrabl;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Create a new Point() instance called p */
        Point p = new Point();

        /* Try to set the name of instance p to "P" */
        try {
            p.setName("P");
        } catch (InvalidPointName ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        /* Try to set the coordinates of instance p to "( -2 / 1 )" */
        try {
            p.setCoordinates(-2, 1);
        } catch (InfiniteCoordinate ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        /* Create a new Point() instance called q */
        Point q = new Point();

        /* Try to set the name of instance q to "Q" */
        try {
            q.setName("Q");
        } catch (InvalidPointName ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        /* Try to set the coordinates of instance q to "( 3 / 5 )" */
        try {
            q.setCoordinates(3, 5);
        } catch (InfiniteCoordinate ex) {
            ex.printStackTrace();
            System.exit(1);
        }


        /* Create a new distance instance */
        Distance distanceStatic = new Distance();

        /* Set the primary Point to p */
        distanceStatic.setPrimary(p);

        /* Set the secondary Point to q */
        distanceStatic.setSecondary(q);

        /* Calculate the distance between the above given Point objects */
        distanceStatic.calcDistance();

        /* Print the distance */
        distanceStatic.printToConsole();


        /* Create a new distance instance */
        Distance distanceDynamic = new Distance();

        /* Create a new Scanner instance */
        final Scanner sc = new Scanner(System.in);

        /* Create a new Point instance */
        Point userPointPrimary = new Point();

        /* Gather name from user */
        try {
            System.out.println("Enter a name for the first point:");
            userPointPrimary.setName(sc.next());
        } catch (InvalidPointName ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        /* Gather coordinates from user */
        try {
            System.out.println("Enter the X coordinate for point: " + p.getName());
            double xBuf = sc.nextDouble();
            System.out.println("Enter the Y coordinate for point: " + p.getName());
            double yBuf = sc.nextDouble();
            userPointPrimary.setCoordinates(xBuf, yBuf);
        } catch (InfiniteCoordinate ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        /* Set the primary Point for distance calculation */
        distanceDynamic.setPrimary(userPointPrimary);

        /* Create a new Point instance */
        Point userPointSecondary = new Point();

        /* Gather name from user */
        try {
            System.out.println("Enter a name for the first point:");
            userPointSecondary.setName(sc.next());
        } catch (InvalidPointName ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        /* Gather coordinates from user */
        try {
            System.out.println("Enter the X coordinate for point: " + p.getName());
            double xBuf = sc.nextDouble();
            System.out.println("Enter the Y coordinate for point: " + p.getName());
            double yBuf = sc.nextDouble();
            userPointSecondary.setCoordinates(xBuf, yBuf);
        } catch (InfiniteCoordinate ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        /* Set the primary Point for distance calculation */
        distanceDynamic.setSecondary(userPointSecondary);


        /* Calculate the distance between the above given Point objects */
        distanceDynamic.calcDistance();

        /* Print the distance */
        distanceDynamic.printToConsole();
    }
}