import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class December_7_Group_1_Task_2_Registration {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countInputs = Integer.parseInt(scan.nextLine());
        String validRegTegex = "^(U\\$)(?<userName>[A-Z][a-z]{2,})(\\1)(P@\\$)(?<pass>[a-zA-Z]{5,}\\d+)(\\4)$";
        Pattern pattern = Pattern.compile(validRegTegex);

        int successReg = 0;
        while (countInputs > 0) {
            String registrationInput = scan.nextLine();
            Matcher matcher = pattern.matcher(registrationInput);

            if (!matcher.find()) {
                System.out.println("Invalid username or password");
                countInputs--;
                continue;
            }
            System.out.println("Registration was successful");
            String name = matcher.group("userName");
            String pass = matcher.group("pass");
            System.out.println("Username: " + name + ", Password: " + pass);

            successReg++;
            countInputs--;
        }
        System.out.println("Successful registrations: "+successReg);
    }
}
