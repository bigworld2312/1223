/**
   This program reads a positive integer and output the
   corresponding Hailstone Series until reaches one

   @author: Minrui (Wally) Yang
   @version: 20160922
*/
import java.util.Scanner;

public class Lab05b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num;
        System.out.print("Enter a starting value: ");
        num = in.nextInt();
        System.out.print(num);
        while (num > 1) {
            System.out.print(", ");
            if (num % 2 == 0) {
                num /= 2;
            }
            else {
                num = 3 * num + 1;
            }
            System.out.print(num);
        }
        System.out.println();
    }
}
