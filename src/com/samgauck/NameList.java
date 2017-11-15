package com.samgauck;

import java.util.ArrayList;
import java.util.Arrays;

public class NameList {
    private NameList() {
        firstNames.addAll(Arrays.asList("Anthony", "Arthur", "Aaron", "Alfred", "Alice", "Alina","Adam"));
        firstNames.addAll(Arrays.asList("Benjamin", "Barry", "Becca"));
        firstNames.addAll(Arrays.asList("Carrie", "Caroline", "Catherine", "Callie", "Caleb", "Cory"));
        firstNames.addAll(Arrays.asList("Donald", "Dave", "Dylan", "Devin", "Drew", "Daniel"));
        firstNames.addAll(Arrays.asList("Esmerelda", "Ezra", "Ezekiel", "Eve"));
        firstNames.addAll(Arrays.asList("Fred"));
        firstNames.addAll(Arrays.asList("George", "Gregory"));
        firstNames.addAll(Arrays.asList("Harry"));
        firstNames.addAll(Arrays.asList("Isabella"));
        firstNames.addAll(Arrays.asList("John", "Joe", "James"));
        firstNames.addAll(Arrays.asList("Kabsal"));
        firstNames.addAll(Arrays.asList("Louis", "Lilly", "Laura"));
        firstNames.addAll(Arrays.asList("Max", "Maeve", "Maurice"));
        firstNames.addAll(Arrays.asList("Ned"));
        firstNames.addAll(Arrays.asList("Oprah"));
        firstNames.addAll(Arrays.asList("Peri"));
        firstNames.addAll(Arrays.asList("Quasar"));
        firstNames.addAll(Arrays.asList("Ryan"));
        firstNames.addAll(Arrays.asList("Sam", "Sylvia", "Samantha"));
        firstNames.addAll(Arrays.asList("Terry"));
        firstNames.addAll(Arrays.asList("Ulfred"));
        firstNames.addAll(Arrays.asList("Veronica"));
        firstNames.addAll(Arrays.asList("Wyndle"));
        firstNames.addAll(Arrays.asList("Xavier"));
        firstNames.addAll(Arrays.asList("Yondu"));
        firstNames.addAll(Arrays.asList("Zev"));


        lastNames.addAll(Arrays.asList("Aaronson"));
    }
    private ArrayList<String> firstNames = new ArrayList<String>();
    private ArrayList<String> lastNames = new ArrayList<String>();
    private static NameList nameList = null;
    public String getFirstName() {
        return firstNames.get((int)Math.round(Math.random() * firstNames.size()));
    }
    public String getLastName() {
        return lastNames.get((int)Math.round(Math.random() * lastNames.size()));
    }

    public static NameList getInstance() {
        nameList = nameList == null ? new NameList() : nameList;
        return nameList;
    }
}
