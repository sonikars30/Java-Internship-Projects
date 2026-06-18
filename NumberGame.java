import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        System.out.println("=================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("=================================");

        do {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + attempts + " attempts.");

            while (attempts > 0) {
                System.out.print("Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed it!");
                    totalScore += attempts * 10;
                    guessedCorrectly = true;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }

                attempts--;
                System.out.println("Attempts left: " + attempts);
            }

            if (!guessedCorrectly) {
                System.out.println("Game Over!");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.println("Current Score: " + totalScore);

            System.out.print("\nPlay Again? (Y/N): ");
            playAgain = sc.next().toUpperCase().charAt(0);

        } while (playAgain == 'Y');

        System.out.println("\n=================================");
        System.out.println("Final Score: " + totalScore);
        System.out.println("Thank You For Playing!");
        System.out.println("=================================");

        sc.close();
    }
}