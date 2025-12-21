// ----------------------
// DUNGEON TEXT ADVENTURE
// ----------------------

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class dungeonGame {

    private static final int INVENTORY_LIMIT = 5;
    private static final List<String> inventory = new ArrayList<>();

    private static final String ITEM_TORCH = "Torch";
    private static final String ITEM_BATTERY = "Battery";
    private static final String ITEM_LOCKED_BOX = "LockedBox";
    private static final String ITEM_SMALL_KEY = "SmallKey";
    private static final String ITEM_MASTER_KEY = "MasterKey";
    private static final String ITEM_OFFICER_DRESS = "OfficerDress";

    private static boolean playing = true;
    private static boolean torchWorking = false;

    private static int delay = 700;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You've been transported to Medieval England");
        pause();
        System.out.println("...and you're stuck in a dungeon.");
        pause();
        System.out.println("You try to find the torch that was in your pocket, but it rolled downhill along with the batteries");
        pause();
        System.out.println("What do you want to do?");
        pause();
        System.out.println("Type in (b) to try and break out or (e) to explore:");
        pause();
        System.out.println("You can also type help at anytime to check available commands");

        while (playing) {
            String choice = scanner.nextLine().trim().toLowerCase();
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

    private static void initialChoice(Scanner scanner, String choice) {
        if (choice.equals("help")) {
            System.out.println("Available commands: b, e");
            System.out.println("b: Try and break the metal gates of the dungeon");
            System.out.println("e: Explore the dungeon");
            return;
        }

        if (choice.equals("b") || choice.contains("break")) {
            System.out.println("You try to barge your way through the metal gates, but it is of no use.");
            pause();
            System.out.println("Though, you see a big padlock in the corner, just out of your reach.");
            pause();
            System.out.println("Maybe there is a key somewhere...");
            return;
        }

        if (choice.equals("e") || choice.contains("explore")) {
            exploreIntro(scanner);
            return;
        }

        System.out.println("That's not a valid option. Type help to see available commands.");
    }

    private static void exploreIntro(Scanner scanner) {
        System.out.println("You start walking deeper into the dungeon");
        pause();
        System.out.println("It starts getting darker and darker the further you walk.");
        pause();
        System.out.println("As you are walking, you find a torch on the floor");
        pause();
        System.out.println("Do you want to pick the torch up? (y/n)");
        String torch = scanner.nextLine().trim().toLowerCase();

        if (torch.equals("help")) {
            System.out.println("Available commands: y, n");
            return;
        }

        if (torch.equals("y") || torch.equals("yes")) {
            System.out.println("You pick the torch up, but there aren't any batteries inside.");
            pause();
            addToInventory(ITEM_TORCH, scanner);
        }

        exploreBatteries(scanner);
    }

    private static void exploreBatteries(Scanner scanner) {
        System.out.println("Out of luck, you find batteries on the floor!");
        pause();
        System.out.println("Do you want to pick them up? (y/n)");
        String batteryChoice = scanner.nextLine().trim().toLowerCase();
        if (batteryChoice.equals("y") || batteryChoice.equals("yes")) {
            addToInventory(ITEM_BATTERY, scanner);
        }

        if (inventory.contains(ITEM_TORCH) && inventory.contains(ITEM_BATTERY)) {
            System.out.println("Do you want to put the batteries in the torch? (y/n)");
            String putIn = scanner.nextLine().trim().toLowerCase();
            if (putIn.equals("y") || putIn.equals("yes")) {
                putBatteryInTorch();
                System.out.println("The torch is working now!");
            }
        }

        exploreTunnelChoice(scanner);
    }

    private static void exploreTunnelChoice(Scanner scanner) {
        System.out.println("You squint your eyes to try and see what is in the distance");
        System.out.println("There seem to be two tunnels...");
        pause();
        System.out.println("Choose your path wisely, dear traveller.");
        pause();
        System.out.println("Which one will it be? (A/B)");

        String tunnel = scanner.nextLine().trim().toLowerCase();
        // If we already have the master key, go finish instead of looping
        if (inventory.contains(ITEM_MASTER_KEY)) {
            escapeDungeon(scanner);
            return;
        }
        if (tunnel.equals("a")) {
            tunnelA(scanner);
            return;
        }
        if (tunnel.equals("b")) {
            tunnelB(scanner);
            return;
        }
        if (tunnel.equals("help")) {
            System.out.println("Available choices: A, B");
            return;
        }
        System.out.println("Huh? I didn't get that command. Try help.");
    }

    public static void tunnelA(Scanner scanner) {
        System.out.println("You decide to go down Tunnel A");
        pause();

        if (!inventory.contains(ITEM_TORCH) || !torchWorking) {
            System.out.println("It's too dark to keep going safely.");
            System.out.println("nice way to say you died");
            System.out.println("GAME OVER");
            System.exit(1);
            return;
        }

        if (!inventory.contains(ITEM_LOCKED_BOX)) {
            System.out.println("While walking, you spot a box on the floor.");
            pause();
            System.out.println("It says 'Property of the Kingdom of England'");
            pause();
            System.out.println("Do you want to pick it up? (y/n)");
            String pick = scanner.nextLine().trim().toLowerCase();
            if (pick.equals("y") || pick.equals("yes")) {
                addToInventory(ITEM_LOCKED_BOX, scanner);
            }
        }

        // If box + key are present, open it here to avoid re-looping prompts
        if (inventory.contains(ITEM_LOCKED_BOX) && inventory.contains(ITEM_SMALL_KEY) && !inventory.contains(ITEM_MASTER_KEY)) {
            System.out.println("Do you want to use the small key to open the box? (y/n)");
            String open = scanner.nextLine().trim().toLowerCase();
            if (open.equals("y") || open.equals("yes")) {
                System.out.println("You open the box...");
                pause();
                System.out.println("Inside is a MASTER KEY.");
                addToInventory(ITEM_MASTER_KEY, scanner);
            }
        }

        // If we already have the master key, go straight to escape
        if (inventory.contains(ITEM_MASTER_KEY)) {
            escapeDungeon(scanner);
            return;
        }

        System.out.println("The tunnel ends here.");
        pause();
        if (!inventory.contains(ITEM_SMALL_KEY)) {
            System.out.println("The box is locked... you probably need a key.");
            pause();
            System.out.println("You remember there was another tunnel. Maybe Tunnel B has something useful.");
        }

        System.out.println("Do you want to go to Tunnel B? (y/n)");
        String go = scanner.nextLine().trim().toLowerCase();
        if (go.equals("y") || go.equals("yes")) {
            tunnelB(scanner);
            return;
        }

        System.out.println("You wait around...");
        pause();
        System.out.println("Nothing happens.");
        exploreTunnelChoice(scanner);
    }

    public static void tunnelB(Scanner scanner) {
        System.out.println("You walk down Tunnel B.");
        pause();

        if (!inventory.contains(ITEM_TORCH) || !torchWorking) {
            System.out.println("It's too dark to keep going safely.");
            System.out.println("nice way to say you died");
            System.out.println("GAME OVER");
            System.exit(1);
            return;
        }

        System.out.println("While walking, you see a few tunnels.");
        pause();
        System.out.println("You can see 3 tunnels. Which one do you want to go in? (1, 2, 3)");
        String which = scanner.nextLine().trim().toLowerCase();

        if (which.equals("2")) {
            System.out.println("You walk down tunnel 2.");
            pause();
            if (!inventory.contains(ITEM_SMALL_KEY)) {
                System.out.println("You find a small key hidden behind a loose stone.");
                pause();
                System.out.println("Do you want to take it? (y/n)");
                String take = scanner.nextLine().trim().toLowerCase();
                if (take.equals("y") || take.equals("yes")) {
                    addToInventory(ITEM_SMALL_KEY, scanner);
                }
            } else {
                System.out.println("You already took the key from here.");
            }
            pause();
            System.out.println("You return to the intersection.");
        } else if (which.equals("1")) {
            System.out.println("You find something sharp and regret touching it.");
            pause();
            System.out.println("nice way to say you died");
            System.out.println("GAME OVER");
            System.exit(1);
            return;
        } else if (which.equals("3")) {
            System.out.println("This tunnel is empty. It's just cold stone.");
        } else if (which.equals("help")) {
            System.out.println("Avaiable commands: 1, 2, 3");
            System.out.println("2: Get the key (this is the important one)");
            return;
        } else {
            System.out.println("That's not a valid command.");
            return;
        }

        if (inventory.contains(ITEM_LOCKED_BOX) && inventory.contains(ITEM_SMALL_KEY) && !inventory.contains(ITEM_MASTER_KEY)) {
            System.out.println("Do you want to use the small key to open the box? (y/n)");
            String open = scanner.nextLine().trim().toLowerCase();
            if (open.equals("y") || open.equals("yes")) {
                System.out.println("You open the box...");
                pause();
                System.out.println("Inside is a MASTER KEY.");
                addToInventory(ITEM_MASTER_KEY, scanner);
            }
        }

        if (inventory.contains(ITEM_MASTER_KEY)) {
            escapeDungeon(scanner);
            return;
        }

        exploreTunnelChoice(scanner);
    }

    private static void escapeDungeon(Scanner scanner) {
        System.out.println("You go back to the dungeon gates.");
        pause();
        System.out.println("Do you want to use the master key to open the padlock? (y/n)");
        String open = scanner.nextLine().trim().toLowerCase();
        if (!(open.equals("y") || open.equals("yes"))) {
            System.out.println("You step back from the gate.");
            return;
        }

        System.out.println("Click.");
        pause();
        System.out.println("The padlock opens.");
        pause();
        System.out.println("On the other side, you find an officer dress.");
        addToInventory(ITEM_OFFICER_DRESS, scanner);
        pause();
        System.out.println("You have to wear it.");
        System.out.println("Do you want to wear it? (y/n)");
        String wear = scanner.nextLine().trim().toLowerCase();
        if (!(wear.equals("y") || wear.equals("yes"))) {
            System.out.println("You don't wear it. A guard immediately questions you.");
            System.out.println("GAME OVER");
            System.exit(1);
            return;
        }

        System.out.println("You put it on and straighten your posture.");
        pause();
        System.out.println("A guard approaches: 'State your business.'");
        pause();
        System.out.println("Say something like: 'I am an officer and I am leaving'");
        String say = scanner.nextLine().trim().toLowerCase();
        if (say.contains("officer") && (say.contains("leave") || say.contains("leaving"))) {
            System.out.println("The guard nods and steps aside.");
            pause();
            System.out.println("YOU ESCAPE!");
            playing = false;
            System.exit(0);
            return;
        }

        System.out.println("The guard doesn't believe you.");
        System.out.println("GAME OVER");
        System.exit(1);
    }

    private static void addToInventory(String item, Scanner scanner) {
        if (inventory.contains(item)) {
            System.out.println(item + " is already in your inventory.");
            return;
        }
        if (inventory.size() >= INVENTORY_LIMIT) {
            System.out.println("Your inventory is full! You can't carry anything more");
            return;
        }
        inventory.add(item);
        System.out.println(item + " has been added to your inventory!");
        System.out.println("Current inventory: " + inventory);
    }

    private static void putBatteryInTorch() {
        if (inventory.contains(ITEM_TORCH) && inventory.contains(ITEM_BATTERY)) {
            inventory.remove(ITEM_BATTERY);
            torchWorking = true;
        }
    }
}