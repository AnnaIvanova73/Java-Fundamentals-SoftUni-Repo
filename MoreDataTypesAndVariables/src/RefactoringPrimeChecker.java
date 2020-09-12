import java.util.Scanner;

public class RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int endNum = Integer.parseInt(scan.nextLine());

        for (int numbers = 2; numbers <= endNum; numbers++) {

            boolean isItPrime = true;
            for (int devider = 2; devider < numbers; devider++) {

                if (numbers % devider == 0) {
                    isItPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", numbers, isItPrime);
        }

    }
}
