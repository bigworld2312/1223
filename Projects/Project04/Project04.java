import java.util.Scanner;

public class Project04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char userInput;
        String userChoice;
        String compChoice;
        String[] choices = {"Rock", "Paper", "Scissors"};

        System.out.print("Please select one of [R/P/S]: ");
        userInput = in.next().charAt(0);
        if (userInput == 'R' || userInput == 'r') {
            userChoice = "Rock";
            System.out.println("You chose: " + userChoice);
        }
        else if (userInput == 'P' || userInput == 'p') {
            userChoice = "Paper";
            System.out.println("You chose: " + userChoice);
        }
        else if (userInput == 'S' || userInput == 's') {
            userChoice = "Scissors";
            System.out.println("You chose: " + userChoice);
        }
        else {
            userChoice = "Rock";
            System.out.println("Invalid choice! Defaulting to " + userChoice + ". ");
        }

        compChoice = choices[(int)(Math.random() * 3)];
        System.out.println("I chose: " + compChoice);

        if (userChoice.equals(compChoice)) {
            System.out.println("A Tie!");
        }
        else if (userChoice == "Rock" && compChoice == "Paper") {
            System.out.println(compChoice + " beats " + userChoice + " - you lose!");
        }
        else if (userChoice == "Rock" && compChoice == "Scissors") {
            System.out.println(userChoice + " beats " + compChoice + " - you win!");
        }
        else if (userChoice == "Paper" && compChoice == "Rock") {
            System.out.println(userChoice + " beats " + compChoice + " - you win!");
        }
        else if (userChoice == "Paper" && compChoice == "Scissors") {
            System.out.println(compChoice + " beats " + userChoice + " - you lose!");
        }
        else if (userChoice == "Scissors" && compChoice == "Rock") {
            System.out.println(compChoice + " beats " + userChoice + " - you lose!");
        }
        else if (userChoice == "Scissors" && compChoice == "Paper") {
            System.out.println(userChoice + " beats " + compChoice + " - you win!");
        }
        else {
            System.out.println("Error! Result not found!");
        }
    }
}
