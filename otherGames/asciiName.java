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
    private static final

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
            "██████ ",
            "██   ██",
            "██████ ",
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
            "██████ "
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
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
        ANSI_REGULAR.put('A', new String[]{
            " █████  ",
            "██   ██ ",
            "███████ ",
            "██   ██ ",
            "██   ██ "
        });
    }

}