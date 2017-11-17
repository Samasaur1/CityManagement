package com.samgauck;

import java.util.ArrayList;
import java.util.Arrays;

public class Command {
    private static Command command;
    public static Command getInstance() {
        command = command == null ? new Command() : command;
        return command;
    }
    private Command() {
        items.addAll(Arrays.asList("Food", "Wood", "Stone", "Iron", "Steel", "Oil", "Coal", "Uranium", "Water", "Carbon"));
    }
    private ArrayList<String> items = new ArrayList<String>();

    public void execute(String command) {
        ArrayList<String> words = new ArrayList<String>();
        words.addAll(Arrays.asList(command.split(" ")));
        String word1 = words.get(0);
        words.remove(0);
        switch (word1.toLowerCase()) {
            case "buy":
                buy(words);
                break;
            case "sell":
                sell(words);
                break;
            case "construct":
                construct(words);
                break;
            default:
                System.out.println("Error 1.1: Command not recognized");
                return;
        }
    }
    private void buy(ArrayList<String> followingWords) {
        if (!items.contains(followingWords.get(0).toLowerCase())) {
            System.out.println("Error 1.2: Item not recognized");
            return;
        }
        //TODO: Buy items
    }
    private void sell(ArrayList<String> followingWords) {
        if (!items.contains(followingWords.get(0).toLowerCase())) {
            System.out.println("Error 1.2: Item not recognized");
            return;
        }
        //TODO: Sell items
    }
    private void construct(ArrayList<String> followingWords) {
        //TODO: Construct
    }
}
