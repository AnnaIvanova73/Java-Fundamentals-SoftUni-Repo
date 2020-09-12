import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task_3_LastStop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> collection = getNumbers(scan);

        String input = scan.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            String paintingNumber;
            boolean isValid;
            int index;
            switch (command) {
                case "Change":
                    String currentPainting = tokens[1];
                    paintingNumber = tokens[2];
                    if (!collection.contains(currentPainting)) {break;}
                    index = collection.indexOf(currentPainting);
                    collection.set(index, paintingNumber);
                    break;
                case "Hide":
                    paintingNumber = tokens[1];
                    collection.remove(paintingNumber);
                    break;
                case "Switch":
                    paintingNumber = tokens[1];
                    String paintingNumTwo = tokens[2];
                    if (!collection.contains(paintingNumber) ||
                            !collection.contains(paintingNumTwo)) {
                        break;
                    }
                    int indexOne = collection.indexOf(paintingNumber);
                    int indexTwo = collection.indexOf(paintingNumTwo);
                    String swap = paintingNumber;
                    collection.set(indexOne, paintingNumTwo);
                    collection.set(indexTwo, swap);
                    break;
                case "Insert":
                    index = Integer.parseInt(tokens[1]);
                    isValid = checkExistence(index, collection);
                    if (!isValid) {
                        break;
                    }
                    paintingNumber = tokens[2];
                    collection.add(index + 1, paintingNumber);
                    break;
                case "Reverse":
                    Collections.reverse(collection);
                    break;

            }


            input = scan.nextLine();
        }
        String print = String.join(" ", collection);
        System.out.println(print);
    }

    private static boolean checkExistence(int index, List<String> paintingNumbers) {
        return index >= 0 && index < paintingNumbers.size();
    }

    private static List<String> getNumbers(Scanner scan) {
        String[] input = scan.nextLine().split("\\s+");
        List<String> list = new ArrayList<>();

        for (String element : input) {
            list.add(element);
        }
        return list;
    }
}
