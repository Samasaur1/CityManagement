package com.samgauck.CityManagement;

import java.util.ArrayList;

/**
 * A class that represents things (items, people, etc.) that are in transport.
 *
 * @author Samasaur
 */
public class Transport {
    public Resources resources;
    public ArrayList<Person> people;
    public Transport() {
        resources = new Resources();
        people = new ArrayList<>();
    }
    public void addPerson(Person person) {
        people.add(person);
    }
}