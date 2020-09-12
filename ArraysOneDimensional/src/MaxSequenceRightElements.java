import java.util.Scanner;

public class MaxSequenceRightElements {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int[] numbers = inputToArrayNumbers(input);

        int maxCountOfElements = 1;
        int maxElement = 0;
        int currentCountElements = 1;

        for (int i = 0; i < numbers.length - 1; i++) {
            int firstElement = numbers[i];
            int subsequent = numbers[i + 1];

            if (firstElement == subsequent) {

                currentCountElements += 1;
                if (maxCountOfElements < currentCountElements) {
                    maxElement=firstElement;
                    maxCountOfElements = currentCountElements;
                }

            }else {
                currentCountElements = 1;
            }
        }
        for (int i = 0; i < maxCountOfElements; i++) {
            System.out.print(maxElement + " ");
        }
    }


    private static int[] inputToArrayNumbers(String input) {
        String[] split = input.split("\\s+");
        int[] myArray = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            myArray[i] = Integer.parseInt(split[i]);
        }
        return myArray;
    }
}
