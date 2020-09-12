import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      int rangeArea = Integer.parseInt(scan.nextLine());
      int[] sum = new int[rangeArea];


        for (int i = 0; i < rangeArea; i++) {

            String name = scan.nextLine();
            int sumLetters = 0;
            int length = name.length();

                for (int indexSecond = 0; indexSecond < name.length(); indexSecond++) {
                    int getLetters = name.charAt(indexSecond);
                        if (getLetters == 97 || getLetters == 101 || getLetters == 105 || getLetters == 111 ||
                            getLetters == 117 || getLetters == 65 || getLetters == 69 || getLetters == 73 ||
                            getLetters == 79 || getLetters == 85) {
                        int multiply = getLetters * length;
                        sumLetters += multiply;
                        } else {
                        int divide = getLetters / length;
                        sumLetters += divide;
                    }
                }

      sum[i] +=sumLetters;

            }

       Arrays.sort(sum);
       for (int num:
             sum) {
           System.out.println(num);
        }
    }
}
