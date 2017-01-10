import java.util.Scanner;
/**
   This program reads two numbers from the user
   and indicates which number is larger

   @author: Minrui Yang, Wally
   @version: 20160908
*/

public class Lab03a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Reads two numbers
        int number1 = 0;
        int number2 = 0;
        System.out.print("Enter your first number: ");
        number1 = in.nextInt();
        System.out.print("Enter your second number: ");
        number2 = in.nextInt();

        // Compare two numbers
        if (number1 > number2) {
            System.out.println(number1 + " is larger than " + number2);
        }
        else if (number1 < number2) {
            System.out.println(number2 + " is larger than " + number1);
        }
        else {
            System.out.println("the two numbers are equal");
        }
    }
}

