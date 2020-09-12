import java.util.Scanner;

public class evenNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        while (num != 0) {
            if (num % 2 == 0) {
                int result = Math.abs(num);
                System.out.printf("The number is: %d", result);
                    break;
            }
            System.out.println("Please write an even number.");
            num=Integer.parseInt(scan.nextLine());

        }
    }
}

