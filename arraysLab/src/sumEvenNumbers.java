import java.util.Scanner;

public class sumEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String elements = scan.nextLine();
        String[] stringNum = elements.split(" ");
        int[] myNums = new int[stringNum.length];

        for (int i = 0; i < myNums.length; i++) {
            myNums[i] = Integer.parseInt(stringNum[i]);
        }

        int evenNumSum = 0;

        for (int i = 0; i < myNums.length; i++) {
            if (myNums[i] % 2 == 0) {
                evenNumSum += myNums[i];
            }
        }
        System.out.println(evenNumSum);
    }
}
