import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tech_Task_2_Deciphering {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String decipher = "";
        int countInput = 1;

        while (countInput <= 2) {

            String input = scan.nextLine();

            if (countInput == 1) {
                String regexBooks = "^[e-z{}|#]+$";
                Pattern pattern = Pattern.compile(regexBooks);
                Matcher matcher = pattern.matcher(input);

                if (!matcher.find()) {
                    System.out.println("This is not the book you are looking for.");
                    return;
                }

                String genchoBook = matcher.group();
                decipher = getDecipherMsg(genchoBook);
            }

            if (countInput == 2) {
                String[] tokens = input.split("\\s+");
                String currentSubstring = tokens[0];
                String replacement = tokens[1];
                String result = decipher.replace(currentSubstring, replacement);
                System.out.println(result);
                break;
            }

            countInput++;
        }
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
