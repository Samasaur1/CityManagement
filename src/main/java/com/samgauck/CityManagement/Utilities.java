package com.samgauck.CityManagement;

import java.util.*;

/**
 * A utility class to help do things.
 */
public class Utilities {
    /**
     * A private constructor so that this class cannot be instantiated.
     */
    private Utilities() {
    }

    /**
     * A method that takes a string and capitalizes it correctly (e.g. eXamPLe → Example).
     *
     * @param original The string to be capitalized.
     * @return A capitalized version of the parameter.
     */
    public static String capitailze(String original) {
        return original.substring(0, 1).toUpperCase() + original.substring(1).toLowerCase();
    }

    /**
     * A method that takes some number of integers and returns the average of them
     *
     * @param values The ints to take the average of.
     * @return The average of the parameters.
     */
    public static double average(int[] values) {
        int total = 0;
        for (int i : values) {
            total += i;
        }
        return total / values.length;
    }

    /**
     * Returns a map (dictionary in other languages) from an ArrayList of keys and one of values.
     *
     * @param keys   An ArrayList of the keys for the Map.
     * @param values An ArrayList of the values for the Map.
     * @return A Map consisting of the keys paired to the values.
     */
    public static Map<String, Integer> generateMap(ArrayList<String> keys, ArrayList<Integer> values) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        if (keys.size() == values.size()) {
            for (int i = 0; i < keys.size(); i++) {
                map.put(keys.get(i), values.get(i));
            }
        }
        return map;
    }

    public static String removeProfanity(String original) {
        return original;
    }
    //TODO: Implement removeProfanity methods.
    public static ArrayList<String> removeProfanity(ArrayList<String> original) {
        return original;
    }
}