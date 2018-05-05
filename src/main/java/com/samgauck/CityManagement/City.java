package com.samgauck.CityManagement;

import java.util.ArrayList;

public class City {
    private String name; //name of the city
    private ArrayList<Person> citizens = new ArrayList<Person>(); //Holds all people in this city
    private NameList nameList = NameList.getInstance();
    public Resources resources = new Resources();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City(String name) { //creates a city named name
        Economy.getInstance().addCity(this); //Adds this to the economy list of cities
        this.name = name;
        newPerson(Sex.MALE);
        newPerson(Sex.FEMALE); //creates 2 new citizens
        citizens.forEach(person -> person.setAge(20)); //sets the citizens to a working age
    }

    /**
     * Names a citizen.
     *
     * @param index     The index of the citizens list where one finds the citizen to name.
     * @param firstName The new first name of the citizen.
     * @param lastName  The new last name of the citizen.
     */
    public void nameCitizen(int index, String firstName, String lastName) {
        citizens.get(index).setFirstName(firstName);
        citizens.get(index).setLastName(lastName);
    }

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

    public ArrayList<Person> getCitizens() {
        return citizens;
    }
}