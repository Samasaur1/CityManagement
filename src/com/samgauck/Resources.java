package com.samgauck;

public class Resources {
    private int money;
    private int food;
    public void setMoney(int money) {
        this.money = money;
    }
    public int getMoney() {
        return money;
    }
    public int getFood() {
        return food;
    }
    public void setFood(int food) {
        this.food = food;
    }

    public Resources() {
        this.setMoney(0);
        this.setFood(0);
    }
    public Resources(int money, int food) {
        this.setMoney(money);
        this.setFood(food);
    }
}
