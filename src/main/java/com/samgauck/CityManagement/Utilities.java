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
    public static <K, V> Map<K, V> generateMap(ArrayList<K> keys, ArrayList<V> values) {
        Map<K, V> map = new HashMap<>();
        if (keys.size() == values.size()) {
            for (int i = 0; i < keys.size(); i++) {
                map.put(keys.get(i), values.get(i));
            }
        }
        return map;
    }

    /**
     * List of prohibited profane words.
     */
    private static Set<String> profaneWords = new HashSet<>(Arrays.asList("fuck", "shit", "bitch", "ass"));

    /**
     * Removes profanity from a given string.
     * @param original The string to 'clean'.
     * @return The cleaned string.
     */
    public static String removeProfanity(String original) {
        for (String bad:profaneWords) {
            original = original.replaceAll(bad, clean(bad));
        }
        return original;
    }

    /**
     * Removes profanity from every string in a given ArrayList.
     * @param original The ArrayList to 'clean'.
     * @return The cleaned ArrayList.
     */
    public static ArrayList<String> removeProfanity(ArrayList<String> original) {
        original.forEach(Utilities::removeProfanity);
        return original;
    }

    /**
     * Takes a word and replaces it with a string of "*"s the same length as the given string.
     * @param dirty The string to replace.
     * @return A string of "*"s.
     */
    private static String clean(String dirty) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < dirty.length(); i++) {
            s.append("*");
        }
        return s.toString();
    }
}