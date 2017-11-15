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
    public Sex getSex() { return sex; }
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
        if ((this.getFirstName() == "Adam" || this.getFirstName() ==  "Eve") && this.getLastname() == "") {
            this.name = this.getFirstName();
        }else {
            this.name = this.getFirstName() + " " + this.getLastname(); //combines firstName and lastName
        }
    }

    private String firstName;
    private String lastname;
    private String name;
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

    @Override
    public String toString() {
        return "A person named " + this.getName() + ", age " + this.getAge() + ", " + this.job;
    }
    //TODO: add code for getting older every birthday (or maybe in Main?)
}
