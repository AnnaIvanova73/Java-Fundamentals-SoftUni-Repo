import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int topNumber = Integer.parseInt(scan.nextLine());
        findMeTopNumber(topNumber);
    }

    private static void findMeTopNumber(int num) {

        for (int i = 1; i <= num; i++) {
            int initialNumber = i;
            int sumOfDigits = 0;
            int count = 0;
            while (initialNumber != 0) {
                int splitDigits = initialNumber % 10;
                sumOfDigits += splitDigits;

                if (splitDigits % 2 != 0) {
                    count++;
                }
                initialNumber /= 10;
            }

            if(count >=1 && sumOfDigits % 8 == 0){
                System.out.println(i);
            }
        }

    }

}
