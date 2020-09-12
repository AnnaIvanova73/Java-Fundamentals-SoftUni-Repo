import java.util.Scanner;

public class Exercise_5_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String bigNumber = scan.nextLine();
        int multiplayer = Integer.parseInt(scan.nextLine());

        if (multiplayer == 0) {
            System.out.println("0");
            return;
        }

        StringBuilder collectNumbers = new StringBuilder();
        int diff = 0;


        for (int i = bigNumber.length() - 1; i >= 0; i--) {
            char currElement = bigNumber.charAt(i);
            String toString = String.valueOf(currElement);

            int digit = Integer.parseInt(toString);
            int product = (digit * multiplayer) + diff;

            collectNumbers.append(product % 10);
            diff = product / 10;
        }

        if (diff != 0) {
            collectNumbers.append(diff);
        }
        String result = collectNumbers.reverse().toString();

        while ( result.charAt(0) =='0'){
            result=result.substring(1);
        }
        System.out.println(result);
    }
}
