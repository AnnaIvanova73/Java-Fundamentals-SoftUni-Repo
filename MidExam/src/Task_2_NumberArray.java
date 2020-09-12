import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_2_NumberArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numberArray = getNumberArray(scan);

        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String commands = tokens[0];

            int index;
            boolean isValid;

            switch (commands) {
                case "Switch":
                    index = Integer.parseInt(tokens[1]);
                    isValid = checkExistence(index, numberArray);
                    if (isValid) {
                        int currNum = numberArray.get(index);
                        int newNum = switched(currNum);
                        numberArray.set(index, newNum);
                    }
                    break;
                case "Change":
                    index = Integer.parseInt(tokens[1]);
                    int valueElement = Integer.parseInt(tokens[2]);
                    isValid = checkExistence(index, numberArray);
                    if (isValid) {
                        numberArray.set(index, valueElement);
                    }
                    break;
                case "Sum":
                    String arguments = tokens[1];
                    int sum = 0;
                    switch (arguments) {
                        case "Negative":
                            sum = getNegativeSum(numberArray);
                            System.out.println(sum);
                            break;
                        case "Positive":
                            sum = getPositiveSum(numberArray);
                            System.out.println(sum);
                            break;
                        case "All":
                            sum = getSumOfAll(numberArray);
                            System.out.println(sum);
                            break;
                    }
                    break;
            }
            input = scan.nextLine();
        }
        for (int currNum : numberArray) {
            if (currNum > -1) {
                System.out.print(currNum + " ");
            }
        }



}

    private static int getSumOfAll(List<Integer> numberArray) {
        int sum = 0;
        for (int currNum : numberArray) {
            sum += currNum;
        }

        return sum;
    }

    private static int getPositiveSum(List<Integer> numberArray) {
        int sum = 0;
        for (int currNum : numberArray) {
            if (currNum > -1) {
                sum += currNum;
            }
        }
        return sum;
    }

    private static int getNegativeSum(List<Integer> numberArray) {
        int sum = 0;
        for (int currNum : numberArray) {
            if (currNum < 0) {
                sum += currNum;
            }
        }
        return sum;
    }

    private static int switched(int currNum) {
        int switcher = -1;
        currNum *= switcher;
        return currNum;
    }

    private static boolean checkExistence(int index, List<Integer> list) {
        if (index >= 0 && index < list.size()) {
            return true;
        }
        return false;
    }

    private static List<Integer> getNumberArray(Scanner scan) {
        String[] input = scan.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String currElement : input) {
            int number = Integer.parseInt(currElement);
            numbers.add(number);
        }
        return numbers;
    }
}
