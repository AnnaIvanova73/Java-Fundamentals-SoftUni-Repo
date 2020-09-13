import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_Registration {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scan.nextLine());

        Pattern patternPerRegistration =
                Pattern.compile("(U\\$)(?<username>[A-Z]{1}[a-z]{2,})\\1(P@\\$)(?<pass>[a-zA-Z]{5,}[0-9]+)\\3");


        int countOffRegistrations = 0;
        for (int i = 0; i <numberOfInputs ; i++) {
            String inputData = scan.nextLine();

            Matcher matchData = patternPerRegistration.matcher(inputData);

            if(matchData.find()){
                System.out.println("Registration was successful");
                String username = matchData.group("username");
                String password = matchData.group("pass");
                System.out.printf("Username: %s, Password: %s%n",username,password);
                countOffRegistrations++;
            }else{
                System.out.println("Invalid username or password");
            }
        }
        System.out.printf("Successful registrations: %d",countOffRegistrations);
    }
}
