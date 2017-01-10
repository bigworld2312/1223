import java.util.Scanner;
/**
   This program reads a grade from 0.0 to 100.0
   Then output the corresponding grade in letter

   @author: Minrui Yang, Wally
   @version: 20160915
*/
public class Lab04a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a grade value between 0 and 100: ");
        double grade = in.nextDouble();

        if (grade >= 93.0 && grade <= 100.0) {
            System.out.println("You received an A");
        }
        else if (grade >= 90.0 && grade < 93.0) {
            System.out.println("You received an A-");
        }
        else if (grade >= 87.0 && grade < 90.0) {
            System.out.println("You received a B+");
        }
        else if (grade >= 83.0 && grade < 87.0) {
            System.out.println("You received a B");
        }
        else if (grade >= 80.0 && grade < 83.0) {
            System.out.println("You received a B-");
        }
        else if (grade >= 77.0 && grade < 80.0) {
            System.out.println("You received a C+");
        }
        else if (grade >= 73.0 && grade < 77.0) {
            System.out.println("You received a C");
        }
        else if (grade >= 70.0 && grade < 73.0) {
            System.out.println("You received a C-");
        }
        else if (grade >= 67.0 && grade < 70.0) {
            System.out.println("You received a D+");
        }
        else if (grade >= 60.0 && grade < 67.0) {
            System.out.println("You received a D");
        }
        else if (grade >= 0.0 && grade < 60.0) {
            System.out.println("You received a E");
        }
        else {
            System.out.println("ERROR: Grade must be between 0 and 100");
        }
    }
}
