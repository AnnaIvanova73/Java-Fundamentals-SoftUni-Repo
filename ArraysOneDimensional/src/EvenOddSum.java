import java.util.Scanner;

public class EvenOddSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rangeArray = Integer.parseInt(scan.nextLine());
        int[] numbers = new int[rangeArray];
        for (int i = 0; i <numbers.length ; i++) {
            numbers[i]=Integer.parseInt(scan.nextLine());
        }

        int oddSum = 0;
        int evenSum = 0;
        for(int number:numbers){
            if (number % 2 == 0){
                evenSum+=number;
            }else{
                oddSum+=number;
            }
        }
        System.out.println(evenSum-oddSum);
    }
}
