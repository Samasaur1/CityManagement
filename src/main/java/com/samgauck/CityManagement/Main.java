package com.samgauck.CityManagement;

import com.gauck.sam.Utilities.Utilities;
import com.samgauck.CityManagement.DateManagement.SimpleDate;

import java.util.*;

/**
 * The main class for the program.
 */
public class Main {

    /**
     * The player's resources.
     */
    public static Resources resources; //TODO: Add ways to get a new city, implement Resources then
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
     * A local reference to the command handler.
     */
    private static Command command = Command.getInstance();
    /**
     * A boolean that indicates whether the game is still looping.
     */
    private static boolean looping = true;
    /**
     * A boolean that indicates whether or not the game is in debug mode.
     */
    private static boolean debug = false;
    /**
     * The private constructor for Main. Should <strong>NEVER</strong> be used.
     */
    private Main() {}

    /**
     * Get whether the game is looping.
     *
     * @return Whether or not the game is looping.
     */
    public static boolean isLooping() {
        return looping;
    }

    /**
     * Sets the looping state of the game.
     *
     * @param looping Whether or not the game should loop.
     */
    public static void setLooping(boolean looping) {
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
    public static boolean getDebug() {
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
                        if (arguments.size() > i + 1) {
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
        System.out.println("There are " + command.commands.size() + " commands in CityManagement");
        command.execute("help");
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
        System.out.println("Version " + "0.8.2"); //Gradle changes this version string.
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
        input = s.nextLine(); //Originally next() which did not allow for two word cities like Las Vegas, Los Angeles, New Mexico, etc.
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
            String last = s.nextLine(); //Originally next() which did not allow for multi part last names like Di Vinci, Delano Roosevelt
            last = Utilities.removeProfanity(last);
            cities.get(0).nameCitizen(0, first, last);
            System.out.println("What is the woman's first name?");
            first = s.next();
            first = Utilities.removeProfanity(first);
            System.out.println("What is the woman's last name?");
            last = s.nextLine(); //Originally next() which did not allow for multi part last names like Di Vinci, Delano Roosevelt
            last = Utilities.removeProfanity(last);
            cities.get(0).nameCitizen(1, first, last);
        } else {
            cities.get(0).nameCitizen(0, "Adam", "");
            cities.get(0).nameCitizen(1, "Eve", "");
        }
    }
}
