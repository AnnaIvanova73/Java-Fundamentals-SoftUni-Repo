import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tech_Task_1_ArrivingInKathmandu_1_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "^(?<name>[a-zA-Z0-9!@#$?]+)=(?<length>\\d+)<<(?<geohashcode>.*?)$";
        Pattern pattern = Pattern.compile(regex);

        String input = scan.nextLine();
        while (!input.equals("Last note")) {

            Matcher matcher = pattern.matcher(input);


            if (!matcher.find()) {
                System.out.println("Nothing found!");
                input = scan.nextLine();
                continue;
            }

            String name = matcher.group("name");
            int length = Integer.parseInt(matcher.group("length"));
            String geohashCode = matcher.group("geohashcode");

            if (geohashCode.length() != length) {
                System.out.println("Nothing found!");
                input = scan.nextLine();
                continue;
            }

            String printName = getName(name);
            System.out.println("Coordinates found! " + printName + " -> " + geohashCode);
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
