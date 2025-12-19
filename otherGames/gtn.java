import java.util.Scanner;
import java.util.Random;
public int highLimit = 100; //guessing between 1 and tis number
public int lowLimit = 0;
public int lowNumber = 0;
public int highNumber = highLimit;

public class GuessTheNumber {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); //wow what has happened to my code...

        int numberToGuess = random.nextInt(100) + 1 //this makes the random number
        int guess;
        int attempts = 0;

        System.out.println("------Welcome to Guess the Number! ------");
        System.out.println("I'm thinking of a number between 1 and 100: Can you guess it? (y/n)");
        String yesOrNo = scanner.nextLine.toLowerCase();

        if (yesorNo.equals("y") || yesOrNo.equals("yes")) {
            do { 
            System.out.println("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;
            if (guess > highLimit || guess < lowLimit) {
                System.out.println("just saying, the number is between" + lowLimit + " and " + highLimit + ".");
                System.out.println("You guessed " + guess);
            }
            else if (guess < numberToGuess) {
                System.out.println("Too low!");
                lowNumber == guess;
                System.out.println("Based on your guesses, the number is now between " + lowNumber + " and " + highNumber);
            }
            else if (guess < numberToGuess) {
                System.out.println("Too high!");
                highNumber = guess;
                System.out.println("Based on your guesses, the number is now between "  + lowNumber + " and " + highNumber);
            }
            
        } while (guess !=  numberToGuess);
        }
        else if (yesOrNo.equals("n") || yesOrNo.equals("no")) {
            System.out.println("That's a bit sad...");
            System.out.println("Come back later to play!");
        }

        scanner.close();
    }
}