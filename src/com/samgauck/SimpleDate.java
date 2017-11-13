package com.samgauck;

public class SimpleDate {
    private int dayOfMonth;
    private int year;
    private Month month;

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public SimpleDate(int month, int day, int year){
        this.dayOfMonth = day;
        this.year = year;
        switch (month) {
            case 1:
                this.month = Month.JAN;
                break;
            case 2:
                this.month = Month.FEB;
                break;
            case 3:
                this.month = Month.MAR;
                break;
            case 4:
                this.month = Month.APR;
                break;
            case 5:
                this.month = Month.MAY;
                break;
            case 6:
                this.month = Month.JUN;
                break;
            case 7:
                this.month = Month.JUL;
                break;
            case 8:
                this.month = Month.AUG;
                break;
            case 9:
                this.month = Month.SEP;
                break;
            case 10:
                this.month = Month.OCT;
                break;
            case 11:
                this.month = Month.NOV;
                break;
            case 12:
                this.month = Month.DEC;
                break;
            default:
                this.month = Month.JAN;
        }
    }

    @Override
    public String toString() {
        return month + " " + dayOfMonth + ", " + year;
    }
}