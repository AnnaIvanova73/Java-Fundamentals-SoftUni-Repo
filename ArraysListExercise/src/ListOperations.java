import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = getInputToNumbers(scan);

        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            int index = 0;
            int number = 0;
            boolean isValid = catchInvalidIndex(index, numbers);
            switch (tokens[0]) {
                case "Add":
                    number = Integer.parseInt(tokens[1]);
                    numbers.add(number);
                    break;
                case "Insert":
                    number = Integer.parseInt(tokens[1]);
                    index = Integer.parseInt(tokens[2]);
                    isValid = catchInvalidIndex(index, numbers);
                    if (isValid) {
                        numbers.add(index, number);
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(tokens[1]);
                    isValid = catchInvalidIndex(index, numbers);
                    if (isValid) {
                        numbers.remove(index);
                    }
                    break;
                case "Shift":
                    String cmdSecond = tokens[1];
                    int rotations = Integer.parseInt(tokens[2]);
                    if (cmdSecond.equals("left")) {
                        numbers = rotateLeft(rotations, numbers);
                    } else {
                        numbers = rotateRight(rotations, numbers);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }

    private static List<Integer> rotateRight(int rotations, List<Integer> numbers) {
        List<Integer> rotatedList = numbers;
        for (int indexFirst = 0; indexFirst < rotations; indexFirst++) {
            int firstNumber = rotatedList.get(rotatedList.size() - 1);
            for (int indexSecond = rotatedList.size() - 1; indexSecond > 0; indexSecond--) {
                int nextNum = rotatedList.get(indexSecond - 1);
                numbers.set(indexSecond,nextNum);
            }
            rotatedList.set(0, firstNumber);
        }


        return rotatedList;
    }

    private static List<Integer> rotateLeft(int rotations, List<Integer> numbers) {
        List<Integer> rotatedList = numbers;

        for (int index = 0; index < rotations; index++) {
            int firstNumber = rotatedList.get(0);
            for (int indexSecond = 0; indexSecond < rotatedList.size() - 1; indexSecond++) {
                int nextNumb = rotatedList.get(indexSecond + 1);
                rotatedList.set(indexSecond, nextNumb);
            }
            rotatedList.set(rotatedList.size() - 1, firstNumber);
        }


        return rotatedList;
    }

    private static void printInvalidIndex(int num) {
        System.out.println("Invalid index");
    }

    private static boolean catchInvalidIndex(int index, List<Integer> modified) {
        if (index >= 0 && index < modified.size()) {
            return true;
        }
        printInvalidIndex(index);
        return false;
    }

    private static List<Integer> getInputToNumbers(Scanner scan) {
        List<Integer> myNumbers = new ArrayList<>();
        String[] arrayInput = scan.nextLine().split("\\s+");

        for (String elements : arrayInput) {
            int number = Integer.parseInt(elements);
            myNumbers.add(number);
        }
        return myNumbers;
    }
}
