import java.util.Scanner;

public class concatNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String firstName  = scan.nextLine();
        String lastNameOfTheFirstName = scan.nextLine();
        String delimiter = scan.nextLine();

        String concatenationOfStrings = firstName+delimiter+lastNameOfTheFirstName;
        System.out.println(concatenationOfStrings);
    }
}
