package rockPaperScissors;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void startGame() {
        if (!prePlayMenu()) return;
        gameBody();
    }

    private static boolean prePlayMenu() {
        System.out.println("Let's play Rock Paper Scissors.");      
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.");  
        System.out.println("\nAre you ready? Write 'yes' if you are");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.equals("yes")) {
            return true;
        } else {
            return false;
        }
    }

    private static void gameBody() {
        System.out.println("Great!\nrock - paper - scissors, shoot!");
        Scanner scanner = new Scanner(System.in);

        String playerValue;
        while (true) {
            playerValue = scanner.next().toLowerCase();
            if (!playerValue.equals("rock") && !playerValue.equals("paper") && !playerValue.equals("scissors")) {
                System.err.println("Wrong input\n");
                scanner.nextLine();
            } else {
                break;
            }
        }

        
        String botValue = generateRandomCombination();
        
        System.out.println("You chose: " + playerValue);
        System.out.println("Bot chose: " + botValue);

        if (playerIsWin(playerValue, botValue) == 1) {
            System.out.println("You are win!");
        } else if (playerIsWin(playerValue, botValue) == 0) {
            System.out.println("It's draw");
        } else {
            System.out.println("You are lose");
        }
    }

    private static String generateRandomCombination() {
        Random random = new Random();

        Map<Integer, String> combinations = new HashMap<>();
        combinations.put(0, "rock");
        combinations.put(1, "paper");
        combinations.put(2, "scissors");

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(3));
        }
        
        return combinations.get(random.nextInt(3));
    }

    private static int playerIsWin(String player, String bot) {
        player = player.toLowerCase();
        if (player.equals(bot)) return 0;

        Map<String, Integer> combinations = new HashMap<>();
        combinations.put("rock", 0);
        combinations.put("paper", 1);
        combinations.put("scissors", 2);


        if (combinations.get(player) == 1 && combinations.get(bot) == 0) {
            return 1;
        } else if (combinations.get(player) == 2 && combinations.get(bot) == 1) {
            return 1;
        } else if (combinations.get(player) == 0 && combinations.get(bot) == 2) {
            return 1;
        } else {
            return -1;
        }
    }
}