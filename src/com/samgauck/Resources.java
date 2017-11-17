package com.samgauck;

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
    public int getFood() {
        return food;
    }
    public int getStone() { return stone; }
    public int getIron() { return iron; }
    public int getSteel() { return steel; }
    public int getOil() { return oil; }
    public int getCoal() { return coal; }
    public int getUranium() { return uranium; }
    public int getWater() { return water; }
    public int getCarbon() { return carbon; }

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
}
