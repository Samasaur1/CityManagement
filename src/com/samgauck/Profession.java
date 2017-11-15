package com.samgauck;

/**
 * A enum that represents a job (profession).
 */
public enum Profession {
    FARMER, BLACKSMITH, JOBLESS;

    @Override
    public String toString() {
        return super.toString().substring(0, 1).toUpperCase() + super.toString().substring(1).toLowerCase();
    }
}
