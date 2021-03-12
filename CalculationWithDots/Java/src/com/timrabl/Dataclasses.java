package com.timrabl;

/* Point class */
class Point {
    /* Name of the point (max. 1 char) */
    private String name;
    /* X coordinate of the Point can't be infinite */
    private double x;
    /* Y coordinate of the Point can't be infinite */
    private double y;

    /* --- Constructor --- */

    Point() {}

    Point(String name, double x, double y) {
        try {
            this.setName(name);
        } catch (InvalidPointName ex) {
            ex.printStackTrace();
            System.exit(2);
        }

        try {
            this.setCoordinates(x, y);
        } catch (InfiniteCoordinate ex) {
            ex.printStackTrace();
            System.exit(2);
        }
    }

    /* --- Setter / Getter --- */

    /* Set the name of the point */
    void setName(String name) throws InvalidPointName {
        /* Validate point name */
        if (!validateName(name)) throw new InvalidPointName(name);

        /* Set this.name to the actual name */
        this.name = name;
    }

    /* Set both ( X and Y ) coordinate of the point */
     public void setCoordinates(double x, double y) throws InfiniteCoordinate {
        /* Validate the X coordinate */
        if (validateCoordinate(x)) throw new InfiniteCoordinate(x);

         /* Validate the Y coordinate */
        if (validateCoordinate(y)) throw new InfiniteCoordinate(y);

        /* Set X coordinate */
        this.setX(x);

        /* Set Y coordinate */
        this.setY(y);
    }

    /* Sets the X coordinate */
    public void setX(double x) {
        this.x = x;
    }

    /* Sets the Y coordinate */
    public void setY(double y) {
        this.y = y;
    }

    /* get the X coordinate */
    public double getX() {
        return x;
    }

    /* get the Y coordinate */
    public double getY() {
        return y;
    }

    /* get the name */
    public String getName() {
        return name;
    }

    /* --- Validator functions --- */

    /* Validates the point name */
    private boolean validateName(String name) {
        /* Validate length of the point name */
        if (!(name.length() > 1)) {
            return true;
        }

        /* Validate char of the point name */
        return name.matches("^[A-Za-z0-9]$");
    }

    /* Validate a single coordinate */
    private boolean validateCoordinate(double coordinate) {
        /* return the boolean value of Double.isInfinite() */
        return Double.isInfinite(coordinate);
    }

    /* --- Functions --- */

    /* Mirror on X axis */
    public void mirrorOnAxisX() {
        this.setY(-this.getY());
    }

    /* Mirror on Y axis */
    public void mirrorOnAxisY() {
        this.setX(-this.getY());
    }

    public void printToConsole() {
        System.out.println(this.name + "( " + this.x + " | " + this.y + ")");
    }
}

/* Distance class */
class Distance {
    /* primary Point() */
    private Point primary;

    /* secondary Point() */
    private Point secondary;

    /* distance value between these two points */
    private double distance;

    /* Initial constructor */
    Distance() {}

    /* Constructor overwrite */
    Distance(Point primary, Point secondary) {
        this.primary = primary;
        this.secondary = secondary;
    }

    /* --- Setter / Getter --- */

    /* Set the primary Point */
    public void setPrimary(Point primary) {
        this.primary = primary;
    }

    /* Set the secondary Point */
    public void setSecondary(Point secondary) {
        this.secondary = secondary;
    }

    /* Set (calc) the distance double */
    private void setDistance() {
        /* Math.hypot() method prevents intermediate overflow or underflow */
        double ac = Math.abs(this.secondary.getY() - this.primary.getY());
        double cb = Math.abs(this.secondary.getX() - this.primary.getX());

        this.distance =  Math.hypot(ac, cb);
    }

    /* Get the distance value */
    public double getDistance() {
        return this.distance;
    }

    /* Get the primary Point */
    public Point getPrimary() {
        return primary;
    }

    /* Get the secondary Point */
    public Point getSecondary() {
        return secondary;
    }

    /* --- Functions --- */

    /* Calculate the distance */
    public void calcDistance() {
        this.setDistance();
    }

    /* Print the distance value in a specific format */
    public void printToConsole() {
        System.out.println("Distance between: "
                + this.primary.getName() + " and " + this.secondary.getName() + " is: " + this.distance);
    }
}
