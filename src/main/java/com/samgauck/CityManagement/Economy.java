package com.samgauck.CityManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Economy {
    private Economy() {
        items.putAll(Utilities.generateMap(itemsList, pricesList));
    }
    private static Economy economy;
    public static Economy getInstance() {
        economy = economy == null ? new Economy() : economy;
        return economy;
    }
    private ArrayList<City> cities = new ArrayList<>();
    public void addCity(City c) {
        cities.add(c);
    }
    private Map<String, Integer> items = new HashMap<>();

    private static ArrayList<String> itemsList = new ArrayList<>(Arrays.asList("food", "wood", "stone", "iron", "steel", "oil", "coal", "uranium", "water", "carbon"));
    private static ArrayList<Integer> pricesList = new ArrayList<>(Arrays.asList(5,1,2,5,10,10,10,10,5,5));

    public ArrayList<String> getItems() {
        return itemsList;
    }
    public int getPrice(String item) {
        return items.get(item);
        //TODO: make supply and demand have an impact
    }
}