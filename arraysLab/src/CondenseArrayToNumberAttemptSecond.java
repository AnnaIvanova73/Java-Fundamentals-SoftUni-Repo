import java.util.Scanner;

public class CondenseArrayToNumberAttemptSecond {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //read input
        String inputLine = scan.nextLine();

        // read array as number
        String[] arraySplit = inputLine.split(" ");
        int[] arrNum = new int[arraySplit.length];
        // insert values into an array
        for (int i = 0; i < arrNum.length; i++) {
            arrNum[i] = Integer.parseInt(arraySplit[i]);
        }

        //calculations

        while (arrNum.length > 1) {

            int[] condensed = new int[arrNum.length - 1];

            for (int j = 0; j <condensed.length; j++) {
                condensed[j] = arrNum[j] + arrNum[j + 1];
           }
        arrNum = condensed;
    }
        System.out.println(arrNum[0]);

}
}
