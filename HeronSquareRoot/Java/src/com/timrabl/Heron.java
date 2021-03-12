package com.timrabl;

import java.text.DecimalFormat;

public class Heron {
    public static double sqrt(double radiant) throws InvalidRadiant {
        if (radiant < 0) {
            throw new InvalidRadiant(radiant);
        }

        double hlp = radiant;
        double e = 0.000001;

        while ( Math.abs(hlp-(radiant/hlp))/hlp > e ) {
            hlp = (radiant / hlp + hlp ) / 2;
        }

        DecimalFormat df = new DecimalFormat("#.###");
        return Double.parseDouble(df.format(hlp));
    }
}