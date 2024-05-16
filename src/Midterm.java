//MIDTERM
//TheMathGame:
//Your task is to develop a program that will teach youngsters the basic math facts of addition, subtraction,
//multiplication and division. The program generates random math problems for students to answer. Players
//get a small reward for correct answers and suffer a small penalty for incorrect ones. User statistics need to
//be recorded in a text file so that they me loaded back into the program when the player returns to play the
//game again. In addition, the youngster should be allowed to see how (s)he is doing at any time while (s)he is
//playing the game.
//WARNING:
//Note that your main() function should consist of mostly function calls and not be greater than 100 lines in
//total; however, your entire program will be closer to 500 - 800 lines of code!
//PROGRAM REQUIREMENTS
//1. Generate simple math fact problems:
//  1. Addition (the total must be an integer >= 0)
//  2. Subtraction (the difference must be an integer >= 0)
//  3. Multiplication (the product must be an integer >= 0)
//  4. Division (the quotient must be an integer >= 0)
//2. Validate user input at every opportunity. If your program crashes because you allow the user to make an
//invalid entry, and you did not write code to handle such potential exceptions, you will NOT pass the
//midterm!
//3. The program should keep track of the following statistics:
//  1. The user’s name
//  2. The total correct answers
//  3. The total wrong answers
//  4. The total earnings ($0.05 is awarded for every correct response and $0.03 is subtracted from every
//     incorrect response)
//4. A separate text file must be created for every user:
//  1. Statistics are read from the file at the start of the game (if the user is a returning player).
//  2. Statistics are recorded at the end of every game.
//5. The program must be developed using functions so that the main() function consists mostly of
//function calls. Below is a list of most of the required functions, you may add your own functions if you
//like:
//  1. credits //This function is used to display your name and what the program does
//  2. menu // This function is used to display the menu with various options
//  3. validateUserResponse // This function is used to validate user input from the menu
//  4. validateUserAnswer // This function is used to validate user input and ensure that ONLY numeric
//      answers are entered by the user.
//  5. checkUserAnswer // given a math problem, this function is used to check if the answer the user
//      entered is correct or incorrect
//  6. updateStats // This function is used to keep a running total of game statistics (in RAM)
//  7. displayStats // This function is used to display statistics on screen
//  8. retrieveStats // This function is used to retrieve player statistics from external txt file when the game
//      starts, assuming the player is a returning player, else create a text file to store the stats.
//  9. saveStats // This function is used to save player statistics on an external txt file.
//  10. You may also want to consider the following four functions: generateAddition, generateSubtraction,
//      generateMultiplication and generateDivision // use these to generate a problem of the appropriate
//      type.
//6. You must use meaningful variable names.
//7. You must comment your code.
//8. You must use variables of the correct type and initialize them with a proper value.
//
// GENERAL RESTRICTIONS FOR ALL QUIZZES, MIDTERM AND FINAL EXAM
//1. No infinite loops, examples include:
//        1. for(;;)
//        2. while(1)
//        3. while(true)
//        4. do{//code}while(1);
//        2. No break statements to exit loops
//3. No labels or go-to statements
//4. If you violate any of these restrictions, you will automatically get a score of ZERO!


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Midterm {
    private static final Scanner scan = new Scanner(System.in);
    private static final Random random = new Random();
    private static String playerName;
    private static double userEarnings = 0.0;
    private static int correct = 0;
    private static int incorrect = 0;

    public static void main(String[] args) {

        credits();

        String playerInput = "";

        System.out.println("Please enter your name and press <ENTER>");
        playerName = scan.nextLine();

        boolean continueInput = true;

        do {
            menu();

            playerInput = validateUserResponse(playerInput);

            saveStats();

        } while(continueInput);
    }

    private static String validateUserResponse(String playerInput) {
        boolean validInput = false;

        while (!validInput) {

            playerInput = scan.nextLine();

            if (playerInput.matches("[0-5]")) {
                validInput = true;
            }else if (playerInput.equalsIgnoreCase("n")) {
                System.exit(0);
            }else {
                System.out.println("This is not a valid menu option. Please enter a number, 1 through 5.");
            }
        }

        if(playerInput.equalsIgnoreCase("1")){
            generateAddition();
        }else if(playerInput.equalsIgnoreCase("2")){
            generateSubtraction();
        }else if(playerInput.equalsIgnoreCase("3")){
            generateMultiplication();
        }else if(playerInput.equalsIgnoreCase("4")){
            generateDivision();
        }else if(playerInput.equalsIgnoreCase("5")){
            displayStats();
        }
        return playerInput;
    }

    private static int validateUserAnswer(){
        boolean validInput = false;
        int input = 0;

        while (!validInput){
            try {
                String userInput = scan.nextLine();
                input = Integer.parseInt(userInput);
                validInput = true;
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return input;
    }

    private static void saveStats() {
        //Creates new file object
        File file = new File("outDataFile.txt");

        try {
            //Checks if the file represented by the file object exists
            if (!file.exists()) {
                //If the file does not exist, it will be created with the name specified by the file object
                file.createNewFile();
            }
            //Creates a new PrintWriter object named pw
            PrintWriter pw = new PrintWriter(file);
            //Writes to the text file created
            pw.println(playerName);
            pw.println(userEarnings);
            pw.println(correct);
            pw.println(incorrect);
            pw.close();
            //Handles exceptions
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    private static void displayStats() {
        System.out.println(playerName);
        System.out.println("Total Earnings: " + userEarnings);
        System.out.println("Total Correct: " + correct);
        System.out.println("Total Incorrect: " + incorrect);
    }

    private static void credits() {
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

        String playerInput = scan.nextLine();

        if(!playerInput.equalsIgnoreCase("y")){
            System.exit(0);
        }
    }

    private static void generateAddition() {
        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        int expected = a + b;

        System.out.println(a + " + " + b + " =");
        int answer = validateUserAnswer();
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
        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        int expected = a / b;

        System.out.println(a + " / " + b + " =");
        int answer = validateUserAnswer();

        checkUserAnswer(expected, answer);
    }

    private static void checkUserAnswer(int expected, int answer) {
        if (expected == answer) {
            System.out.println("Correct answer!");
            System.out.println("You have been awarded $0.03");

            userEarnings += 0.03;
            correct += 1;

        } else {
            System.out.println("Wrong answer. Try again.");
            System.out.println("You have been penalized $0.05");

            userEarnings -= 0.05;
            incorrect -= 1;
        }
    }

    private static void updateStats(){

    }
}

//public static Problem generateRandomProblem (){
//    Random randomGen = new Random();
//
//    int number1 = randomGen.nextInt(201);
//    int number2 = randomGen.nextInt(201);
//
//    Operation operation = Operation.values()[randomGen.nextInt(Operation.values().length)];
//    return new Problem(number1, number2, operation);
//}

//class Problem{
//
//    private int number1;
//    private int number2;
//    private Operation operation;
//
//    public Problem(int number1, int number2, Operation operation) {
//        this.number1 = number1;
//        this.number2 = number2;
//        this.operation = operation;
//}
//    public int getNumber1() {
//        return number1;
//    }
//
//    public int getNumber2() {
//        return number2;
//    }
//
//    public Operation getOperation() {
//        return operation;
//    }
//}
//
//enum Operation {
//    ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
//}