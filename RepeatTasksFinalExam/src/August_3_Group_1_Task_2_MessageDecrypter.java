import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class August_3_Group_1_Task_2_MessageDecrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countInputs = Integer.parseInt(scan.nextLine());
        String regex = "^([$%])([A-Z][a-z]{2,})(\\1): \\[([\\d]+)]\\|\\[([\\d]+)]\\|\\[([\\d]+)]\\|$";
        Pattern pattern = Pattern.compile(regex);

        while (countInputs-- > 0) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (!matcher.find()) {
                System.out.println("Valid message not found!");
                continue;
            }
            String partFirst = getDecrypted(matcher.group(4));
            String partSecond = getDecrypted(matcher.group(5));
            String partThird = getDecrypted(matcher.group(6));
            String tag = matcher.group(2);
            System.out.println(tag + ": " + partFirst + partSecond + partThird);
        }
    }

    private static String getDecrypted(String group) {
        int ascii = Integer.parseInt(group);
        return String.valueOf((char) ascii);
    }
}
