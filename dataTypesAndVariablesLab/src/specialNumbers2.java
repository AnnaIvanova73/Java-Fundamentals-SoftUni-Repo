import java.util.Scanner;

public class specialNumbers2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= number; i++) {

            int digits = i;
            int digit1 = digits % 10;
            System.out.println(digit1); // работи за отделяне на число с две цифри, задачата е подвеждаща
            int digits2 = digits / 10;
            System.out.println(digits2);
            int strongNumber = digit1 + digits2;

            if (strongNumber == 5 || strongNumber == 7 || strongNumber == 11) {
                System.out.printf("%d -> True\n", digits);
            } else {
                System.out.printf("%d -> False\n",digits);
            }

        }


    }
}
