import java.util.Scanner;

public class MaxSequenceTomanov {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        int[] numbers = new int[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int length = 1;
        int endIndex = -1;
        int bestLength = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                length++;
                if (length > bestLength) {
                    bestLength = length;
                    endIndex = i + 1;
                }
            } else {
                length = 1;
            }
        }

        for (int i = endIndex; i > endIndex - bestLength; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}

