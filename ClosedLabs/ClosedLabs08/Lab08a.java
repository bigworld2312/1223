/**
 * Lab08a.java
 *
 *   A program that performs ROT13 encryption on a string.
 *   Used to practice breaking code up into methods.
 *
 * @authors Minrui (Wally) Yang
 * @version: 20161020
 */
import java.util.Scanner;

public class Lab08a {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        String originStr = getText(stdin);
        while (!(originStr.equals("!!!"))) {
            String encrypedStr = rot13(originStr);
            displayResults(originStr, encrypedStr);
            originStr = getText(stdin);
        }

        System.out.println("Goodbye!");
    }

    // Given a Scanner, prompt the user for an input string.  Check to make sure that
    // the user inputs a non-empty string and return the String to the calling program./
    private static String getText(Scanner inScanner) {
        System.out.print("Enter your text to encrypt (!!! to quit): ");

        String text = inScanner.nextLine();
        while (text.length() == 0) {
            System.out.println("ERROR! String must not be empty!");
            System.out.print("\nEnter your text to encrypt (!!! to quit): ");
            text = inScanner.nextLine();
        }

        return text;
    }

    // Given a string, return the ROT13 transformation of the String.  For example, given the
    // input String "ABCXYZ" the function returns the String "NOPKLM".
    private static String rot13(String input) {
        // System.out.println(input);
        String temp = "";
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if ((currentChar >= 65 && currentChar <= 77)
                || (currentChar >= 97 && currentChar <= 109)) {
                temp += (char)(currentChar + 13);
            }
            else if ((currentChar > 77 && currentChar <= 90)
                     || (currentChar > 109 && currentChar<= 122)) {
                temp += (char)(currentChar - 13);
            }
            else {
                temp += currentChar;
            }
        }

        return temp;
    }

    // Given an input text and an encrypted text, display the strings in the formatted
    // output described by the instructions for closed lab 09.
    private static void displayResults(String inText, String encText) {
        System.out.print("\n+");
        for (int i = 0; i < inText.length() + 13; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        System.out.println("| ORIGINAL:  " + inText + " |");
        System.out.println("| ENCRYPTED: " + encText + " |");

        System.out.print("+");
        for (int i = 0; i < inText.length() + 13; i++) {
            System.out.print("-");
        }
        System.out.println("+\n");
    }
}
