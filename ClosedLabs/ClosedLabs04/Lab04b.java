import java.util.Scanner;
/**
   This program reads an time input in ordinary format (2:30 PM)
   And output the military format of the time (1434)

   @author: Minrui Yang, Wally
   @version: 20160915
*/
public class Lab04b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a time in HH:MM AM/PM format: ");
        String date = in.nextLine();
        int hour = 0;
        int minute = 0;
        // Get Hour
        if (date.equals("Midnight")) {
            hour = 0; minute = 0;
        }
        else if (date.equals("Noon")) {
            hour = 12; minute = 0;
        }
        else {
            boolean isTwoDigit = Character.isDigit(date.charAt(1));
            if (isTwoDigit) {
                hour = Integer.parseInt(date.substring(0, 2));
            }
            else {
                hour = Integer.parseInt(date.substring(0, 1));
            }

            if (hour == 12) {
                hour = 0;
            }
            if (date.charAt(date.length()-2) == 'P') { // Check if the hour is P.M.
                hour += 12;
            }
            // Get Minute
            minute = Integer.parseInt(date.substring(date.length()-5, date.length()-3));
       }
       System.out.printf("Time in military time is: %02d%02d\n", hour, minute);
    }
}
