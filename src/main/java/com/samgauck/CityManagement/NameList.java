package com.samgauck.CityManagement;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The singleton list of names.
 */
public class NameList {
    /**
     * Creates the list of names.
     */
    private NameList() {
        firstNames.addAll(Arrays.asList("Anthony", "Arthur", "Aaron", "Alfred", "Alice", "Alina", "Adam", "Alvin", "Alan", "Amelia", "Amy", "Ava"));
        firstNames.addAll(Arrays.asList("Benjamin", "Barry", "Becca", "Bruce", "Ben"));
        firstNames.addAll(Arrays.asList("Carrie", "Caroline", "Catherine", "Callie", "Caleb","Chico" "Cory", "Clint"));
        firstNames.addAll(Arrays.asList("Donald", "Dave", "Dylan", "Devin", "Drew", "Daniel", "Douglas"));
        firstNames.addAll(Arrays.asList("Esmerelda", "Ezra", "Ezekiel", "Eve", "Eva"));
        firstNames.addAll(Arrays.asList("Fred"));
        firstNames.addAll(Arrays.asList("George", "Gregory"));
        firstNames.addAll(Arrays.asList("Harry", "Hudson","Hannah","Helen"));
        firstNames.addAll(Arrays.asList("Isabella"));
        firstNames.addAll(Arrays.asList("John","Johnny", "Joe", "James", "Jordan","Jimmy"));
        firstNames.addAll(Arrays.asList("Kabsal"));
        firstNames.addAll(Arrays.asList("Louis", "Lilly", "Laura","Larry"));
        firstNames.addAll(Arrays.asList("Max", "Maeve", "Maurice"));
        firstNames.addAll(Arrays.asList("Ned", "Natasha"));
        firstNames.addAll(Arrays.asList("Oprah"));
        firstNames.addAll(Arrays.asList("Peri", "Peter","Paul));
        firstNames.addAll(Arrays.asList("Quasar"));
        firstNames.addAll(Arrays.asList("Ryan", "Rod"));
        firstNames.addAll(Arrays.asList("Sam", "Sylvia", "Samantha", "Stephen", "Susannah", "Samuel"));
        firstNames.addAll(Arrays.asList("Terry", "Tony"));
        firstNames.addAll(Arrays.asList("Ulfred"));
        firstNames.addAll(Arrays.asList("Veronica"));
        firstNames.addAll(Arrays.asList("Wyndle", "Wanda", "Walter"));
        firstNames.addAll(Arrays.asList("Xavier"));
        firstNames.addAll(Arrays.asList("Yondu"));
        firstNames.addAll(Arrays.asList("Zev"));
        /*
         * In the constructor, initialize the first and last name lists.
         */
        lastNames.addAll(Arrays.asList("Aaronson", "Amato", "Arteaga", "Adler", "Aguilar", "Applefeld", "Avril", "Abell", "Aber", "Abbett", "Abram", "Acker"));
        lastNames.addAll(Arrays.asList("Berkowitz", "Benito", "Blickely", "Blumenthal", "Banner", "Barton", "Baran", "Barker", "Brier", "Burney", "Bryne"));
        lastNames.addAll(Arrays.asList("Craven", "Cain", "Clover", "Corbett", "Cunningham", "Callahan", "Campbell", "Cidecian", "Coles"));
        lastNames.addAll(Arrays.asList("Darnell", "Darmond", "Deane", "DeLuca", "Dente", "Dhruv", "Doran", "Dai", "Dente"));
        lastNames.addAll(Arrays.asList("Ehrlacher", "Elieson", "Evans", "Eisen"));
        lastNames.addAll(Arrays.asList("Feller", "Fishburn", "Freeman", "Fang", "Forbes", "Feinberg", "Fuss"));
        lastNames.addAll(Arrays.asList("Gauck", "Garcia", "Garman", "Gordon", "Greenwald", "Getz", "Guttman"));
        lastNames.addAll(Arrays.asList("Hamilton", "Harris", "Heit", "Heller", "Hughes", "Hurtig", "Hill", "Hirschhorn"));
        lastNames.addAll(Arrays.asList("Isler"));
        lastNames.addAll(Arrays.asList("Jacobs", "Johnson", "Jones"));
        lastNames.addAll(Arrays.asList("Kane", "Keefer", "Knight", "Kummer", "Kurtz"));
        lastNames.addAll(Arrays.asList("Leach", "Lebson", "Lew", "Linz", "Lopez", "Lloyd"));
        lastNames.addAll(Arrays.asList("Macek", "Major", "McManus", "McDonald", "Miller", "Maximoff", "Ma", "Mele"));
        lastNames.addAll(Arrays.asList("Newman", "Navarro", "Nelson"));
        lastNames.addAll(Arrays.asList("Otto", "oberman"));
        lastNames.addAll(Arrays.asList("Potter", "Patterson", "Peters", "Potters"));
        lastNames.addAll(Arrays.asList("Quasar", "Quill"));
        lastNames.addAll(Arrays.asList("Richardson", "Rifkin", "Rollfinke", "Rudow", "Romanoff"));
        lastNames.addAll(Arrays.asList("Smith", "Sachs", "Schneider", "Seidenman", "Stark", "Strange"));
        lastNames.addAll(Arrays.asList("Thompson", "Trench"));
        lastNames.addAll(Arrays.asList("Underwood"));
        lastNames.addAll(Arrays.asList("Vernick", "Varley", "Van Der Velpen"));
        lastNames.addAll(Arrays.asList("Woodson", "Walsh", "Watson", "Weiss", "Weinstein", "Wolf"));
        lastNames.addAll(Arrays.asList("Xavier"));
        lastNames.addAll(Arrays.asList("Yrians"));
        lastNames.addAll(Arrays.asList("Zlamal"));
    }

    /**
     * The list of first names.
     */
    private ArrayList<String> firstNames = new ArrayList<>();
    /**
     * The list of last names.
     */
    private ArrayList<String> lastNames = new ArrayList<>();
    /**
     * The NameList instance.
     */
    private static NameList nameList = null;

    /**
     * Gets a random first name from the list.
     *
     * @return A String that is a random first name.
     */
    public String getFirstName() {
        return firstNames.get((int) Math.round(Math.random() * firstNames.size()));
    }

    /**
     * Gets a random last name from the list.
     *
     * @return A String that is a random last name.
     */
    public String getLastName() {
        return lastNames.get((int) Math.round(Math.random() * lastNames.size()));
    }

    /**
     * Gets the NameList instance if it exists, otherwise make a new one.
     *
     * @return The one and only NameList instance.
     */
    public static NameList getInstance() {
        nameList = nameList == null ? new NameList() : nameList;
        return nameList;
    }
}
