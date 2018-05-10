package com.samgauck.CityManagement;

import com.samgauck.CityManagement.DateManagement.SimpleDate;

import java.util.*;

/**
 * The main class for the program.
 */
public class Main {

    /**
     * The time in milliseconds. Used for waiting.
     */
    private static long millis;
    /**
     * The scanner to get input from the command line.
     */
    private static Scanner s = new Scanner(System.in);
    /**
     * The current input from the command line.
     */
    private static String input;
    /**
     * The list of the player's cities.
     */
    private static ArrayList<City> cities = new ArrayList<>();
    /**
     * The current date.
     */
    private static SimpleDate date;
    /**
     * A local reference to the list of names.
     */
    private static NameList nameList = NameList.getInstance();
    /**
     * The player's resources.
     */
    public static Resources resources; //TODO: Add ways to get a new city, implement Resources then
    /**
     * A local reference to the command handler.
     */
    private static Command command = Command.getInstance();
    /**
     * A Boolean that indicates whether the game is still looping.
     */
    private static Boolean looping = true;
    /**
     * A Boolean that indicates whether or not the game is in debug mode.
     */
    private static Boolean debug = false;

    /**
     * Get whether the game is looping.
     *
     * @return Whether or not the game is looping.
     */
    public static Boolean isLooping() {
        return looping;
    }

    /**
     * Sets the looping state of the game.
     *
     * @param looping Whether or not the game should loop.
     */
    public static void setLooping(Boolean looping) {
        Main.looping = looping;
    }

    /**
     * Gets a player-owned city from the list.
     *
     * @param index The index of the city to get from the list.
     * @return The requested city.
     */
    public static City getCity(int index) {
        if (0 <= index && index <= cities.size() - 1) {
            return cities.get(index);
        } else if (cities.size() >= 1) {
            return cities.get(0);
        }
        return new City("City");
    }

    /**
     * Gets the date.
     *
     * @return The current date.
     */
    public static SimpleDate getDate() {
        return date;
    }

    /**
     * Get whether the game is in debug mode.
     *
     * @return Whether the game is in debug mode.
     */
    public static Boolean getDebug() {
        return debug;
    }

    /**
     * The main method of the game.
     *
     * @param args Any command-line arguments.
     */
    public static void main(String[] args) {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList(args));
        if (arguments.size() != 0) {
            for (int i = 0; i < arguments.size(); i++) {
                switch (arguments.get(i)) {
                    case "debug":
                        debug = true;
                        break;
                    case "load":
                        if (arguments.size() > 1) {
                            command.execute("Load " + arguments.get(i + 1));
                            arguments.remove(i + 1);
                            break;
                        }
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
        System.out.println("buy food 100 (recommended)");
        s.nextLine();
        input = s.nextLine();
        while (looping) {
            command.execute(input);
            System.out.println(Main.getDate().toString());
            for (Person p : getCity(0).getCitizens()) {
                if (p.isBirthday()) {
                    p.handleBirthday();
                }
            }
            Main.getDate().proceedOneDay();
            input = s.nextLine();
        }
    }

    /**
     * Sets up the game and does the introduction.
     */
    private static void start() {
        date = new SimpleDate(1, 1, 2020); //Sets game date to 1/1/2020
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        System.out.println("Sam Gauck Presents:");
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
        millis = System.currentTimeMillis();
        while (true) {
            if (!(System.currentTimeMillis() - millis < 2000)) break; //two second wait
        }
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("CityManagement");
        System.out.println("Version 1.0");
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
        millis = System.currentTimeMillis();
        while (true) {
            if (!(System.currentTimeMillis() - millis < 2000)) break; //two second wait
        }
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.print("Would you like to load a save? (Y/N)");
        input = s.next();
        if (input.equalsIgnoreCase("y")) {
            System.out.println("Enter a save code:");
            s.nextLine();
            input = s.nextLine();
            command.execute(input);
        }
        System.out.print("Please enter a name for your city: ");
        input = s.next();
        input = Utilities.removeProfanity(input);
        cities.add(new City(input)); //creates new city with your name
        cities.get(0).resources.setMoney(100_000);
        cities.get(0).resources.setFood(1_000);
        System.out.print("Would you like to name your citizens? (Y/N)");
        input = s.next();
        if (input.equalsIgnoreCase("y")) {
            System.out.println("What is the man's first name?");
            String first = s.next();
            first = Utilities.removeProfanity(first);
            System.out.println("What is the man's last name?");
            String last = s.next();
            last = Utilities.removeProfanity(last);
            cities.get(0).nameCitizen(0, first, last);
            System.out.println("What is the woman's first name?");
            first = s.next();
            first = Utilities.removeProfanity(first);
            System.out.println("What is the woman's last name?");
            last = s.next();
            last = Utilities.removeProfanity(last);
            cities.get(0).nameCitizen(1, first, last);
        } else {
            cities.get(0).nameCitizen(0, "Adam", "");
            cities.get(0).nameCitizen(1, "Eve", "");
        }
    }
}