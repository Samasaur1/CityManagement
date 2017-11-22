package com.samgauck;

import com.samgauck.DateManagement.SimpleDate;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static long millis;
    private static Scanner s = new Scanner(System.in);
    private static String input;
    private static ArrayList<City> cities = new ArrayList<>();
    private static SimpleDate date;
    private static NameList nameList = NameList.getInstance();
    public static Resources resources; //TODO: Add ways to get a new city, implement Resources then
    private static Command command = Command.getInstance();
    private static Boolean looping = true;
    private static Boolean gui = true;
    private static Boolean debug = false;
    public static Boolean getLooping() { return looping; }
    public static void setLooping(Boolean looping) { Main.looping = looping; }

    public static City getCity(int index) {
        if (0 <= index && index <= cities.size() - 1) {
            return cities.get(index);
        } else if (cities.size() >= 1) {
            return cities.get(0);
        }
        return new City("City");
    }
    public static SimpleDate getDate() {
        return date;
    }
    public static Boolean getDebug() { return debug; }

    public static void main(String[] args) {
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "nogui":
                        gui = false;
                        break;
                    case "debug":
                        debug = true;
                        break;
                    default:
                        System.out.println("Not a valid argument. Starting normally...");
                        millis = System.currentTimeMillis();
                        while (true) {
                            if (!(System.currentTimeMillis() - millis < 2000)) break; //two second wait
                        }
                }
            }
        }
        start();
        System.out.println("The proper command format is:");
        System.out.println("command item [amount] [arguments]");
        System.out.println("For example, to buy 100 food:");
        System.out.println("buy food 100");
        System.out.println("Mess with the case however you want, but spelling must be exact");
        System.out.println("BuY fOoD 100 (okay)");
        System.out.println("buy fod 100 (incorrect)");
        System.out.println("buy food 100 (correct/best/great)");
        s.nextLine();
        input = s.nextLine();
        while (looping) {
            command.execute(input);
            input = s.nextLine();
        }
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
        cities.add(new City(input)); //creates new city with your name
        cities.get(0).resources.setMoney(100_000);
        cities.get(0).resources.setFood(1_000);
        System.out.print("Would you like to name your citizens? (Y/N)");
        input = s.next();
        if (input.equalsIgnoreCase("y")) {
            System.out.println("What is the man's first name?");
            String first = s.next();
            System.out.println("What is the man's last name?");
            String last = s.next();
            cities.get(0).nameCitizen(0, first, last);
            System.out.println("What is the woman's first name?");
            first = s.next();
            System.out.println("What is the woman's last name?");
            last = s.next();
            cities.get(0).nameCitizen(1, first, last);
        }else {
            cities.get(0).nameCitizen(0, "Adam", "");
            cities.get(0).nameCitizen(1, "Eve", "");
        }
    }
}
