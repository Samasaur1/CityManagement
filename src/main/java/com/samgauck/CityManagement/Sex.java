package com.samgauck.CityManagement;
import com.gauck.sam.Utilities.*;

/**
 * A enum representation of a sex (not a gender).
 */
public enum Sex {
    MALE, FEMALE;

    /**
     * Returns the sex as a string, capitalized (e.g. Male).
     *
     * @return A correctly capitalized string representation of a sex.
     */
    @Override
    public String toString() {
        return Utilities.capitalize(super.toString());
    }
}