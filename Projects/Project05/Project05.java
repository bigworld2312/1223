/**
   This program emulate a guessing game and evaluate user's
   performance based on user's time of guessing.

   @author: Minrui (Wally) Yang
   @version: 20160929
*/
import java.util.Scanner;

public class Project05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = (int)(Math.random() * 100 + 1);
        int count = 1;

        // System.out.println(num);
        System.out.print("Enter a guess between 1 and 100: ");
        int userInput = in.nextInt();
        while (userInput != num) {
            if (userInput > num && userInput <= 100) {
                System.out.println("Your guess was too high.  Try again.");
            }
            else if (userInput < num && userInput >= 1) {
                System.out.println("Your guess was too low.  Try again.");
            }
            else {
                System.out.println("Your guess is out of range.  Pick a number between 1 and 100.");
            }
            count++;

            System.out.print("\nEnter a guess between 1 and 100: ");
            userInput = in.nextInt();
        }
        System.out.println("You guessed it in " + count + " tries.");

        if (count == 1) {
            System.out.println("That was lukcy!");
        }
        else if (2 <= count && count <= 4) {
            System.out.println("That was amazing!");
        }
        else if (5 <= count && count <= 6) {
            System.out.println("That was good.");
        }
        else if (count == 7) {
            System.out.println("That was OK.");
        }
        else if (8 <= count && count <= 9) {
            System.out.println("That was not very good.");
        }
        else {
            System.out.println("This just isn't your game.");
        }
    }
}
