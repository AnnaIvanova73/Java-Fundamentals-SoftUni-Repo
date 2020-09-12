import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int[] numbers = readInputMakeArrayNumbers(input);

        int compareNum = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numbers.length - 1; i++) {
            int firstNumber = numbers[i];
            for (int secondIndex = i + 1; secondIndex < numbers.length; secondIndex++) {
                int secondNumber = numbers[secondIndex];
                int sum = firstNumber + secondNumber;
                if(sum == compareNum){
                    System.out.println(firstNumber + " " + secondNumber);

                }

            }
        }


    }

    private static int[] readInputMakeArrayNumbers(String input) {
        String[] split = input.split("\\s+");
        int[] myArray = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            myArray[i] = Integer.parseInt(split[i]);
        }
        return myArray;
    }
}
