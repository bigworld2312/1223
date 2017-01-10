import java.util.Scanner;
/**
   This program read the two sides of a rectangle from user
   and calculate the perimeter, area, and length of the diagonal
   of the rectangle

   @author: Minrui Yang, Wally
   @version: 20160901
*/
public class Lab02b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the length of the first side: ");
        double length1 = in.nextDouble();
        System.out.print("Enter the length of the second side: ");
        double length2 = in.nextDouble();
        double perimeter = (length1 + length2) * 2;
        System.out.println("The perimeter of your rectangle is: " + perimeter);
        double area = length1 * length2;
        System.out.println("The area of your rectangle is: " + area);
        double lengthDiagonal =
            Math.sqrt((length1 * length1) + (length2 * length2));
        System.out.println("The length of the diagonal of your rectangle is: "
                           + lengthDiagonal);
        System.out.println("Goodbye!");
    }
}
