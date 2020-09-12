import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoreExercise_Task_3_PostOffice_Rumen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] tokens = input.split("\\|");
        String first = tokens[0];
        String numbers = tokens[1];
        String[] words = tokens[2].split("\\s+");

        Pattern patternMessage = Pattern.compile("([#$%*&])([A-Z]+)\\1");
        Matcher match = patternMessage.matcher(first);

        String capitalLetters = "";
        if (match.find()) {
            capitalLetters = match.group(2);
        }

        LinkedHashMap<Character, Integer> collectionCharacteristics = new LinkedHashMap<>();

        for (int i = 0; i < capitalLetters.length(); i++) {
            collectionCharacteristics.putIfAbsent(capitalLetters.charAt(i), 0);
        }


        String regexDigits = "([0-9]{2}):([0-9]{2})";
        Pattern patternDigits = Pattern.compile(regexDigits);
        Matcher matchDigits = patternDigits.matcher(numbers);

        while (matchDigits.find()) {
            int number = Integer.parseInt(matchDigits.group(1));
            int length = Integer.parseInt(matchDigits.group(2));
            if (collectionCharacteristics.containsKey((char) number)) {
                collectionCharacteristics.put((char) number, length + 1);
            }
        }

        for (Character character : collectionCharacteristics.keySet()) {
            for (String word : words) {
                if (character == word.charAt(0) && word.length() == collectionCharacteristics.get(character)) {
                    System.out.println(word);
                }
            }
        }
    }
}