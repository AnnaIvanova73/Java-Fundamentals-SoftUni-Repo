import java.util.*;
public class April_06_Tech_Task_1_Dictionary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> dictionary = new HashMap<>();

        for (int i = 1; i <= 3; i++) {
            String input = scan.nextLine();
            switch (i) {
                case 1:
                    String[] tokens = input.split(" \\| ");
                    fillInTheMap(dictionary, tokens);
                    break;
                case 2:
                    String[] words = input.split(" \\| ");
                    printDefinition (words,dictionary);
                    break;
                case 3:
                    if(input.equals("End")){
                        return;
                    }
                    dictionary.keySet().stream().sorted().forEach(k -> System.out.print(k + " "));
                    break;
            }
        }

    }

    private static void printDefinition(String[] words, Map<String, List<String>> dictionary) {
        for (String word : words) {
            if(dictionary.containsKey(word)){
                System.out.println(word);
                dictionary.get(word).stream().sorted((a,b) -> Integer.compare(b.length(),a.length()))
                        .forEach(d-> {
                    System.out.println(" -" + d.trim());
                });
            }
        }
    }

    private static void fillInTheMap(Map<String, List<String>> dictionary, String[] tokens) {
        for (String currentWordAndDefinition : tokens) {
            String[] parts = currentWordAndDefinition.split(":");
            String word = parts[0];
            String definition = parts[1];

            if(!dictionary.containsKey(word)){
                dictionary.put(word,new ArrayList<>());
                dictionary.get(word).add(definition);
            }else{
                dictionary.get(word).add(definition);
            }

        }
    }
}
