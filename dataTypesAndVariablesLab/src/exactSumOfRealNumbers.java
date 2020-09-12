import java.math.BigDecimal;
import java.util.Scanner;

public class exactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numbersForCalculation = Integer.parseInt(scan.nextLine());

        BigDecimal sumOfNumbers = new BigDecimal(0);
        for (int i = 1; i <=numbersForCalculation ; i++) {

            BigDecimal nums = new BigDecimal(scan.nextLine());

            sumOfNumbers = sumOfNumbers.add(nums);
        }
        System.out.println(sumOfNumbers);
    }
}
