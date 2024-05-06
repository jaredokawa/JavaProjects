import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a, b, c, d, e;

        System.out.println("Please enter the first whole number.");
        a = readWholeNumber(scan);

        System.out.println("Please enter the second whole number.");
        b = readWholeNumber(scan);

        System.out.println("Please enter the third whole number.");
        c = readWholeNumber(scan);


        System.out.println("Please enter the fourth whole number.");
        d = readWholeNumber(scan);


        System.out.println("Please enter the fifth whole number.");
        e = readWholeNumber(scan);

        int avg = (a + b + c + d + e) / 5;

        System.out.println("The average of those numbers is " + avg);
    }

    //Method to read a whole number from user input
    private static int readWholeNumber (Scanner scan)
    {
        while(true)
        {
            if (scan.hasNextInt())
            {
                return scan.nextInt();
            } else
            {
                System.out.println("Error: Please enter a whole number.");
                scan.next();
            }
        }
    }
}