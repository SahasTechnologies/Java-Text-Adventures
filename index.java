// -----------------------------------------
// index.java, for running all of my games
// -----------------------------------------

//sorry, im too used to HTML so i named it index
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
// import org.jline.terminal.Terminal;
// import org.jline.terminal.Terminal.TerminalBuilder; (I wanted this to work like a real terminal app but for that i need to physically download libraries)

class Index {

    private static final int NOT_PLAYED = Integer.MIN_VALUE;
    private static final String CLASSPATH = "." + File.pathSeparator + "otherGames";

    private static int spaceshipExitCode = NOT_PLAYED;
    private static int dungeonExitCode = NOT_PLAYED;
    private static int asciiExitCode = NOT_PLAYED;
    private static int guessExitCode = NOT_PLAYED;

    //ANSI Codes for colouring the terminal
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            System.out.println("--- Welcome! ---");
            System.out.println("to the java games made by:");
            System.out.println("███████  █████  ██   ██  █████  ███████ ");
            System.out.println("██      ██   ██ ██   ██ ██   ██ ██      ");
            System.out.println("███████ ███████ ███████ ███████ ███████ ");
            System.out.println("     ██ ██   ██ ██   ██ ██   ██      ██ ");
            System.out.println("███████ ██   ██ ██   ██ ██   ██ ███████ ");

            while (running) {
                System.out.println("\nWhich game would you like to play today?");
                System.out.println("You can choose text adventures or other games.");
                System.out.println("Input choice 'text' or 'other' to play.");
                System.out.println("Type 'results' to see results, or 'quit' to exit.");

                String choice = scanner.nextLine().trim().toLowerCase();
                switch (choice) {
                    case "text", "t" -> textAdventureChooser(scanner);
                    case "other", "o" -> otherGamesChooser(scanner);
                    case "results", "r" -> printAllResults();
                    case "quit", "q", "exit" -> running = false;
                    default -> System.out.println("Beep boop 🤖 I didn't get that. Please enter again:");
                }
            }
        }
    }

    public static void textAdventureChooser(Scanner scanner) {
        System.out.println("Which text adventure game would you like to play?");
        System.out.println("1. Spaceship Escape (s)");
        System.out.println("2. Dungeon (d)");
        System.out.println("Type in (s) or (d), or 'back' to return.");

        String choice = scanner.nextLine().trim().toLowerCase();
        switch (choice) {
            case "s", "spaceship" -> spaceshipExitCode = runGame("AdventureGame");
            case "d", "dungeon" -> dungeonExitCode = runGame("dungeonGame");
            case "back", "b" -> {
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    public static void otherGamesChooser(Scanner scanner) {
        System.out.println("Here are the other games available:");
        System.out.println("1. ASCII Name Generator (a)");
        System.out.println("2. Guess The Number (g)");
        System.out.println("Type in (a) or (g), or 'back' to return.");

        String otherChoice = scanner.nextLine().trim().toLowerCase();
        switch (otherChoice) {
            case "a", "ascii" -> asciiExitCode = runGame("AsciiArt");
            case "g", "guess", "gtn" -> guessExitCode = runGame("GuessTheNumber");
            case "back", "b" -> {
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    //thing to run other files and get the exit code to know if they won or not
    private static int runGame(String className) {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", CLASSPATH, className);
            pb.inheritIO(); // show the game output in the same terminal
            Process process = pb.start();
            return process.waitFor();
        } catch (IOException e) {
            System.out.println("Error running " + className + ": " + e.getMessage());
            return NOT_PLAYED;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error running " + className + ": " + e.getMessage());
            return NOT_PLAYED;
        }
    }

    private static void printAllResults() {
        System.out.println("\n --- Game Results ---");
        printResult("Spaceship Escape", spaceshipExitCode);
        printResult("Dungeon", dungeonExitCode);
        printResult("ASCII Name Generator", asciiExitCode);
        printResult("Guess The Number", guessExitCode);
    }

    //print with COLOUR! 🖌️🎨yay this will look so nice when this is done🎨🎨🎨🎨🎨🎨🎨🎨
    private static void printResult(String gameName, int exitCode) {
        if (exitCode == NOT_PLAYED) {
            System.out.println(gameName + ": Not played");
            return;
        }

        if (exitCode == 0) {
            System.out.println(gameName + ": " + GREEN + "WIN" + RESET);
        } else if (exitCode == 1) {
            System.out.println(gameName + ": " + RED + "LOSS" + RESET);
        } else if (exitCode == 2) {
            System.out.println(gameName + ": EXITED");
        } else {
            System.out.println(gameName + ": Exit code " + exitCode);
        }
    }

}
//there was a triton game... which i got rid of
//i gave up since i spent wayyyyyy too long on dungeon game
