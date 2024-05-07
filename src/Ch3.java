import java.util.Scanner;

public class Ch3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        System.out.println("Please enter an integer that represents a number of pennies.");

        int cents = scan.nextInt();

        if (cents <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            quarters = cents / 25;
            cents %= 25;

            dimes = cents / 10;
            cents %= 10;

            nickels = cents / 5;
            cents %= 5;

            pennies = cents;

            if (quarters == 1) {
                System.out.println(quarters + " Quarter");
            } else if (quarters > 1) {
                System.out.println(quarters + " Quarters");
            }

            if (dimes == 1) {
                System.out.println(dimes + " Dime");
            } else if (dimes > 1) {
                System.out.println(dimes + " Dimes");
            }

            if (nickels == 1) {
                System.out.println(nickels + " Nickel");
            } else if (nickels > 1) {
                System.out.println(nickels + " Nickels");
            }

            if (pennies == 1) {
                System.out.println(pennies + " Penny");
            } else if (pennies > 1) {
                System.out.println(pennies + " Pennies");
            }
        }
    }
}