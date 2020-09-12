import java.util.Scanner;

public class ArraysRotationFromRightNegativeLastIndex {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arraySplit = scan.nextLine().split(" ");
        int[] numbers = new int[arraySplit.length];
        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = Integer.parseInt(arraySplit[index]);
        }

        int rotation = Integer.parseInt(scan.nextLine());// до макс големината на масива - 1
        rotation = rotation % numbers.length;

        for (int i = 0; i < rotation; i++) { // 1 2 3 4
            int lastDigit = numbers[numbers.length - 1];//4, 3
            //1234, 4123
            for (int j = numbers.length - 1; j > 0; j--) {//1223 - j1, 1223 - j2,1123 || j--> 3 4112 j 2 4112
                numbers[j] = numbers[j - 1];
            }
            numbers[0] = lastDigit; // 1 -> 4 --> 1123 --> 4123 ||  4--> 3 4123 -- >3412
        }

    }
}
