import java.util.Scanner;

public class MethodReturnMaxSequenceArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int[] number = readInputMakeArrayNumbers(input);
        int[] maxSequence = maxSequenceEqualElements(number);

        for (int num : maxSequence) {
            System.out.print(num + " ");
        }

    }

    private static int[] readInputMakeArrayNumbers(String input) {
        String[] split = input.split("\\s+");
        int[] myArray = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            myArray[i] = Integer.parseInt(split[i]);
        }
        return myArray;
    }

    private static int[] maxSequenceEqualElements(int[] numbers) {

        int maxElement = 0;
        int maxCount = 1;

        int currentCount = 1;
        for (int i = 0; i < numbers.length - 1; i++) {

            int firstElement = numbers[i];
            int subsequentElement = numbers[i + 1];

            if (firstElement == subsequentElement) {
                currentCount++;
                if (maxCount < currentCount) {
                    maxCount = currentCount;
                    maxElement = numbers[i];
                }

            } else {
                currentCount = 1;
            }
        }
        int[] maxSequence = new int[maxCount];
        for (int j = 0; j < maxCount; j++) {
            maxSequence[j] = maxElement;
        }
        return maxSequence;
    }
}
