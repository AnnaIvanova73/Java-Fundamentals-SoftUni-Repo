import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class August_9_Task_2_Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countInputs = Integer.parseInt(scan.nextLine());
        String passRegex = "^(.+)>(?<first>[\\d]{3})\\|(?<second>[a-z]{3})\\|(?<third>[A-Z]{3})\\|(?<fourth>[^<>]{3})<(\\1)$";
        Pattern pattern = Pattern.compile(passRegex);

        while (countInputs > 0){
            String password = scan.nextLine();
            Matcher matcher = pattern.matcher(password);

            if(!matcher.find()){
                System.out.println("Try another password!");
                countInputs--;
                continue;
            }
            StringBuilder correctPass = new StringBuilder();
            String first = matcher.group("first");
            String second = matcher.group("second");
            String third = matcher.group("third");
            String fourth = matcher.group("fourth");
            correctPass.append(first).append(second).append(third).append(fourth);
            System.out.println("Password: " + correctPass.toString());

            countInputs--;
        }
    }
}
