import java.util.Scanner;
/**
   This program outputs math expressions randomly and asks
   the user for answer and assesses user's performance

   @author: Minrui Yang, Wally
   @version: 20160912
*/
public class Project03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int TOTAL = 4;
        int correctCount = 0;
        int userInput = 0;
        int correctAnswer = 0;

        // Print Greeting messages
        System.out.print("Enter your name: ");
        String userName = in.next();
        System.out.println("Welcome " + userName
                           + "! Please answer the following questions: ");
        System.out.println();

        // Generate two random numbers
        int number1 = (int)(20 * Math.random()) + 1;
        int number2 = (int)(20 * Math.random()) + 1;

        // Generate plus expression
        correctAnswer = number1 + number2;
        System.out.print(number1 + " + " + number2 + " = ");
        userInput = in.nextInt();
        if (userInput == correctAnswer) {
            correctCount++;
            System.out.println("Correct!");
        }
        else {
            System.out.println("Wrong!");
            System.out.println("The correct answer is " + correctAnswer);
        }
        System.out.println();

        // Generate multiple expression
        correctAnswer = number1 * number2;
        System.out.print(number1 + " * " + number2 + " = ");
        userInput = in.nextInt();
        if (userInput == correctAnswer) {
            correctCount++;
            System.out.println("Correct!");
        }
        else {
            System.out.println("Wrong!");
            System.out.println("The correct answer is " + correctAnswer);
        }
        System.out.println();

        // Generate divide expression
        correctAnswer = number1 / number2;
        System.out.print(number1 + " / " + number2 + " = ");
        userInput = in.nextInt();
        if (userInput == correctAnswer) {
            correctCount++;
            System.out.println("Correct!");
        }
        else {
            System.out.println("Wrong!");
            System.out.println("The correct answer is " + correctAnswer);
        }
        System.out.println();

        // Generate module expression
        correctAnswer = number1 % number2;
        System.out.print(number1 + " % " + number2 + " = ");
        userInput = in.nextInt();
        if (userInput == correctAnswer) {
            correctCount++;
            System.out.println("Correct!");
        }
        else {
            System.out.println("Wrong!");
            System.out.println("The correct answer is " + correctAnswer);
        }
        System.out.println();

        // Assess on the performance
        double rate = ((double)correctCount / TOTAL) * 100;
        System.out.println("You got " + correctCount + " correct answers");
        System.out.println("That's " + rate + "%!");
    }
}
