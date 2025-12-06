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
                fuselage(scanner);
            } 
            else if (choice.equals("k")) {
                kitchen(scanner);
            } 
            else if (choice.equals("c")) {
                compartment(scanner);
            } 
            else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    public static void fuselage(Scanner scanner) {
            // IF person does not have key
        if (user does not have the key){
            System.out.println("Hmm, seems like this door is locked. You'll need a key to unlock it.");
        }
        else {
            System.out.println("You use the key to open the door of the fuselage.");
            System.out.println("Inside the fuselage you find an endless number of hallways...");
            if (user does not have the map) {
                System.out.println("You'll need to find a map to exit, or you can try your luck");
                System.out.println("Type exit to exit and find the map, or try to try and find your way out.");
            }
            else {
                System.out.println("Luckily you have a map, and you find the correct door");
                System.out.println("You find the door labelled exit, but it has a 3-digit lock on it");
                exitriddle(scanner)
            }

        }
    }
// what is public static void???? def() in python is so much easier
    public static void kitchen(Scanner scanner) { //what is a scanner scanner?????;
        System.out.println("You enter the kitchen. It's messy, but you spot something shiny.");
        System.out.println("Do you want to pick up the shiny object? (y/n)");
        if (choice.equals("y")) {
            System.out.println("It turned out to be a sharp knife.");
            System.out.println("As you picked it up, it made a big cut in your palm.");
            System.out.println("It was also rusted on the other side.")
            System.out.println("You're losing blood, fast. You also now need to go to hospital.");
            System.out.println("-30s on time.");
            System.out.println("You walk back with a bloody hand.");
        if (choice.equals("n")) {
            System.out.println("You decide not to pick it up. As you walk back, you can't help but think what that could have been.");
            System.out.println("Could it have been a key?");
        }
        }
    }

    public static void compartment(Scanner scanner) {
        System.out.println("You enter and find a box");
        System.out.println("Do you want to pick this box up? (y/n)");
        if (choice.equals("y")) {
            compartmentbox(scanner);
        }
        else if (choice.equals("n")) {
            System.out.println("You shrug and start to leave the room");
            compartmentmap(scanner);
        }
       
    }
    
    public static void compartmentbox(Scanner scanner) {
        System.out.println("Solve this riddle to enter the room.");
        System.out.println("I have a mouth that never speaks,");
        System.out.println("A hunger nothing can appease.");
        System.out.println("I swallow suns without a trace...");
        System.out.println("What am I, lurking out in space?");
        System.out.println("If this is too hard, type exit to exit the room or hint for a hint (-10s)");
        if (choice.equals("Black Hole")) {
                System.out.println("You got it!");
                System.out.println("You found inside a key, covered in gold.");
                System.out.println("On it, it's written:");
                System.out.println("Use only in emergencies");
                System.out.println("You keep this in your pocket and start to leave the room.");
                //set variable has_key to TRUE
        else if (choice.equals("hint")) {
            //add code here to check for how many hints have been used up and show hint1,2,3 accoringly
            //FIXME
            System.out.println("Where even time forgets is steps, a shadow's edge marks the point... of no return.") //HINT 1
            System.out.println("Beyond my event horizon, nothing, and I mean nothing, can come back out.") //HINT 2
            System.out.println("I am an object with gravity so strong that not even light can escape me.") //HINT 3
            System.out.println("You've used up all your available hints. Press exit to exit or repeathint to repeat the hints you were already given (no time penalty)")
        }
        }
    }

    public static void compartmentmap(Scanner scanner);
        //Place where the user will find the map

    public static void exitriddle(Scanner scanner); {
        System.out.println("I'm the number of a perfect sweep,");
        System.out.println("A full embrace where angles sleep.");
        System.out.println("I bind the round in unseen code -");
        System.out.println("Name me, and close the road.");
        System.out.println("Give the 3-digit code to exit, or type hint for a int (-5s)");
        if
    }

}