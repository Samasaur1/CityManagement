package com.samgauck;

public enum Sex {
    MALE, FEMALE;

    @Override
    public String toString() {
        return Utilities.capitailze(super.toString());
    }
}
