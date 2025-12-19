// ----------------------
// DUNGEON TEXT ADVENTURE
// ----------------------

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class dungeonGame {

    private static boolean initialBreak = false;
    private static final int INVENTORY_LIMIT = 5;
    private static List<String> inventory = new ArrayList<>();
    private static boolean inventoryUsed = false;
    private static int delay = 1 * 1000;
    private static boolean torchWorking = true;
    private static int health = 100;
    private static boolean healthUsed = false;
    private static boolean playing = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (playing) {
            System.out.println("You've been transported to Medieval England");
            pause();
            System.out.println("...and you're stuck in a dungeon.");
            pause();
            System.out.println("What do you want to do?");
            pause();
            System.out.println("Type in (b) to try and break out or (e) to explore:");
            pause();
            System.out.println("You can also type help at anytime to check available commands");
            String choice = scanner.nextLine().toLowerCase();
            initialChoice(scanner, choice);
        }

        scanner.close();
    }

    private static void pause() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void initialChoice(Scanner scanner, String choice) {
        if (choice.equals("b") || choice.contains("break")) {
            if (initialBreak) {
                System.out.println("Your shoulders are tired and you can't even try to break the metal gate.");
            } else {
                System.out.println("You try to barge your way through the metal gates, but it is of no use.");
                pause();
                System.out.println("Though, you see a big padlock in the corner, just out of your reach.");
                pause();
                System.out.println("Your shoulders hurt, and you give up.");
                pause();
                initialBreak = true;
            }
        }

        if (choice.equals("e") || choice.contains("explore")) {
            System.out.println("You start walking deeper into the dungeon");
            pause();
            System.out.println("It starts getting darker and darer the further you walk.");
            pause();
            System.out.println("As you are walking, you find a torch on the floor");
            pause();
            System.out.println("Do you want to pick the torch up? (y/n)");
            String torch = scanner.nextLine().toLowerCase();
            if (torch.equals("y") || torch.equals("yes")) {
                System.out.println("You pick the torch up, but there aren't any batteries inside.");
                pause();
                System.out.println("Do you still want to keep the torch with you? (y/n)");
                String keepTorch = scanner.nextLine().toLowerCase();
                if (keepTorch.equals("y") || keepTorch.equals("yes")) {
                    System.out.println("You keep the torch with you.");
                    addToInventory("Torch", scanner);
                    explore1(scanner);
                } else if (torch.equals("help")) {
                    System.out.println("Available commands: y, n");
                    System.out.println("y: Pick up the torch");
                    System.out.println("n: Not pick up the torch");
                    explore1(scanner);
                } else {
                    System.out.println("That's not a valid command. Type help to ");
                }
            } else if (torch.equals("n") || torch.equals("no")) {
                System.out.println("You left the torch behind.");
                explore1(scanner);
            }
        }

        else if (choice.equals("help")) {
            System.out.println("Available commands: b, e");
            System.out.println("b: Try and break the metal gates of the dungeon");
            System.out.println("e: Explore the dungeon");
            initialChoice(scanner, scanner.nextLine().toLowerCase());
        } else {
            System.out.println("That's not a valid option. Type help to see available commands.");
            initialChoice(scanner, scanner.nextLine().toLowerCase());
        }
    }

    public static void addToInventory(String item, Scanner scanner) {
        if (!inventoryUsed) {
            System.out.println("Welcome to your inventory!");
            pause();
            System.out.println("You can keep a maximum of " + INVENTORY_LIMIT + " things in here");
            pause();
            System.out.println("Type in inventory at anytime to check what is in your inventory.");
            pause();
            System.out.println("Type in drop (item) at any time to drop an item from your inventory.");
            pause();
            System.out.println("Keep in mind that when you drop an item, you can't pick it up again (since its dropped)");
            inventoryUsed = true;
        }
        if (inventory.contains(item)) {
            System.out.println(item + " is already in your inventory.");
            pause();
            System.out.println("Do you want to remove " + item + "?");
        } else if (inventory.size() < INVENTORY_LIMIT) {
            inventory.add(item);
            System.out.println(item + " has been added to your inventory!");
            printInventory();
        } else {
            System.out.println("Your inventory is full! You can't carry anything more");
            pause();
            System.out.println("Do you want to drop an item? (y/n)");
            String dropItem = scanner.nextLine().toLowerCase();
            if (dropItem.equals("y") || dropItem.equals("yes") || dropItem.contains("drop")) {
                // dropItem();
            } else if (dropItem.equals("n")) {
                System.out.println("Okay, you didn't drop anything.");
                pause();
                System.out.println("But, " + item + " didn't get added to your inventory");
            }
        }
    }

    public static void printInventory() {
        if (inventory.size() < 1) {
            System.out.println("You have nothing in your inventory.");
        } else {
            System.out.println("Current inventory: " + inventory);
        }
    }

    public static void explore1(Scanner scanner) {
        System.out.println("Out of luck, you find batteries on the floor!");
        pause();
        System.out.println("Do you want to add the batteries to your inventory?");
        String batteryChoice = scanner.nextLine().toLowerCase();
        if (batteryChoice.equals("y") || batteryChoice.equals("yes")) {
            if (inventory.contains("Torch")) {
                System.out.println("You can add the battery to your torch!");
                pause();
                System.out.println("Do you want to add the batteries in?");
                String torchBattery = scanner.nextLine().toLowerCase();
                if (torchBattery.equals("y") || torchBattery.equals("yes")) {
                    System.out.println("You add the batteries in the torch. The torch is working now!");
                    torchWorking = true;
                } else if (torchBattery.equals("n") || torchBattery.equals("no")) {
                    addToInventory("Battery", scanner);
                } else if (torchBattery.equals("help")) {
                    System.out.println("Available commands: y,n");
                    System.out.println("y: Add the battery to the torch");
                    System.out.println("n: Do not add the battery to the torch");
                }
            } else {
                addToInventory("Battery", scanner);
            }
        }
    }

    public static void explore2(Scanner scanner) {
        System.out.println("You continue walking deeper inside the dungeon.");
        pause();
        if (torchWorking) {
            System.out.println("You see a banana peel on the floor.");
            pause();
            System.out.println("Do you want to add this to your inventory? (y/n)");
            String bananaPeel = scanner.nextLine().toLowerCase();
            if (bananaPeel.equals("y") || bananaPeel.equals("yes")) {
                addToInventory("BananaPeel", scanner);
                System.out.println("The bacteria from the banana peel has infected your body.");
                pause();
                System.out.println("Who knows how long the banana peel has been there?");
                pause();
                healthChange(-10);
                explore3(scanner);
            } else if (bananaPeel.equals("n") || bananaPeel.equals("no")) {
                System.out.println("You didn't put the banana peel in your inventory.");
                printInventory();
                explore3(scanner);
            } else if (bananaPeel.equals("help")) {
                System.out.println("Available commands: y,n");
                System.out.println("y: Put the banana peel in your inventory");
                System.out.println("n: Don't put the banana peel in your inventory");
                explore3(scanner);
            }
        } else {
            System.out.println("There's a banana peel on the floor!");
            pause();
            System.out.println("...but you only find out after you slip on it...");
            healthChange(-10);
            explore3(scanner);
        }
    }

    public static void healthChange(int change) {
        if (!healthUsed) {
            System.out.println("Welcome to the health system!");
            System.out.println("Pretty obvious... you die when your health becomes 0...");
            healthUsed = true;
        }
        health += change;
        System.out.println("Your health is now " + health + "%");
        if (health <= 0) {
            System.out.println("... and you've died.");
            System.out.println("🎮 Game Over");
            playing = false;
        }
    }

    public static void explore3(Scanner scanner) {
        System.out.println("You squint your eyes to try and see what is in the distance");
        System.out.println("There seem to be two tunnels...");
        pause();
        System.out.println("   _________________________________________________________|");
        System.out.println(" /|     -_-                                             _-  |");
        System.out.println("/ |_-_- _                                         -_- _-   -|");
        System.out.println("  |                            _-  _--                      |");
        System.out.println("  |            A               ,               B            |");
        System.out.println("  |      .-'````````'.        '(`        .-'```````'-.      |");
        System.out.println("  |    .` |           `.      `)'      .` |           `.    |");
        System.out.println("  |   /   |   ()        \\      U      /   |    ()       \\ |");
        System.out.println("  |  |    |    ;         | o   T   o |    |    ;         |  |");
        System.out.println("  |  |    |     ;        |  .  |  .  |    |    ;         |  |");
        System.out.println("  |  |    |     ;        |   . | .   |    |    ;         |  |");
        System.out.println("  |  |    |     ;        |    .|.    |    |    ;         |  |");
        System.out.println("  |  |    |____;_________|     |     |    |____;_________|  |");
        System.out.println("  |  |   /  __ ;   -     |     !     |   /     `'() _ -  |  |");
        System.out.println("  |  |  / __  ()        -|        -  |  /  __--      -   |  |");
        System.out.println("  |  | /        __-- _   |   _- _ -  | /        __--_    |  |");
        System.out.println("  |__|/__________________|___________|/__________________|__|");
        System.out.println(" /                                             _ -          |");
        System.out.println("/   -_- _ -             _- _---                       -_-  -_");
        pause();
        System.out.println("Choose your path wisely, dear traveller.");
        pause();
        System.out.println("Which one will it be? (A/B/none)");
        String tunnel = scanner.nextLine().toLowerCase();
        if (tunnel.equals("A") ) {
            tunnelA(scanner);
        }
        else if (tunnel.equals("B")) {
            tunnelB(scanner);
        }
        else if (tunnel.equals("help")) {
            System.out.println("Available choices: A, B, none");
            System.out.println("A: Go to tunnel A");
            System.out.println("B: Go to tunnel B");
            System.out.println("None: Go back");
        }
        else {
            System.out.println("Huh? I didn't get that command.");
            System.out.println("Try help to see available commands");
        }
    }

    public static void tunnelA(Scanner scanner) {
        System.out.println("You decide to go down Tunnel A");
        pause();
        if (torch not in inventory) {
        System.out.println("It's quite dark... you shiver as you keep walking");
        System.out.println("After a point, you can't see anything.");
        System.out.println("Do you want to go back and pick up the torch?");
        String goBackTorch = scanner.nextLine().toLowerCase();    
        if (goBackTorch.equals("y") || goBackTorch.equals("yes")) {
            System.out.println("You go back to pick up the torch");
            pause();
            System.out.println("Somehow, almost magically...");
            System.out.println("you retrace your steps until you find the torch.");
            addToInventory(torch);
            pause();
            System.out.println("You walk back to where you were.");
            // code to say oof there is no battery do you want to go back and find the battery? and redirect to the other else if which is below
        }
        else if (goBackTorch.equals("n") || goBackTorch.equals("no")) {
            System.out.println("You decide to explore without a torch.");
            System.out.println("While walking, you slip on something and hit your head hard, with a loud thud.");
            System.out.println(nice way to say you died);
            retry(scanner);
        }
        else if (goBackTorch.equals("help")) {
            System.out.println("Available commands: y, n");
            System.out.println("y: Go back to pick up the torch");
            System.out.println("n: Don't go back to pick up the torch");
        }
        else {
            System.out.println("That's not a valid command. Try 'help' to find available commands");
        }

        else if (torch is in inventoy without battery) {
            System.out.println("It's quite dark...");
            if (battery is not in inventory) {
                System.out.println("You have a torch, but you can't turn it on, since there is no battery...");
                System.out.println("Do you want to go back to pick it up?");
                String pickBattery = scanner.nextLine().toLowerCase();
                    if (pickBattery.equals("y") || pickBattery.equals("yes")) {
                        System.out.println("You try to go back... but you can't retrace your steps.");
                        pause();
                        System.out.println("You're lost in the dark...");
                        pause();
                        System.out.println("You call for help, but nobody comes to help you.");
                        pause();
                        pause();
                        System.out.println("You wait and wait...");
                        System.out.println(nice way to say you died);
                        System.out.println("GAME OVER.");
                        retry(scanner);
                    }
                    else if (pickBattery.equals("n") || pickBattery.equals("no")) {
                        System.out.println("You decide not to go back to find the torch");
                        pause();
                        System.out.println("You continue walking, but lose yourself in the tunnel");
                        pause();
                        System.out.println("While retracing your steps, you hit your head on something...");
                        pause();
                        System.out.println("... or someone.");
                        pause();
                        System.out.println("You fall down on the floor unconscious, and sleep there forever.");

                    }
                    else if (pickBattery.equals("help")) {
                        System.out.println("Available commands: y,n");
                        System.out.println("y: Try to go back and pick up the battery");
                        System.out.println("n: Don't go back to pick up the battery")
                    }
            }
            else if (battery is in inventory) {
                System.out.println("You have a battery with you.");
                pause();
                System.out.println("Do you want to put them in the torch? (y/n)");
                String batteryInTorch = scanner.nextLine().toLowerCase();
                if (batteryInTorch.equals("y")|| batteryInTorch.equals("yes")) {
                    System.out.println("You put the battery inside the torch.");
                    putBatteryInTorch();
                    System.out.println("You can see now!");
                }
            }
        }
        

        }
    }

    public static void tunnelB(Scanner scanner) {
        System.out.println("You walk down Tunnel B.");
        if (torch is not in inventory) {
            System.out.println("It's quite dark, and you can't find your way around");
            System.out.println("Do you want to go back to try and find the torch? (y/n)");
            String doYouWantToGoBackToTryAndFindTheTorch = scanner.nextLine().toLowerCase(); //sorry about the doYouWantToGoBackToTryAndFIndTheTorch i was bored
            if (doYouWantToGobackToTryAndFindTheTorch.equals("y")|| doYouWantToGoBackToTryAndFindTheTorch.equals("yes")) {
                System.out.println("You go back and try and retrace your steps.");
                pause();
                System.out.println("While going back, you see a few tunnels.");
                pause();
                System.out.println("Your vision is hazy, and you can't remember where you came from");
                pause();
                System.out.println("You can only see 3 tunnels. Which one do you want to go in? (1, 2, 3)");
                String whichOneDoYouWantToGoIn = scanner.nextLine().toLowerCase(); //😂
                if (whichOneDoYouWantToGoIn.equals("1") || whichOneDoYouWantToGoIn.equals("1")) {
                    System.out.println("You walk for a long time through tunnel" + whichOneDoYouWantToGoIn);
                    pause();
                    System.out.println("You walk");
                    pause();
                    System.out.println("and you walk");
                    pause();
                    System.out.println("and you walk even more");
                    pause();
                    System.out.println("You feel like this is wrong road..");
                    pause();
                    System.out.println("Until you feel something beneath your feet.");
                    System.out.println("It's too dark to make out, but it's circular...");
                    pause();
                    System.out.println("Do you want to pick it up?");
                    String pick = scanner.nextLine().toLowerCase(); //i was about to write String doYouWantToPickItUp :p
                    if (pick.equals("y") || pick.equals("yes")) {
                        System.out.println("You pick it up...");
                        pause();
                        System.out.println("and you realise that it's not a torch.");
                        pause();
                        System.out.println("It's a tiny dagger!");
                        System.out.println("      .---.");
                        System.out.println("      |---|");
                        System.out.println("      |---|");
                        System.out.println("      |---|");
                        System.out.println("  .---^ - ^---.");
                        System.out.println("  :___________:");
                        System.out.println("    |  |//|");
                        System.out.println("    |  |//|");
                        System.out.println("    |  |//|");
                        System.out.println("    |  |//|");
                        System.out.println("    |  |//|");
                        System.out.println("    |  |//|");
                        System.out.println("    |  |.-|");
                        System.out.println("    |.-'**|");
                        System.out.println("     \***/");
                        System.out.println("      \*/");
                        System.out.println("       V");
                        pause();
                        System.out.println("");
                        System.out.println("      '");
                        System.out.println("       ^'");
                        System.out.println("      (_)");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("   -.   ^   .-");
                        System.out.println("_____\'.|.'/________");
                        System.out.println("ASCII Art credit to kevin kreamer - kreamer@centraltx.net");
                        pause();
                        System.out.println("As you take it out of the circular box, you just see the outline of a drop of blood fall");
                        pause();
                        System.out.println("A few seconds later, you realise that it was your blood, when your hand starts to pain.");
                        pause();
                        System.out.println("Only then do you realise just how numb your hand is, and how fatigued you are.");
                        pause();
                        System.out.println("You're too tired to move...");
                        pause();
                        System.out.println("So you sleep.");
                        pause();
                        pause();
                        System.out.println("ᵃⁿᵈ ʸᵒᵘ ⁿᵉᵛᵉʳ ʷᵃᵏᵉ ᵘᵖ ᵃᵍᵃᶦⁿ...");
                        pause();
                        System.out.println("GAME OVER");
                        retry(scanner);


                    }
                    else if (pick.equals("n") || pick.equals("no")) {
                        System.out.println("You decide not to pick it up.");
                        pause();
                        System.out.println("You can't help but wonder if it was a torch...");
                        System.out.println("but you're too fatigued to think about it now.");
                        pause();
                        System.out.println("You walkk back to the intersection where the tunnels meet.");
                        //code to ask again where do you want to go and this time make sure that only options are the tunnels the person hasnt gone to yet
                    }
                    else if (pick.equals("help")) {
                        System.out.println("Available commands: y, n");
                        System.out.println("y: Pick up the circular item");
                        System.out.println("n: Don't pick up the circular item");

                    }
                    else {
                        System.out.println("That's not a valid command. Type help to see available options");
                    }

                }
                else if (whichOneDoYouWantToGoIn.equals("2")) {
                    System.out.println("You walk down tunnel 2.");
                }

                else if (whichOneDoYouWantToGoIn.equals("3")) {
                    System.out.println("You walk down tunnel 3.");
                    
                }

                else if (whichOneDoYouWantToGoIn.equals("help")) {
                    System.out.println("Avaiable commands: 1, 2, 3");
                    System.out.println("1: Walk down tunnel 1");
                    System.out.println("2: Walk down tunnel 2");
                    System.out.println("3: Walk down tunnel 3");
                }

                else {
                    System.out.println("That's not a valid command. Try 'help' for available commands");
                }
            
        }
        else if (doYouWantToGoBackToTryAndFindTheTorch.equals("n")) {
            // i regret naming it doyou want to go bak to try and find the torch
            System.out.println("")
        }
        
        System.out.println("You spot a box on the floor.");
        System.out.println("Do you want to pick the box up? (y/n)");
        String box = scanner.nextLine().toLowerCase();
        if (box.equals("y") || box.equals("yes")) {
            addToInventory(box);
            System.out.println("The box has a lock on it. Can you find the key?");
        }
    }

    public static void retry (Scanner scanner) {
        break; //break the while playing loop
        System.out.println("Do you want to retry, or do you give up? (y/n)");
        String retry = scanner.nextLine().toLowerCase();
        if (retry.equals("y") || retry.equals("yes")) {
            unbreak;
        }
        else if (retry.equals("n") || retry.equals("no")) {
            System.out.println("goodbye!");
            System.out.println("                               ______________________________________ |");
            System.out.println("                               |                                      |");
            System.out.println("                    _.---------|.--.                                  |");
            System.out.println("                 .-'  `       .'/  ``                                 |");
            System.out.println("              .-'           .' |    /|                                |");
            System.out.println("           .-'         |   /   `.__//                                 |");
            System.out.println("        .-'           _.--/        /       GOODBYE!                   |");
            System.out.println("       |        _  .-'   /        /        see you next time...       |");
            System.out.println("       |     ._  \\      /     `  /        :D                         |");
            System.out.println("       |        ` .    /     `  /                                     |");
            System.out.println("       |         \\ \\ '/        /                                    |");
            System.out.println("       |        - \\  /        /|                                     |");
            System.out.println("       |        '  .'        / |                                      |");
            System.out.println("       |          '         |.'|                                      |");
            System.out.println("       |                    |  |                                      |");
            System.out.println("       |                    |  |______________________________________|");
            System.out.println("       |                    |.'");
            System.out.println("       |                    /");
            System.out.println("       |                   /");
            System.out.println("       |                  /");
            System.out.println("       )                 /|");
            System.out.println("    .A/`-.              / |");
            System.out.println("   AMMMA. `-._         / /");
            System.out.println("  AMMMMMMMMA. `-.     / /");
            System.out.println(" AMMMMMMMMMMMMA. `.    /");
            System.out.println("AMMMMMMMMMMMMMMMMA.`. /");
            System.out.println("MMMMMMMMMMMMMMMMMMMA.`.");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMA.`.");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMA.");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMA.");
            System.out.println("MMVKMMMMMMMMMMMMMMMMMMMMMMM");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMV'");
            System.out.println("ASCII art credit to https://asciiart.website/art/4901");
            System.out.println();
            System.exit(1);
        }
        else if (retry.equals("help")) {
            System.out.println("Available commands: y,n");
            System.out.println("y: Retry the game");
            System.out.println("n: Exit the game");
        }
        else {
            System.out.println("Huh? I didn't get that. That's not a valid command. Type help for commands info");
        }
    }
}


//CREDIT TO SID (my friend) who gave me this idea and i made it into a 500 line plus game\
// it did tae me, like, 10 hours to finish though