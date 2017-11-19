package com.samgauck;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Command {
    private static Command command;
    public static Command getInstance() {
        command = command == null ? new Command() : command;
        return command;
    }
    private Command() {}
    private Economy economy = Economy.getInstance();
    private ArrayList<String> items = economy.getItems();

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
            default:
                System.out.println("Error 1.1: Command not recognized");
                return;
        }
    }
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
