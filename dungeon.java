// ----------------------
// DUNGEON TEXT ADVENTURE
// ----------------------

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class dungeonGame {

    private static long startTime;
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
            } else if (bananaPeel.equals("n") || bananaPeel.equals("no")) {
                System.out.println("You didn't put the banana peel in your inventory.");
                printInventory();
            } else if (bananaPeel.equals("help")) {
                System.out.println("Available commands: y,n");
                System.out.println("y: Put the banana peel in your inventory");
                System.out.println("n: Don't put the banana peel in your inventory");
            }
        } else {
            System.out.println("There's a banana peel on the floor!");
            pause();
            System.out.println("...but you only find out after you slip on it...");
            healthChange(-10);
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
}