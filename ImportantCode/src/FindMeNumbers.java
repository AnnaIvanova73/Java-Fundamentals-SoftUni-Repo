import java.util.ArrayList;
import java.util.List;

public class FindMeNumbers {


    private static List <Integer> parseLineOfNumbersForLoop(String line) {
        String[] split = line.split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < split.length ; i++) {
            int num = Integer.parseInt(split[i]);
            numbers.add(num);
        }
        return numbers;
    }


    private static void parseLineOfNumbers(String line) {
        String[] strings = line.split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String string : strings) {
            int number = Integer.parseInt(string);
            numbers.add(number);
        }

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

    static int absValue(int number) {
        int absResult = 0;
        if (number < 0) {
            absResult = -number;
        } else {
            absResult = number;
        }
        return absResult;
    }

    static int absValueReturnInCondition(int number) {
        if (number < 0) {
            return -number;
        } else {
            return number;
        }
    }

    static int absValueReturn(int number) {
        if (number < 0) {
            return -number;
        }
        return number;
    }

    static int maxPower(int number, int power) {
        int result = 1;
        for (int i = 0; i < power; i++) {
            result *= number;
        }
        return result;
    }


}
