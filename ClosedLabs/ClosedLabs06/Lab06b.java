/**
   This program reads strings from the user
   and test whether the string is a palindrome

   @author: Minrui (Wally) Yang
   @version: 20160929
*/
import java.util.Scanner;

public class Lab06b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = in.nextLine();
        while (str.length() > 0) {
            int length = str.length();
            int halfLength = str.length() / 2;
            boolean isPalindrome = true;
            for (int i = 0; i < halfLength; i++) {
                if (str.charAt(i) != str.charAt(length-1-i)) {
                    isPalindrome = false;
                }
            }
            if (isPalindrome) {
                System.out.println(str + " is a palindrome.");
            }
            else {
                System.out.println(str + " is NOT a palindrome.");
            }

            System.out.print("\nEnter a string: ");
            str = in.nextLine();
        }
        System.out.println("Empty line read - Goodbye!");
    }
}
