package com.samgauck.CityManagement;

import java.text.NumberFormat;

/**
 * A class that hold all resources.
 */
public class Resources {
    /**
     * The number of resources in total.
     */
    private static final int numberOfResources = 10;
    /**
     * The money in this collection of resources.
     */
    private int money;
    /**
     * The food in this collection of resources.
     */
    private int food;
    /**
     * The stone in this collection of resources.
     */
    private int stone;
    /**
     * The iron in this collection of resources.
     */
    private int iron;
    /**
     * The steel in this collection of resources.
     */
    private int steel;
    /**
     * The oil in this collection of resources.
     */
    private int oil;
    /**
     * The coal in this collection of resources.
     */
    private int coal;
    /**
     * The uranium in this collection of resources.
     */
    private int uranium;
    /**
     * The water in this collection of resources.
     */
    private int water;
    /**
     * The carbon in this collection of resources.
     */
    private int carbon;
    /**
     * The bronze in this collection of resources.
     */
    private int bronze;

    public Resources() {
        this.setMoney(0);
        this.setFood(0);
        this.setStone(0);
        this.setIron(0);
        this.setSteel(0);
        this.setOil(0);
        this.setCoal(0);
        this.setUranium(0);
        this.setWater(0);
        this.setCarbon(0);
        this.setBronze(0);
    }

    public Resources(int money, int food, int stone, int iron, int steel, int oil, int coal, int uranium, int water, int carbon, int bronze) {
        this.setMoney(money);
        this.setFood(food);
        this.setStone(stone);
        this.setIron(iron);
        this.setSteel(steel);
        this.setOil(oil);
        this.setCoal(coal);
        this.setUranium(uranium);
        this.setWater(water);
        this.setCarbon(carbon);
        this.setBronze(bronze);
    }

    /**
     * Gets the total number of resources
     *
     * @return The number of resources that exist in the game.
     */
    public static int getNumberOfResources() {
        return numberOfResources;
    }

    /**
     * Gets the money of this collection of resources.
     *
     * @return The contained money.
     */
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Gets the money, formatted correctly.
     *
     * @return The formatted money.
     */
    public String getFormattedMoney() {
        return NumberFormat.getCurrencyInstance().format(getMoney());
    }

    /**
     * Gets the food of this collection of resources.
     *
     * @return The contained food.
     */
    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    /**
     * Gets the stone of this collection of resources.
     *
     * @return The contained stone.
     */
    public int getStone() {
        return stone;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }

    /**
     * Gets the iron of this collection of resources.
     *
     * @return The contained iron.
     */
    public int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }

    /**
     * Gets the steel of this collection of resources.
     *
     * @return The contained steel.
     */
    public int getSteel() {
        return steel;
    }

    public void setSteel(int steel) {
        this.steel = steel;
    }

    /**
     * Gets the oil of this collection of resources.
     *
     * @return The contained oil.
     */
    public int getOil() {
        return oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    /**
     * Gets the coal of this collection of resources.
     *
     * @return The contained coal.
     */
    public int getCoal() {
        return coal;
    }

    public void setCoal(int coal) {
        this.coal = coal;
    }

    /**
     * Gets the uranium of this collection of resources.
     *
     * @return The contained uranium.
     */
    public int getUranium() {
        return uranium;
    }

    public void setUranium(int uranium) {
        this.uranium = uranium;
    }

    /**
     * Gets the water of this collection of resources.
     *
     * @return The contained water.
     */
    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    /**
     * Gets the carbon of this collection of resources.
     *
     * @return The contained carbon.
     */
    public int getCarbon() {
        return carbon;
    }

    public void setCarbon(int carbon) {
        this.carbon = carbon;
    }

    /**
     * Gets the bronze of this collection of resources.
     *
     * @return The contained bronze.
     */
    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    /**
     * Gets the amount of a given item.
     *
     * @param item The item of which the amount has been requested.
     * @return The amount of the given item.
     */
    public int getItem(String item) {
        switch (item) {
            case "food":
                return getFood();
            case "stone":
                return getStone();
            case "iron":
                return getIron();
            case "steel":
                return getSteel();
            case "oil":
                return getOil();
            case "coal":
                return getCoal();
            case "uranium":
                return getUranium();
            case "water":
                return getWater();
            case "carbon":
                return getCarbon();
            case "bronze":
                return getBronze();
            default:
                return getFood();
        }
    }

    /**
     * Sets a given item to a given amount.
     *
     * @param item   The item to set to the amount.
     * @param amount The amount to set the item to.
     */
    public void setItem(String item, int amount) {
        switch (item) {
            case "food":
                setFood(amount);
                break;
            case "stone":
                setStone(amount);
                break;
            case "iron":
                setIron(amount);
                break;
            case "steel":
                setSteel(amount);
                break;
            case "oil":
                setOil(amount);
                break;
            case "coal":
                setCoal(amount);
                break;
            case "uranium":
                setUranium(amount);
                break;
            case "water":
                setWater(amount);
                break;
            case "carbon":
                setCarbon(amount);
                break;
            case "bronze":
                setBronze(amount);
                break;
            default:
                setFood(amount);
        }
    }

    public void setAll(int money, int food, int stone, int iron, int steel, int oil, int coal, int uranium, int water, int carbon, int bronze) {
        this.setMoney(money);
        this.setFood(food);
        this.setStone(stone);
        this.setIron(iron);
        this.setSteel(steel);
        this.setOil(oil);
        this.setCoal(coal);
        this.setUranium(uranium);
        this.setWater(water);
        this.setCarbon(carbon);
        this.setBronze(bronze);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Money: ").append(NumberFormat.getCurrencyInstance().format(money)).append("\n");
        s.append("Food: ").append(food).append("\n");
        s.append("Stone: ").append(stone).append("\n");
        s.append("Iron: ").append(iron).append("\n");
        s.append("Steel: ").append(steel).append("\n");
        s.append("Oil: ").append(oil).append("\n");
        s.append("Coal: ").append(coal).append("\n");
        s.append("Uranium: ").append(uranium).append("\n");
        s.append("Water: ").append(water).append("\n");
        s.append("Carbon: ").append(carbon).append("\n");
        s.append("Bronze: ").append(bronze).append("\n");
        return s.toString();
    }

    /**
     * Gets a string that is optomized for saving.
     *
     * @return The resources in a string formatted 0§0§0§0§0§0§0§0§0§0
     */
    public String saveableString() {
        StringBuilder s = new StringBuilder();
        s.append(money).append("§");
        s.append(food).append("§");
        s.append(stone).append("§");
        s.append(iron).append("§");
        s.append(steel).append("§");
        s.append(oil).append("§");
        s.append(coal).append("§");
        s.append(uranium).append("§");
        s.append(water).append("§");
        s.append(carbon).append("§");
        s.append(bronze);
        return s.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Resources other = (Resources) obj;
        if (this.getMoney() != other.getMoney()) return false;
        if (this.getFood() != other.getFood()) return false;
        if (this.getStone() != other.getStone()) return false;
        if (this.getIron() != other.getIron()) return false;
        if (this.getSteel() != other.getSteel()) return false;
        if (this.getOil() != other.getOil()) return false;
        if (this.getCoal() != other.getCoal()) return false;
        if (this.getUranium() != other.getUranium()) return false;
        if (this.getWater() != other.getWater()) return false;
        if (this.getCarbon() != other.getCarbon()) return false;
        return this.getBronze() == other.getBronze();
    }

    /**
     * A method that determines whether or not one Resources is a superset of another.
     * Can be used to determine whether one Resources can be payed by another.
     *
     * @param other The Resources that is (potentially) smaller.
     * @return Whether or not the given Resources is a subset of the calling one.
     */
    public boolean encompasses(Resources other) {
        if (getMoney() < other.getMoney()) return false;
        if (getFood() < other.getFood()) return false;
        if (getStone() < other.getStone()) return false;
        if (getIron() < other.getIron()) return false;
        if (getSteel() < other.getSteel()) return false;
        if (getOil() < other.getOil()) return false;
        if (getCoal() < other.getCoal()) return false;
        if (getUranium() < other.getUranium()) return false;
        if (getWater() < other.getWater()) return false;
        if (getBronze() < other.getBronze()) return false;
        return getCarbon() >= other.getCarbon();
    }

    /**
     * An alias for the {@link #encompasses(Resources) encompasses} method.
     *
     * @param other The Resources that is (potentially) smaller.
     * @return Whether or not the given Resources is a subset of the calling one.
     */
    public boolean greaterThanOrEqualTo(Resources other) {
        return encompasses(other);
    }

    /**
     * An alias for the {@link #encompasses(Resources) encompasses} method.
     *
     * @param other The Resources that is (potentially) smaller.
     * @return Whether or not the given Resources is a subset of the calling one.
     */
    public boolean gte(Resources other) {
        return encompasses(other);
    }

    /**
     * An alias for the {@link #encompasses(Resources) encompasses} method.
     *
     * @param other The Resources that is (potentially) smaller.
     * @return Whether or not the given Resources is a subset of the calling one.
     */
    public boolean isSupersetOf(Resources other) {
        return encompasses(other);
    }

    /**
     * Multiplies every resources in the Resources by the given quantity.
     * <p>
     * This method mutates the Resources itself and returns void.
     *
     * @param quantity The quantity to multiply by.
     */
    public void multiplyBy(int quantity) {
        setAll(getMoney() * quantity, getFood() * quantity, getStone() * quantity,
                getIron() * quantity, getSteel() * quantity, getOil() * quantity,
                getCoal() * quantity, getUranium() * quantity, getWater() * quantity,
                getCarbon() * quantity, getBronze() * quantity);
    }

    /**
     * Returns a new Resources object with all its values equal to this Resources' values times the given quantity.
     * <p>
     * This method does not change the caller, creating a new Resources and returning that.
     *
     * @param quantity The quantity to multiply by.
     * @return A new Resources with all its values multiplied by the given quantity.
     */
    public Resources multipliedBy(int quantity) {
        return new Resources(getMoney() * quantity, getFood() * quantity, getStone() * quantity,
                getIron() * quantity, getSteel() * quantity, getOil() * quantity,
                getCoal() * quantity, getUranium() * quantity, getWater() * quantity,
                getCarbon() * quantity, getBronze() * quantity);
    }

    /**
     * Subtracts the given Resources from this Resources. This method mutates the caller.
     *
     * @param amount The Resources to subtract from the caller.
     */
    public void subtract(Resources amount) {
        setAll(getMoney() - amount.getMoney(), getFood() - amount.getFood(), getStone() - amount.getStone(),
                getIron() - amount.getIron(), getSteel() - amount.getSteel(), getOil() - amount.getOil(),
                getCoal() - amount.getCoal(), getUranium() - amount.getUranium(), getWater() - amount.getWater(),
                getCarbon() - amount.getCarbon(), getBronze() - amount.getBronze());
    }

    /**
     * Returns a new Resources object with all its values equal to this Resources' values minus the given Resources.
     * <p>
     * This method does not change the caller, creating a new Resources and returning that.
     *
     * @param other The Resources to subtract.
     * @return A new Resources equal to this Resources' values minus the given one's.
     */
    public Resources difference(Resources other) {
        return new Resources(getMoney() - other.getMoney(), getFood() - other.getFood(), getStone() - other.getStone(),
                getIron() - other.getIron(), getSteel() - other.getSteel(), getOil() - other.getOil(),
                getCoal() - other.getCoal(), getUranium() - other.getUranium(), getWater() - other.getWater(),
                getCarbon() - other.getCarbon(), getBronze() - other.getBronze());
    }
}