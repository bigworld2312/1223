/**
 * Lab07a.java
 *
 *   A simple program that computes the number of words in an input string.
 *   Used to practice breaking code up into methods. 
 *
 * @author: Minrui(Wally) Yang
 * @version: 20161006
 */
import java.util.Scanner;

public class Lab07a {

	public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      String str = getInputString(in);
      int wordCount = getWordCount(str);

      System.out.println("Your string has " + wordCount + " in it.");
	}

	// Given a Scanner, prompt the user for a String.  If the user enters an empty
	// String, report an error message and ask for a non-empty String.  Return the
	// String to the calling program.
	private static String getInputString(Scanner inScanner) {
      String input;
      System.out.print("Enter a string: ");
      input = inScanner.nextLine();
      while (input.length() == 0) {
          System.out.println("ERROR - string must not be empty.");
          System.out.print("\nEnter a string: ");
          input = inScanner.nextLine();
      }

      return input;
	}

	// Given a String return the number of words in the String.  A word is a sequence of 
	// characters with no spaces.  Write this method so that the function call:
	// 		int count = getWordCount("The quick brown fox jumped");
	// results in count having a value of 5.  You will call this method from the main method.
	// For this assignment you may assume that
	// words will be separated by exactly one space.
	private static int getWordCount(String input) {
      int count = 1;
      for (int i = 0; i < input.length(); i++) {
          if (input.charAt(i) == ' ') {
              count++;
          }
      }

      return count;
	}

}
