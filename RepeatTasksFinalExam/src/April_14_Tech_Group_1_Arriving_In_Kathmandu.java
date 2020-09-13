import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class April_14_Tech_Group_1_Arriving_In_Kathmandu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "^([a-zA-Z0-9!@#$?]+)=(\\d+)<<(.+)$";
        Pattern pattern = Pattern.compile(regex);

        String input;
        while (!"Last note".equals(input = scan.nextLine())) {
            Matcher matcher = pattern.matcher(input);
            boolean hasMach = false;

            if (matcher.find()) {
                String peakName = matcher.group(1);
                int length = Integer.parseInt(matcher.group(2));
                String hashCode = matcher.group(3);
                peakName = get(peakName);
                if (length == hashCode.length()) {
                    System.out.println("Coordinates found! " + get(peakName) + " -> " + hashCode);
                    hasMach = true;
                }
            }
            if (!hasMach && !matcher.find()) {
                System.out.println("Nothing found!");
            }
        }
    }

    private static String get(String peakName) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < peakName.length() ; i++) {
            char ch = peakName.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                result.append(ch);
            }
        }
        return result.toString();
    }
}
// list.forEach((key, value) -> System.out.println("-----" + value.size()));