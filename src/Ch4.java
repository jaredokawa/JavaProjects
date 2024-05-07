import java.util.Scanner;

public class Ch4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstSpace = 0;
        int secondSpace = 0;
        String firstName = "";
        String lastName = "";
        String num = "";
        double dollars = 0;

        System.out.println("Please enter your enter firstname, lastname, " +
                "amount of money you want to withdraw separated by spaces.");
        String input = scan.nextLine();

        //Separate by spaces
        firstSpace = input.indexOf(' ');
        secondSpace = input.lastIndexOf(' ');

        //Extract the first name and last name
        firstName = input.substring(0, firstSpace);
        lastName = input.substring(firstSpace, secondSpace);

        //Extract the dollar amount
        num = input.substring(secondSpace);
        dollars = Double.parseDouble(num);

//        DecimalFormat df = new DecimalFormat("$#,###,###.##");
        System.out.printf("Hi " + firstName + lastName + "! You would like to withdraw $%,.2f" + ", Thanks!", dollars);
    }
}