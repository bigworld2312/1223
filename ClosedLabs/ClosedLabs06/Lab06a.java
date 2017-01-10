/**
   This program output a 10 * 10 multiplication table to
   the screen.

   @author: Minrui (Wally) Yang
   @version: 20160929
*/

public class Lab06a {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%3d ", i * j);
            }
            System.out.println();
        }
    }
}
