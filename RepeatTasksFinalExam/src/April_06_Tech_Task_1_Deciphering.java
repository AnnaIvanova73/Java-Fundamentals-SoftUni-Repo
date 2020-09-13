import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class April_06_Tech_Task_1_Deciphering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String encryptedString = scan.nextLine();

        String regex = "^([d-z{}|#]+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(encryptedString);

        if(!matcher.find()){
            System.out.println("This is not the book you are looking for.");
            return;
        }

        String message = matcher.group();
        StringBuilder newMsg = new StringBuilder();

        for (int i = 0; i <message.length() ; i++) {
            int letter = message.charAt(i);
            letter-=3;
            newMsg.append((char)letter);
        }
            message = newMsg.toString();

        String [] substring = scan.nextLine().split("\\s+");
        String existing = substring[0];
        String replacement = substring[1];
        message = message.replace(existing,replacement);

        System.out.println(message);

    }
}
