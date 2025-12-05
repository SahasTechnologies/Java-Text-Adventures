import java.util.Scanner;

public class AdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        long startTime = System.currentTimeMillis();
        long timeLimit = 3 * 60 * 1000; // 3 minutes in milliseconds

        System.out.println("Welcome to this game!");

        while (playing) {
            // Check if time is up
            if (System.currentTimeMillis() - startTime >= timeLimit) {
                System.out.println("Time's up. The spaceship launches.");
                System.out.println("There's nothing you can do now...");
                System.out.println("Game over.");
                break; // end the game
            }

            System.out.println("You wake up to find yourself trapped in a spaceship.");
            System.out.println("You hear an alarm go off... the spaceship is launching in 3 minutes. You have to escape before then.");
            System.out.println("Write /time at any time to check how much time you have left.");
            System.out.println("You see 3 doors in front of you: The fuselage (f), the kitchen (k), and the compartment room (c). Where do you want to go?");

            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("/time")) {
                long elapsed = System.currentTimeMillis() - startTime;
                long remaining = (timeLimit - elapsed) / 1000;
                System.out.println("You have " + remaining + " seconds left!");
            } 
            else if (choice.equals("f")) {
                System.out.println("Hmm, seems like this door is locked. You'll need a key to unlock it.");
            } 
            else if (choice.equals("k")) {
                System.out.println("You enter the kitchen. It's messy, but maybe there's something useful here...");
            } 
            else if (choice.equals("c")) {
                System.out.println("You enter the compartment room. A locked chest awaits...");
            } 
            else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}