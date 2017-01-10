/**
   This program reads some UPC code and test if they are valid
   User's input ends with a blank line.

   @author: Minrui (Wally) Yang
   @version: 20161006
*/
import java.util.Scanner;

public class Project06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a UPC (enter a blank line to quit): ");
        String upcStr = in.nextLine();
        while (upcStr.length() > 0) {
            if (upcStr.length() != 12) {
                System.out.println("ERROR UPC MUST have exactly 12 digits");
            }
            else {
                int checkDigit = 0;
                int actualDigit = Character.getNumericValue(upcStr.charAt(upcStr.length() - 1));
                int subtotal1 = 0;
                int subtotal2 = 0;
                for (int i = 0; i < upcStr.length() - 1; i++) {
                    if ((i+1) % 2 != 0) {
                        subtotal1 += Character.getNumericValue(upcStr.charAt(i));
                    }
                    else {
                        subtotal2 += Character.getNumericValue(upcStr.charAt(i));
                    }
                }
                subtotal1 *= 3;
                int total = subtotal1 + subtotal2;
                total %= 10;
                if (total != 0) {
                    checkDigit = 10 - total;
                }
                System.out.println("Check digit should be: " + checkDigit);
                System.out.println("Check digit is: " + actualDigit);
                if (checkDigit == actualDigit) {
                    System.out.println("UPC is valid");
                }
                else {
                    System.out.println("UPC is not valid");
                }
            }
            System.out.print("\nEnter a UPC (enter a blank line to quit): ");
            upcStr = in.nextLine();
        }
        System.out.println("Goodbye!");
    }
}
