import java.util.Scanner;

// 83 От 100
public class condenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputLine = scan.nextLine();

        String[] arraysString = inputLine.split(" ");

        int[] arrayNumbers = new int[arraysString.length];

        for (int i = 0; i < arrayNumbers.length; i++) {
            arrayNumbers[i] = Integer.parseInt(arraysString[i]);
        }


        while (arrayNumbers.length > 1) {


            int[] condensed = new int[arrayNumbers.length - 1];

            for (int i = 0; i < condensed.length; i++) {
                condensed[i] = arrayNumbers[i] + arrayNumbers[i + 1];
            }

            arrayNumbers = condensed;
        }

        System.out.println(arrayNumbers[0]);


    }
}
