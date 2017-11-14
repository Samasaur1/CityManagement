package com.samgauck;

import com.samgauck.DateManagement.SimpleDate;

/**
 * Person represents a person with an age, name, job, and birthday.
 */
public class Person {

    public int getAge() {
        return age;
    }
    public Profession getJob() {
        return job;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastname() {
        return lastname;
    }
    public String getName() {
        this.updateName();
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setJob(Profession job) {
        this.job = job;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    private void updateName() {
        this.name = this.getFirstName() + " " + this.getLastname(); //combines firstName and lastName
    }

    private String firstName;
    private String lastname;
    private String name;
    private int age;
    private Profession job;
    private SimpleDate birthday;
    public Person() { //when born, sets age to 0 and birthday to the current date
        this.setAge(0);
        this.birthday = Main.getDate();
    }

    @Override
    public String toString() {
        return "A person named " + this.getName() + ", age " + this.getAge() + ", " + this.job;
    }
    //TODO: add code for getting older every birthday (or maybe in Main?)
}
