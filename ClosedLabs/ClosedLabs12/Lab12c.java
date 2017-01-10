/**
 * Lab12a.java
 *
 *   A program that prompts the user for an input file name and, if that file exists,
 *   displays each line of that file in reverse order.
 *   Used to practice simple File I/O and breaking code up into methods as well as a first
 *   step to implementing Lab13b.java - reversing the entire file and Lab13c.java writing
 *   output to a separate output file.
 *
 * @author Minrui (Wally) Yang
 *
 */
import java.io.*;
import java.util.*;


public class Lab12c {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.print("Enter an input file name: ");
        String inputFileName = getFileName(stdin);
        System.out.print("Enter an output file name: ");
        String outputFileName = getFileName(stdin);

        while (inputFileName.equals(outputFileName)) {
            System.out.println("ERROR! Your input file and output file MUST be different");
            System.out.print("Enter an input file name: ");
            inputFileName = getFileName(stdin);
            System.out.print("Enter an output file name: ");
            outputFileName = getFileName(stdin);
        }

        try {
            File f = new File(inputFileName);
            Scanner inputFile = new Scanner(f);
            String buffer = "";
            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    buffer += line.charAt(i);
                }
                buffer += "\n";
            }
            buffer = buffer.substring(0, buffer.length()-1);
            // System.out.println(reverse(buffer));
            inputFile.close();
            try {
                PrintWriter outputFile = new PrintWriter(outputFileName);
                outputFile.println(reverse(buffer));
                outputFile.close();
            }
            catch (IOException e) {
                System.out.println("Error writing to file " + outputFileName);
            }
        }
        catch (IOException e) {
            System.out.println("There was a problem reading from " + inputFileName);
        }
    }

    // Given a Scanner as input prompts the user to enter a file name.  If given an
    // empty line, respond with an error message until the user enters a non-empty line.
    // Return the string to the calling program.  Note that this method should NOT try
    // to determine whether the file name is an actual file - it should just get a
    // valid string from the user.
    private static String getFileName(Scanner inScanner) {
        String name = inScanner.nextLine();

        return name;
    }

    // Given a String as input return the reverse of that String to the calling program.
    private static String reverse(String inString) {
        String outString = "";
        for (int i = inString.length()-1; i >= 0; i--) {
            outString += inString.charAt(i);
        }

        return outString;
    }
}
