package hangman;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra"};


    //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    private String[] gallows = new String[]{
            """
+---+
|   |
    |
    |
    |
    |
=========
""",

            """
+---+
|   |
O   |
    |
    |
    |
=========
""",

            """
+---+
|   |
O   |
|   |
    |
    |
=========
""",

            """
 +---+
 |   |
 O   |
/|   |
     |
     |
 =========
""",

            """
 +---+
 |   |
 O   |
/|\\  |
     |
     |
 =========
""",

            """
 +---+
 |   |
 O   |
/|\\  |
/    |
     |
 =========
""",

            """
 +---+
 |   |
 O   |
/|\\  |
/ \\  |
     |
 =========
"""};


    private String wordToGuess;
    private char[] guessedChars;
    private char[] missedChars;
    private int gallowsPosition;
    private char prevGuessingChar;


    public Hangman() {
        Random r = new Random();
//        this.wordToGuess = words[r.nextInt(words.length)];
        this.wordToGuess = "wall";
        this.guessedChars = new char[wordToGuess.length()];
        this.gallowsPosition = 0;
        this.missedChars = new char[6];
        this.prevGuessingChar = ' ';
    }


    private void printPrevGuessingChar() {
        System.out.println("Guess: " + this.prevGuessingChar);
    }


    private void printGallows() {
        System.out.println(gallows[gallowsPosition]);
    }


    private void printWord(){
        System.out.print("Word:  ");
        if (this.guessedChars[0] == 0) {
            for (int i = 0; i < this.wordToGuess.length(); i++) {
                System.out.print(" _");
            }
        } else {
            for (int i = 0; i < this.wordToGuess.length(); i++) {
                if (this.isContain(wordToGuess.charAt(i))) {
                    System.out.print(wordToGuess.charAt(i));
                } else {
                    System.out.print("_");
                }
                System.out.print(" ");
            }
        }
        System.out.println();
    }


    private boolean isContain(char source) {
        if (this.guessedChars == null) return false;

        for (int i = 0; i < this.guessedChars.length; i++) {
            if (source == this.guessedChars[i]) {
                return true;
            }
        }
        return false;
    }


    private void printMisses() {
        System.out.print("Misses:  ");
        if (this.missedChars[0] == 0) {
            System.out.println();
            return;
        }

        for (char missedChar : this.missedChars) {
            System.out.print(missedChar);
        }
        System.out.println();
    }


    private void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    private boolean checkCharInWord(char in) {
        for (int i = 0; i < this.wordToGuess.length(); i++) {
            if (this.wordToGuess.charAt(i) == in) {
                return true;
            }
        }
        return false;
    }


    private void addCharToGuessedArr(char c) {
        for (int i = 0; i < this.guessedChars.length; i++) {
            if (this.guessedChars[i] == 0) {
                this.guessedChars[i] = c;
                return;
            }
        }
    }


    private void addCharToMissedArr(char c) {
        for (int i = 0; i < this.missedChars.length; i++) {
            if (this.missedChars[i] == 0) {
                this.missedChars[i] = c;
                return;
            }
        }
    }


    private void inputGuessChar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess: ");
        char tmpInput = scanner.next().charAt(0);
        if (checkCharInWord(tmpInput)) {
            addCharToGuessedArr(tmpInput);
        } else {
            addCharToMissedArr(tmpInput);
            this.gallowsPosition++;
        }
        prevGuessingChar = tmpInput;
    }


    private void printGameResult() {
        if (this.gallowsPosition == this.gallows.length - 1) {
            printGallows();
            System.out.println("\nRIP!\nThe word was: '" + this.wordToGuess + "'");
        } else {
            printPrevGuessingChar();
            printGallows();
            printWord();
            System.out.println("\nGOOD WORK!");
        }
    }


//    private boolean checkWordWasGuessed() {
//        for (int i = 0; i < this.guessedChars.length; i++) {
//            if (isContain(guessedChars[i]))
//        }
//    }


    public void startGame() {
        /*
        1) решить как ретёрнуться с цикла ака победа
        2) решить проблему с переполнением this.guessedChars
         */

        while (this.gallowsPosition != this.gallows.length - 1 ) {
            printPrevGuessingChar();
            printGallows();
            printWord();
            System.out.println();
            printMisses();
            System.out.println();
            inputGuessChar();
            cleanScreen();
        }
        printGameResult();
    }
}
