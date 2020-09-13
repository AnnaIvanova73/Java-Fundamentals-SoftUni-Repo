import java.util.*;
import java.util.stream.Collectors;

public class Tech_Task_1_Dictionary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Map<String, List<String>> dictionary = new HashMap<>();

        int count = 1;
        while (count <= 3) {
            String input = scan.nextLine();

            switch (count) {
                case 1:
                    String[] wordsAndDefinitions = input.split("\\|+");
                    fillMap(wordsAndDefinitions, dictionary);
                    break;
                case 2:
                    String[] wordsPerPrint = input.split("\\s+");
                    printCurrentWords(wordsPerPrint, dictionary);
                    break;
                case 3:
                    if(input.equals("List")){
                        dictionary.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((a) -> {
                            System.out.print(a.getKey().trim() + " ");
                        });
                    }else{
                        return;
                    }
                    break;
            }
            count++;
        }


    }

    private static void printCurrentWords(String[] wordsPerPrint, Map<String, List<String>> dictionary) {
        for (String s : wordsPerPrint) {
            String currentWord = s.trim();
            if (dictionary.containsKey(currentWord)) {
                System.out.println(currentWord);
                dictionary.get(currentWord).stream().sorted((q1, q2) -> Integer.compare(q2.length(), q1.length()))
                        .forEach((e) -> {
                            System.out.print(" -");
                            System.out.print(e.trim());
                            System.out.println();
                        });
            }
        }
    }

    private static void fillMap(String[] wordsAndDefinitions, Map<String, List<String>> dictionary) {
        List<String> list = new ArrayList<>();
        for (String wordsAndDefinition : wordsAndDefinitions) {
            String currElements = wordsAndDefinition.trim();
            String[] split = currElements.split(":");
            String word = split[0];
            String definition = split[1];
            if(!dictionary.containsKey(word)){
                dictionary.put(word,new ArrayList<>());
                dictionary.get(word).add(definition);
            }else{
                dictionary.get(word).add(definition);
            }
        }
    }
}
