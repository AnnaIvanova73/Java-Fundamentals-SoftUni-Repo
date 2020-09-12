import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] elements = scan.nextLine().split("\\s+");

        int[] numbers = new int[elements.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(elements[i]);
        }

        int maxSequence = 1;
        int currentCount = 1;
        int number = numbers[0];

        for (int i = 0; i < numbers.length - 1; i++) {

            int currentNumber = numbers[i];
            int previousNumber = numbers[i + 1];

            if (currentNumber == previousNumber) {
                currentCount += 1;
                if (currentCount > maxSequence) {
                    maxSequence = currentCount;
                     number = currentNumber;
                }
            } else {
                currentCount = 1;
            }

        }
        for (int i = 0; i < maxSequence; i++) {
            System.out.print(number + " ");
        }
    }
}
