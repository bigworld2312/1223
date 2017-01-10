/**
 * Project08.java
 *
 *   A program that converts decimal numbers to Roman numerals.
 *   Used to practice breaking code up into methods.
 *
 * @author: Minrui (Wally) Yang
 * @version: 20161020
 */
import java.util.Scanner;

public class Project08 {

    private static String[] romanNumeral = {
        "IVX", "XLC", "CDM"
    };

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int number = promptUserForNumber(stdin);
        while (number != 0) {
            // System.out.println(number + ":");
            String numeral = convertNumberToNumeral(number);
            System.out.println(numeral);

            number = promptUserForNumber(stdin);
        }
        System.out.println("Goodbye!");
    }

    // Given a Scanner as input, prompts the user to input a number between 1 and 3999.
    // Checks to make sure the number is within range, and provides an error message until
    // the user provides a value within range.  Returns the number input by the user to the
    // calling program.
    private static int promptUserForNumber(Scanner inScanner) {
        System.out.print("Enter a number between 1 and 3999 (0 to quit): ");
        int num = inScanner.nextInt();
        while (num < 0 || num > 3999) {
            System.out.println("ERROR! Number must be between 1 and 3999");
            System.out.print("\nEnter a number between 1 and 3999 (0 to quit): ");

            num = inScanner.nextInt();
        }

        return num;
    }

    // Given a number as input, converts the number to a String in Roman numeral format,
    // following the rules in the writeup for Lab 09.  Returns the String to the calling
    // program.  NOTE:  This method can possibly get long and complex.  Use the
    // convertDigitToNumeral method below to break this up and make it a bit simpler to code.
    private static String convertNumberToNumeral(int number) {
        String numeral = "";
        int index = 0;
        while (number != 0) {
            int digit = number % 10;

            // System.out.println(digit + ": ");
            if (index == 3) {
                for (int i = 0; i < digit; i++) {
                    numeral = "M" + numeral;
                }
            }
            else {
                numeral = convertDigitToNumeral(
                    digit,
                    romanNumeral[index].charAt(0),
                    romanNumeral[index].charAt(1),
                    romanNumeral[index].charAt(2)) + numeral;
            }
            // System.out.println(Numeral);
            index++;
            number /= 10;
        }

        return numeral;
    }

    // Given a digit and the Roman numerals to use for the "one", "five" and "ten" positions,
    // returns the appropriate Roman numeral for that digit.  For example, if the number to
    // convert is 49 we would call convertDigitToNumeral twice.  The first call would be:
    //     convertDigitToNumeral(9, 'I','V','X')
    // and would return a value of "IX".  The second call would be:
    //     convertDigitToNumeral(4, 'X','L','C')
    // and would return a value of "XL".  Putting those togeter we would see that 49 would be the
    // Roman numeral XLIX.
    // Call this method from convertNumberToNumeral above to convert an entire number into a
    // Roman numeral.
    private static String convertDigitToNumeral(int digit, char one, char five, char ten) {
        String temp = "";
        if (digit < 4)
        {
            for (int i = 0; i < digit; i++) {
                temp += one;
                // System.out.println(temp);
            }
            //System.out.println(digit + ":" +  temp);
        }
        else if (digit == 4) {
            temp += "" + one + five;
            //System.out.println(digit + ":" + temp);
        }
        else if (digit < 9){
            temp += five;
            for (int i = 0; i < digit - 5; i++) {
                temp += one;
            }
            //System.out.println(digit + ":" + temp);
        }
        else {
            temp += "" + one + ten;
            //System.out.println(digit + ":" + temp);
        }

        return temp;
    }
}
