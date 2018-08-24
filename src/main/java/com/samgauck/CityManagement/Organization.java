package com.samgauck.CityManagement;

import com.gauck.sam.Utilities.Utilities;

import java.util.ArrayList;

/**
 * A class that represents an organization.
 *
 * @author Samasaur
 */
public class Organization {
    /**
     * An enum representing the type of an {@link Organization Organization}.
     */
    public enum Type {
        MILITARISTIC, POLITICAL, RELIGIOUS, SOCIAL;

        /**
         * Returns the organization type as a string, capitalized (e.g. Militaristic).
         *
         * @return A correctly capitalized string representation of a organization type.
         */
        @Override
        public String toString() {
            return Utilities.capitalize(super.toString());
        }
    }

    /**
     * Creates a new organization with the specified type.
     * @param type The type of the new organization.
     */
    public Organization(Organization.Type type) {
        this.type = type;
        this.people = new ArrayList<>();
        this.resources = new Resources();
    }

    /**
     * Get the type of the organization.
     * @return The type of the organization.
     */
    public Type getType() {
        return type;
    }

    /**
     * The type of the organization.
     */
    private Type type;

    /**
     * Get the people belonging to the organization.
     * @return The people who belong to the organization.
     */
    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     * Get the resources belonging to the organization.
     * @return The organization's resources.
     */
    public Resources getResources() {
        return resources;
    }

    /**
     * The people in the organization.
     */
    private ArrayList<Person> people;
    /**
     * The organization's resources.
     */
    private Resources resources;

    /**
     * Add a person to the organization.
     * @param person The person to add.
     */
    public void addPerson(Person person) {
        people.add(person);
    }
}
