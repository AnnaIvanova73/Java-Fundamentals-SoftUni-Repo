import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_MessageTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int messages = Integer.parseInt(scan.nextLine());

        Pattern regex = Pattern.compile("!(?<command>[A-Z]{1}[a-z]{2,})!:\\[(?<message>[A-Za-z]{8,})\\]");

        for (int i = 0; i < messages; i++) {
            String input = scan.nextLine();

            Matcher match = regex.matcher(input);

            if (match.find()) {
                System.out.print(match.group("command") + ": ");
                String msg = match.group("message");
                List<String> encrypt = getAscii(msg);
                System.out.println(String.join(" ",encrypt));
            } else {
                System.out.println("The message is invalid");
            }
        }
    }

    private static List<String> getAscii(String msg) {
        List<String> crack = new ArrayList<>();
        for (int i = 0; i <msg.length() ; i++) {
            int ascii = msg.charAt(i);
            String strings = String.valueOf(ascii);
            crack.add(strings);
        }
        return crack;
    }
}
