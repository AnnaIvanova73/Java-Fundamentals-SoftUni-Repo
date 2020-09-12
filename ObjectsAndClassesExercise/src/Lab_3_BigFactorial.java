import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Lab_3_BigFactorial {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        BigInteger factorial = new BigInteger("1");

        for (int i = 2; i <=n ; i++) {
            String num = String.valueOf(i);
            BigInteger bigInteger = new BigInteger(num);
            factorial = factorial.multiply(bigInteger);
        }
        System.out.println(factorial);
    }
}
