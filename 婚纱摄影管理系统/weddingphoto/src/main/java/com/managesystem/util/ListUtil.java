package com.managesystem.util;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public class ListUtil {
    public static boolean CompareListSize(List a, List b) {
        int aSize = a.size();
        int bSize = b.size();
        if (aSize > bSize) {
            return true;
        } else {
            return false;
        }
    }
}
