package com.samgauck;

public enum Sex {
    MALE, FEMALE;

    @Override
    public String toString() {
        return super.toString().substring(0, 1).toUpperCase() + super.toString().substring(1).toLowerCase();
    }
}
