package com.samgauck.CityManagement.DateManagement;

/**
 * This is, for lack of a better word, a wrapper for the Month enum, that allows access to the base enum and also hold the number of days in the month.
 */
public class MonthClass {
    /**
     * The month of this MonthClass.
     */
    private Month month;
    /**
     * The number of days in this month.
     */
    private int numberOfDays;

    /**
     * Creates a new MonthClass that represents the given month.
     *
     * @param m The month that this MonthClass should represent.
     */
    public MonthClass(Month m) {
        setMonth(m);
        numberOfDays = getNumberOfDays(m);
    }

    /**
     * Gives the number of days in a month.
     *
     * @param m The month whose number of days you want.
     * @return An int that is the number of days in the month.
     */
    private static int getNumberOfDays(Month m) {
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

    /**
     * Gets the number of days from the private variable.
     *
     * @return The number of days in a month, and int.
     */
    public int getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * Returns the underlying Month enum.
     *
     * @return A Month enum.
     */
    public Month getMonth() {
        return month;
    }

    /**
     * Sets the month and updates the number of days.
     *
     * @param month A Month enum that represents the new month.
     */
    public void setMonth(Month month) {
        this.month = month;
        setNumberOfDays(getNumberOfDays(this.month));
    }

    /**
     * Sets the number of days.
     *
     * @param numberOfDays The new number of days.
     */
    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    /**
     * Returns the month as a string, without the number of days.
     *
     * @return A correctly capitalized string representation of a month.
     */
    @Override
    public String toString() {
        return month.toString();
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
        MonthClass other = (MonthClass) obj;
        if (this.getNumberOfDays() != other.getNumberOfDays()) return false;
        return this.getMonth().equals(other.getMonth());
    }
}