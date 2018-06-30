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
        constructables.putAll(Utilities.generateMap(constructablesList, requirementsList));
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

    private Map<String, Resources> constructables = new HashMap<>();

    /**
     * The list of items.
     */
    private static ArrayList<String> itemsList = new ArrayList<>(Arrays.asList("food", "wood", "stone", "iron", "steel", "oil", "coal", "uranium", "water", "carbon"));

    private static ArrayList<String> constructablesList = new ArrayList<>(Arrays.asList("steel", "city")); //TODO: Fill (& requirementsList [64])
    /**
     * The list of prices.
     */
    private static ArrayList<Integer> pricesList = new ArrayList<>(Arrays.asList(5, 1, 2, 5, 10, 10, 10, 10, 5, 5));

    private static ArrayList<Resources> requirementsList = new ArrayList<>(Arrays.asList(
            new Resources(0,0,0,1,0,0,1,0,0,0),//Steel
            new Resources(0,0,0,0,0,0,0,0,0,0)//City
    ));

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
    }

    public Resources getRequirements(String constructable) {
        return constructables.get(constructable);
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

    private void setPrice(String item, int price) {
        items.put(item, price);
    }

    public void updatePrice(EconomicalActionType action, String item, int amount) { //TODO: Add more accurate economic impact
        if (!item.contains(item)) return;
        switch (action) {
            case BUYING:
                setPrice(item, getPrice(item) + amount);
                break;
            case SELLING:
                setPrice(item, getPrice(item) - amount);
                break;
            case CONSTRUCTING:
                setPrice(item, getPrice(item) - ((int) Math.floor(amount / 10)));
                break;
        }
    }

    public enum EconomicalActionType {
        BUYING, SELLING, CONSTRUCTING;
    }
}