package com.samgauck;

import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<Person> citizens = new ArrayList<Person>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City(String name) {
        this.name = name;
    }
}
