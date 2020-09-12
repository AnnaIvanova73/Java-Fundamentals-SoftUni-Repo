import java.util.Scanner;

public class sumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input = Integer.parseInt(scan.nextLine());

        int sum = 0;
        for (int i = 1; i <= input ; i++) {
            int oddNum = 2*i-1;
                System.out.println(String.format("%d",oddNum));
                sum +=oddNum;
        }
        System.out.print(String.format("Sum: %d",sum));

    }
}
