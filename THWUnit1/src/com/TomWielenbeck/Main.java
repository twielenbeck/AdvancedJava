package com.TomWielenbeck;

/**
 * Created by Tom Wielenbeck
 */
public class Main {
    /**
     * THWUnit1 program iterates through 2 csv files (places.csv, stuff.csv) and returns the countries in either file,
     * the number of cities in each of those files, and how many items those countries make (Stuff).
     */

    private final static FileInput country = new FileInput("places.csv");
    private final static FileInput cities = new FileInput("places.csv");
    private final static FileInput stuff = new FileInput("stuff.csv");
    private static String cityHolder;
    private static String stuffHolder;



    /**
     * Main: <br>
     *     Main method iterates through places.csv, formats the output of the program,
     *     and closes the files upon completion.
     * @param args
     */

    public static void main(String[] args) {
        String[] fields;
        String placesHolder;
        //Array that stores the number of items found in each loop
        int[] nums = new int[2];
        boolean first = true;
        //Headers for the console
        System.out.format("%-22s %6s %5s\n","Country","Cities", "Stuff");
        System.out.format("%-22s %6s %5s\n","=======","======", "=====");
        //iterates through places.csv, splits and stores the fields
        while ((placesHolder = country.fileReadLine()) != null) {
            fields = placesHolder.split(",");
            citySearch(first, fields[0], nums);
            stuffSearch(first, fields[0], nums);
            first = false;
            //if statement to group Country column
            if(nums[0] != 0) {
                System.out.format("%-22s %6s %5s\n", fields[0], nums[0], nums[1]);
            }
        }
        country.fileClose();
        cities.fileClose();
        stuff.fileClose();
    }

    /**
     * citySearch: <br>
     *     citySearch iterates through the places CSV file to populate the nums array based on how many
     *     countries were matched in the file.
     * @param country String that stores the current iteration of the country
     * @param nums Array that stores the number of cities per country
     */
    public static void citySearch(boolean first, String country, int[] nums) {
        nums[0] = 0;
        String[] fields;
        boolean done = false;
        if(first) {
            cityHolder = cities.fileReadLine();
        }
        //Loop that splits by comma delimiter and stores as fields
        while ((cityHolder != null) && !(done)) {
            fields = cityHolder.split(",");
            //increment nums of the current iteration if the country matches
            if (fields[0].equals(country)) {
                nums[0]++;
                cityHolder = cities.fileReadLine();
            } else if (!(fields[0].equals(country))) {
                done = true;
            }
        }
    }

    /**
     * stuffSearch: <br>
     *     stuffSearch iterates through the stuff CSV file to populate the nums array based on how many
     *     countries were matched in the file.
     * @param country String that stores the current iteration of the country
     * @param nums Array that stores the number of stuff made per country
     */
    public static void stuffSearch(boolean first, String country, int[] nums) {
        nums[1] = 0;
        String[] fields;
        boolean done = false;
        if(first) {
            stuffHolder = stuff.fileReadLine();
        }
        //Loop that splits by comma delimiter and stores as fields
        while ((stuffHolder != null) && !(done)) {
            fields = stuffHolder.split(",");
            //increment nums of the current iteration if the country matches
            // Can't figure out why this if condition is never true; therefore, it is not being triggered.
            // If this were fixed the program would increment the Stuff column accurately.
            if (fields[0].equals(country)) {
                nums[1]++;
                stuffHolder = stuff.fileReadLine();
            } else if (!(fields[0].equals(country))) {
                done = true;
            }
        }
    }
}