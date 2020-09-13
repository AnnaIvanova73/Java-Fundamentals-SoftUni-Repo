import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A1_Task_2_Group_1_forRumen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String findAllNumbers = "([0-9]{1})";
        Pattern patternDigits = Pattern.compile(findAllNumbers);
        String input = scan.nextLine();

        Matcher matcher = patternDigits.matcher(input);

        long sumCoolNum = 1;
        while (matcher.find()) {
            int digits = Integer.parseInt(matcher.group());
            sumCoolNum *= digits;
        }
        System.out.println("Cool threshold: " + sumCoolNum);

        String emojRegex = "([*]{2}|[:]{2})([A-Z][a-z]{2,})(\\1)";
        Pattern pattern = Pattern.compile(emojRegex);
        matcher = pattern.matcher(input);
        int found = 0;
        int length = input.length();
        List<String> coolEmojis = new ArrayList<>();
        while (length > 0) {

            if (matcher.find()) {
                found++;
                String currentMatch = matcher.group(2);
                boolean isCool = isCool(sumCoolNum, currentMatch);
                if(isCool){
                    coolEmojis.add(matcher.group(1) + currentMatch + matcher.group(3));
                }
            }

            length--;
        }
        System.out.println(found + " emojis found in the text. The cool ones are:");
        coolEmojis.forEach(System.out::println);

    }

    private static boolean isCool(long sumCoolNum, String currentMatch) {
        long sum = 0;
        for (int i = 0; i < currentMatch.length(); i++) {
            int ascii = currentMatch.charAt(i);
            sum += ascii;
        }

        return sum >= sumCoolNum;
    }
}
