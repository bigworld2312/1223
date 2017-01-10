/**
 * Lab08a.java
 *
 *   A program that performs ROT13 encryption on a string.
 *   User to choose how many character to shift.
 *   Used to practice breaking code up into methods.
 *
 * @authors Minrui (Wally) Yang
 * @version: 20161020
 */
import java.util.Scanner;

public class Lab08b {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        String originStr = getText(stdin);
        while (!(originStr.equals("!!!"))) {
            int amount = getNum(stdin);
            String encrypedStr = shiftMessage(originStr, amount);
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

    // Given a Scanner, prompt the user for an input integer. Check to make sure that
    // the user inputs a integer between 0 and 26 and return the number.
    private static int getNum(Scanner inScanner) {
        System.out.print("Enter amount to shift text by: ");
        int amount = inScanner.nextInt();
        while (amount < 0 || amount > 26) {
            if (amount < 0) {
                System.out.println("ERROR! Shift must be non-negative!");
            }
            else {
                System.out.println("ERROR! Shift must be no more than 26!");
            }

            System.out.print("Enter amount to shift by: ");
            amount = inScanner.nextInt();
        }
        inScanner.nextLine(); // Consume extra newline characters

        return amount;
    }

    // Given a string, return the nth shifted transformation of the String.  For example, given the
    // input String "ABCXYZ" and 13 the function returns the String "NOPKLM".
    private static String shiftMessage(String input, int n) {
        // System.out.println(input);
        String temp = "";
        int flag = 26 - n - 1;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if ((currentChar >= 65 && currentChar <= (65 + flag))
                || (currentChar >= 97 && currentChar <= (97 + flag))) {
                temp += (char)(currentChar + n);
            }
            else if ((currentChar > (65 + flag) && currentChar <= 90)
                     || (currentChar > (97 + flag) && currentChar<= 122)) {
                temp += (char)(currentChar - (flag + 1));
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
        System.out.println("+");
    }
}
