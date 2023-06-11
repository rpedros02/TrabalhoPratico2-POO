/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Models;


import Controllers.ShipController;
import Exceptions.InvalidDateException;

import java.io.Serializable;
import java.time.Year;
import java.util.Scanner;

public class Date implements Serializable {
    public int day;
    public int month;
    public int year;

    /**
     * Date Constructor.
     *
     * @param day   → Date Day - Int
     * @param month → Date Month - Int
     * @param year  → Date Year - Int
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Verifies the Date by checking if the number of days matches the given month.
     * Also calls the method {@link Date#isLeap(int year)} to check if the year is Leap.
     *
     * @param day   → Given Day - Int
     * @param month → Given Month - Int
     * @param year  → Given Year - Int
     * @return true if the Date is valid, otherwise false.
     */
    private static boolean isValid(int day, int month, int year) {
        boolean flag = false;
        if (year < 1900 || year > Year.now().getValue()) {
            return false;
        }
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                if (day > 0 && day <= 31) {
                    flag = true;
                }
            }
            case 4, 6, 9, 11 -> {
                if (day > 0 && day <= 30) {
                    flag = true;
                }
            }
            case 2 -> {
                if (isLeap(year)) {
                    if (day > 0 && day <= 29) {
                        flag = true;
                    }
                } else {
                    if (day > 0 && day <= 28) {
                        flag = true;
                    }
                }
            }
            default -> {
            }
        }
        return flag;
    }


    /**
     * Checks if the given Year is Leap.
     *
     * @param year → Given Year - Int
     * @return true if the Year is leap, false otherwise.
     */
    private static boolean isLeap(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }


    /**
     * Creates a new {@link Date} instance.
     *
     * @param label Label to use on the input label;
     * @return the new Date.
     * @throws InvalidDateException in case the isn't valid.
     */
    public static Date newDate(String label) throws InvalidDateException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Day of " + label);
        int day = (int) ShipController.getOption(sc);
        System.out.print("Month of " + label);
        int month = (int) ShipController.getOption(sc);
        System.out.print("Year of " + label);
        int year = (int) ShipController.getOption(sc);
        if (isValid(day, month, year)) {
            return new Date(day, month, year);
        } else {
            throw new InvalidDateException("Invalid Date.");
        }

    }

    /**
     * Override Method toString.
     *
     * @return Date in <b>dd/mm/YYYY</b> format.
     */
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
