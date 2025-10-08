import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxRounds = 3; 
        int score = 0;

        System.out.println("=== Welcome to the Number Guessing Game ===");

        for (int round = 1; round <= maxRounds; round++) 
        {
            int numberToGuess = random.nextInt(100) + 1; 
            int attemptsLeft = 5; 
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round + " begins!");
            System.out.println("I have chosen a number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess it!");

            while (attemptsLeft > 0) 
            {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println(" Correct! You guessed the number!");
                    guessedCorrectly = true;
                    score++;
                    break;
                } 
                else if (userGuess > numberToGuess) 
                {
                    System.out.println("Too high! Try again.");
                }
                else 
                {
                    System.out.println("Too low! Try again.");
                }
                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) 
            {
                System.out.println(" Out of attempts! The number was: " + numberToGuess);
            }

            if (round < maxRounds) 
            {
                System.out.print("\nDo you want to continue to next round? (yes/no): ");
                String choice = scanner.next().toLowerCase();
                if (!choice.equals("yes")) 
                {
                    break;
                }
            }
        }

        System.out.println("\n=== Game Over! ===");
        System.out.println("Your final score: " + score + " out of " + maxRounds);

        scanner.close();
    }
}
