package com.samgauck.CityManagement;

import com.samgauck.CityManagement.DateManagement.SimpleDate;

/**
 * Person represents a person with an age, name, job, and birthday.
 */
public class Person {

    public int getAge() {
        return age;
    }

    public static int getWorkingAge() {
        return workingAge;
    }

    public static int getMatingAge() {
        return matingAge;
    }

    public Profession getJob() {
        return job;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public String getName() {
        if ((this.getFirstName().equals("Adam") || this.getFirstName().equals("Eve")) && this.getLastName().isEmpty()) {
            return this.getFirstName();
        } else {
            return this.getFirstName() + " " + this.getLastName(); //combines firstName and lastName
        }
    }

    public void setAge(int age) {
        this.age = age;
        if (getAge() > getMatingAge()) {
            this.canMate = true;
        }
        if (getAge() > getWorkingAge()) {
            this.canWork = true;
        }
    }

    private void incrementAge() {
        setAge(getAge() + 1);
    }

    public static void setWorkingAge(int newAge) {
        workingAge = newAge;
    }

    public static void setMatingAge(int newAge) {
        matingAge = newAge;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setJob(Profession job) {
        this.job = job;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    private String firstName;
    private String lastName;
    private int age;
    private static int workingAge;
    private static int matingAge;
    private Profession job;
    private Boolean canWork;
    private Boolean canMate;
    private SimpleDate birthday;

    public SimpleDate getBirthday() {
        return birthday;
    }

    public Boolean isBirthday() {
        return ((getBirthday().getMonth() == Main.getDate().getMonth()) && getBirthday().getDayOfMonth() == Main.getDate().getDayOfMonth());
    }

    public void handleBirthday() {
        System.out.println("It's " + getName() + "'s birthday!");
        incrementAge();
        System.out.println("They are now " + getAge() + " years old");
    }

    private Sex sex;

    public Person() { //when born, sets age to 0 and birthday to the current date and sex to either male or female
        this(Math.random() * 2 > 1 ? Sex.MALE : Sex.FEMALE);
    }

    public Person(Sex sex) {
        this.setAge(0);
        this.birthday = new SimpleDate(Main.getDate());
        this.setJob(Profession.JOBLESS);
        this.sex = sex;
        this.canWork = false;
        this.canMate = false;
    }

    /**
     * Returns a string representation of a person, format "A person named Sam, age 14, Jobless".
     *
     * @return A string representation of the person.
     */
    @Override
    public String toString() {
        return "A person named " + this.getName() + ", age " + this.getAge() + ", " + this.job;
    }
    //TODO: add code for getting older every birthday (or maybe in Main?)
}