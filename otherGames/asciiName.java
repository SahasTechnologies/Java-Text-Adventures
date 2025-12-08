/// -----------------------------------------
/// MAKE ASCII FROM YOUR NAME!!!
/// -----------------------------------------
import java.util.*;
// thanks to patorjk.com

public class AsciiArt {

    // for adding multiple fonts :D
    //private static final Map<Character, String[]> ANSI_REGULAR = new HashMap<>();
    //private static final Map<Character, String[]> ISOMETRIC = new HashMap<>();
    // i wanted to add multiple fonts but i cant since this will take wayyyy too long
    private static final Map<Character, String[]> ANSI_REGULAR = new HashMap<>();

    // TO HACKATIME STAFF
    // IF I GET BANNED FOR COPY PASTING
    // I am copying my own code to not repeat it and change all the colours pls dont ban me please
    // this was very painful as you can guess
    static {
        // the ANSI regular font
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('B', new String[]{
            "██████  ",
            "██   ██ ",
            "██████  ",
            "██   ██ ",
            "██████  "
        });
        ANSI_REGULAR.put('C', new String[]{
            " ██████ ",
            "██      ",
            "██      ",
            "██      ",
            " ██████ "
        });
        ANSI_REGULAR.put('D', new String[]{
            "██████  ",
            "██   ██ ",
            "██   ██ ",
            "██   ██ ",
            "██████  "
        });
        ANSI_REGULAR.put('E', new String[]{
            "███████ ",
            "██      ",
            "█████   ",
            "██      ",
            "███████ "
        });
        ANSI_REGULAR.put('F', new String[]{
            "███████ ",
            "██      ",
            "█████   ",
            "██      ",
            "██      "
        });
        ANSI_REGULAR.put('G', new String[]{
            " ██████ ",
            "██      ",
            "██   ███",
            "██    ██",
            " ██████ "
        });
        ANSI_REGULAR.put('H', new String[]{
            "██   ██ ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('I', new String[]{
            "██ ",
            "██ ",
            "██ ",
            "██ ",
            "██ "
        });
        ANSI_REGULAR.put('J', new String[]{
            "     ██ ",
            "     ██ ",
            "     ██ ",
            "██   ██ ",
            " █████  "
        });
        ANSI_REGULAR.put('K', new String[]{
            "██   ██ ",
            "██  ██  ",
            "█████   ",
            "██  ██  ",
            "██   ██ "
        });
        ANSI_REGULAR.put('L', new String[]{
            "██      ",
            "██      ",
            "██      ",
            "██      ",
            "███████ "
        });
        ANSI_REGULAR.put('M', new String[]{
            "███    ███ ",
            "████  ████ ",
            "██ ████ ██ ",
            "██  ██  ██ ",
            "██      ██ "
        });
        ANSI_REGULAR.put('N', new String[]{
            "███    ██ ",
            "████   ██ ",
            "██ ██  ██ ",
            "██  ██ ██ ",
            "██   ████ "
        });
        ANSI_REGULAR.put('O', new String[]{
            " ██████  ",
            "██    ██ ",
            "██    ██ ",
            "██    ██ ",
            " ██████  "
        });
        ANSI_REGULAR.put('P', new String[]{
            "██████  ",
            "██   ██ ",
            "██████  ",
            "██      ",
            "██      "
        });
        ANSI_REGULAR.put('Q', new String[]{
            " ██████  ",
            "██    ██ ",
            "██ ▄▄ ██ ",
            " ██████  ",
            "    ▀▀   "
        });
        ANSI_REGULAR.put('R', new String[]{
            "██████  ",
            "██   ██ ",
            "██████  ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('S', new String[]{
            "███████ ",
            "██      ",
            "███████ ",
            "     ██ ",
            "███████ "
        });
        ANSI_REGULAR.put('T', new String[]{
            "████████ ",
            "   ██    ",
            "   ██    ",
            "   ██    ",
            "   ██    "
        });
        ANSI_REGULAR.put('U', new String[]{
            "██    ██ ",
            "██    ██ ",
            "██    ██ ",
            "██    ██ ",
            " ██████  "
        });
        ANSI_REGULAR.put('V', new String[]{
            "██    ██ ",
            "██    ██ ",
            "██    ██ ",
            " ██  ██  ",
            "  ████   "
        });
        ANSI_REGULAR.put('W', new String[]{
            "██     ██ ",
            "██     ██ ",
            "██  █  ██ ",
            "██ ███ ██ ",
            " ███ ███  "
        });
        ANSI_REGULAR.put('X', new String[]{
            "██   ██ ",
            " ██ ██  ",
            "  ███   ",
            " ██ ██  ",
            "██   ██ "
        });
        ANSI_REGULAR.put('Y', new String[]{
            "██    ██ ",
            " ██  ██  ",
            "  ████   ",
            "   ██    ",
            "   ██    "
        });
        ANSI_REGULAR.put('Z', new String[]{
            "███████ ",
            "   ███  ",
            "  ███   ",
            " ███    ",
            "███████ "
        });

        // Digits 0-9
        ANSI_REGULAR.put('0', new String[]{
            " ██████  ",
            "██  ████ ",
            "██ ██ ██ ",
            "████  ██ ",
            " ██████  "
        });
        ANSI_REGULAR.put('1', new String[]{
            " ██ ",
            "███ ",
            " ██ ",
            " ██ ",
            " ██ "
        });
        ANSI_REGULAR.put('2', new String[]{
            "██████  ",
            "     ██ ",
            " █████  ",
            "██      ",
            "███████ "
        });
        ANSI_REGULAR.put('3', new String[]{
            "██████  ",
            "     ██ ",
            " █████  ",
            "     ██ ",
            "██████  "
        });
        ANSI_REGULAR.put('4', new String[]{
            "██   ██ ",
            "██   ██ ",
            "███████ ",
            "     ██ ",
            "     ██ "
        });
        ANSI_REGULAR.put('5', new String[]{
            "███████ ",
            "██      ",
            "███████ ",
            "     ██ ",
            "███████ "
        });
        ANSI_REGULAR.put('6', new String[]{
            " ██████  ",
            "██       ",
            "███████  ",
            "██    ██ ",
            " ██████  "
        });
        ANSI_REGULAR.put('7', new String[]{
            "███████ ",
            "     ██ ",
            "    ██  ",
            "   ██   ",
            "   ██   "
        });
        ANSI_REGULAR.put('8', new String[]{
            " █████  ",
            "██   ██ ",
            " █████  ",
            "██   ██ ",
            " █████  "
        });
        ANSI_REGULAR.put('9', new String[]{
            " █████  ",
            "██   ██ ",
            " ██████ ",
            "     ██ ",
            " █████  "
        });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Welcome to ASCII Name Generator! ---");

        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("Only use A-Z and 0-9 otherwise it can't be ascii-ed");
            System.out.println("What do you want to ascii-ify?");
            String text = scanner.nextLine().toUpperCase();

            // Print ASCII art
            printAscii(text);

            // Credit and colour prompt
            System.out.println("\nCredit to patorjk.com for the ASCII Text!");
            System.out.println("Do you want this in a different colour? (y/n)");
            String colourChoice = scanner.nextLine().trim().toLowerCase();

            if (colourChoice.equals("y") || colourChoice.equals("yes")) {
                System.out.println("Choose a colour: ");
                System.out.println("1. Red");
                System.out.println("2. Green");
                System.out.println("3. Blue");

                String colour = scanner.nextLine().trim().toLowerCase();
                String ANSI_RED = "\u001B[31m";
                String ANSI_GREEN = "\u001B[32m";
                String ANSI_BLUE = "\u001B[34m";
                String ANSI_RESET = "\u001B[0m";

                String selectedColour;
                if (colour.equals("1") || colour.equals("red")) {
                    selectedColour = ANSI_RED;
                } else if (colour.equals("2") || colour.equals("green")) {
                    selectedColour = ANSI_GREEN;
                } else if (colour.equals("3") || colour.equals("blue")) {
                    selectedColour = ANSI_BLUE;
                } else {
                    System.out.println("Invalid choice, defaulting to no colour.");
                    selectedColour = "";
                }

                // Reprint the same text in selected colour
                printAsciiColored(text, selectedColour, ANSI_RESET);

                System.out.println("Your system/IDE might not support ANSI colour, and if it doesnt...");
                System.out.println("Well, there's not much i can do about that...");
            } else if (!colourChoice.equals("n") && !colourChoice.equals("no")) {
                System.out.println("Invalid choice, continuing without colour.");
            } //ansi doesn't work for me 😭 so idk if this really works

            // Ask to ascii-ify more
            System.out.println("Do you want to ASCII-ify more stuff? (y/n)");
            String again = scanner.nextLine().trim().toLowerCase();
            if (!(again.equals("y") || again.equals("yes"))) {
                keepGoing = false;
                System.out.println("Thank you for using the ASCII Name Generator! Goodbye!");
                System.exit(2); // exit with code 2
            }// code 2 means that the user exited normally no win or loss
        }// since it isnt really a game right

        scanner.close();
    }

    private static void printAscii(String text) {
        for (int line = 0; line < 5; line++) {
            StringBuilder sb = new StringBuilder();
            for (char c : text.toCharArray()) {
                String[] asciiChar = ANSI_REGULAR.get(c);
                if (asciiChar != null) {
                    sb.append(asciiChar[line]).append(" ");
                } else {
                    sb.append("        ").append("  "); // space for unknown characters
                }
            }
            System.out.println(sb.toString());
        }
    }

    private static void printAsciiColored(String text, String colour, String reset) {
        for (int line = 0; line < 5; line++) {
            StringBuilder sb = new StringBuilder();
            sb.append(colour); // set colour once per line
            for (char c : text.toCharArray()) {
                String[] asciiChar = ANSI_REGULAR.get(c);
                if (asciiChar != null) {
                    sb.append(asciiChar[line]).append(" ");
                } else {
                    sb.append("        ").append("  "); // space for unknown characters
                }
            }
            sb.append(reset); // reset colour at end of line
            System.out.println(sb.toString());
        }
    }
}
// wow... this is longer than my spaceship game :D