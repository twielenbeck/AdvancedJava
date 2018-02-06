package us.mattgreen;

import java.util.Scanner;

public class Main {
    private static String line ="";
    private static String rating ="";
    private final static FileInput cardAccts = new FileInput("movie_cards.csv");
    private final static FileInput cardPurchases = new FileInput("movie_purchases.csv");
    private final static FileInput movieRatings = new FileInput("movie_rating.csv");
    private static Scanner keyboard = new Scanner(System.in);
    //call another file
    public static void main(String[] args) {
        String line;
        String[] fields;
        int[] nums = new int[2];
        int[] num = new int[2];
        System.out.format("%8s  %-18s %6s %6s %6s\n","Account","Name", "Movies", "Points", "Ratings");
        boolean first = true;
        while ((line = cardAccts.fileReadLine()) != null) {
            fields = line.split(",");
            findPurchases(first,fields[0], nums);
            findScores(first,fields[0], num);
            first = false;
            System.out.format("00%6s  %-18s  %2d   %4d    %4d\n",fields[0],fields[1], nums[0], nums[1], num[1]);
        }
    }

    //almost identical method
    public static void findPurchases(boolean first, String acct, int[] nums) {
        nums[0] = 0;
        nums[1] = 0;
        String[] fields;
        boolean done = false;
        if (first){
            line = cardPurchases.fileReadLine();
        }
        while ((line != null) && !(done)) {
            fields = line.split(",");
            if (fields[0].compareTo(acct) > 0) {
                done = true;
            }
            else if (fields[0].equals(acct)) {
                nums[0]++;
                nums[1] += Integer.parseInt(fields[2]);
                line = cardPurchases.fileReadLine();
            }
        }
    }
    public static void findScores(boolean first, String acct, int[] num) {
        int count = 0;
        num[0] = 0;
        num[1] = 0;
        String[] fields;
        boolean done = false;
        if (first){
            rating = movieRatings.fileReadLine();
        }
        while ((rating != null) && !(done)) {
            fields = rating.split(",");
            if (fields[0].compareTo(acct) > 0) {
                if (count != 0) {
                    num[1] = num[1] / count;
                }
                done = true;
            }
            else if (fields[0].equals(acct)) {
                num[0]++;
                num[1] += Integer.parseInt(fields[1]);
                count++;
                rating = movieRatings.fileReadLine();
            }
        }
    }
}