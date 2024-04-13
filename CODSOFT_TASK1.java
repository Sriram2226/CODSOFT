import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static int score = 0;

    public static void playNumberGame() {
        Random randomNumberGenerator = new Random();
        Scanner scanner = new Scanner(System.in);
        int randomNumber = randomNumberGenerator.nextInt(100);
        int chances = 5;
        System.out.println("\t\t\tNUMBER GUESSING GAME");
        System.out.println("CHANCES : 5");
        while (chances > 0) {
            System.out.print("Enter your guessed number : ");
            int userInput = scanner.nextInt();
            if (randomNumber == userInput) {
                System.out.println("You guessed it Right, The correct number is " + randomNumber);
                score++;
                System.out.println("Score : " + score);
                break;
            } else if (randomNumber > userInput) {
                System.out.println("\n\n Your number is low");
            } else if (randomNumber < userInput) {
                System.out.println("\n\n Your number is High");
            }
            chances--;
            if (chances == 0) {
                System.out.println("You missed. Right Answer is : " + randomNumber);
                System.out.println("Score : " + score);
                break;
            } else {
                System.out.println("You missed the chance \n\n Remaining Chance : " + chances);
            }
        }
    }

    public static void main(String args[]) {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Want to enter (Y/N) : ");
            userInput = scanner.next();
            if (userInput.equalsIgnoreCase("n")) {
                System.out.println("Game ended");
                System.out.println("Final Score : " + score);

                break;
            }
            playNumberGame();
        } while (userInput.equalsIgnoreCase("y"));
        System.out.println("\n\nThank you");
        scanner.close();
    }
}
