import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String firstLine = scan.nextLine();
        String secondLine = scan.nextLine();
        List<Integer> firstNumbers = parseIntLineOfNumbers(firstLine);
        List<Integer> secondNumbers = parseIntLineOfNumbers(secondLine);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < Math.min(firstNumbers.size(), secondNumbers.size()); i++) {
            int firstNum = firstNumbers.get(i);
            int secondNum = secondNumbers.get(i);
            result.add(firstNum);
            result.add(secondNum);
        }

        if (firstNumbers.size() > secondNumbers.size()) {
            result.addAll(getRemainingElements(firstNumbers,secondNumbers));
        } else {

            result.addAll(getRemainingElements(secondNumbers,firstNumbers));
        }

        System.out.println(result.toString().replaceAll("[\\[\\],]",""));
    }
     static List<Integer> getRemainingElements(List<Integer> longerList, List<Integer> shorterList)
    {
        List<Integer> NUMBERS = new ArrayList<>();
        for (int i = shorterList.size(); i < longerList.size(); i++)
            NUMBERS.add(longerList.get(i));
        return NUMBERS;
    }


    private static List<Integer> parseIntLineOfNumbers(String firstLine) {
        String[] split = firstLine.split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String string : split) {
            int number = Integer.parseInt(string);
            numbers.add(number);
        }
        return numbers;
    }
}
