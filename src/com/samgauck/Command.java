package com.samgauck;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A singleton class that manages all commands.
 */
public class Command {
    private static Command command;
    /**
     * Gets the Command instance if it exists, otherwise make a new one.
     * @return The one and only Command instance.
     */
    public static Command getInstance() {
        command = command == null ? new Command() : command;
        return command;
    }
    private Command() {
        items.addAll(Arrays.asList("Food", "Wood", "Stone", "Iron", "Steel", "Oil", "Coal", "Uranium", "Water", "Carbon"));
    }
    private ArrayList<String> items = new ArrayList<String>();

    /**
     * A high-level function that takes a command and call the function that it is trying to do.
     * @param command The command given bby the user.
     */
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

    /**
     * A function that buys items.
     * @param followingWords The user's command, minus the word "buy".
     */
    private void buy(ArrayList<String> followingWords) {
        if (!items.contains(followingWords.get(0).toLowerCase())) {
            System.out.println("Error 1.2: Item not recognized");
            return;
        }
        //TODO: Buy items
    }

    /**
     * A function that sells items.
     * @param followingWords The user's command, minus the word "sell".
     */
    private void sell(ArrayList<String> followingWords) {
        if (!items.contains(followingWords.get(0).toLowerCase())) {
            System.out.println("Error 1.2: Item not recognized");
            return;
        }
        //TODO: Sell items
    }

    /**
     * A function that constructs items/things.
     * @param followingWords The user's command, minus the word "construct".
     */
    private void construct(ArrayList<String> followingWords) {
        //TODO: Construct
    }
}
