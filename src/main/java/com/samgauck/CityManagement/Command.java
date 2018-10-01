package com.samgauck.CityManagement;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import com.gauck.sam.Utilities.*;

/**
 * A singleton class that manages all commands.
 */
public class Command {
    /**
     * The Command instance.
     */
    private static Command command;
    /**
     * The list of all possible commands.
     */
    public final ArrayList<String> commands = new ArrayList<>(Arrays.asList("buy", "sell", "construct", "quit", "load", "save", "help,", "status"));
    /**
     * A local reference to the economy.
     */
    private Economy economy = Economy.getInstance();
    /**
     * The list of items.
     */
    private ArrayList<String> items = economy.getItems();

    /**
     * The list of constructables (constructable items).
     */
    private ArrayList<String> constructables = economy.getConstructables();

    /**
     * Creates a new Command instance. It is private so that it can be a singleton.
     */
    private Command() {
    }

    /**
     * Gets the Command instance if it exists, otherwise make a new one.
     *
     * @return The one and only Command instance.
     */
    public static Command getInstance() {
        command = command == null ? new Command() : command;
        return command;
    }

    /**
     * A high-level function that takes a command and call the function that it is trying to do.
     *
     * @param command The command given by the user.
     */
    public void execute(String command) {
        command = Utilities.removeProfanity(command);
        command = command.toLowerCase();
        ArrayList<String> words = new ArrayList<>(Arrays.asList(command.split(" ")));
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
                save();
                break;
            case "help":
                help(words);
                break;
            case "status":
                status(words);
                break;
            default:
                System.out.println("Error 1.1: Command not recognized");
                return;
        }
    }

    /**
     * A function that buys items.
     *
     * @param followingWords The user's command, minus the word "buy".
     */
    private void buy(ArrayList<String> followingWords) {
        System.out.println();
        if (followingWords.size() == 0) {
            System.out.println("Error 1.2.1: No item to buy");
            return;
        }
        if (!items.contains(followingWords.get(0))) {
            System.out.println("Error 1.2.2: Item not recognized");
            return;
        }
        String item = followingWords.get(0);
        int amount;
        if (followingWords.size() == 1) {
            System.out.println("No amount given, buying 1 " + item);
            amount = 1;
        } else if (followingWords.get(1).matches(".*\\D.*")) {
            System.out.println("Error 1.3.2.1: Not a valid amount");
            return;
        } else {
            try {
                long x = Long.parseLong(followingWords.get(1));
                if (x > Integer.MAX_VALUE) {
                    System.out.println("Error 1.3.2.2: Amount too large for one transaction");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error 1.3.2.3: Amount too large for one transaction");
                return;
            } catch (Exception e) {
                System.out.println("Error 1.3.2.4: Undetermined");
                if (Main.getDebug()) {
                    System.out.println("In debug mode, so printing information");
                    System.out.println(e);
                    e.printStackTrace();
                    System.out.println(e.getCause());
                    System.out.println(e.getMessage());
                }
                return;
            }
            amount = Integer.parseInt(followingWords.get(1));
        }
        if ((Main.getCity(0).resources.getMoney() - (economy.getPrice(item) * amount)) < 0) {
            if (followingWords.size() <= 2 || !followingWords.get(2).contains("d")) {
                System.out.println("You don't have enough money to pay for " + amount + " " + item + " and you didn't specify that you could go into debt");
                System.out.println("The most you could buy is " + (int) Math.floor(Main.getCity(0).resources.getMoney() / economy.getPrice(item)));
                System.out.println("Transaction not completed");
                return;
            }
        }
        Main.getCity(0).resources.setMoney(Main.getCity(0).resources.getMoney() - (economy.getPrice(item) * amount));
        Main.getCity(0).resources.setItem(item, Main.getCity(0).resources.getItem(item) + amount);
        System.out.println("Transaction completed");
        System.out.println(Main.getCity(0).resources.toString());

        economy.updatePrice(Economy.EconomicalActionType.BUYING, item, amount);
    }

    /**
     * A function that sells items.
     *
     * @param followingWords The user's command, minus the word "sell".
     */
    private void sell(ArrayList<String> followingWords) {
        System.out.println();
        if (followingWords.size() == 0) {
            System.out.println("Error 1.2.1: No item to sell");
            return;
        }
        if (!items.contains(followingWords.get(0))) {
            System.out.println("Error 1.2.2: Item not recognized");
            return;
        }
        String item = followingWords.get(0);
        int amount;
        if (followingWords.size() == 1) {
            System.out.println("No amount given, selling 1 " + item);
            amount = 1;
        } else if (followingWords.get(1).matches(".*\\D.*")) {
            System.out.println("Error 1.3.2.1: Not a valid amount");
            return;
        } else {
            try {
                long x = Long.parseLong(followingWords.get(1));
                if (x > Integer.MAX_VALUE) {
                    System.out.println("Error 1.3.2.2: Amount too large for one transaction");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error 1.3.2.3: Amount too large for one transaction");
                return;
            } catch (Exception e) {
                System.out.println("Error 1.3.2.4: Undetermined");
                if (Main.getDebug()) {
                    System.out.println("In debug mode, so printing information");
                    System.out.println(e);
                    e.printStackTrace();
                    System.out.println(e.getCause());
                    System.out.println(e.getMessage());
                }
                return;
            }
            amount = Integer.parseInt(followingWords.get(1));
        }
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

        economy.updatePrice(Economy.EconomicalActionType.SELLING, item, amount);
    }

    /**
     * A function that constructs items/things.
     *
     * @param followingWords The user's command, minus the word "construct".
     */
    private void construct(ArrayList<String> followingWords) {
        System.out.println();
        if (followingWords.size() == 0) {
            System.out.println("Error 1.2: Nothing to construct");
            return;
        }
        if (!constructables.contains(followingWords.get(0))) {
            System.out.println("Error 1.2.2: Unable to construct '" + followingWords.get(0) + "'");
            return;
        }
        String constructable = followingWords.get(0);
        int amount;
        if (followingWords.size() == 1) {
            System.out.println("No amount given, constructing 1 " + constructable);
            amount = 1;
        } else if (followingWords.get(1).matches(".*\\D.*")) {
            System.out.println("Error 1.3.2.1: Not a valid amount");
            return;
        } else {
            try {
                long x = Long.parseLong(followingWords.get(1));
                if (x > Integer.MAX_VALUE) {
                    System.out.println("Error 1.3.2.2: Amount too large for one transaction");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error 1.3.2.3: Amount too large for one transaction");
                return;
            } catch (Exception e) {
                System.out.println("Error 1.3.2.4: Undetermined");
                if (Main.getDebug()) {
                    System.out.println("In debug mode, so printing information");
                    System.out.println(e);
                    e.printStackTrace();
                    System.out.println(e.getCause());
                    System.out.println(e.getMessage());
                }
                return;
            }
            amount = Integer.parseInt(followingWords.get(1));
        }
        Resources price = economy.getRequirements(constructable);
        if (!(Main.getCity(0).resources.encompasses(price.multipliedBy(amount)))) {
            System.out.println("You don't have enough resources to construct '" +  constructable + "' x" + amount + " and you can't go into debt in construction.");
            System.out.println("You have:\n" + Main.getCity(0).resources.toString());
            System.out.println("You need:\n" + price.multipliedBy(amount).toString());
            System.out.println("Construction not completed");
            return;
        }
        Main.getCity(0).resources.subtract(price.multipliedBy(amount));
        if (constructable.equalsIgnoreCase("city")) {
            //TODO: Add city
        } else if (items.contains(constructable)) {
            Main.getCity(0).resources.setItem(constructable, Main.getCity(0).resources.getItem(constructable) + amount);
        }
        System.out.println("Construction completed");
        System.out.println(Main.getCity(0).resources.toString());

        economy.updatePrice(Economy.EconomicalActionType.CONSTRUCTING, constructable, amount);
    }
    /**
     * Ends the looping command input.
     */
    private void quit() {
        Main.setLooping(false);
        System.out.println("Thanks for playing!");
        System.exit(0);
    }

    /**
     * Loads a save code and updates the game to its state.
     *
     * @param followingWords The user's command, minus the word "load".
     */
    private void load(ArrayList<String> followingWords) {
        if (followingWords.size() <= 0) {
            System.out.println("Error 1.2: No save code given.");
        } else if (followingWords.size() > 1) {
            System.out.println("Error 1.3: To load, execute \"load [save-code]\", but replace \"[save-code]\" with your save code.");
        } else {
            /* General checking start*/
            ArrayList<String> code = new ArrayList<>();
            code.addAll(Arrays.asList(followingWords.get(0).split("•")));
            if (code.size() != 5) {
                System.out.println("Error 1.2.1: Save code not valid");
                return;
            }
            /*General checking end*/
            /*Name checking start*/
            //No checking; anything is accepted
            /*Name checking end*/
            /*Resource checking start*/
            ArrayList<String> resources = new ArrayList<>();
            ArrayList<Integer> resourceInts = new ArrayList<>();
            resources.addAll(Arrays.asList(code.get(1).split("§")));
            for (int i = 0; i < resources.size(); i++) {
                try {
                    resourceInts.add(Integer.parseInt(resources.get(i)));
                } catch (NumberFormatException e) {
                    System.out.println("Error 1.2.3: Save code not valid");
                }
            }
            if (resourceInts.size() != Resources.getNumberOfResources() || resources.size() != Resources.getNumberOfResources()) { //If there is the wrong number of resources
                System.out.println("Error 1.2.3: Save code not valid");
                return;
            }
            /*Resource checking end*/
            /*Person checking starts*/
            ArrayList<String> people = new ArrayList<>();
            ArrayList<String> person = new ArrayList<>();
            people.addAll(Arrays.asList(code.get(2).split("§")));
            for (int i = 0; i < people.size(); i++) {
                person.addAll(Arrays.asList(people.get(i).split("‡")));
                if (person.size() != 5) { //wrong number of fields = 1.2.4
                    System.out.println("Error 1.2.4: Save code not valid");
                    return;
                }
                try {
                    Integer.parseInt(person.get(2));
                } catch (NumberFormatException e) {
                    System.out.println("Error 1.2.4.3: Save code not valid");
                    return;
                }
                try {
                    Profession.valueOf(person.get(3).toUpperCase());
                } catch (Exception e) {
                    System.out.println("Error 1.2.4.4: Save code not valid");
                    return;
                }
                person.clear();
            }
            /*Person checking ends*/
            /*Date checking starts*/
            ArrayList<String> date = new ArrayList<>();
            ArrayList<Integer> dateInts = new ArrayList<>();
            date.addAll(Arrays.asList(code.get(3).split("§")));
            if (date.size() != 3) { //Failure checking for changing the date
                System.out.println("Error 1.2.5.1: Save code not valid");
                return;
            }
            date.forEach(d -> {
                try {
                    dateInts.add(Integer.parseInt(d));
                } catch (NumberFormatException e) {
                    System.out.println("Error 1.2.5.2: Save code not valid");
                }
            });
            /*Date checking ends*/
            /*Economy checking starts*/
            ArrayList<String> priceStrings = new ArrayList<>();
            ArrayList<Integer> prices = new ArrayList<>();
            priceStrings.addAll(Arrays.asList(code.get(4).split("§")));
            if (priceStrings.size() != economy.getItems().size()) {//Not correct number of prices
                System.out.println("Error 1.2.6.1: Save code not valid");
                return;
            }
            priceStrings.forEach(p -> {
                try {
                    prices.add(Integer.parseInt(p));
                } catch (NumberFormatException e) {
                    System.out.println("Error 1.2.6.2: Save code not valid");
                }
            });
            /*Economy checking ends*/

            //Set city name. No reason this would fail.
            Main.getCity(0).setName(code.get(0));

            //Sets number of resources. Can fail if they don't pass Integers
            Main.getCity(0).resources.setAll(resourceInts.get(0), resourceInts.get(1), resourceInts.get(2), resourceInts.get(3), resourceInts.get(4), resourceInts.get(5), resourceInts.get(6), resourceInts.get(7), resourceInts.get(8), resourceInts.get(9), resourceInts.get(10));

            //Sets people. Can fail if they mess with the fields
            for (int i = 0; i < people.size(); i++) {
                person.addAll(Arrays.asList(people.get(i).split("‡")));
                Main.getCity(0).getCitizens().get(i).setFirstName(person.get(0)); //If incorrect(impossible) = Error 1.2.4.1
                Main.getCity(0).getCitizens().get(i).setLastName(person.get(1)); //If incorrect(impossible) = Error 1.2.4.2
                Main.getCity(0).getCitizens().get(i).setAge(Integer.parseInt(person.get(2))); //If incorrect = Error 1.2.4.3
                Main.getCity(0).getCitizens().get(i).setJob(Profession.valueOf(person.get(3).toUpperCase())); //If incorrect = Error 1.2.4.4
                Main.getCity(0).getCitizens().get(i).setSex((person.get(4).equalsIgnoreCase("m")) ? Sex.MALE : Sex.FEMALE); //If incorrect(impossible) = Error 1.2.4.5
                person.clear();
            }

            //Sets date. Can fail if they don't pass Integers
            Main.getDate().setDate(dateInts.get(0), dateInts.get(1), dateInts.get(2));

            //Sets current prices. Can fail if they don't pass Integers
            economy.setPrices(prices);

            System.out.println("Loaded!");
        }
    }

    /**
     * Saves the game by printing out a save code of the state of the game.
     */
    private void save() {
        StringBuilder s = new StringBuilder();
        s.append(Main.getCity(0).getName()).append("•");
        s.append(Main.getCity(0).resources.saveableString()).append("•");
        Main.getCity(0).getCitizens().forEach(p -> {
            s.append(p.getFirstName()).append("‡");
            s.append(p.getLastName()).append("‡");
            s.append(p.getAge()).append("‡");
            s.append(p.getJob()).append("‡");
            s.append(p.getSex().toString().substring(0, 1)).append("§");
        });
        s.reverse().deleteCharAt(0).reverse().append("•"); //deletes the last "§" form the getCitizens().foreach loop and adds the •
        s.append(Main.getDate().saveableString()).append("•");
        items.forEach(item -> {
            s.append(economy.getPrice(item)).append("§");
        });
        s.reverse().deleteCharAt(0).reverse().append("•"); //deletes the last "§" form the items.foreach loop and adds the •
        System.out.println("Your save code is:");
        System.out.println(s.toString());
    }

    /**
     * Helps the player by giving information.
     *
     * @param followingWords The topics that the player wants specific help on.
     */
    private void help(ArrayList<String> followingWords) {
        if (followingWords.size() == 0) {
            StringBuilder s = new StringBuilder();
            s.append("A proper command starts with a command word. The list of command words is as follows").append("\n");
            for (int i = 0; i < commands.size(); i++) {
                s.append(commands.get(i)).append(", ");
            }
            s.reverse().deleteCharAt(0).deleteCharAt(0).reverse().append("\n");
            s.append("\n");
            s.append("Buy, sell, construct, and load all require additional arguments").append("\n");
            s.append("Help can be called with or without arguments").append("\n");
            s.append("Quit and save ignore arguments").append("\n");
            s.append("Buy, sell, and construct accept an item (to buy, sell, or construct) and an amount. For example:").append("\n");
            s.append("buy food 100").append("\n");
            s.append("will buy 100 food (if you have enough money)").append("\n");
            s.append("\n");
            s.append("Buy, specifically, has extra options. You can add a \"d\" flag as an extra argument to let yourself go into debt").append("\n");
            s.append("Help can be called by itself (as you have), or with a command to learn more about that command").append("\n");
            s.append("Quit and save can be passed arguments, but they will ignore them completely").append("\n");
            System.out.println(s.toString());
            return;
        } else if (followingWords.size() == 1 && commands.contains(followingWords.get(0))) {
            StringBuilder s = new StringBuilder();
            switch (followingWords.get(0)) {
                case "buy":
                    s.append("The 'buy' command is how you buy resources. Usage is \"buy [item] [amount] [arguments]\". For example:").append("\n");
                    s.append("buy food 100").append("\n");
                    s.append("The [item] and [amount] fields are necessary, but the [arguments] are optional").append("\n");
                    s.append("\n");
                    s.append("Possible arguments are:").append("\n");
                    s.append("d, which allows you to go into debt").append("\n");
                    s.append("\n");
                    break;
                case "sell":
                    s.append("The 'sell' command is how you sell resources. Usage is \"sell [item] [amount]\". For example:").append("\n");
                    s.append("sell food 100").append("\n");
                    s.append("Both the [item] and [amount] fields are necessary").append("\n");
                    break;
                case "construct":
                    s.append("The 'construct' command lets you construct items, both items that one could buy and ones that are otherwise exclusive.").append("\n");
                    s.append("Usage is \"construct [constructable] [amount]\". For example:").append("\n");
                    s.append("construct city 1").append("\n");
                    s.append("Both the [item] and [amount] fields are necessary").append("\n");
                    break;
                case "quit":
                    s.append("The 'quit' command quits the game. It does not ask you if you are sure, and it will not save").append("\n");
                    s.append("There are no other arguments. Usage:").append("\n");
                    s.append("quit").append("\n");
                    break;
                case "load":
                    s.append("The 'load' command loads a save code. The save code is the only argument. Usage:").append("\n");
                    s.append("load ").append("\n");
                    break;
                case "save":
                    s.append("The 'save' command shows a save code. It accepts no arguments. Usage:").append("\n");
                    s.append("save").append("\n");
                    break;
                case "help":
                    s.append("The help command helps you out. If invoked with no arguments, it shows general help").append("\n");
                    s.append("If called with an argument, the usage should be \"help [command]\". For example:").append("\n");
                    s.append("help buy").append("\n"); //Add second level of help? such as "help buy [arguments]"
                    break;
                default:
                    System.out.println("Error 1.2: Command not recognized");
            }
            System.out.println(s.toString());
        } else {
            System.out.println("Error 1.2: Topic not recognized");
        }
    }

    /**
     * Prints out the status.
     *
     * @param followingWords The topics that the player wants specific status on.
     */
    private void status(ArrayList<String> followingWords) {
        if (followingWords.size() == 0) {
            System.out.println(Main.getCity(0).resources.toString());
            return;
        }
        switch (followingWords.get(0).toLowerCase()) {
            case "buy":
                System.out.println("The most you could buy of every item, without going into debt, is:");
                for (String item : economy.getItems()) {
                    System.out.println((int) (Math.floor(Main.getCity(0).resources.getMoney() / economy.getPrice(item))) + " " + item + ", for " + NumberFormat.getCurrencyInstance().format((int) (Math.floor(Main.getCity(0).resources.getMoney() / economy.getPrice(item))) * economy.getPrice(item)));
                }
                break;
            case "sell":
                break;
            case "construct":
                break;
            case "quit":
                break;
            case "load":
                break;
            case "save":
                break;
            case "help":
                break;
            case "status":
                break;
            case "money":
                NumberFormat n = NumberFormat.getCurrencyInstance();
                System.out.println("You have " + Main.getCity(0).resources.getFormattedMoney());
                break;
            case "food":
            case "stone":
            case "iron":
            case "steel":
            case "oil":
            case "coal":
            case "uranium":
            case "water":
            case "carbon":
                System.out.println("You have " + Main.getCity(0).resources.getItem(followingWords.get(0).toLowerCase()) + " " + followingWords.get(0).toLowerCase());
                break;
            default:
                System.out.println("Error 1.9.1: Topic not recognized");
                System.out.println();
                System.out.println("Defaulting to generic 'status' command...");
                System.out.println();
                System.out.println(Main.getCity(0).resources.toString());
        }
    }
}