//  Write a program which:
//  1. Prompts the user for 5 test scores as integers greater than or equal to zero and less than or equal to 100.
//  2. Ensures that the user entries are valid (integers greater than or equal to zero and less than or equal to 100).
//  3. Stores the 5 tests scores in an array.
//  4. Uses the bubble sort to sort the scores in ascending order.
//  5. Calculates the letter grade for each test
//  6. Displays the letter grade of each score as well as the overall average (the average of the 5 tests).
//  SPECIFIC REQUIREMENTS
//  1. You must include a method called calcAverage to compute the average of the 5 test scores; it takes an
//  array of type int as a parameter and returns the average.
//  2. You must include a method called validateUserInput to ensure user entries are integers greater than or
//  equal to zero and less than or equal to 100.
//  3. You must include a method determineGrade to compute the average of the 5 test scores; it takes an int
//  array with the test scores and a char array to store the corresponding letter grades. The letter grade is
//  arrived at using the table below:
//  score Letter Grade
//  >=90 A
//  >=80 and <90 B
//  >=70 and <80 C
//  >=60 and <70 D
//  >=0 and <60 F
//  4. You must include a method called bubbleSort which sorts the values (test scores) stored in the array in
//  ascending order.
//  5. You must include a method called displayTestScores which displays each test score and its
//  corresponding letter, as well as the overall average.

import java.util.Scanner;

public class Ch7 {
    public static void main(String[] args) {
        //Create an array to store 5 test scores from user and
        int[] testScores = new int[5];
        // Method expects an array of integers as input, so we pass the testScores array to it.
        // This allows the method to work with the testScores array inside its own scope,
        // performing tasks such as reading user input and storing it in the array.
        addTestScoresToArray(testScores);
        //Sorts the test scores using bubble sort
        bubbleSort(testScores);
        //Calculate the letter grade for each test score
        char[] letterGrades = new char[testScores.length];
        determineGrade(testScores, letterGrades);
        //Display the letter grade of each score as well as the overall average
        displayTestScores(testScores, letterGrades);

    }

    //Method that returns a boolean value to indicate if the user input is within range
    public static boolean validateUserInput(int input) {
        return input >= 0 && input <= 100;
    }

    //Method to add test scores to an array
    public static void addTestScoresToArray(int[] scoresArray) {
        Scanner scan = new Scanner(System.in);

        //Loop to iterate over the scores array to
        for (int i = 0; i < scoresArray.length; i++) {
            boolean validInput = false;
            int score;

            //Loop to ask user for test scores until it reaches the scores array length of 5
            while (!validInput) {
                System.out.println("Enter a test score " + (i + 1) + " (0-100):");

                //Check if the next input is an integer
                if (scan.hasNextInt()) {
                    //Stores user input into score variable
                    score = scan.nextInt();

                    //Checks user input stored in score variable with method
                    if (validateUserInput(score)) {
                        scoresArray[i] = score; //If user input is validated, add to scores array
                        validInput = true; //Sets flag to true to exit loop
                    } else {
                        System.out.println("Invalid score. Please enter a number between 0 and 100.");
                        scan.next(); //Consume invalid token
                    }
                }
            }
        }
    }

    public static void bubbleSort(int[] array) {
        int n = array.length; //Stores the length of the input array, which represents the # of elements in the array
        boolean swapped; //Flag to track whether elements were swapped during a pass through the array

        //Repeats until no more swaps are made
        do {
            swapped = false;
            //Iterates through the array
            for (int i = 1; i < n; i++) {
                //Compares adjacent elements and swaps if necessary
                if (array[i - 1] > array[i]) //Checks if the current element is greater than the next element in the array
                {
                    //Stores the value of the current element in temp. Prevents data loss when swapped
                    int temp = array[i - 1];
                    //Swaps the current element with the next element in the array
                    array[i - 1] = array[i];
                    //Completes swap by assigning the value in temp to next element in array
                    array[i] = temp;
                    swapped = true; //Sets to true to indicate that at least one swap occurred during the pass through the array
                }
            }
        } while (swapped);
    }

    //Determines the letter grades for test scores
    public static void determineGrade(int[] scores, char[] grades) {
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];

            if (score >= 90) {
                grades[i] = 'A';
            } else if (score >= 80) {
                grades[i] = 'B';
            } else if (score >= 70) {
                grades[i] = 'C';
            } else if (score >= 60) {
                grades[i] = 'D';
            } else {
                grades[i] = 'F';
            }
        }
    }

    //Displays test scores and their corresponding letter grades
    public static void displayTestScores(int[] scores, char[] grades) {
        double totalScore = 0;
        int score = 0;
        char grade = ' ';
        double average = 0;

        for (int i = 0; i < scores.length; i++) {
            score = scores[i];
            grade = grades[i];
            totalScore += score;
            System.out.println("Test Score: " + score + ", Grade: " + grade);
        }
         average = totalScore / scores.length;
        System.out.println("Overall Average: " + average);
    }
}