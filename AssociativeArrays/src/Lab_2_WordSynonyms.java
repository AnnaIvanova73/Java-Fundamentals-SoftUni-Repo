import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Lab_2_WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, ArrayList<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();

            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);

        }

//        for (Map.Entry<String, ArrayList<String>> entry : words.entrySet()) {
//           String value = String.join(", ", entry.getValue());
//          //  String substring = entry.getValue().toString().substring(1, entry.getValue().toString().length() - 1);
//            //String withReplacement = entry.getValue().toString().replace("[", "").replace("]", "");
//            System.out.println(String.format("%s - %s",entry.getKey()
//                    ,value));
//            System.out.println();
//        }

//        words
//                .forEach((key, value) -> System.out.printf("%s - %s%n", key, value.
//                        toString().
//                        replace("[", "")
//                        .replace("]", "")));


        words
                .forEach((key, value) -> System.out.printf("%s - %s%n", key, value.toString()
                        .substring(1, value.toString().length() -1)));

    }
}

