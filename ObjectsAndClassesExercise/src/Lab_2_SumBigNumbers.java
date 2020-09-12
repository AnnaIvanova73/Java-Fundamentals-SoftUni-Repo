import java.math.BigInteger;
import java.util.Scanner;

public class Lab_2_SumBigNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BigInteger firstNum = new BigInteger(scan.nextLine());
        BigInteger secondNum = new BigInteger(scan.nextLine());

        System.out.println(firstNum.add(secondNum));
    }
}
