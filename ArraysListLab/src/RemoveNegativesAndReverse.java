import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = getLineOfNumbers(scan);

        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            int currentIndex = i;
            if (currentNumber < 0) {
                numbers.remove(currentIndex);
                i -= 1;
            }

        }

        if (numbers.size() > 0) {
            Collections.reverse(numbers);
            for (Integer number : numbers) {
                System.out.print(number + " ");
            }
        } else {
            System.out.println("empty");
        }


    }


    private static List<Integer> getLineOfNumbers(Scanner scan) {
        List<Integer> myNumbers = new ArrayList<>();

        String[] lineInput = scan.nextLine().split("\\s+");
        for (int i = 0; i < lineInput.length; i++) {
            int currentNumber = Integer.parseInt(lineInput[i]);
            myNumbers.add(currentNumber);
        }

        return myNumbers;
    }
}
