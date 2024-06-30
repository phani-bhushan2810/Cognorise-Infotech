import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; 
        Scanner scanner = new Scanner(System.in);
        int userGuess;
        int attempts = 0;
        int maxAttempts = 10;

        System.out.println("Welcome to the Guessing Game! Try to guess the number between 1 and 100.");
        
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;
            
            if (userGuess < numberToGuess) {
                System.out.println("Your guess is too low.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Your guess is too high.");
            } else {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                break;
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Sorry! You've used all your attempts. The number was " + numberToGuess + ".");
            }
        }
        
        scanner.close();
    }
}
