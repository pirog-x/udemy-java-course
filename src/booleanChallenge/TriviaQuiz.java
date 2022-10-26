package booleanChallenge;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class TriviaQuiz {
    public static void solution() {
        List<String> userAnswers = triviaQuiz();
        getResult(userAnswers);
    }

    private static List<String> triviaQuiz() {
        Scanner scanner = new Scanner(System.in);
        List<String> userAnswers = new ArrayList<>(4);

        System.out.println("1. Which country held the 2016 Summer Olympics?");
        System.out.println("\ta) China");
        System.out.println("\tb) Ireland");
        System.out.println("\tc) Brazil");
        System.out.println("\td) Italy");

        userAnswers.add(scanner.next());    

        System.out.println("\n2. Which planet is the hottest?");
        System.out.println("\ta) Venus");
        System.out.println("\tb) Saturn");
        System.out.println("\tc) Mercury");
        System.out.println("\td) Mars");

        userAnswers.add(scanner.next());

        System.out.println("\n3. What is the rarest blood type?");
        System.out.println("\ta) O");
        System.out.println("\tb) A");
        System.out.println("\tc) B");
        System.out.println("\td) AB-Negative");

        userAnswers.add(scanner.next());

        System.out.println("\n4. Which one of these characters is friends with Harry Potter?");
        System.out.println("\ta) Ron Weasley");
        System.out.println("\tb) Hermione Granger");
        System.out.println("\tc) Draco Malfoy");

        userAnswers.add(scanner.next());

        return userAnswers;
    }

    private static int checkAnswers(List<String> userAnswers) {
        List<String> correctAnswers = new ArrayList<>(4);
        correctAnswers.add("c");
        correctAnswers.add("a");
        correctAnswers.add("d");
        correctAnswers.add("a");

        int userMark = 0;

        for (int i = 0; i < correctAnswers.size(); i++) {
            if (i == 3) {
                if (correctAnswers.get(i).equals(userAnswers.get(i)) || userAnswers.get(i).equals("b")) {
                    userMark += 5;
                }
            }

            if (correctAnswers.get(i).equals(userAnswers.get(i))) {
                userMark += 5;
            }
        }
        return userMark;
    }

    private static void getResult(List<String> userAnswer) {
        int userMark = checkAnswers(userAnswer);
        System.out.println("Your final score is: " + userMark + "/20");

        if (userMark > 15) {
            System.out.println("Wow, you know your stuff!");
        } else if (userMark < 15) {
            System.out.println("Not bad!");
        } else {
            System.out.println("better luck next time.");
        }
    }
}