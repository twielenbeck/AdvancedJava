package com.TomWielenbeck;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Tom Wielenbeck
 * Create a program that reads the files: date_diff.csv.
 * The program should read all of the records and calculate the number of days
 * between the two dates and print out the number of days,
 * and then translate it into years, months and days.
 * When the file is finished, list the number of dates that start in each month with the number.
 */

public class Main {
    /**
     * @param dateFile reads date_diff.csv
     */
    private final static FileInput dateFile = new FileInput("date_diff.csv");

    /**
     * Main: <br>
     *     Parses through date_diff.csv and stores the file under the String dateHolder. It then runs through dateHolder
     *     and trims unnecessary characters, and loop splits each line into a 2-dimensional array (String fields[]).
     *     Once the fields[] has it's 2 values it trims the remaining unnecessary characters and is formatted for
     *     Date data types: date1, and date2. Since the file has only 2 formats for dates it will check which format
     *     it is and parses it accordingly. Using Date.getTime() method it converts each field item into milliseconds
     *     and are subtracted from each other. The milliseconds are converted into the corresponding time frames and
     *     displayed in the output.
     *
     *     The month is then pulled out of date1/date2 and stored as month1/month2. 1 is added to each month to better
     *     correspond to the actual Gregorian calendar representation of each month. Counters c1 through c12 are
     *     incremented based on each occurrence of the months that were in the date_diff.csv file. The file is
     *     then closed and the number of occurrences are then displayed in the output.
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        /**
         * @param fields Two dimensional array of strings that holds the first and second cell in the csv that
         *               represents 1 row in date_diff.csv.
         * @param dateHolder String that holds date_diff.csv as one long String to be parsed through.
         * @param date1 Date data type that holds the date value of fields[0].
         * @param date2 Date data type that holds the date value of fields[1].
         * @param c1 int counter for January.
         * @param c2 int counter for February.
         * @param c3 int counter for March.
         * @param c4 int counter for April.
         * @param c5 int counter for May.
         * @param c6 int counter for June.
         * @param c7 int counter for July.
         * @param c8 int counter for August.
         * @param c9 int counter for September.
         * @param c10 int counter for October.
         * @param c11 int counter for November.
         * @param c12 int counter for December.
         * @param df1 SimpleDateFormat object for Day-Month-Year
         * @param df2 SimpleDateFormat object for Month Day, Year
         * @param diff long milliseconds of date2 subtracted from milliseconds of date1
         * @param totalDays Total amount of days diff
         * @param years The amount of years in totalDays
         * @param months The amount of months in totalDays that remain after years are taken out
         * @param days The amount of days in totalDays after years and months are taken out
         * @param month1 int used to grab the month value out of date1 (1 is added to match the value of the month).
         * @param month2 int used to grab the month value out of date2 (1 is added to match the value of the month).
         */
        String[] fields;
        String dateHolder;
        Date date1, date2;
        int c1=0, c2=0, c3=0, c4=0, c5=0, c6=0, c7=0, c8=0, c9=0, c10=0, c11=0, c12=0;
        SimpleDateFormat df1 = new SimpleDateFormat("dd-MMM-yy");
        SimpleDateFormat df2 = new SimpleDateFormat("MMM dd, yyyy");
        System.out.format("%9s %9s %9s %9s\n","Total Days","Years", "Months", "Days");
        System.out.format("%9s %9s %9s %9s\n","==========","=====", "======", "====");
        while ((dateHolder = dateFile.fileReadLine()) != null) {
            if(dateHolder.contains(".")) {
                dateHolder = dateHolder.replace(".", "").trim();
            }
            if(dateHolder.startsWith("\"")) {
                fields = dateHolder.split("\",", 2);
            }
            else {
                fields = dateHolder.split(",", 2);
            }
            fields[0] = fields[0].replace("\"", "");
            fields[1] = fields[1].replace("\"", "");

            if(fields[0].contains("-"))date1 = df1.parse(fields[0]);
            else date1 = df2.parse(fields[0]);

            if(fields[1].contains("-")) date2 = df1.parse(fields[1]);
            else date2 = df2.parse(fields[1]);

            long diff = Math.abs(date1.getTime() - date2.getTime());
            long totalDays = diff / (1000 * 60 * 60 * 24);
            long years = totalDays / 365;
            long months = (long) Math.floor((totalDays % 365) / 30.4167);
            long days = (long) Math.floor((totalDays % 365) % 30.4167);

            System.out.format("%-9d %9d %9d %9d\n", totalDays, years, months, days);

            /**
             * Justification paragraph:
             * I chose to use the Date.getMonth() method to retrieve an int value and assign it to month1/month2.
             * This is because I already had a variable used to parse through the while loop already. It was less effort
             * to use the tools I had already built to complete the first act of this assignment. I then used counters
             * for each month to display the amount of occurrences that came upon each month throughout the parsing of
             * the date_diff.csv file.
             */
            int month1 = date1.getMonth() + 1;
            int month2 = date2.getMonth() + 1;
            if (month1 == 1 || month2 == 1) c1++;
            if (month1 == 2 || month2 == 2) c2++;
            if (month1 == 3 || month2 == 3) c3++;
            if (month1 == 4 || month2 == 4) c4++;
            if (month1 == 5 || month2 == 5) c5++;
            if (month1 == 6 || month2 == 6) c6++;
            if (month1 == 7 || month2 == 7) c7++;
            if (month1 == 8 || month2 == 8) c8++;
            if (month1 == 9 || month2 == 9) c9++;
            if (month1 == 10 || month2 == 10) c10++;
            if (month1 == 11 || month2 == 11) c11++;
            if (month1 == 12 || month2 == 12) c12++;
        }
        dateFile.fileClose();

        System.out.println("===============");
        System.out.println("Jan " + c1);
        System.out.println("Feb " + c2);
        System.out.println("Mar " + c3);
        System.out.println("Apr " + c4);
        System.out.println("May " + c5);
        System.out.println("Jun " + c6);
        System.out.println("Jul " + c7);
        System.out.println("Aug " + c8);
        System.out.println("Sep " + c9);
        System.out.println("Oct " + c10);
        System.out.println("Nov " + c11);
        System.out.println("Dec " + c12);
    }
}
