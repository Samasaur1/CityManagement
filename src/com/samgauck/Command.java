package com.samgauck;

import java.text.NumberFormat;
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
    private Command() {}
    private Economy economy = Economy.getInstance();
    private ArrayList<String> items = economy.getItems();

    /**
     * A high-level function that takes a command and call the function that it is trying to do.
     * @param command The command given by the user.
     */
    public void execute(String command) {
        ArrayList<String> words = new ArrayList<String>();
        command = command.toLowerCase();
        words.addAll(Arrays.asList(command.split(" ")));
        String word1 = words.get(0);
        words.remove(0);
        switch (word1) {
            case "buy":
                buy(words);
                break;
            case "sell":
                sell(words);
                break;
            case "construct":
                construct(words);
                break;
            case "quit":
                quit();
                break;
            case "load":
                load(words);
                break;
            case "save":
                save(words);
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
        System.out.println("");
        if (followingWords.size() == 0) {
            System.out.println("Error 1.2.1: No item to buy");
            return;
        }
        if (!items.contains(followingWords.get(0))) {
            System.out.println("Error 1.2.2: Item not recognized");
            return;
        }
        if (followingWords.get(1).matches("\\D+")) {
            System.out.println("Error 1.3: Not a valid amount");
            return;
        }
        String item = followingWords.get(0);
        int amount = Integer.parseInt(followingWords.get(1));
        if ((Main.getCity(0).resources.getMoney() - (economy.getPrice(item) * amount)) < 0) {
            if (followingWords.size() <= 3 || followingWords.get(2).contains("d")) {
                System.out.println("You don't have enough money to pay for " + amount + " " + item + " and you didn't specify that you could go into debt");
                System.out.println("The most you could buy is " + (int)Math.floor(Main.getCity(0).resources.getMoney()/economy.getPrice(item)));
                System.out.println("Transaction not completed");
                return;
            }
        }
        Main.getCity(0).resources.setMoney(Main.getCity(0).resources.getMoney() - (economy.getPrice(item) * amount));
        Main.getCity(0).resources.setItem(item, Main.getCity(0).resources.getItem(item) + amount);
        System.out.println("Transaction completed");
        System.out.println(Main.getCity(0).resources.toString());
    }

    /**
     * A function that sells items.
     * @param followingWords The user's command, minus the word "sell".
     */
    private void sell(ArrayList<String> followingWords) {
        System.out.println("");
        if (followingWords.size() == 0) {
            System.out.println("Error 1.2.1: No item to sell");
            return;
        }
        if (!items.contains(followingWords.get(0))) {
            System.out.println("Error 1.2.2: Item not recognized");
            return;
        }
        if (followingWords.get(1).matches("\\D+")) {
            System.out.println("Error 1.3: Not a valid amount");
            return;
        }
        String item = followingWords.get(0);
        int amount = Integer.parseInt(followingWords.get(1));
        if ((Main.getCity(0).resources.getItem(item) - amount) < 0) {
            System.out.println("You don't have enough " + item);
            System.out.println("The most you could sell is " + Main.getCity(0).resources.getItem(item));
            System.out.println("Transaction not completed");
            return;
        }
        Main.getCity(0).resources.setMoney(Main.getCity(0).resources.getMoney() + (economy.getPrice(item) * amount));
        Main.getCity(0).resources.setItem(item, Main.getCity(0).resources.getItem(item) - amount);
        System.out.println("Transaction completed");
        System.out.println(Main.getCity(0).resources.toString());
    }

    /**
     * A function that constructs items/things.
     * @param followingWords The user's command, minus the word "construct".
     */
    private void construct(ArrayList<String> followingWords) {
        //TODO: Construct
    }

    /**
     * Ends the looping command input.
     */
    private void quit() {
        Main.setLooping(false);
        System.out.println("Thanks for playing!");
    }
    private void load(ArrayList<String> followingWords) {
        //TODO
    }
    private void save(ArrayList<String> followingWords) {
        //TODO
    }
}
