import java.util.Scanner;

public class ArraysRotationFromLastIndex {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arraySplit = scan.nextLine().split(" ");
        int[] numbers = new int[arraySplit.length];
        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = Integer.parseInt(arraySplit[index]);
        }

        int rotation = Integer.parseInt(scan.nextLine());
        rotation = rotation % numbers.length;

        for (int i = 0; i < rotation; i++) {
            int lastDigit = numbers[numbers.length - 1];

            for (int j = numbers.length - 1; j > 0; j--) {
                numbers[j] = numbers[j - 1];
            }
            numbers[0] = lastDigit;
        }

    }
}
