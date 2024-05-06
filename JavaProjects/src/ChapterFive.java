//        There are tons of ways of doing this assignment..
//        You may also use the java file validate below to figure out
//        the way to check if the user input is legit and what to do after with it.
//
//        Also please take a look at the validate.java below for an example of how to validate
//
//        If you need more hints on what tools to use for each part of the assignment let me know.
//
//        RESTRICTION - DO NOT USE Integer.parseInt(????, 2) to get the answer
//
//        NOTES FOR PROCRASTINATORS-
//
//        You will need a while loop to figure out the answer.
//        You will need to use .indexOf(), .charAt(). length() methods.
//        You will need an int variable for the power
//        You will need a while loop as well for the validation
//        you will need a do-while loop to make it restart
//        You will use indexOf to find out the far right number to evaluate
//        You will use charAt() to compare if it == '1' or '0' with an IF else statement
//        Store your answer after evaluating each 1 or 0. Answer = answer += math.pow(2 , power)

//        1. Asks the user to enter a binary number ,example: 1011011
//        2. Validates that the entry is a binary number. Nothing but a binary number should be allowed.
//        3. The program converts and displays the binary number to its base 10 equivalent, Example 111 = 7
//        4. The user must be asked if he/she wants to continue entering numbers or quit.
//        5. Keeps a record in a txt file named outDataFile.txt with the history of all numbers entered and the
//        associated results, in the following format:
//          You entered 111
//          Its base 10 equivalent is 7
//          You entered 1010101
//          Its base 10 equivalent is 85


import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        boolean continueInput = true;

        do
        {
            boolean validInput = false;
            int decimalEquivalent = 0;

            while (!validInput)
            {
                System.out.println("Enter a binary number, example: 1011011");
                String inputCheck = scan.nextLine();

                if (inputCheck.matches("[01]+")) {
                    validInput = true;

                    //Get the binary number entered by user
                    String binaryNumber = inputCheck;
                    //Get length of the binary number
                    int length = binaryNumber.length();

                    //Iterate through the binary digits
                    for (int i = length - 1; i >= 0; i--) {
                        //Get binary digit at position i
                        char binaryDigit = binaryNumber.charAt(i);

                        //Calculate the decimal value of the current digit based on its position
                        int position = length - i - 1; //Position starts from zero at the far right
                        //If binaryDigit == 1 calculate digit by position; Else assign 0 as the decimal value
                        int decimalValue = (int) ((binaryDigit == '1') ? (int) Math.pow(2, position) : 0);

                        //Add the decimal value of the current digit to decimal equivalent
                        decimalEquivalent += decimalValue;
                    }

                    //Print the validated user input
                    System.out.println("You entered " + binaryNumber);
                    //Print the base 10 equivalent
                    System.out.println("Its base 10 equivalent is " + decimalEquivalent);

                } else
                {
                    //Prints message if user input is not valid
                    System.out.println("The number you entered is not valid. Please enter a binary number.");
                }
            }

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
                pw.println("This number is a validated binary number");
                pw.println(decimalEquivalent);
                pw.close();
                System.out.println("Done");
                //Handles exceptions
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Ask user if they want to continue
            System.out.println("Would you like to continue to enter binary numbers? y/n");
            //Scan user input and store into choice string var
            String choice = scan.nextLine();
            //Check choice variable, ignoring case of user input and store in continueInput var
            continueInput = choice.equalsIgnoreCase("y");

        } while (continueInput);
    }
}