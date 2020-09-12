import java.util.Scanner;

public class multiplicationTableVolTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        int multiplier = Integer.parseInt(scan.nextLine());

        int result = 0;
        if (multiplier > 10) {
            result = number * multiplier;
            System.out.println(String.format("%d X %d = %d", number, multiplier, result));
        }
        for (int i = multiplier; i <= 10; i++) {
            result = number * i;
            System.out.println(String.format("%d X %d = %d", number, i, result));
        }
    }
}


