package com.samgauck;

import com.samgauck.DateManagement.SimpleDate;

import java.util.Scanner;

public class Main {

    private static long millis;
    private static Scanner s = new Scanner(System.in);
    private static String input;
    private static City mainCity;
    private static SimpleDate date;
    private static NameList nameList = NameList.getInstance();
    public static Resources resources; //TODO: Add ways to get a new city, implement Resources then
    private static Command command = Command.getInstance();

    public static City getMainCity() {
        return mainCity;
    }

    public static SimpleDate getDate() {
        return date;
    }

    public static void main(String[] args) {
        start();
        System.out.println("The proper command format is:");
        System.out.println("command item [amount] [arguments]");
        System.out.println("For example, to buy 100 food:");
        System.out.println("buy food 100");
        System.out.println("Mess with the case however you want, but spelling must be exact");
        System.out.println("BuY fOoD 100 (correct)");
        System.out.println("buy fod 100 (incorrect)");
        input = s.next();
        command.execute(input);
    }
    private static void start() {
        date = new SimpleDate(1,1,2020); //Sets game date to 1/1/2020
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
        mainCity = new City(input); //creates new city with your name
        System.out.print("Would you like to name your citizens? (Y/N)");
        input = s.next();
        if (input.equalsIgnoreCase("y")) {
            System.out.println("What is the man's first name?");
            String first = s.next();
            System.out.println("What is the man's last name?");
            String last = s.next();
            mainCity.nameCitizen(0, first, last);
            System.out.println("What is the woman's first name?");
            first = s.next();
            System.out.println("What is the woman's last name?");
            last = s.next();
            mainCity.nameCitizen(1, first, last);
        }else {
            mainCity.nameCitizen(0, "Adam", "");
            mainCity.nameCitizen(1, "Eve", "");
        }
    }
}
