/**
   This program reads a string and outputs the string
   in the reverse order

   @author: Minrui (Wally) Yang
   @version: 20160922
*/
import java.util.Scanner;

public class Lab05c {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string to reverse: ");
        String str = in.nextLine();
        for (int i = str.length()-1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }
}
