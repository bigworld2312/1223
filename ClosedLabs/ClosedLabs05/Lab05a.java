/**
   This program reads a string and count the digits in the
   string, then print the count on the screen

   @author: Minrui (Wally) Yang
   @version: 20160922
 */
import java.util.Scanner;

public class Lab05a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string to count the digits in: ");
        String str = in.nextLine();
        int countDigit = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                countDigit++;
            }
        }
        System.out.println("Your string contains " + countDigit + " digits.");
    }
}
