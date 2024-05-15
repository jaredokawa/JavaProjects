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
//invalid entry and you did not write code to handle such potential exceptions, you will NOT pass the
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


import java.util.Random;
import java.util.Scanner;

public class Midterm {
    private static final Scanner scan = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {

        String playerName;
        String playerInput = "";

        System.out.println("Please enter your name.");
        playerName = scan.nextLine();

        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");


        boolean validInput = false;

        while(!validInput){
            System.out.println("Please select a number.");
            playerInput = scan.nextLine();

            if(playerInput.matches("[01]+")){
                validInput = true;
            }
        }

        if(playerInput.equalsIgnoreCase("1")){
            generateAddition();
        }
    }

    private static void generateAddition() {
        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        int expected = a + b;

        System.out.println(a + " + " + b + " =");
        String answer = scan.nextLine();

        checkResult(expected, Integer.parseInt(answer));
    }

    private void generateSubtraction() {
        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        int expected = a + b;

        System.out.println(a + " - " + b + " =");
        String answer = scan.nextLine();

        checkResult(expected, Integer.parseInt(answer));
    }

    private void generateMultiplication() {
        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        int expected = a + b;

        System.out.println(a + " - " + b + " =");
        String answer = scan.nextLine();

        checkResult(expected, Integer.parseInt(answer));
    }

    private int askQuestion(final String question) {
        System.out.print(question);

        return scan.nextInt();
    }

    private static void checkResult(final int expected, final int answer) {
        if (expected == answer) {
            System.out.println("Correct answer!");
        } else {
            System.out.println("Wrong answer. Try again.");
        }
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