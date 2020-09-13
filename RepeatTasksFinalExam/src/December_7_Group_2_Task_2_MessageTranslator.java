import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//String regex = "^!(?<command>[A-Z][a-z]{2,})!:(?<message>[a-zA-z]{8,})$";
public class December_7_Group_2_Task_2_MessageTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countMessages = Integer.parseInt(scan.nextLine());
        String regex = "!(?<command>[A-Z]{1}[a-z]{2,})!:\\[(?<message>[A-Za-z]{8,})\\]";
        Pattern validation = Pattern.compile(regex);

        while (countMessages > 0) {
            String message = scan.nextLine();

            Matcher matcher = validation.matcher(message);
            if (!matcher.find()) {
                System.out.println("The message is invalid");
                countMessages--;
                continue;
            }
            String command = matcher.group("command");
            System.out.print(command + ": ");

            String matchMessage = matcher.group("message");
            for (int i = 0; i < matchMessage.length(); i++) {
                int ascii = matchMessage.charAt(i);
                    System.out.print(ascii + " ");
            }

            System.out.println();
            countMessages--;
        }
    }
}
