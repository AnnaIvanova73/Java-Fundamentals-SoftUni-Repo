import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static int evenSum(int num) {

        int result = 0;
        while (num > 0) {

            int number = num % 10;
            if (number % 2 == 0) {
                result += number;
            }
            num /= 10;
        }

        return result;
    }

    public static int oddSum(int num) {

        int result = 0;
        while (num > 0) {

            int number = num % 10;

            if (number % 2 != 0) {
                result += number;
            }

            num /= 10;
        }

        return result;
    }

    public static int multiplyEvenByOdds(int num) {
        int odd = oddSum(num);
        int even = evenSum(num);
        return odd * even;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        int absoluteNumber = Math.abs(number);
        int result = multiplyEvenByOdds(absoluteNumber);
        System.out.println(result);
    }

}

