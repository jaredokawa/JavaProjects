import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Midterm2 {

    private static final Scanner scan = new Scanner(System.in);
    private static final Random random = new Random();
    private static String playerName;
    private static int correct = 0;
    private static int incorrect = 0;
    private static final double CORRECT_CHANGE = 0.03;
    private static final double INCORRECT_CHANGE = 0.05;

    public static void main(String[] args) {
        String playerInput;
        credits();
        menu();
        playerInput = getUserInput();
        generateMathChallenge(playerInput);
    }

    private static void generateMathChallenge(String playerInput) {
        switch (playerInput) {
            case "1":
                generateAddition();
                break;
            case "2":
                generateSubtraction();
                break;
            case "3":
                generateMultiplication();
                break;
            case "4":
                generateDivision();
                break;
            case "n":
                System.exit(0);
            default:
                displayStats();
                break;
        }
    }

    private static void displayStats() {
        System.out.println(playerName);
       double a = (correct * CORRECT_CHANGE) + (incorrect * INCORRECT_CHANGE);

        System.out.println("Total Earnings: " + a );
        System.out.println("Total Correct: " + correct);
        System.out.println("Total Incorrect: " + incorrect);

        System.out.println("Press any key to continue...");

        //TODO get rid of this
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateAddition() {
        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        int answer;
        int expected = a + b;

        System.out.println(a + " + " + b + " =");
        answer = validateUserAnswer();
        checkUserAnswer(expected, answer);
    }

    private static void generateSubtraction() {
        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        int expected = a - b;

        System.out.println(a + " - " + b + " =");
        int answer = validateUserAnswer();

        checkUserAnswer(expected, answer);
    }

    private static void generateMultiplication() {
        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        int expected = a * b;

        System.out.println(a + " * " + b + " =");
        int answer = validateUserAnswer();

        checkUserAnswer(expected, answer);
    }

    private static void generateDivision() {
        int b = random.nextInt(9) + 1;
        int a = random.nextInt(9) * b;
        int expected = a / b;

        System.out.println(a + " / " + b + " =");
        int answer = validateUserAnswer();

        checkUserAnswer(expected, answer);
    }

    private static void checkUserAnswer(int expected, int answer) {
        if (expected == answer) {
            System.out.println("Correct answer!");
            System.out.println("You have been awarded $0.03");
            correct++;

        } else {
            System.out.println("Wrong answer. Try again.");
            System.out.println("You have been penalized $0.05");
            incorrect++;
        }

        System.out.println("Press any key to continue...");

        //TODO GET RID OF
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getUserInput() {
        String playerInput = "";
        boolean validInput = false;

        while (!validInput) {

            playerInput = scan.nextLine();

            if (playerInput.matches("[12345nN]")) {
                validInput = true;
            } else {
                System.out.println("This is not a valid menu option. Please enter a number, 1 through 5.");
            }
        }
        return playerInput;
    }

    private static void credits() {
        String playerInput;

        System.out.println("***********************");
        System.out.println("***********************");
        System.out.println("***********************");
        System.out.println("******           ******");
        System.out.println("******TheMathGame******");
        System.out.println("******    By     ******");
        System.out.println("******   Jared   ******");
        System.out.println("******   Okawa   ******");
        System.out.println("******           ******");
        System.out.println("***********************");
        System.out.println("***********************");
        System.out.println("***********************");
        System.out.println(" ");
        System.out.println("y/Y to continue, any other char to exit.");

        playerInput = scan.nextLine();

        if (!playerInput.equalsIgnoreCase("y")) {
            System.exit(0);
        }

        System.out.println("Please enter your name and press <ENTER>");
        playerName = scan.nextLine();
    }

    private static void menu() {
        System.out.println("******CHOOSE A PROBLEM******");
        System.out.println("****************************");
        System.out.println("****************************");
        System.out.println("******                ******");
        System.out.println("****** 1. ADD         ******");
        System.out.println("****** 2. SUBTRACT    ******");
        System.out.println("****** 3. MULTIPLY    ******");
        System.out.println("****** 4. DIVIDE      ******");
        System.out.println("****** 5. STATS       ******");
        System.out.println("****** n/N to QUIT    ******");
        System.out.println("******                ******");
        System.out.println("****************************");
        System.out.println("****************************");
        System.out.println(" ");
        System.out.println("Please select a number and press <ENTER>");
    }

    private static int validateUserAnswer() {
        boolean validInput = false;
        int input = 0;

        while (!validInput) {
            //TODO get rid of this try catch and validate correctly
            try {
                String userInput = scan.nextLine();
                input = Integer.parseInt(userInput);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return input;
    }
}
