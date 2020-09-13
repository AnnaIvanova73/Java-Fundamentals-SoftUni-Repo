import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tech_Task_1_ArrivingInKathmandu_1_0 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        while (!input.equals("Last note")) {
            Pattern pattern = Pattern.compile("^(?<name>[a-zA-Z0-9!@#$?]+)=(?<length>\\d+)<<(?<geohashcode>.+)$");
            Matcher matcher = pattern.matcher(input);
            boolean hasMatch = false;

            if (matcher.find()) {
                String name = matcher.group("name");
                int length = Integer.parseInt(matcher.group("length"));
                String geohashCode = matcher.group("geohashcode");
                name = getName(name);

                if (geohashCode.length() == length) {
                    System.out.println("Coordinates found! " + name + " -> " + geohashCode);
                    hasMatch = true;
                } else {
                    hasMatch = false;
                }
            }

            if (!hasMatch) {
                System.out.println("Nothing found!");
            }

            input = scan.nextLine();
        }

    }

    private static String getName(String name) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}
