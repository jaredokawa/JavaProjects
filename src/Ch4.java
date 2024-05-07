import java.util.Scanner;

public class Ch4 {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your enter firstname, lastname, " +
                "amount of money you want to withdraw separated by spaces.");
        String input = scan.nextLine();

        //Separate by spaces
        int firstSpace = input.indexOf(' ');
        int secondSpace = input.lastIndexOf(' ');

        //Extract the first name and last name
        String firstName = input.substring(0, firstSpace);
        String lastName = input.substring(firstSpace, secondSpace);

        //Extract the dollar amount
        String num = input.substring(secondSpace);
        double dollars = Double.parseDouble(num);

//        DecimalFormat df = new DecimalFormat("$#,###,###.##");
        System.out.printf("Hi " + firstName + lastName + "! You would like to withdraw $%,.2f" +", Thanks!", dollars);
    }
}