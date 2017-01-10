/**
 * Project07.java
 *
 *   A program that plays the dice game high/low
 *   Used to practice breaking code up into methods.
 *
 * @author: Minrui (Wally) Yang
 * @version: 20161012
 */
import java.util.Scanner;

public class Project07 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int pool = 100;
        int bet = getBet(in, pool);
        while (pool != 0 && bet != 0) {
            char choice = getHighLow(in);

            int dice1 = getRoll();
            int dice2 = getRoll();
            System.out.println("Die 1 rolls: " + dice1);
            System.out.println("Die 2 rolls: " + dice2);
            int total = dice1 + dice2;
            System.out.println("Total of tow dice is: " + total);

            int result = determineWinnings(choice, bet, total);
            pool += result;

            if (pool > 0) {
                bet = getBet(in, pool);
            }
        }
        System.out.println("You have " + pool + " dollars left");
        System.out.println("Goodbye!");
    }

    // Given a Scanner and a current maximum amount of money, prompt the user for
    // an integer representing the number of dollars that they want to bet.  This
    // number must be between 0 and to maximum number of dollars.  If the user enters
    // a number that is out of bounds, display an error message and ask again.
    // Return the bet to the calling program.
    private static int getBet(Scanner inScanner, int currentPool) {
        System.out.println("You have " + currentPool + " dollars");
        System.out.print("Enter an amount to bet (0 to quit): ");

        int bet = inScanner.nextInt();
        while (!(0 <= bet && bet <= currentPool)) {
            System.out.println("Your bet MUST be between 0 and "
                               + currentPool + " dollars");
            System.out.println("You have " + currentPool + " dollars");
            System.out.print("Enter an amount to bet (0 to quit): ");
            bet = inScanner.nextInt();
        }

        return bet;
    }

    // Given a Scanner, prompt the user for a single character indicating whether they
    // would like to bet High ('H'), Low ('L') or Sevens ('S').  Your code should accept
    // either capital or lowercase answers, but should display an error if the user attempts
    // to enter anything but one of these 3 values and prompt for a valid answer.
    // Return the character to the calling program.
    private static char getHighLow(Scanner inScanner) {
        System.out.print("High, low or sevens (H/L/S): ");

        char choice = inScanner.next().charAt(0);
        while (choice != 'H' && choice != 'h'
               && choice != 'L' && choice != 'l'
               && choice != 'S' && choice != 's') {
            System.out.println("Invalid Input!");
            System.out.print("High, low or sevens (H/L/S): ");
            choice = inScanner.next().charAt(0);
        }

        return choice;
    }

    // Produce a random roll of a single six-sided die and return that value to the calling
    // program
    private static int getRoll() {
        int number = ((int)(Math.random() * 6 + 1));
        return number;
    }

    // Given the choice of high, low or sevens, the player's bet and the total result of
    // the roll of the dice, determine how much the player has won.  If the player loses
    // the bet then winnings should be negative.  If the player wins, the winnings should
    // be equal to the bet if the choice is High or Low and 4 times the bet if the choice
    // was Sevens.  Return the winnings to the calling program.
    private static int determineWinnings(char highLow, int bet, int roll) {
        if (highLow == 'h' || highLow == 'H') {
            if (roll > 7) {
                System.out.println("You won " + bet + " dollars\n");
                return bet;
            }
            else {
                System.out.println("You lost!\n");
                return -bet;
            }
        }
        else if (highLow == 'l' || highLow == 'L') {
            if (roll < 7) {
                System.out.println("You won " + bet + " dollars\n");
                return bet;
            }
            else {
                System.out.println("You lost!\n");
                return -bet;
            }
        }
        else {
            if (roll == 7) {
                System.out.println("You won " + (4 * bet) + " dollars\n");
                return 4 * bet;
            }
            else {
                System.out.println("You lost!\n");
                return -bet;
            }
        }
    }
}
