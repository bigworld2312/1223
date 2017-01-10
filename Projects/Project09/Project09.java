/**
 * Project09.java
 *
 *   A program that converts Roman numerals to decimal numbers.
 *   Used to practice breaking code up into methods. 
 *
 * @author Minrui (Wally) Yang
 * @version: 20161027
 */
import java.util.Scanner;

public class Project09 {

    static String numeralTable = "IVXLCDM";

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        String numeral = "";
        int num = 0;
        numeral = promptUserForNumeral(stdin);
        while (!numeral.equals("Q")) {
            num = convertNumeralToNumber(numeral);
            System.out.println("The numeral MCMLXXXIV is the decimal number " + num);
            System.out.println();
            numeral = promptUserForNumeral(stdin);
        }
        System.out.println("Goodbye!");
    }

    // Given a Scanner as input, prompts the user to input a Roman numeral.  Checks to make
    // sure that the user does not enter an empty String.  If the user does enter an
    // empty String, report an error and ask for a new String until a non-empty String is
    // provided.  Return the String input by the user to the calling program.
    private static String promptUserForNumeral(Scanner inScanner) {
        System.out.print("Enter a roman numeral (Q to quit): ");
        String numeral = inScanner.nextLine();
        while (numeral.length() == 0) {
            System.out.println("ERROR! Your must enter a non-empty line!");
            System.out.print("\nEnter a roman numeral (Q to quit): ");
            numeral = inScanner.nextLine();
        }

        return numeral;
    }

    // Given a String as input, converts the String to a number assuming that the String
    // is a Roman numeral (following the rules in the writeup for Project 09).  Returns the
    // number to the calling program.  NOTE:  This method can possibly get long and complex.
    // This about how you can break it up into two or three smaller methods to make it
    // less complex.
    private static int convertNumeralToNumber(String numeral) {
        int total = 0;
        while (numeral.length() > 0) {
            char ch = numeral.charAt(0);
            if (numeral.length() == 1 ||
                numeralTable.indexOf(ch) >= numeralTable.indexOf(numeral.charAt(1))) {
                total += convertCharacterToNumber(ch);
                numeral = numeral.substring(1, numeral.length());
                // System.out.println("Add to" + total);
            }
            else {
                total += convertCharacterToNumber(numeral.charAt(1));
                // System.out.println("Add to" + total);
                total -= convertCharacterToNumber(ch);
                // System.out.println("Subtract to" + total);
                numeral = numeral.substring(2, numeral.length());
            }
        }
        return total;
    }

    // Given a character that contains a single numeral, returns the integer value for
    // that character.  Use the tables in the writeup for Project 09 to fill in this method.
    // For example, if the method is called with:
    //     convertCharacterToNumber('X')
    // the method should return the value 10.  And if the method is called with:
    //     convertCharacterToNumber('L')
    // the method should return the value 50.
    // Use this method with convertNumeralToNumber above to convert an entire Roman numeral
    // into a number.
    private static int convertCharacterToNumber(char numeral) {
        int num = 0;
        switch(numeral) {
        case 'I':
            num = 1;
            break;
        case 'V':
            num = 5;
            break;
        case 'X':
            num = 10;
            break;
        case 'L':
            num = 50;
            break;
        case 'C':
            num = 100;
            break;
        case 'D':
            num = 500;
            break;
        case 'M':
            num = 1000;
            break;
        }

        return num;
    }
}
