import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tech_Task_2_Deciphering_1_0 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] substrings = scan.nextLine().split("\\s+");

        String regexBooks = "^[d-z{}|#]*$";
        Pattern pattern = Pattern.compile(regexBooks);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find()) {
            System.out.println("This is not the book you are looking for.");
            return;
        }

        String genchoBook = matcher.group();
        String decipher = getDecipherMsg(genchoBook);

        String existing = substrings[0];
        String replacement = substrings[1];
        String result = decipher.replace(existing, replacement);
        System.out.println(result);
    }

    private static String getDecipherMsg(String string) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char ch = (char) (string.charAt(i) - 3);
            builder.append(ch);
        }
        return builder.toString();
    }
}
