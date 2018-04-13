package com.samgauck.CityManagement.DateManagement;

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

    public void setDate(int month, int dayOfMonth, int year) {
        this.dayOfMonth = dayOfMonth;
        this.month = new MonthClass(numberToMonth(month));
        this.year = year;
    }

    /**
     * Takes an int, 1-12 and converts it to a month. Default is JAN.
     * @param n The number of the month.
     * @return The month represented by the number.
     */
    private Month numberToMonth(int n) {
        switch (n) {
            case 1:
                return Month.JAN;
            case 2:
                return Month.FEB;
            case 3:
                return Month.MAR;
            case 4:
                return Month.APR;
            case 5:
                return Month.MAY;
            case 6:
                return Month.JUN;
            case 7:
                return Month.JUL;
            case 8:
                return Month.AUG;
            case 9:
                return Month.SEP;
            case 10:
                return Month.OCT;
            case 11:
                return Month.NOV;
            case 12:
                return Month.DEC;
            default:
                return Month.JAN;
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