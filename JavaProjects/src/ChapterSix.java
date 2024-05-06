//1. Asks the user to enter a positive integer greater than 0
//2. Validates that the entry is a positive integer
//3. Outputs the digits in reverse order with a space separating the digits
//4. Outputs the even digits not in reverse order with a space separating the digits (consider zero to be even)
//5. Outputs the odd digits not in reverse order with a space separating the digits
//6. The program outputs “There are no odd digits”, when there are no odd digits in the user input.
//7. The program outputs “There are no even digits”, when there are no even digits in the user input.
//8. Allows user is to repeat/continue the program as many times as he/she wants
//9. Keeps a record in a txt file named outDataFile.txt with the history of all numbers entered and the
//associated results, in the following format:
//the original number is 1023
//the number reversed 3 2 0 1
//the even digits are 0 2
//the odd digits are 1 3
//        -----------------
//the original number is 102030
//the number reversed 0 3 0 2 0 1
//the even digits are 0 2 0 0
//the odd digits are 1 3


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        boolean continueInput = true;

        do
        {
            boolean validInput = false;
            int validatedInt = 0;
            int evenDigitsCount = 0;
            int oddDigitsCount = 0;
            StringBuilder evenDigits = new StringBuilder();
            StringBuilder oddDigits = new StringBuilder();
            StringBuilder reversedWithSpaces = new StringBuilder();

            while (!validInput)
            {
                System.out.println("Enter a positive integer greater than 0.");
                String inputCheck = scan.nextLine();

                //Validates that the entry is a positive integer
                if (inputCheck.matches("[0-9]+"))
                {
                    validInput = true;

                    //Parse the integer and store it in the validatedInt variable
                    validatedInt = Integer.parseInt(inputCheck);

                    //Output the original number
                    System.out.println("the original number " + validatedInt);

                    //Convert the Integer to a String
                    String numberString = Integer.toString(validatedInt);

                    //Clear the StringBuilder before adding new content
                    reversedWithSpaces.setLength(0);

                    //Iterate through numbers to reverse and add spaces
                    for (int i = numberString.length() - 1; i >= 0; i--)
                    {
                        char digit = numberString.charAt(i);
                        reversedWithSpaces.append(digit).append(" ");
                    }
                    //Print the reversed string with spaces
                    System.out.println("the number reversed " + reversedWithSpaces);

                } else
                {
                    //Prints message if user input is not valid
                    System.out.println("The number you entered is not valid. Please enter a positive integer.");
                }

                // Iterate through digits to determine if any are even or odd
                int temp = validatedInt; // Temp variable to avoid modifying validatedInt
                while (temp > 0) {
                    int digit = temp % 10;
                    if (digit % 2 == 0) {
                        evenDigits.append(digit);
                        evenDigitsCount++;
                    } else {
                        oddDigits.append(digit);
                        oddDigitsCount++;
                    }
                    temp /= 10;
                }

                // Output even digits
                if (evenDigitsCount > 0) {
                    System.out.println("the even digits are " + evenDigits);
                } else {
                    System.out.println("There are no even digits");
                }

                // Output odd digits
                if (oddDigitsCount > 0) {
                    System.out.println("the odd digits are " + oddDigits);
                } else {
                    System.out.println("There are no odd digits");
                }
            }

            //Creates new file object
            File file = new File("outDataFile.txt");

            try
            {
                //Checks if the file represented by the file object exists
                if (!file.exists())
                {
                    //If the file does not exist, it will be created with the name specified by the file object
                    file.createNewFile();
                }
                //Creates a new PrintWriter object named pw
                PrintWriter pw = new PrintWriter(file);
                //Writes to the text file created
                pw.println("the original number " + validatedInt);
                pw.println("the number reversed " + reversedWithSpaces);
                pw.println("the even digits are " + evenDigits);
                pw.println("the odd digits are " + oddDigits);
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