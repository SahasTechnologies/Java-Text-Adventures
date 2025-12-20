import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

class AdventureGame {

// ---------------------------------------------------------------------------
// the variables
// idk why there are so many even though its under 300 lines :sob:
// ---------------------------------------------------------------------------
    
    //the time
    private static long startTime;
    // Corrected TIME_LIMIT definition
    private static final long TIME_LIMIT = 3 * 60 * 1000L; //3min in millis

    // all my booleans
    private static boolean hasKey = false;
    private static boolean hasMap = false;
    private static boolean pickedKnife = false;
    private static boolean playing = true; // Added to control the while loop in main

    // all my ints
    private static int exitTries = 0;
    private static Set<Integer> triedDoors = new HashSet<>(); // check tried doorts
    private static int hintsUsed_Compartment = 0; //for the compartment box with the key
    private static int hintsUsed_map = 0;
    private static int hintsUsed_Exit = 0; //for the actual exit
    private static final int CORRECT_DOOR = 90; //its an int in case i need to change it for whatever reason
    // by the way, 90 is statistically proven to be the least chosen 'random' number by humans
    // good luck exiting this without a map

    // A static Random object for general random choices
    private static final Random random = new Random();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // boolean playing = true; // Moved this declaration to static field above

        startTime = System.currentTimeMillis(); //start countdown

        System.out.println("Welcome to Escape the Spaceship!");
        System.out.println("-----");

        while (playing) {
            // Check if time is up
            if (System.currentTimeMillis() - startTime >= TIME_LIMIT) {
                gameOver(); // Calls the loss method with System.exit(1)
                break; 
            }

            //show the remaining time for the user to see
            long elapsed = System.currentTimeMillis() - startTime;
            long remainingSeconds = (TIME_LIMIT - elapsed) / 1000;

            //the starting prints
            System.out.println("\n--- Current Location: Main Hallway ---");
            System.out.println("You wake up to find yourself trapped in a spaceship.");
            System.out.println("You hear an alarm go off... the spaceship is launching in 3 minutes. You have to escape before then.");
            System.out.println("Write /time at any time to check how much time you have left.");
            System.out.println("You see 3 doors in front of you:");
            System.out.println("The Fuselage Room (f), The Kitchen (k) and the Compartment Room (c)");
            System.out.println("Where do you want to go? (f/k/c) or type /time for remaining time.");

            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("/time")) {
                timeleft(); // Removed scanner argument as it's not used here
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
        } // this one ends the while loop (i get confused when there are many {}s)

        scanner.close();
    }// end main
    
    // --- NEW METHOD FOR GAME LOSS (Time's Up) ---
    public static void gameOver() {
        System.out.println("\n ALARM BLARING: You have no more time left to escape the spaceship.");
        System.out.println("Time's up. The spaceship launches.");
        System.out.println("There's nothing you can do now...");
        System.out.println("--- Game over. ---");
        
        // Signal a loss (Failure) to the calling program
        System.exit(1); 
    }
    // ---------------------------------------------


    // Helper method to deduct time
    public static void addTimePenalty(int seconds) {
        // Increases the startTime, which reduces the effective TIME_LIMIT duration
        startTime -= TimeUnit.SECONDS.toMillis(seconds); 
    }
    
    // Helper method to show remaining time
    public static void timeleft() {
        long elapsed = System.currentTimeMillis() - startTime;
        long remainingSeconds = (TIME_LIMIT - elapsed) / 1000;
        if (remainingSeconds < 0) remainingSeconds = 0;

        System.out.println("You have " + remainingSeconds + " seconds left.");
        return;
    }

    // the specific room logic starts here:
    // what is public static void???? def() in python is so much easier
    public static void fuselage(Scanner scanner) {
        // IF person does not have key
        if (!hasKey){
            System.out.println("\n--- Current Location: Fuselage Door ---"); // Corrected typo in Location
            System.out.println("Hmm, seems like this door is locked. You'll need a key to unlock it.");
            return; // Needs to be 'return;' not 'return false;' for a void method
        }
        else { //if person DOES have the key
            System.out.println("\n--- Current Location: Fuselage ---"); // Corrected typo in Location
            System.out.println("You use the key to open the door of the fuselage.");
            
            if (!hasMap) { //! means does not
                System.out.println("Inside the fuselage you find an endless number of hallways...");
                System.out.println("You'll need to find a map to exit, or you can try your luck");
                System.out.println("Type exit to exit and find the map, or try to try and find your way out.");

                String choice = scanner.nextLine().toLowerCase();
                
                if (choice.equals("try")) {
                    if (exitTries == 0) { // Changed assignment to comparison and removed semicolon
                        System.out.println("You see 100 doors in front of you. Counting these doors takes 15 seconds");
                        addTimePenalty(15);
                    } else { // Removed unnecessary brackets
                        System.out.println("You know that there are 100 doors.");
                        System.out.println("You've tried doors: " + triedDoors); // Added the tried doors set
                    }
                    
                    System.out.println("Which door do you choose to try? (Enter a number 1-100)");
                    
                    // Input handling for integer choice
                    try {
                        String doorInput = scanner.nextLine();
                        int doorChoice = Integer.parseInt(doorInput);
                        
                        if (doorChoice >= 1 && doorChoice <= 100) { // Corrected logic check
                            
                            boolean alreadyTried = triedDoors.contains(doorChoice);
                            
                            if (alreadyTried) {
                                System.out.println("You've already tried this door, but you go in and check again...");
                            } 
                            
                            triedDoors.add(doorChoice); // Add door to tried set
                            exitTries++;
                            exitNumber(doorChoice, scanner); // Pass the chosen door number
                            
                        } else {
                            System.out.println("That's not a door number between 1 and 100.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                    
                } else if (choice.equals("exit")) {
                    System.out.println("You retreat back to the main hallway to find a map.");
                    return;
                } else {
                    System.out.println("Invalid choice. Returning to the main hallway.");
                    return;
                }
            }
            else { // User has map
                System.out.println("Luckily you have a map, and you find the correct door");
                System.out.println("You find the door labelled exit, but it has a 3-digit lock on it");
                exitriddle(scanner);
            }
        }
    }

    public static void kitchen(Scanner scanner) { //what is a scanner scanner?????;
        System.out.println("\n--- Current Location: Kitchen ---");
        System.out.println("You enter the kitchen. It's messy, but you spot something shiny.");
        
        if (pickedKnife) {
            System.out.println("You already picked up the knife. Your hand is still bleeding.");
            return;
        }

        System.out.println("Do you want to pick up the shiny object? (y/n)");
        String choice = scanner.nextLine().toLowerCase();
        
        // Corrected logic to use .contains for "y" or "yes"
        if (choice.contains("y")) { 
            System.out.println("It turned out to be a sharp knife.");
            System.out.println("As you picked it up, it made a big cut in your palm.");
            System.out.println("It was also rusted on the other side.");
            System.out.println("You're losing blood, fast. You also now need to go to hospital.");
            System.out.println("-30s on time.");
            addTimePenalty(30); // Corrected: Call the method to add penalty
            pickedKnife = true;
            System.out.println("You walk back with a bloody hand.");
        } 
        // Corrected logic to use .contains for "n" or "no"
        else if (choice.contains("n")) { 
            System.out.println("You decide not to pick it up. As you walk back, you can't help but think what that could have been.");
            System.out.println("Could it have been a key?");
        } else {
            System.out.println("Invalid choice. You leave the room.");
        }
    }

    public static void compartment(Scanner scanner) {
        System.out.println("\n--- Current Location: Compartment Room ---");
        System.out.println("You enter and find a box and a panel.");
        System.out.println("Do you want to check the box or the panel? (b/p) or type exit to leave.");
        String choice = scanner.nextLine().toLowerCase();
        
        if (choice.contains("b") || choice.contains("box") || choice.contains("container")) {
            compartmentbox(scanner);
        }
        else if (choice.contains("p") || choice.contains("panel")) {
            compartmentmap(scanner);
        }
        else if (choice.equals("exit")) {
            System.out.println("You shrug and start to leave the room.");
        }
        else {
            System.out.println("Invalid choice. You leave the room.");
        }
    }
    
    public static void compartmentbox(Scanner scanner) {
        if (hasKey) {
            System.out.println("The box is already open and empty.");
            return;
        }

        System.out.println("Solve this riddle to open the box.");
        System.out.println("I have a mouth that never speaks,");
        System.out.println("A hunger nothing can appease.");
        System.out.println("I swallow suns without a trace...");
        System.out.println("What am I, lurking out in space?");
        System.out.println("If this is too hard, type exit to exit the room or hint for a hint (penalty: -10s).");
        
        String answer = scanner.nextLine().toLowerCase();

        if (answer.contains("black hole")) {
            System.out.println("You got it!");
            System.out.println("You found inside a key, covered in gold.");
            System.out.println("On it, it's written:");
            System.out.println("Use only in emergencies");
            System.out.println("You keep this in your pocket and start to leave the room.");
            hasKey = true; //set variable hasKey to true
        } else if (answer.equals("hint")) {
            //add code here to check for how many hints have been used up and show hint1,2,3 accoringly
            //FIXME - implemented logic below
            
            if (hintsUsed_Compartment < 3) {
                hintsUsed_Compartment++;
                addTimePenalty(10);
                System.out.println("Time penalty applied: -10s");
            }

            switch (hintsUsed_Compartment) {
                case 1:
                    System.out.println("HINT 1: Where even time forgets is steps, a shadow's edge marks the point... of no return."); 
                    break;
                case 2:
                    System.out.println("HINT 2: Beyond my event horizon, nothing, and I mean nothing, can come back out."); 
                    break;
                case 3:
                    System.out.println("HINT 3: I am an object with gravity so strong that not even light can escape me."); 
                    break;
            }
            
            if (hintsUsed_Compartment == 3) {
                System.out.println("You've used up all your available hints.");
            }
            System.out.println("Press exit to exit or retry to try the riddle again.");
            String nextAction = scanner.nextLine().toLowerCase();
            if (nextAction.equals("retry")) {
                compartmentbox(scanner);
            }
        } else if (answer.equals("exit")) {
            System.out.println("You decide to leave the box alone for now.");
        } else {
            System.out.println("That's incorrect. Try again.");
            compartmentbox(scanner); // Recursive call to retry
        }
    }

    public static void compartmentmap(Scanner scanner) {
        //Place where the user will find the map
        if (hasMap) {
            System.out.println("You've already found the map. It's safe in your pocket.");
            return;
        }
        System.out.println("You find a hidden panel and slide it open. Inside is a detailed MAP of the spaceship!");
        System.out.println("The map clearly shows the correct path through the Fuselage.");
        hasMap = true;
    }

    public static void exitriddle(Scanner scanner) { 
        System.out.println("\n--- The Exit Lock Riddle ---");
        System.out.println("I'm the number of a perfect sweep,");
        System.out.println("A full embrace where angles sleep.");
        System.out.println("I bind the round in unseen code -");
        System.out.println("Name me, and close the road.");
        System.out.println("Give the 3-digit code to exit, or type hint for a hint (penalty: -5s)");
        
        String input = scanner.nextLine().trim();
        
        if (input.equals("hint")) { 
            
            if (hintsUsed_Exit < 3) {
                hintsUsed_Exit++;
                addTimePenalty(5);
                System.out.println("Time penalty applied: -5s");
            }
            
   
            switch (hintsUsed_Exit) {
                case 1:
                    System.out.println("HINT 1: I count a journey that ends where it begins, unchanged yet composite.");
                    break;
                case 2:
                    System.out.println("HINT 2: I'm highly composite - divisible by 2, 3, 4, 5, 6, 8, 9, 10 and 12.");
                    break;
                case 3:
                    System.out.println("HINT 3: I'm the toal degrees in a full circle.");
                    break;
            }
            
            if (hintsUsed_Exit == 3) {
                System.out.println("You've used up all your available hints.");
            }
            exitriddle(scanner);
            
        } else {

            try {
                int code = Integer.parseInt(input);
                
                if (input.matches("\\d{3}")) { // Check if input is exactly 3 digits
                    
                    System.out.println("You try the code: " + code);
                    addTimePenalty(2); //add code to minus 2 seconds from the time
                    System.out.println("It took you 2 seconds to try the code (-2s).");
                    
                    if (code == 360) { 
                        finalExit();
                    } else { 
                        System.out.println("You try the code, but it doesn't open.");
                        exitriddle(scanner);
                    }
                    
                } else { 
                    System.out.println("That's not even 3 digits!");
                    System.out.println("You have to enter a 3 digit code since it is 3 digits.");
                    exitriddle(scanner);
                }
            } catch (NumberFormatException e) {
                System.out.println("Is that a decimal? Or not a number?");
                System.out.println("You can't put decimals in a lock, just saying.");
                System.out.println("That's not a valid 3 digit code. Try again.");
                System.out.println("Just saying - the code has numbers only.");
                exitriddle(scanner);
            }
        }
    }

    public static void finalExit() { 
        playing = false; // Stop the main game loop
        
        // This calculates the final time remaining before printing the success message
        long elapsed = System.currentTimeMillis() - startTime;
        long remaining = (TIME_LIMIT - elapsed) / 1000;
        if (remaining < 0) remaining = 0; // Ensure remaining time isn't negative
        
        System.out.println("\n SUCCESS! ");
        System.out.println("That's correct! You escape the spaceship in time!");
        
        System.out.println("You had " + remaining + " seconds remaining!"); //actually make it show the remaininf time
        if (pickedKnife) {
            System.out.println("But your hand is bleeding... you need a hospital fast!");
        }
        System.out.println("--- Game Over! ---");
        
        System.exit(0);
    }

    

    public static void exitNumber(int chosenDoor, Scanner scanner) { 
        String[] sentences = {
            "With sweat on your face, you go to check the door, hoping that it is the exit",
            "You walk towards the door, praying that it will be the exit",
            "You hope that this door will be the exit",
            "You hope it's the exit...",
            "You run towards the door, silently cursing yourself for not finding a map",
            "You go towards the door, wishing you had taken the map with you."
        };

        
        System.out.println(sentences[random.nextInt(sentences.length)]);
    
        System.out.println("Checking this door takes 1 second of your time. (-1s)");
        addTimePenalty(1);
        
        if (chosenDoor == CORRECT_DOOR) {
            System.out.println("You found the correct door!");
            exitriddle(scanner);
        } else {
            System.out.println("The door is a dead end. You return to the hallway.");
        }
    }
}