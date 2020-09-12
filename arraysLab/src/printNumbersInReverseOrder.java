import java.util.Scanner;

public class printNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputAmountNum = Integer.parseInt(scan.nextLine());

        int [] containInput = new int [inputAmountNum];

        for (int i = 0; i < containInput.length ; i++) {
            int number = Integer.parseInt(scan.nextLine());
            containInput[i] = number;
        }

        for (int i = containInput.length-1; i >= 0 ; i--) {
            System.out.print(containInput[i]);
            System.out.print(" ");
        }
    }
}
