package com.timrabl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class NumFromString {
    public static List<Float> numFromString(String string) {
        Pattern rgp = Pattern.compile("[+-]?([0-9]*[.,])?[0-9]+");
        Matcher rgm = rgp.matcher(string);
        List<Float> res = new ArrayList<>();

        while (rgm.find()) {
            res.add(Float.parseFloat(rgm.group().replaceAll(",",".")));
        }

        return res;
    }
}
