package com.samgauck.CityManagement;

import java.util.*;

/**
 * A singleton class that represents the global economy in the game.
 */
public class Economy {
    /**
     * Creates the Economy singleton.
     */
    private Economy() {
        items.putAll(Utilities.generateMap(itemsList, pricesList));
    }

    /**
     * The economy instance.
     */
    private static Economy economy;

    /**
     * Gets the economy instance and creates it if it doesn't exist.
     *
     * @return The one and only economy instance.
     */
    public static Economy getInstance() {
        economy = economy == null ? new Economy() : economy;
        return economy;
    }

    /**
     * The list of all cities.
     */
    private ArrayList<City> cities = new ArrayList<>();

    /**
     * Adds a city to the list of cities.
     *
     * @param c The city to add.
     */
    public void addCity(City c) {
        cities.add(c);
    }

    /**
     * The list of items mapped to their prices.
     */
    private Map<String, Integer> items = new HashMap<>();

    /**
     * The list of items.
     */
    private static ArrayList<String> itemsList = new ArrayList<>(Arrays.asList("food", "wood", "stone", "iron", "steel", "oil", "coal", "uranium", "water", "carbon"));

    private static ArrayList<String> constructablesList = new ArrayList<>(); //TODO: Fill
    /**
     * The list of prices.
     */
    private static ArrayList<Integer> pricesList = new ArrayList<>(Arrays.asList(5, 1, 2, 5, 10, 10, 10, 10, 5, 5));

    /**
     * Get the list of items.
     *
     * @return The list of items.
     */
    public static ArrayList<String> getItems() {
        return itemsList;
    }

    public static ArrayList<String> getConstructables() {
        return constructablesList;
    }

    /**
     * Gets the price of a specific item.
     *
     * @param item The item which price you want.
     * @return The price of the given item.
     */
    public int getPrice(String item) {
        return items.get(item);
        //TODO: make supply and demand have an impact
    }

    /**
     * Sets all prices. Should only be used for loading saves.
     *
     * @param prices The list of prices, in order.
     */
    public void setPrices(ArrayList<Integer> prices) {
        if (prices.size() != pricesList.size()) return;
        items.clear();
        items.putAll(Utilities.generateMap(itemsList, prices));
    }
}