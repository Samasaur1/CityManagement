package com.samgauck.CityManagement.DateManagement;

import static com.samgauck.CityManagement.DateManagement.Month.*;

/**
 * SimpleDate holds a day, month and year. Day and year are ints, while the month is a MonthClass.
 */
public class SimpleDate {
    /**
     * The day of the month it is (e.g. on August 22, this would be 22).
     */
    private int dayOfMonth;
    /**
     * The year of this date.
     */
    private int year;
    /**
     * The month of this date.
     */
    private MonthClass month;

    /**
     * Gets the day of the month.
     *
     * @return The day of the month.
     */
    public int getDayOfMonth() {
        return dayOfMonth;
    }

    /**
     * Gets the year.
     *
     * @return The year of this date.
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets the month (not the MonthClass) of this date.
     *
     * @return The month of this date.
     */
    public Month getMonth() {
        return month.getMonth();
    }

    /**
     * Creates a new date with the specified month, day, and year.
     *
     * @param month The month of the new date, as an Integer (1-12).
     * @param day   The day of the month of the new date, as an Integer.
     * @param year  The year of the new date, as an Integer.
     */
    public SimpleDate(int month, int day, int year) {
        this.setDate(month, day, year);
    }

    /**
     * Creates a new date that is the same date as the given one.
     *
     * @param date The date to use as a reference.
     */
    public SimpleDate(SimpleDate date) {
        this.setDate(date);
    }

    /**
     * Sets the date to the specified month, day, and year
     *
     * @param month The month of the new date, as an Integer (1-12).
     * @param day   The day of the month of the new date, as an Integer.
     * @param year  The year of the new date, as an Integer.
     */
    public void setDate(int month, int day, int year) {
        this.dayOfMonth = day;
        this.month = new MonthClass(numberToMonth(month));
        this.year = year;
    }

    /**
     * Sets the date to the same as the given one.
     *
     * @param newDate The date to use as a reference.
     */
    public void setDate(SimpleDate newDate) {
        this.setDate(monthToNumber(newDate.getMonth()), newDate.getDayOfMonth(), newDate.getYear());
    }

    /**
     * Takes an int, 1-12 and converts it to a month. Default is JAN.
     *
     * @param n The number of the month.
     * @return The month represented by the number.
     */
    private static Month numberToMonth(int n) {
        switch (n) {
            case 1:
                return JAN;
            case 2:
                return FEB;
            case 3:
                return MAR;
            case 4:
                return APR;
            case 5:
                return MAY;
            case 6:
                return JUN;
            case 7:
                return JUL;
            case 8:
                return AUG;
            case 9:
                return SEP;
            case 10:
                return OCT;
            case 11:
                return NOV;
            case 12:
                return DEC;
            default:
                return JAN;
        }
    }

    /**
     * Inputs a Month and converts it to an int representing that month. Default is 1 (JAN).
     *
     * @param m The month.
     * @return The number of the month.
     */
    private static int monthToNumber(Month m) {
        switch (m) {
            case JAN:
                return 1;
            case FEB:
                return 2;
            case MAR:
                return 3;
            case APR:
                return 4;
            case MAY:
                return 5;
            case JUN:
                return 6;
            case JUL:
                return 7;
            case AUG:
                return 8;
            case SEP:
                return 9;
            case OCT:
                return 10;
            case NOV:
                return 11;
            case DEC:
                return 12;
            default:
                return 1;
        }
    }

    /**
     * Returns a date one day after the inputted date.
     *
     * @param old The original date.
     * @return A new date one day later.
     */
    public static SimpleDate nextDay(SimpleDate old) {
        int m = monthToNumber(old.getMonth());
        int d = old.getDayOfMonth() + 1;
        int y = old.getYear();
        if (old.getDayOfMonth() > old.month.getNumberOfDays()) {
            d = 1;
            m += 1;
            if (m == 13) {
                m = 1;
                y += 1;
            }
        }
        return new SimpleDate(m, d, y);
//        old.dayOfMonth += 1;
//        if (old.getDayOfMonth() > old.month.getNumberOfDays()) {
//            old.dayOfMonth = 1;
//            int newMonth = monthToNumber(old.getMonth()) + 1;
//            int newYear = old.getYear();
//            while (newMonth > 12) {
//                newMonth -= 12;
//                newYear += 1;
//            }
//            old.setDate(newMonth, old.getDayOfMonth(), newYear);
//        }
//        return old;
    }

    /**
     * Changes the date to a date one day in the future (from this date).
     */
    public void proceedOneDay() {
        this.setDate(nextDay(this));
    }

    /**
     * Converts a date to a string with format Jan 1, 2017.
     *
     * @return A string formatted Jan 1, 2017.
     */
    @Override
    public String toString() {
        return month + " " + dayOfMonth + ", " + year;
    }

    /**
     * Converts a date to a string that is easily saved.
     *
     * @return A string formatted 1§1§2017.
     */
    public String saveableString() {
        return String.valueOf(monthToNumber(getMonth())) + "§" + getDayOfMonth() + "§" + getYear();
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
        SimpleDate other = (SimpleDate) obj;
        if (this.getDayOfMonth() != other.getDayOfMonth()) return false;
        if (this.getYear() != other.getYear()) return false;
        return this.month.equals(other.month);
    }
}