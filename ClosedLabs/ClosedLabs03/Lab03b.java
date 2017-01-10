import java.util.Scanner;
/**
   This program reads two strings and determines
   the correct lexographic ordering of the strings

   @author: Minrui Yang, Wally
   @version: 20160908
*/
public class Lab03b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Reads two strings
        String str1 = "";
        String str2 = "";
        System.out.print("Enter the first string: ");
        str1 = in.next();
        System.out.print("Enter the second string: ");
        str2 = in.next();

        // Compare two strings
        if (str1.compareTo(str2) < 0) {
            System.out.println(str1 +
                               " comes before " + str2 + " lexiographically");
        }
        else if (str1.compareTo(str2) > 0) {
            System.out.println(str2 +
                               " comes before " + str1 + " lexiographically");
        }
        else {
            System.out.println("The two strings are same");
        }
    }
}

