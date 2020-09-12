import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = getLineOfNumbers(scan);

        String input = scan.nextLine();

        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {

                case "Contains":
                    int number = Integer.parseInt(tokens[1]);
                    boolean isContain = numbers.contains(number);
                    if (isContain) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    List<Integer> newArr = getNumbersOddOrEven(tokens, numbers);
                    printMyListArray(newArr);
                    break;
                case "Get":
                    int sum = getSumOFAllElements(numbers);
                    System.out.println(sum);
                    break;
                case "Filter":
                    List<Integer> filterNumbers = compareAndFilterNumbers(tokens, numbers);
                    printMyListArray(filterNumbers);
                    break;
            }
            input = scan.nextLine();

        }

    }

    private static List<Integer> compareAndFilterNumbers(String[] tokens, List<Integer> numbers) {
        List<Integer> myNumbers = new ArrayList<>();
        int compareNumber = Integer.parseInt(tokens[2]);

        for (Integer number : numbers) {

            switch (tokens[1]) {
                case "<":
                    if (number < compareNumber) {
                        myNumbers.add(number);
                    }
                    break;
                case ">":
                    if (number > compareNumber) {
                        myNumbers.add(number);
                    }
                    break;
                case ">=":
                    if (number >= compareNumber) {
                        myNumbers.add(number);
                    }
                    break;
                case "<=":
                    if (number <= compareNumber) {
                        myNumbers.add(number);
                    }
                    break;
            }

        }

        return myNumbers;
    }

    private static int getSumOFAllElements(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static void printMyListArray(List<Integer> newArr) {
        for (int number : newArr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private static List<Integer> getNumbersOddOrEven(String[] tokens, List<Integer> numbers) {
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        for (int index = 0; index < numbers.size(); index++) {
            int currentElement = numbers.get(index);
            if (currentElement % 2 == 0) {
                evenNumbers.add(currentElement);
            } else {
                oddNumbers.add(currentElement);
            }
        }
        switch (tokens[1]) {
            case "even":
                return evenNumbers;
            case "odd":
                return oddNumbers;
        }
        return numbers;
    }


    private static List<Integer> getLineOfNumbers(Scanner scan) {
        String[] tokens = scan.nextLine().split("\\s+");
        List<Integer> arrNumbers = new ArrayList<>();
        for (String token : tokens) {
            int num = Integer.parseInt(token);
            arrNumbers.add(num);
        }
        return arrNumbers;
    }
}
