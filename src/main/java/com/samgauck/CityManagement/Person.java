package com.samgauck.CityManagement;

import com.samgauck.CityManagement.DateManagement.SimpleDate;

/**
 * Person represents a person with an age, name, job, and birthday.
 */
public class Person {

    /**
     * Gets the age of the person.
     *
     * @return The age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the working age for a person.
     *
     * @return The standard working age.
     */
    public static int getWorkingAge() {
        return workingAge;
    }

    /**
     * Gets the mating age for a person.
     *
     * @return The standard mating age.
     */
    public static int getMatingAge() {
        return matingAge;
    }

    /**
     * Gets the person's job.
     *
     * @return The person's job.
     */
    public Profession getJob() {
        return job;
    }

    /**
     * Gets the person's first name.
     *
     * @return The person's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the person's last name.
     *
     * @return The person's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the person's biological sex.
     *
     * @return The person's biological sex.
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Gets the person's full name. If they have no last name, use their first name.
     *
     * @return The person's full name.
     */
    public String getName() {
        if (this.getLastName().isEmpty()) {
            return this.getFirstName();
        } else {
            return this.getFirstName() + " " + this.getLastName(); //combines firstName and lastName
        }
    }

    /**
     * Sets the person's age.
     *
     * @param age The person's new age.
     */
    public void setAge(int age) {
        this.age = age;
        if (getAge() > getMatingAge()) {
            this.canMate = true;
        }
        if (getAge() > getWorkingAge()) {
            this.canWork = true;
        }
    }

    /**
     * Increments the person's age by one.
     */
    private void incrementAge() {
        setAge(getAge() + 1);
    }

    /**
     * Sets the standard working age.
     *
     * @param newAge The new working age.
     */
    public static void setWorkingAge(int newAge) {
        workingAge = newAge;
    }

    /**
     * Sets the standard mating age.
     *
     * @param newAge The new mating age.
     */
    public static void setMatingAge(int newAge) {
        matingAge = newAge;
    }

    /**
     * Sets the person's first name.
     *
     * @param firstName The new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = Utilities.removeProfanity(firstName);
    }

    /**
     * Sets the person's job.
     *
     * @param job The new job.
     */
    public void setJob(Profession job) {
        this.job = job;
    }

    /**
     * Sets the person's last name.
     *
     * @param lastName The new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = Utilities.removeProfanity(lastName);
    }

    /**
     * Sets the person's biological sex.
     *
     * @param sex The new biological sex.
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * The person's first name.
     */
    private String firstName;
    /**
     * The person's last name.
     */
    private String lastName;
    /**
     * The person's age.
     */
    private int age;
    /**
     * The standard working age.
     */
    private static int workingAge;
    /**
     * The standard mating age.
     */
    private static int matingAge;
    /**
     * The person's job.
     */
    private Profession job;
    /**
     * Whether this person is old enough to work.
     */
    private Boolean canWork;
    /**
     * Whether this person is old enough to mate.
     */
    private Boolean canMate;
    /**
     * The person's birthday.
     */
    private SimpleDate birthday;

    /**
     * Gets the person's birthday.
     *
     * @return The person's birthday.
     */
    public SimpleDate getBirthday() {
        return birthday;
    }

    /**
     * Whether or not it is this person's birthday.
     *
     * @return Whether it is this person's birthday.
     */
    public Boolean isBirthday() {
        return ((getBirthday().getMonth() == Main.getDate().getMonth()) && getBirthday().getDayOfMonth() == Main.getDate().getDayOfMonth());
    }

    /**
     * What to do on the person's birthday.
     */
    public void handleBirthday() {
        System.out.println("It's " + getName() + "'s birthday!");
        incrementAge();
        System.out.println("They are now " + getAge() + " years old");
    }

    /**
     * The person's biological sex.
     */
    private Sex sex;

    /**
     * Creates a new person with a random sex.
     */
    public Person() { //when born, sets age to 0 and birthday to the current date and sex to either male or female
        this(Math.random() * 2 > 1 ? Sex.MALE : Sex.FEMALE);
    }

    /**
     * Creates a new person with the given sex.
     *
     * @param sex The new person's biological sex.
     */
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
        Person other = (Person) obj;
        if (!(this.getBirthday().equals(other.getBirthday()))) return false;
        if (!(this.getAge() == other.getAge())) return false;
        if (!(this.getFirstName().equals(other.getFirstName()))) return false;
        if (!(this.getLastName().equals(other.getLastName()))) return false;
        if (!(this.getName().equals(other.getName()))) return false;
        if (!(this.getJob().equals(other.getJob()))) return false;
        return this.getSex().equals(other.getSex());
    }
}