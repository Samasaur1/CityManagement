package com.samgauck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Utilities {
    private Utilities() {}
    public static String capitailze(String original) {
        return original.substring(0, 1).toUpperCase() + original.substring(1).toLowerCase();
    }
    public static double average(int[] values) {
        int total = 0;
        for (int i:values) {
            total += i;
        }
        return total/values.length;
    }
    public static Map<String, Integer> generateMap(ArrayList<String> keys, ArrayList<Integer> values) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        if (keys.size() == values.size()) {
            for (int i = 0; i<keys.size(); i++) {
                map.put(keys.get(i), values.get(i));
            }
        }
        return map;
    }
}
