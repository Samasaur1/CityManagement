package com.samgauck;

import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<Person> citizens = new ArrayList<Person>();
    public void newPerson() {
        Person p = new Person();
        citizens.add(p);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City(String name) {
        this.name = name;
        newPerson();
        newPerson();
        citizens.forEach(person -> person.setAge(20));
    }

    @Override
    public String toString() {
        return "A city named " + this.name;
    }
    public String listCitizens() {
        StringBuilder output = new StringBuilder();
        for (Person citizen : citizens) {
            output.append(citizen).append("\n");
        }
        return output.toString();
    }
}
