
import java.util.Scanner;
import java.util.Random;

public class GuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numberToGuess = rand.nextInt(100) + 1; // random number 1–100
        int attemptsLeft = 5; // limit attempts
        int guess;

        System.out.println("Guess the number between 1 and 100. You have " + attemptsLeft + " attempts!");

        while (attemptsLeft > 0) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attemptsLeft--;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! You guessed it!");
                break;
            }

            if (attemptsLeft > 0) {
                System.out.println("Attempts left: " + attemptsLeft);
            } else {
                System.out.println("Out of attempts! The number was: " + numberToGuess);
            }
        }

        sc.close();
    }
}
