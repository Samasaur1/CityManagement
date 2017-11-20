package com.samgauck.DateManagement;

import static com.samgauck.DateManagement.Month.*;

/**
 * SimpleDate holds a day, month and year. Day and year are ints, while the month is a MonthClass.
 */
public class SimpleDate {
    private int dayOfMonth;
    private int year;
    private MonthClass month;

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month.getMonth();
    }

    public SimpleDate(int month, int day, int year){
        this.dayOfMonth = day;
        this.year = year;
        this.month = new MonthClass(this.numberToMonth(month));
    }

    /**
     * Takes an int, 1-12 and converts it to a month. Default is JAN.
     * @param n The number of the month.
     * @return The month represented by the number.
     */
    private Month numberToMonth(int n) {
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
     * @param m The month.
     * @return The number of the month.
     */
    private int monthToNumber(Month m) {
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
     * @param old The original date.
     * @return A new date one day later.
     */
    public SimpleDate nextDay(SimpleDate old) {
        old.dayOfMonth += 1;
        if (old.dayOfMonth > old.month.getNumberOfDays()) {
            old.dayOfMonth = 1;
            old.month.setMonth(this.numberToMonth(old.monthToNumber(old.month.getMonth()) + 1));
        }
        return old;
    }

    /**
     * Converts a date to a string with format Jan 1, 2017.
     * @return A string formatted Jan 1, 2017.
     */
    @Override
    public String toString() {
        return month + " " + dayOfMonth + ", " + year;
    }
    public String simpleString() {
        StringBuilder s = new StringBuilder();
        s.append(monthToNumber(getMonth())).append("§").append(getDayOfMonth()).append("§").append(getYear());
        return s.toString();
    }
}