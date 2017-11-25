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
    public String getLastName() {
        return lastName;
    }
    public Sex getSex() { return sex; }
    public String getName() {
        if ((this.getFirstName() == "Adam" || this.getFirstName() ==  "Eve") && this.getLastName() == "") {
            return this.getFirstName();
        }else {
            return this.getFirstName() + " " + this.getLastName(); //combines firstName and lastName
        }
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
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setSex(Sex sex) { this.sex = sex; }

    /**
     * Sets the name variable to the first name plus the last name, unless there is no last name, in which case it is only the first name.
     */
    private void updateName() {
    }

    private String firstName;
    private String lastName;
    private int age;
    private Profession job;
    private SimpleDate birthday;
    private Sex sex;
    public Person() { //when born, sets age to 0 and birthday to the current date and sex to either male or female
        this.setAge(0);
        this.birthday = Main.getDate();
        this.setJob(Profession.JOBLESS);
        if (Math.random() * 2 > 1) {
            this.sex = Sex.MALE;
        }else {
            this.sex = Sex.FEMALE;
        }
    }
    public Person(Sex sex) {
        this.setAge(0);
        this.birthday = Main.getDate();
        this.setJob(Profession.JOBLESS);
        this.sex = sex;
    }

    /**
     * Returns a string representation of a person, format "A person named Sam, age 14, Jobless".
     * @return A string representation of the person.
     */
    @Override
    public String toString() {
        return "A person named " + this.getName() + ", age " + this.getAge() + ", " + this.job;
    }
    //TODO: add code for getting older every birthday (or maybe in Main?)
}
