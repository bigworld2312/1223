/**
 * Project11.java
 *
 *   A program that plays simple word guessing game.  In this game the user provides a list of
 *   words to the program.  The program randomly selects one of the words to be guessed from
 *   this list.  The player then guesses letters in an attempt to figure out what the hidden
 *   word might be.  The number of guesses that the user takes are tracked and reported at the
 *   end of the game.
 *
 *   See the write-up for Project 11 for more details.
 *
 * @author Minrui (Wally) Yang
 * @version 20161121
 */
import java.util.*;
import java.io.*;

public class Project11 {

    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        boolean reMatch = true;

        // Read word file
        System.out.print("Enter a filename containing your wordlist: ");
        String fileName = stdin.nextLine();
        File f = new File(fileName);
        Scanner fileIn = new Scanner(f);

        // Read word list and get the word to guess
        ArrayList<String> wordList = getList(fileIn);
        System.out.println("Read " + wordList.size() + " words from the file");

        while (reMatch) {
            String word = getRandomWord(wordList).toUpperCase();
            String star = starWord(word);
            boolean found = false;
            int guessCount = 0;
            ArrayList<Character> guessedCharacters = new ArrayList<Character>();

            System.out.println("word " + word);
            while (!found) {
                // Prompt initial message
                if (guessCount != 0) {
                    System.out.println("That is not the correct word");
                    System.out.println("\nPlease guess another letter and try again.");
                }
                else {
                    System.out.println();
                }
                System.out.println("The word to guess is: " + star);

                // Get guess character
                System.out.print("Previous character guessed: ");
                printGuessed(guessedCharacters);
                char guessCharacter = getCharacterGuess(stdin);
                while (checkInList(guessCharacter, guessedCharacters)) {
                    System.out.println("You've already guessed " + guessCharacter
                                     + " try another character");
                    System.out.println("\nThe word to guess is: " + star);
                    System.out.print("Previous character guessed: ");
                    printGuessed(guessedCharacters);
                    System.out.print("Enter a character to guess: ");
                    guessCharacter = getCharacterGuess(stdin);
                }
                guessedCharacters.add(guessCharacter);
                System.out.println("The character " + guessCharacter + " occurs in "
                                   + checkChar(guessCharacter, word) + " positions");

                // Modify guess process
                star = modifyGuess(guessCharacter, word, star);

                // Get guess word
                System.out.println("\nThe word to guess is now: " + star);
                System.out.print("Enter your guess: ");
                String guess = stdin.nextLine().toUpperCase();
                System.out.println("guess " + guess);

                // check guess word
                found = checkWord(guess, word);
                guessCount++;
            }
            // get rematch option
            System.out.println("Congratulations! " + word + " is the correct word.");
            System.out.println("\nYou achived the correct answer in " + guessCount + " guesses!");
            reMatch = getReMatch(stdin);
        }
    }

    // Given a Scanner as input, returns a List<String> of strings read from the Scanner.
    // The method should read words from the Scanner until there are no more words in the file
    // (i.e. inScanner.hasNext() is false).  The list of strings should be returned to the calling program.
    private static ArrayList<String> getList(Scanner inScanner) {
        ArrayList<String> list = new ArrayList<String>();
        while (inScanner.hasNextLine()) {
            list.add(inScanner.nextLine());
        }
        return list;
    }

    // Given two strings as input, compares the first string (guess) to the second
    // (solution) character by character.  If the two strings are not exactly the same,
    // return false.  Otherwise return true.
    private static boolean checkWord(String guess, String solution) {
        if (guess.equals(solution)) {
            return true;
        }
        else {
            return false;
        }
    }


    // Given a ArrayList<String> list of strings as input, randomly selects one of the strings
    // in the list and returns it to the calling program.
    private static String getRandomWord(ArrayList<String> inList) {
        int index = (int)(Math.random() * inList.size());
        return inList.get(index);
    }


    // Given a Scanner as input, prompt the user to enter a character.  If the character
    // enters anything other than a single character provide an error message and ask
    // the user to input a single character.  Otherwise return the single character to
    // the calling program.
    private static char getCharacterGuess(Scanner inScanner) {
        System.out.print("Enter a character to guess: ");
        String input = inScanner.nextLine().toUpperCase();
        while (input.length() != 1) {
            System.out.println("One character at a time!");
            System.out.print("Enter a character to guess: ");
            input = inScanner.nextLine().toUpperCase();
        }
        char choice = input.charAt(0);
        return choice;
    }

    // Given a character inChar and a ArrayList<Character> list of characters, check to see if the
    // character inChar is in the list.  If it is, return true.  Otherwise, return false. 
    private static boolean checkInList(char inChar, ArrayList<Character> inList) {
        boolean isInList = false;
        for (int i = 0; i < inList.size(); i++) {
            if (inList.get(i) == inChar) {
                isInList = true;
            }
        }
        return isInList;
    }

    // Given a String, return a String that is the exact same length but consists of
    // nothing but '*' characters.  For example, given the String DOG as input, return
    // the string ***
    private static String starWord(String inWord) {
        int length = inWord.length();
        String buffer = "";
        for (int i = 0; i < length; i++) {
            buffer += "*";
        }
        return buffer;
    }

    // Given a character and a String, return the count of the number of times the
    // character occurs in that String.
    private static int checkChar(char guessChar, String guessWord) {
        int countChar = 0;
        for (int i = 0; i < guessWord.length(); i++) {
            if (guessChar == guessWord.charAt(i)) {
                countChar++;
            }
        }
        return countChar;
    }

    // Given a character, a String containing a word, and a String containing a 'guess'
    // for that word, return a new String that is a modified version of the 'guess'
    // string where characters equal to the character inChar are uncovered.
    // For example, given the following call:
    //   modfiyGuess('G',"GEOLOGY", "**O*O*Y")
    // This functions should return the String "G*O*OGY".
    private static String modifyGuess(char inChar, String word, String currentGuess) {
        for (int i = 0; i < word.length(); i++) {
            if (inChar == word.charAt(i)) {
                currentGuess = currentGuess.substring(0, i)
                    + word.charAt(i)
                    + currentGuess.substring(i+1, word.length());
            }
        }
        return currentGuess;
    }

    /**
       Given a Scanner, prompt user for rematch option
       @param inScanner: Scanner to get input
       @return true if 'y' or 'Y', false if 'n' or 'N'
     */
    private static boolean getReMatch(Scanner inScanner) {
        System.out.print("Would you like a rematch [y/n]? ");
        char choice = inScanner.nextLine().toUpperCase().charAt(0);
        while (choice != 'N' && choice != 'Y') {
            System.out.println("Error input! Enter 'y' or 'n'");
            System.out.print("Would you like a rematch [y/n]? ");
            choice = inScanner.nextLine().toUpperCase().charAt(0);
        }
        return choice == 'Y'? true: false;
    }

    /**
       Given a ArrayList of Character, print out its elements
       @param
    */
    private static void printGuessed(ArrayList<Character> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
