package hangman;
import java.util.Random;

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


    private String[] gallows = {
            "+---+\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n"};


    private String wordToGuess;
    private char[] guessedChars;
    private int gallowsPosition;
    private char[] missedChars;
    private char prevGuessingChar;


    public Hangman() {
        Random r = new Random();
        this.wordToGuess = words[r.nextInt(words.length)];
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
        if (this.missedChars[0] == 0) return;

        for (int i = 0; i < this.missedChars.length; i++) {
            System.out.print(this.missedChars[i]);
        }
        System.out.println();
    }


    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public void startGame() {
        printPrevGuessingChar();
        printGallows();
        printWord();
        printMisses();
    }
}
