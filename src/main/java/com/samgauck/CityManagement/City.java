package com.samgauck.CityManagement;

import java.util.ArrayList;

/**
 * A class that represents a city.
 */
public class City {
    /**
     * The resources in the city.
     */
    public Resources resources = new Resources();
    /**
     * The name of the city.
     */
    private String name;
    /**
     * A list of all the citizens in the city.
     */
    private ArrayList<Person> citizens = new ArrayList<>();
    /**
     * A local reference to the list of names.
     */
    private NameList nameList = NameList.getInstance();

    /**
     * Creates a city with the given name.
     *
     * @param name The name of the new city.
     */
    public City(String name) {
        Economy.getInstance().addCity(this); //Adds this to the economy list of cities
        this.name = Utilities.removeProfanity(name);
        newPerson(Sex.MALE);
        newPerson(Sex.FEMALE); //creates 2 new citizens
        citizens.forEach(person -> person.setAge(20)); //sets the citizens to a working age
    }

    /**
     * Creates a new person and adds them to the citizens list.
     */
    public void newPerson() {
        Person p = new Person();
        citizens.add(p);
    }

    /**
     * Creates a new person and adds them to the citizens list.
     *
     * @param sex The sex of the person.
     */
    public void newPerson(Sex sex) {
        Person p = new Person(sex);
        citizens.add(p);
    }

    /**
     * Removes the given person from the list of citizens if they exist.
     *
     * @param person The person to remove.
     * @return Whether or not the person was in the list, and therefore removed.
     */
    public Boolean removePerson(Person person) {
        return citizens.remove(person);
    }

    /**
     * Gets the name of the city.
     *
     * @return The name of the city.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the city.
     *
     * @param name The new name of the city.
     */
    public void setName(String name) {
        this.name = Utilities.removeProfanity(name);
    }

    /**
     * Names a citizen.
     *
     * @param index     The index of the citizens list where one finds the citizen to name.
     * @param firstName The new first name of the citizen.
     * @param lastName  The new last name of the citizen.
     */
    public void nameCitizen(int index, String firstName, String lastName) {
        citizens.get(index).setFirstName(Utilities.removeProfanity(firstName));
        citizens.get(index).setLastName(Utilities.removeProfanity(lastName));
    }

    /**
     * Gives the citizen at the given index a random name.
     *
     * @param index The index of the citizen in the list to name.
     */
    public void nameCitizen(int index) {
        nameCitizen(index, nameList.getFirstName(), nameList.getLastName());
    }

    @Override
    public String toString() {
        return "A city named " + this.name;
    }

    /**
     * Builds a string that is a multiple line list of citizens.
     *
     * @return A string list of all citizens.
     */
    public String listCitizens() {
        StringBuilder output = new StringBuilder();
        for (Person citizen : citizens) {
            output.append(citizen).append("\n");
        }
        return output.toString();
    }

    /**
     * Get the list of citizens.
     *
     * @return The list fo citizens.
     */
    public ArrayList<Person> getCitizens() {
        return citizens;
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
        City other = (City) obj;
        if (!(this.getCitizens().equals(other.getCitizens()))) return false;
        if (!(this.resources.equals(other.resources))) return false;
        return this.getName().equals(other.getName());
    }
}