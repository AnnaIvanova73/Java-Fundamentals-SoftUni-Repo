import java.util.*;
public class April_06_Tech_Task_1_Dictionary_1_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] wordsAndDefinitions = scan.nextLine().split(" \\| ");

        Map<String, List<String>> dictionary = new HashMap<>();
        for (String wordsAndDefinition : wordsAndDefinitions) {
            String[] tokens = wordsAndDefinition.split(":");
            String word = tokens[0];
            String definition = tokens[1];
            if (!dictionary.containsKey(word)) {
                dictionary.put(word, new ArrayList<>());
                dictionary.get(word).add(definition);
                continue;
            }
            dictionary.get(word).add(definition);
        }

        String[] searchByword = scan.nextLine().split("\\s+");

        for (String word : searchByword) {
            if (dictionary.containsKey(word)) {
                System.out.println(word);
                dictionary.get(word).stream().sorted((d1, d2) -> d2.length() - d1.length())
                        .forEach(value -> System.out.println(" -" + value.trim()));
            }
        }

        String finalCommand = scan.nextLine();

        if (finalCommand.equals("List")) {
            dictionary.keySet().stream().sorted().forEach(w -> System.out.print(w + " "));
        }
    }
}
