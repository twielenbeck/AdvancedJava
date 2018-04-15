
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlombardo
 */
public class StartCopying {
    public static void main(String[] args) {
        StartCopying sc = new StartCopying();
        String input = sc.readln();
        sc.writeln(input);
    }

    public String readln() {
        System.out.println("Please enter some text, then press return:");

        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public void writeln( String line ) {
            System.out.println("Here is the text you entered, which I've copied below.");
            System.out.println( line );
    }

}
