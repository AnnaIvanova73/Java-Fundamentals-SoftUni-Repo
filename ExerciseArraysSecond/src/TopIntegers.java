import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputLine = scan.nextLine().split(" ");

        int[] numArr = new int[inputLine.length];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(inputLine[i]);
        }

        for (int i = 0; i < numArr.length; i++) {
            int biggest = numArr[i];
            boolean isItBiggest = true;


            for (int j = i + 1; j < numArr.length; j++) {
                int secondNum = numArr[j];

                if (biggest <= secondNum) {
                    isItBiggest = false;
                    break;
                }

            }
            if (isItBiggest) {
                System.out.print(biggest + " ");
            }
        }
    }
}
