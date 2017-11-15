package com.samgauck.DateManagement;

import com.samgauck.Utilities;

/**
 * A three-letter enum representation of a month.
 */
public enum Month {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;

    @Override
    public String toString() {
        return Utilities.capitailze(super.toString());
    }
}
