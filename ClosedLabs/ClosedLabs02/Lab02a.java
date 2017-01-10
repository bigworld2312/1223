import java.util.Scanner;
/**
   This program read user's name as input and display some information
   about user's name

   @author: Minrui Yang, Wally
   @version: 20160901
*/
public class Lab02a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = new String(in.next());
        System.out.println("Hello " + name);
        System.out.println("Your name is " + name.length() + " letters long.");
        System.out.println("Your name starts with a " + name.charAt(0) + ". ");
        System.out.println("Your name ends with a " + name.charAt(name.length()-1) + ". ");
        System.out.println("Goodbye " + name);
    }
}
