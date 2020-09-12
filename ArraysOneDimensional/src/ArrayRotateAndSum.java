import java.util.Scanner;

public class ArrayRotateAndSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arraySplit = scan.nextLine().split(" ");
        long[] numbers = new long[arraySplit.length];
        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = Integer.parseInt(arraySplit[index]);
        }

        int rotation = Integer.parseInt(scan.nextLine());

        long[] sum = new long[numbers.length];

        if (rotation > 0) {

            for (int i = 0; i < rotation; i++) {
                long lastDigit = numbers[numbers.length - 1];

                for (int j = numbers.length - 1; j > 0; j--) {
                    numbers[j] = numbers[j - 1];
                }
                numbers[0] = lastDigit;

                for (int indexFirst = 0; indexFirst < numbers.length; indexFirst++) {
                    long secondNum = numbers[indexFirst];
                    sum[indexFirst] += secondNum;
                }
            }

        }
        for (long elementFinal : sum) {
            System.out.print(Math.abs(elementFinal) + " ");
        }
    }
}

