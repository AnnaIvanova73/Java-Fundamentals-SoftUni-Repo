import java.util.Scanner;

public class evenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //input
        String lineInput = scan.nextLine();

        //read array
        String[] stringSplit = lineInput.split(" ");
        int[] numbers = new int[stringSplit.length];
        for (int i = 0; i < numbers.length ; i++) {
            numbers[i]=Integer.parseInt(stringSplit[i]);
        }

        //calculations
        int evenSum = 0;
        int oddSum=0;
        for (int i = 0; i <numbers.length ; i++) {
                if (numbers[i] % 2 == 0){
                    evenSum+=numbers[i];
                } else{
                    oddSum+=numbers[i];
                }
        }

        //result
        int diffEvenOdd = evenSum-oddSum;

        //output
        System.out.println(diffEvenOdd);

    }
}
