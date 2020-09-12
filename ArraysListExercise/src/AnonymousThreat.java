import com.company.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> lineOfChars = getMyCollection(scan);

        String input = scan.nextLine();

        while (!"3:1".equals(input)) {
            String[] tokens = input.split("\\s+");


            switch (tokens[0]) {

                case "merge":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    mergeMyLine(lineOfChars, startIndex, endIndex);
                    break;
                case "divide":
                    int indexDivide = Integer.parseInt(tokens[1]);
                    int divideTimes = Integer.parseInt(tokens[2]);
                    if (divideTimes ==0){
                        break;

                    }
                    String currentElement = lineOfChars.get(indexDivide);
                    int substringsLength = currentElement.length() / divideTimes;

                    if (currentElement.length() % divideTimes == 0) {
                        lineOfChars.remove(currentElement);
                        int count = 0;

                        for (int i = 0; i < divideTimes; i++) {
                            String separatedElement = "";

                            if (count == currentElement.length()) {
                                break;
                            }
                            for (int j = 0; j < substringsLength; j++) {
                                separatedElement += currentElement.charAt(count);
                                count++;
                            }
                            lineOfChars.add(i + indexDivide, separatedElement);
                        }

                    } else {
                        lineOfChars.remove(currentElement);
                        int count = 0;
                        for (int i = 0; i < divideTimes; i++) {
                            String separatedElement = "";

                            for (int j = 0; j < substringsLength; j++) {
                                separatedElement += currentElement.charAt(count);
                                count++;
                            }
                            lineOfChars.add(i + indexDivide, separatedElement);
                        }
                        String element = "";
                        for (int i = count; i < currentElement.length() ; i++) {
                          element+=currentElement.charAt(i);
                        }
                        lineOfChars.add(count, element);

                    }
                    break;
            }


            input = scan.nextLine();
        }

        // String[] elements =
        // System.out.println(lineOfChars.toString());
        for (String lineOfChar : lineOfChars) {
            System.out.print(lineOfChar + " ");
        }

    }


    private static void mergeMyLine(List<String> lineOfChars, int startIndex, int endIndex) {
        if (startIndex < 0) {
            startIndex = 0;
        }

        if (endIndex > lineOfChars.size() - 1) {
            endIndex = lineOfChars.size() - 1;
        }
        int counter = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            String concat = lineOfChars.get(counter) + lineOfChars.get(counter + 1);
            lineOfChars.set(counter, concat);
            lineOfChars.remove(counter + 1);
        }
    }

    private static List<String> getMyCollection(Scanner scan) {
        String input = scan.nextLine();
        String[] split = input.split("\\s+");
        List<String> characters = new ArrayList<>();
        for (String elements : split) {
            characters.add(elements);
        }
        return characters;
    }
}
