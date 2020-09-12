import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] numbers = new int [n];

        for (int i = 0; i < numbers.length ; i++) {
            numbers [i] = scan.nextInt();
        }

        for (int i = numbers.length - 1; i >= 0 ; i--) {
            System.out.println(numbers[i]);
        }
    }
}
