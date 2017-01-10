/**
 * ClosedLab01c.java
 * A simple program accept a name and a number as inputs
 * Ouput the greeting message and the number with its squared and cubed
 *
 * Successfully outputed
 * Same
 * @author Minrui Yang
 * @version 20160825
 *
 */
package osu.cse1223;

import java.util.Scanner;

public class ClosedLab01c {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String myName = keyboard.nextLine();
        System.out.print("Enter a whole number: ");
        int number = keyboard.nextInt();
        System.out.println("Hello " + myName);
        System.out.println("Your number is: " + number);
        System.out.println("The number square is: " + (number * number));
        int cubed = number * number * number;
        System.out.println("The number cubed is: " + cubed);
    }
}
