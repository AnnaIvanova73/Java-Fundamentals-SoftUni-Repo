import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Exercise_2_Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        List<String> participants = Arrays.stream(input.split("[, ]+"))
                .collect(Collectors.toList());

        String regexName = "([A-Za-z]+)";
        Pattern patternNames = Pattern.compile(regexName);

        String regexDigits = "[\\d]";
        Pattern patternDigits = Pattern.compile(regexDigits);

        Map<String, Integer> finalists = new LinkedHashMap<>();

        String contestants = scan.nextLine();
        while (!"end of race".equals(contestants)) {

            StringBuilder currentPlayer = new StringBuilder();
            Matcher matchLetters = patternNames.matcher(contestants);

            while (matchLetters.find()) {
                String currentLetter = matchLetters.group();
                currentPlayer.append(currentLetter);
            }


            if (participants.contains(currentPlayer.toString())) {

                Matcher matchDigits = patternDigits.matcher(contestants);
                int currentKm = 0;

                while (matchDigits.find()) {
                    int currentDigit = Integer.parseInt(matchDigits.group());
                    currentKm += currentDigit;
                }


                if (!finalists.containsKey(currentPlayer.toString())) {
                    finalists.put(currentPlayer.toString(), currentKm);
                } else {
                    int previousResult = finalists.get(currentPlayer.toString());
                    finalists.put(currentPlayer.toString(), currentKm + previousResult);
                }

            }
            contestants = scan.nextLine();
        }
        final int[] insideCounter = {-1};
        final String[] places = {"1st", "2nd", "3rd"};
        finalists
                .entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int first = p1.getValue();
                    int second = p2.getValue();
                    return second - first;
                })
                .limit(3)
                .forEach(f -> {
                    int jgf = insideCounter[0] += 1;
                    System.out.printf("%s place: %s\n", places[jgf], f.getKey());
                });
    }
}
