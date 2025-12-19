// -----------------------------------------
// index.java, for running all of my games
// -----------------------------------------

//sorry, im too used to HTML so i named it index
import java.util.Scanner;
// import org.jline.terminal.Terminal;
// import org.jline.terminal.Terminal.TerminalBuilder; (I wanted this to work like a real terminal app but for that i need to physically download libraries)

public class Index {

    private static boolean spaceship = false;
    private static boolean dungeon = false;

    private static int spaceshipResult = 0;
    private static int dungeonResult = 0; // and code 2 means the thing for ascii name

    //ANSI Codes for colouring the terminal
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Welcome! ---");
        System.out.println("to the java games made by:");
        System.out.println("███████  █████  ██   ██  █████  ███████ ");
        System.out.println("██      ██   ██ ██   ██ ██   ██ ██      ");
        System.out.println("███████ ███████ ███████ ███████ ███████ ");
        System.out.println("     ██ ██   ██ ██   ██ ██   ██      ██ ");
        System.out.println("███████ ██   ██ ██   ██ ██   ██ ███████ ");
        System.out.println("Which game would you like to play today?");
        System.out.println("You can choose text adventures or other games.");
        System.out.println("Input choice 'text' or 'other to play.");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("text") || choice.equals("t")) {
            textAdventureChooser(scanner);
        }
        else if (choice.equals("o") || choice.equals("other")) {
           otherGamesChooser(scanner);
            }
        }
        else {
            System.out.println("Beep boop 🤖 I didn't get that. Please enter again:");
        }
    }

    public static void textAdventureChooser(Scanner scanner) {
        if (!spaceship && !triton) { //no games were played yet
            System.out.println("Which text adventure game would you like to play?");
            System.out.println("1. Spaceship Escape (s)");
            System.out.println("3. Dungeon (d)")
            System.out.println("Type in (s) or (d)");
            String choice = scanner.nextLine().toLowerCase();
                if (choice.equals("s") || choice.contains("spaceship")) {
                    spaceship = true;
                    spaceshipResult  = playSpaceship();
                }
                }
                else if (choice.equals(d) || choce.contains("dungeon")) {
                    dungeon = true;
                    dungeonResult = playDungeon();
                }
        }
        if (spaceship || triton) {
            //at least 1 gameplayed
            System.out.println("\n --- Game Results ---");
            printResult("Spaceship Escape", spaceshipResult);
            printResult("Triton", tritonResult);
        }
    }

    private static int playSpaceship() {
        return runGame("Spaceship");
    }

    private static int playTriton() {
        return runGame("Triton");
    }

    //thing to run other files and get the exit code to know if they won or not
    private static int runGame(String className) {
        try {
            ProcessBuilder pb  =  new ProcessBuilder("java", className);
            pb.inheritIO(); // show the game output in the same terminal
            Process process = pb.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) return 1; //to log as a win
            else if (exitCode == 1) return -1; //log as loss
        }
        catch (Exception e) {
            System.out.println("Error running " + className +  ": " + e.getMessage());
        }
        return 0; // for nor played or if there is an error
    } 

    //print with COLOUR! 🖌️🎨yay this will look so nice when this is done🎨🎨🎨🎨🎨🎨🎨🎨
    private static void printResult(String gameName, int result) {
        if (result == 1) { //means that you won
            System.out.println(gameName + ": " + GREEN + "WIN" + RESET);
        }
        else if (result == -1) { // means that you lost
            System.out.println(gameName + ": " + RED + "LOSS" + RESET);

        }
        else { //means that you didnt play it at all
            System.out.println(gameName + ": Not played");
        }
    }

    public static void otherGamesChooser(Scanner scanner) {
        System.out.println("Here are the other games available:");
            System.out.println("1. ASCII Name Generator (a)");
            System.out.println("There's nothing else here yet, but more games will be added soon!");
            System.out.println("Type in (a)");
            String otherChoice = scanner.nextLine().toLowerCase();
            if (otherChoice.equals("a") || otherChoice.contains("ascii")) {
                try {
                    ProcessBuilder pb  =  new ProcessBuilder("java", "otherGames/asciiName");
                    pb.inheritIO(); // show the game output in the same terminal
                    Process process = pb.start();
                    process.waitFor();
                }
                catch (Exception e) {
                    System.out.println("Error running ASCII Name Generator: " + e.getMessage());
                } 
                //there are soo many bugs 🐛🐛🐛🐛🐛🐛🐞🐞🐞🐞🐞🪲🪲🪲🪲🪲🪲🪲🪲🐜🐜🐜🐜🐜🐜🐜🦗🦗🦗🦗
                //🪰🪰🪰🪰🪰🪰🪰🪰🪰🦟🦟🦟🦟🦟🦟🦟🦟🦟🪳🪳🪳🪳🪳🦗🦗🦗🦗🦗🐞🐞🐞🐞🐞🐞🪲🪲🪲🪲🪲🪲🐜🐜🐜🐜🐛🐛🐛
                //see there are so many
    }

}

//there was a triton game... which i got rid of
//i gave up since i spent wayyyyyy too long on dungeon game
