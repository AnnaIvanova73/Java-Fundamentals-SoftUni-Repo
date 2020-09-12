import java.util.Scanner;

public class reverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word= scan.nextLine();

        for (int i = word.length() -1 ; i >= 0 ; i--) {
            int reverse = word.charAt(i);//ascii стойност
            char reverse1 = word.charAt(i);// чарове - букви, цифри
            System.out.print(reverse);

        }
    }
}
