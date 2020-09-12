import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        int[] numbers = new int[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int uniqueNumber = Integer.parseInt(scan.nextLine());


        for (int i = 0; i < numbers.length - 1; i++) {

            int oneOfPair = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {

                int twoOfPair = numbers[j];
                int compareResult = oneOfPair + twoOfPair;

                if (compareResult == uniqueNumber) {
                    System.out.print(oneOfPair + " " + twoOfPair);
                    System.out.println();


                }
            }
        }
    }
}
