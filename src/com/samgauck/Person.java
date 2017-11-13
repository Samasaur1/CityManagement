package com.samgauck;

import java.util.Date;

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
        this.name = this.getFirstName() + " " + this.getLastname();
    }

    private String firstName;
    private String lastname;
    private String name;
    private int age;
    private Profession job;
    private Date birthday;
    public Person() {
        this.setAge(0);
    }
}
