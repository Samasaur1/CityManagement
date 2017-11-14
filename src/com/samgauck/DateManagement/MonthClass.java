package com.samgauck.DateManagement;

/**
 * This is, for lack of a better word, a wrapper for the Month enum, that allows access to the base enum and also hold the number of days in the month.
 */
public class MonthClass {
    private Month month;
    private int numberOfDays;
    public MonthClass(Month m) {
        setMonth(m);
        numberOfDays = this.getNumberOfDays(m);
    }
    private int getNumberOfDays(Month m) {
        switch (m) {
            case JAN:
                return 31;
            case FEB:
                return 28;
            case MAR:
                return 31;
            case APR:
                return 30;
            case MAY:
                return 31;
            case JUN:
                return 30;
            case JUL:
                return 31;
            case AUG:
                return 31;
            case SEP:
                return 30;
            case OCT:
                return 31;
            case NOV:
                return 30;
            case DEC:
                return 31;
            default:
                return 31;
        }
    }
    public int getNumberOfDays() {
        return numberOfDays;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
        setNumberOfDays(getNumberOfDays(this.month));
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    @Override
    public String toString() {
        return month.toString();
    }
}
