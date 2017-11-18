package com.samgauck;

import java.util.ArrayList;
import java.util.Arrays;

public class Economy {
    private Economy() {
        items.addAll(Arrays.asList("Food", "Wood", "Stone", "Iron", "Steel", "Oil", "Coal", "Uranium", "Water", "Carbon"));
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
    private ArrayList<String> items = new ArrayList<>();

    public ArrayList<String> getItems() {
        return items;
    }
}
