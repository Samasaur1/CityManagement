package com.samgauck;

import java.text.NumberFormat;

/**
 * A class that hold all resources.
 */
public class Resources {
    private int money;
    private int food;
    private int stone;
    private int iron;
    private int steel;
    private int oil;
    private int coal;
    private int uranium;
    private int water;
    private int carbon;
    public int getMoney() {
        return money;
    }
    public int getFood() { return food; }
    public int getStone() { return stone; }
    public int getIron() { return iron; }
    public int getSteel() { return steel; }
    public int getOil() { return oil; }
    public int getCoal() { return coal; }
    public int getUranium() { return uranium; }
    public int getWater() { return water; }
    public int getCarbon() { return carbon; }
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
            default:
                return getFood();
        }
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public void setFood(int food) {
        this.food = food;
    }
    public void setStone(int stone) { this.stone = stone; }
    public void setIron(int iron) { this.iron = iron; }
    public void setSteel(int steel) { this.steel = steel; }
    public void setOil(int oil) { this.oil = oil; }
    public void setCoal(int coal) { this.coal = coal; }
    public void setUranium(int uranium) { this.uranium = uranium; }
    public void setWater(int water) { this.water = water; }
    public void setCarbon(int carbon) { this.carbon = carbon; }
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
            default:
                setFood(amount);
        }
    }
    public void setAll(int money, int food, int stone, int iron, int steel, int oil, int coal, int uranium, int water, int carbon) {
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
    }

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
    }
    public Resources(int money, int food, int stone, int iron, int steel, int oil, int coal, int uranium, int water, int carbon) {
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
        return s.toString();
    }
    public String simpleString() {
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
        s.append(carbon);
        return s.toString();
    }
}
