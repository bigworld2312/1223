/**
   This program ask for a long string and a substring for input
   and displays several information about the substring and the long string
   then prompt the user for a position number and a replacement string,
   the program will then print the char at the number and the string
   after replaced with the replacement string.

   @author: Minrui Yang, Wally
   @version: 20160907

   -*- EXTRA CREDIT -*-
   The code kept executing normally but the position reported -1,
   and the substring method throws an Exception because it reads the argument -1,
   and got out of the bounds of the string.

   Line 49 of my code caused the error. I should make a test about wether the indexOf
   method return the normal output, if not, program should terminate or prompt another
   input from the user.
*/
import java.util.Scanner;

public class Project02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String longStr = "";
        String subStr = "";

        // Prompt the user for the long string and the substring.

        System.out.print("Enter a long string: ");
        longStr = in.nextLine();
        System.out.print("Enter a substring: ");
        subStr = in.nextLine();

        // Get the length of both strings.

        int lengthOfLongStr = longStr.length();
        int lengthOfSubStr = subStr.length();

        System.out.println("Length of your string: " + lengthOfLongStr);
        System.out.println("Length of your substring: " + lengthOfSubStr);

        // Slice the long string with the substring

        int posOfSubStr = longStr.indexOf(subStr);
        System.out.println("Starting position of your substring in string: "
                           + posOfSubStr);
        System.out.println("String before your substring: "
                           + longStr.substring(0, posOfSubStr));
        System.out.println("String after your substring: "
                           + longStr.substring(posOfSubStr+lengthOfSubStr, lengthOfLongStr));

        // Get a position number and prompt the char on the position

        System.out.print("Enter a position between 0 and "
                         + (lengthOfLongStr - 1) + ": ");
        int posOfChar = Integer.parseInt(in.nextLine());
        // int pos = in.nextInt();
        // in.nextLine(); // Cosume the newline character
        System.out.println("The character at position "
                           + posOfChar + " is " + longStr.charAt(posOfChar));

        // Replace the substring with a new string

        System.out.print("Enter a replacement string: ");
        String repStr = in.nextLine();
        System.out.println("Your new string is: " + longStr.replaceFirst(subStr, repStr));
    }
}
