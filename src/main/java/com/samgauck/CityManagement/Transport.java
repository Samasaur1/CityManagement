package com.samgauck.CityManagement;

import java.util.ArrayList;

/**
 * A class that represents things (items, people, etc.) that are in transport.
 *
 * @author Samasaur
 */
public class Transport {
    private Resources resources;
    private ArrayList<Person> people;

    public ArrayList<Person> getPeople() {
        return people;
    }

    public Resources getResources() {
        return resources;
    }

    public Transport() {
        resources = new Resources();
        people = new ArrayList<>();
    }
    public void addPerson(Person person) {
        people.add(person);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Transport other = (Transport) obj;
        if (!(this.getPeople().equals(other.getPeople()))) return false;
        return this.getResources().equals(other.getResources());
    }
}