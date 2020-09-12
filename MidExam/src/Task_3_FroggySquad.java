import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task_3_FroggySquad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> riversideFrogs = getFrogs(scan);


        String input = scan.nextLine();
        while (!input.equals("Print Normal") && !input.equals("Print Reversed")) {
            String[] tokens = input.split("\\s+");
            boolean isValid;
            String cmdSecond = tokens[1];
            switch (tokens[0]) {
                case "Join":
                    riversideFrogs.add(cmdSecond);
                    break;
                case "Jump":
                    int index = Integer.parseInt(tokens[2]);
                    isValid = validateIndex(index, riversideFrogs);
                    if (isValid) {
                        riversideFrogs.add(index, cmdSecond);
                    }
                    break;
                case "Dive":
                    int indexDive = Integer.parseInt(cmdSecond);
                    isValid = validateIndex(indexDive, riversideFrogs);
                    if (isValid) {
                        riversideFrogs.remove(indexDive);
                    }
                    break;
                case "First":
                    int count = Integer.parseInt(cmdSecond);
                    printFirstFrogs(count, riversideFrogs);
                    break;
                case "Last":
                    int countSecond = Integer.parseInt(cmdSecond);
                    printLastFrogs(countSecond, riversideFrogs);
                    break;

            }
            input = scan.nextLine();
        }
        System.out.println();
        if ("Print Normal".equals(input)) {
            printAllFrogs(riversideFrogs);
        }
        if ("Print Reversed".equals(input)) {
            Collections.reverse(riversideFrogs);
            printAllFrogs(riversideFrogs);
        }
    }

    private static void printAllFrogs(List<String> list) {
        System.out.print("Frogs: ");
        for (String currentElement : list) {
            System.out.print(currentElement + " ");
        }
    }

    private static void printLastFrogs(int countSecond, List<String> riversideFrogs) {
        int iterate = riversideFrogs.size() - countSecond;
        String frogs = "";
        if (countSecond >= riversideFrogs.size()) {
            for (int i = 0; i < riversideFrogs.size(); i++) {
                frogs += riversideFrogs.get(i) + " ";
            }
        }
        if (countSecond < riversideFrogs.size()) {
            for (int i = iterate; i < riversideFrogs.size(); i++) {
                frogs += riversideFrogs.get(i) + " ";
            }

        }

        System.out.print(frogs.trim());
    }

    private static void printFirstFrogs(int count, List<String> riversideFrogs) {
        int currentCount = 0;
        String frogs = "";
        for (String riversideFrog : riversideFrogs) {
            frogs += riversideFrog + " ";
            currentCount++;
            if (currentCount == count) {
                break;
            }
        }
        System.out.print(frogs.trim());

    }

    private static boolean validateIndex(int index, List<String> riversideFrogs) {
        if (index >= 0 && index < riversideFrogs.size()) {
            return true;
        }
        return false;
    }

    private static List<String> getFrogs(Scanner scan) {
        String[] input = scan.nextLine().split("\\s+");
        List<String> arrayList = new ArrayList<>();
        for (String currentElement : input) {
            arrayList.add(currentElement);
        }
        return arrayList;
    }
}
