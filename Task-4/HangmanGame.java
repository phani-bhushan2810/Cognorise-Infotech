import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
       
        String[] words = {"programming", "java", "hangman", "computer", "science"};

        
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)];

        
        char[] guessedWord = new char[wordToGuess.length()];
        Arrays.fill(guessedWord, '_');
        ArrayList<Character> wrongGuesses = new ArrayList<>();
        int maxWrongGuesses = 6;

        Scanner scanner = new Scanner(System.in);

        
        while (true) {
            System.out.println("Current word: " + String.valueOf(guessedWord));
            System.out.println("Wrong guesses: " + wrongGuesses);
            displayHangman(wrongGuesses.size());

            
            if (String.valueOf(guessedWord).equals(wordToGuess)) {
                System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                break;
            }

            
            if (wrongGuesses.size() >= maxWrongGuesses) {
                System.out.println("Sorry, you've been hanged! The word was: " + wordToGuess);
                break;
            }

            
            System.out.print("Guess a letter: ");
            char guessedLetter = scanner.next().toLowerCase().charAt(0);

            
            boolean correctGuess = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessedLetter) {
                    guessedWord[i] = guessedLetter;
                    correctGuess = true;
                }
            }

            
            if (!correctGuess) {
                if (!wrongGuesses.contains(guessedLetter)) {
                    wrongGuesses.add(guessedLetter);
                } else {
                    System.out.println("You've already guessed that letter.");
                }
            }
        }

        scanner.close();
    }

    
    public static void displayHangman(int wrongGuesses) {
        switch (wrongGuesses) {
            case 0:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 1:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 2:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 3:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 4:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 5:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" /    |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 6:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                System.out.println("      |");
                System.out.println("=========");
                break;
        }
    }
}
