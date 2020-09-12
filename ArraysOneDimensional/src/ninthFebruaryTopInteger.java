import java.util.Scanner;

public class ninthFebruaryTopInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int[] numbers = inputToArrayNumbers(input);


        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            boolean isItBiggest = true;
            for (int j = i + 1; j < numbers.length; j++) {
                int numberSecond = numbers[j];
                if (numberSecond >= number) {
                    isItBiggest = false;
                }
            }
            if (isItBiggest){
                System.out.print(number + " ");
            }
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
