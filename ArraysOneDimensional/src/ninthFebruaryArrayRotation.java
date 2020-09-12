import java.util.Scanner;

public class ninthFebruaryArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] arraySplit = input.split("\\s+");

        int rotation = Integer.parseInt(scan.nextLine());
        //int[] numbersArray = (makeArrayOfNumbers(arraySplit));
        int[] numbersArray = returnRotatedElementsPositiveLoop(makeArrayOfNumbers(arraySplit),rotation) ;

        //int[] rotatedArray = returnRotatedElementsPositiveLoop(numbersArray, rotation);
        //int[] rotatedNegativeArray = rotatedElementsNegativeLoop(numbersArray, rotation);
        printArray(numbersArray);


    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.println(num + " ");
        }
    }

    private static int[] rotatedElementsNegativeLoop(int[] numbers, int rotation) {

        for (int i = 0; i < rotation; i++) {
            int lastNum = numbers[numbers.length - 1];

            for (int j = numbers.length - 1; j > 0; j--) {
                numbers[j] = numbers[ j - 1];
            }


            numbers[0] = lastNum;
        }
        return numbers;
    }


    private static int[] returnRotatedElementsPositiveLoop(int[] numbers, int rotation) {

        for (int i = 0; i < rotation; i++) {
            int saveNum = numbers[0];

            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }

            numbers[numbers.length - 1] = saveNum;
        }

        return numbers;
    }

    //rotation 4
    private static int[] makeArrayOfNumbers(String[] array) {

        int[] myArrNumbers = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            myArrNumbers[i] = Integer.parseInt(array[i]);
        }

        return myArrNumbers;
    }
}
