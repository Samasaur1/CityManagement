package com.samgauck.CityManagement;

import java.util.ArrayList;

/**
 * A class that represents things (items, people, etc.) that are in transport.
 *
 * @author Samasaur
 */
public class Transport {
    /**
     * The resources in transport.
     */
    private Resources resources;
    /**
     * The people in transport.
     */
    private ArrayList<Person> people;

    /**
     * Get a list of people being transported.
     * @return The list of people in transit.
     */
    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     * Get the resources being transported.
     * @return The resources in transit.
     */
    public Resources getResources() {
        return resources;
    }

    /**
     * Creates a new Transport with no resources or people.
     */
    public Transport() {
        resources = new Resources();
        people = new ArrayList<>();
    }

    /**
     * Add a person to the transport.
     * @param person The person to add.
     */
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