import java.util.*;

public class Lab13a {

    /**
     * Removes all space characters from a String
     *
     * @param input
     *            String to have spaces removed from
     * @return the input String with spaces removed
     */
    public static String removeSpaces(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                result = result.append(input.charAt(i));
            }
        }
        return result.toString();
    }

    /**
     * Expands a String by repeating characters in the String.
     * The character at position 0 is repeated 0 times, position one
     * is repeated once, position 2 is repeated twice and so on.
     * @param input String to expand
     * @return the input String expanded
     */
    public static String expandString(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < i; j++) {
                result = result.append(input.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        // System.out.print("Enter a string to de-space: ");
        // String line = stdin.nextLine();
        // while (line.length() > 0) {
        //     System.out.println("Without spaces: " + removeSpaces(line));
        //     System.out.print("Enter a string to de-space: ");
        //     line = stdin.nextLine();
        // }

        System.out.print("Enter a string to expand: ");
        String line = stdin.nextLine();
        while (line.length() > 0) {
            System.out.println("Expaned: " + expandString(line));
            System.out.print("Enter a string to expand: ");
            line = stdin.nextLine();
        }

        System.out.println("Goodbye!");
    }

}
