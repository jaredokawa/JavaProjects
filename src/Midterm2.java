import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
    private static double userEarnings = 0;

    public static void main(String[] args) {
        String playerInput;
        boolean continueInput = true;
        credits();

        System.out.println("Please enter your name and press <ENTER>");
        playerName = scan.nextLine();

        loadStats();

        do {
            menu();
            playerInput = getUserInput();
            generateMathChallenge(playerInput);
            saveStats();
        } while (continueInput);
    }

    private static void loadStats() {
        File file = new File(playerName.concat(".txt"));

        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {
                playerName = fileScanner.nextLine();
                String earningsLine = fileScanner.nextLine();
                userEarnings = Double.parseDouble(earningsLine.split("\\$")[1]);
                correct = Integer.parseInt(fileScanner.nextLine());
                incorrect = Integer.parseInt(fileScanner.nextLine());
            } catch (IOException | NumberFormatException e) {
                throw new RuntimeException("Error loading stats", e);
            }
        }
    }

    private static void saveStats() {
        //Creates new file object
        File file = new File(playerName.concat(".txt"));

        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(playerName);
            pw.printf("%.2f%n", userEarnings);
            pw.println(correct);
            pw.println(incorrect);
        } catch (IOException e) {
            throw new RuntimeException("Error saving stats", e);
        }
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
        boolean validInput = false;

        System.out.println(playerName);
        System.out.println("Total Earnings: $" + userEarnings );
        System.out.println("Total Correct: " + correct);
        System.out.println("Total Incorrect: " + incorrect);

        while (!validInput) {
            System.out.println("Press <ENTER> to continue...");
            String entry = scan.nextLine();

            if (entry.isEmpty()) {
                validInput = true;  // Input is valid, so we exit the loop
                break;
            } else {
                System.out.println("Press <ENTER> to continue...");  // Prompt again if input is not empty
            }
        }
    }

    private static void generateAddition() {
        String answer;

        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        int expected = a + b;

        System.out.println(a + " + " + b + " =");
        answer = validateUserAnswer();
        checkUserAnswer(expected, Integer.parseInt(answer));
    }

    private static void generateSubtraction() {
        String answer;

        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        int expected = a - b;

        System.out.println(a + " - " + b + " =");
        answer = validateUserAnswer();

        checkUserAnswer(expected, Integer.parseInt(answer));
    }

    private static void generateMultiplication() {
        String answer;

        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        int expected = a * b;

        System.out.println(a + " * " + b + " =");
        answer = validateUserAnswer();

        checkUserAnswer(expected, Integer.parseInt(answer));
    }

    private static void generateDivision() {
        String answer;

        int b = random.nextInt(9) + 1;
        int a = random.nextInt(9) * b;
        int expected = a / b;

        System.out.println(a + " / " + b + " =");
        answer = validateUserAnswer();

        checkUserAnswer(expected, Integer.parseInt(answer));
    }

    private static void checkUserAnswer(int expected, int answer) {
        boolean validInput = false;

        if (expected == answer) {
            System.out.println("Correct answer!");
            System.out.println("You have been awarded $0.03");
            correct++;
            userEarnings += CORRECT_CHANGE;

        } else {
            System.out.println("Wrong answer. Try again.");
            System.out.println("You have been penalized $0.05");
            incorrect++;
            userEarnings -= INCORRECT_CHANGE;
        }

        while (!validInput) {
            System.out.println("Press <ENTER> to continue...");
            String entry = scan.nextLine();

            if (entry.isEmpty()) {
                validInput = true;  // Input is valid, so we exit the loop
                break;
            } else {
                System.out.println("Press <ENTER> to continue...");  // Prompt again if input is not empty
            }
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

    private static String validateUserAnswer() {
        boolean validInput = false;

        String playerInput = "";

            while (!validInput) {

                playerInput = scan.nextLine();

                if (playerInput.matches("[0-9]+")) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
            return playerInput;
        }

    }