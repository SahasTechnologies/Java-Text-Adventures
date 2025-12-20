import java.util.Random;
import java.util.Scanner;

class GuessTheNumber {
    private static final int HIGH_LIMIT = 100; //guessing between 1 and this number
    private static final int LOW_LIMIT = 1;

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); //wow what has happened to my code...

        int numberToGuess = random.nextInt(HIGH_LIMIT) + LOW_LIMIT; //this makes the random number
        int guess = 0;
        int attempts = 0;

        int lowNumber = LOW_LIMIT;
        int highNumber = HIGH_LIMIT;

        System.out.println("------Welcome to Guess the Number! ------");
        System.out.println("I'm thinking of a number between 1 and 100: Can you guess it? (y/n)");
        String yesOrNo = scanner.nextLine().toLowerCase();

        if (yesOrNo.equals("y") || yesOrNo.equals("yes")) {
            do { 
            System.out.println("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;
            if (guess > HIGH_LIMIT || guess < LOW_LIMIT) {
                System.out.println("just saying, the number is between " + LOW_LIMIT + " and " + HIGH_LIMIT + ".");
                System.out.println("You guessed " + guess);
            }
            else if (guess < numberToGuess) {
                System.out.println("Too low!");
                lowNumber = guess + 1;
                System.out.println("Based on your guesses, the number is now between " + lowNumber + " and " + highNumber);
            }
            else if (guess > numberToGuess) {
                System.out.println("Too high!");
                highNumber = guess - 1;
                System.out.println("Based on your guesses, the number is now between "  + lowNumber + " and " + highNumber);
            }
            
        } while (guess !=  numberToGuess);

        System.out.println("Correct! The number was " + numberToGuess + ".");
        System.out.println("Attempts: " + attempts);
        }
        else if (yesOrNo.equals("n") || yesOrNo.equals("no")) {
            System.out.println("That's a bit sad...");
            System.out.println("Come back later to play!");
        }

        scanner.close();
    }
}