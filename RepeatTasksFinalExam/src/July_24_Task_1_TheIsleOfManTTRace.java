import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class July_24_Task_1_TheIsleOfManTTRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "([\"#$%*&])([A-Za-z]+)(\\1)=([\\d]+)!!(.+)$";
        Pattern pattern = Pattern.compile(regex);

        boolean hasCoordinates = false;
        String input = scan.nextLine();
        while (!hasCoordinates) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group(2);
                int length = Integer.parseInt(matcher.group(4));
                String hashcode = matcher.group(5);
                if (hashcode.length() == length) {
                    hashcode = increaseValue(hashcode);
                    System.out.println("Coordinates found! " + name + " -> " + hashcode);
                    hasCoordinates = true;
                }
            }
            if (!matcher.find() && !hasCoordinates) {
                System.out.println("Nothing found!");
                input = scan.nextLine();
            }

        }
    }

    private static String increaseValue(String hashcode) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < hashcode.length(); i++) {
            int asciiValue = hashcode.charAt(i);
            asciiValue += hashcode.length();
            result.append((char) asciiValue);
        }
        return result.toString();
    }
}
