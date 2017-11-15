package com.samgauck;

import com.samgauck.DateManagement.SimpleDate;

import java.util.Scanner;

public class Main {

    private static long millis;
    private static Scanner s = new Scanner(System.in);
    private static String input;
    private static City city;
    private static SimpleDate date;
    private static NameList nameList = NameList.getInstance();
    private static Resources resources;

    public static SimpleDate getDate() {
        return date;
    }

    public static void main(String[] args) {
        start();
        System.out.println(city.listCitizens());
    }
    private static void start() {
        date = new SimpleDate(1,1,2020); //Sets game date to 1/1/2020
        resources = new Resources(100_000, 1000); //Sets money to 100,000 and food to 1,000
        for (int i = 0; i < 10; i++){
            System.out.println();
        }
        System.out.println("Sam Gauck Presents:");
        for (int i = 0; i < 3; i++){
            System.out.println();
        }
        millis = System.currentTimeMillis();
        while (true){
            if (!(System.currentTimeMillis() - millis < 2000)) break; //two second wait
        }
        for (int i = 0; i < 50; i++){
            System.out.println();
        }
        System.out.println("CityManagement");
        System.out.println("Version 1.0");
        for (int i = 0; i < 3; i++){
            System.out.println();
        }
        millis = System.currentTimeMillis();
        while (true){
            if (!(System.currentTimeMillis() - millis < 2000)) break; //two second wait
        }
        for (int i = 0; i < 50; i++){
            System.out.println();
        }
        System.out.print("Please enter a name for your city: ");
        input = s.next();
        city = new City(input); //creates new city with your name
        System.out.print("Would you like to name your citizens? (Y/N)");
        input = s.next();
        if (input.equalsIgnoreCase("y")) {
            System.out.println("What is the man's first name?");
            String first = s.next();
            System.out.println("What is the man's last name?");
            String last = s.next();
            city.nameCitizen(0, first, last);
            System.out.println("What is the woman's first name?");
            first = s.next();
            System.out.println("What is the woman's last name?");
            last = s.next();
            city.nameCitizen(1, first, last);
        }else {
            city.nameCitizen(0, "Adam", "");
            city.nameCitizen(1, "Eve", "");
        }
    }
}
