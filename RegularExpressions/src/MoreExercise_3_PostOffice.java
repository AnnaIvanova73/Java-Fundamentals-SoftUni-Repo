import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoreExercise_3_PostOffice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] tokens = input.split("\\|");
        String first = tokens[0];
        String numbers = tokens[1];
        String words = tokens[2];

        Pattern patternMessage = Pattern.compile("([#$%*&])([A-Z]+)\\1");
        Matcher match = patternMessage.matcher(first);

        String capitalLetters = "";
        while (match.find()) {
            String current = match.group();
            capitalLetters = current.substring(1, current.length() - 1);

        }

        Map<Character, Integer> collectionCharacteristics = new LinkedHashMap<>();

        for (int i = 0; i < capitalLetters.length(); i++) {
            int asciiValue = capitalLetters.charAt(i);

            String regexDigits = "([0-9]{2}):([0-9]{2})";
            Pattern patternDigits = Pattern.compile(regexDigits);
            Matcher matchDigits = patternDigits.matcher(numbers);

            while (matchDigits.find()) {
                int number = Integer.parseInt(matchDigits.group(1));
                int length = Integer.parseInt(matchDigits.group(2));
                if (asciiValue == number) {
                    char letter = (char) number;
                    collectionCharacteristics.putIfAbsent(letter, length + 1);
                    break;
                }
            }

        }

        for (int i = 0; i < capitalLetters.length(); i++) {
            String letter = String.valueOf(capitalLetters.charAt(i));
            int legth = collectionCharacteristics.get(capitalLetters.charAt(i));

            String patternCurrent = String.format("\\b(.?[%s][a-zA-z0-9_-]{%d})\\b", letter, legth-1);
            Pattern patternCurr = Pattern.compile(patternCurrent);

            Matcher newMatch = patternCurr.matcher(words);
            while (newMatch.find()) {
                String current = newMatch.group().trim();
                if (!Character.isAlphabetic(current.charAt(0))) {
                    continue;
                }
                System.out.println(current);

            }

        }
    }

}

