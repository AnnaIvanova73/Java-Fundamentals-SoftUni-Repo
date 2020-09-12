import java.util.Scanner;

public class FactorialDivision {
//гърмяла  е поради това,че работя с интове проверка за отрицателно число не е необходими, цикъла започва от едно


    public static long factorialNumber(int num1) {

            long fact = 1;

            for (int j = 1; j <= num1; j++) {
                fact = fact * j;
            }
            return fact;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());

        double firstFactorial = factorialNumber(firstNum);
        double secondFactorial = factorialNumber(secondNum);

        double result = firstFactorial * 1.0 / secondFactorial;

        System.out.printf("%.2f", result);

    }
}
