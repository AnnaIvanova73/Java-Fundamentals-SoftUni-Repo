import java.util.Scanner;

public class Exercise_4_CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();
        StringBuilder encrypt = new StringBuilder();

        for (int i = 0; i <input.length() ; i++) {
            int currentValue = input.charAt(i) + 3;
            char newLetter =(char) currentValue;
            encrypt.append(newLetter);
        }

        System.out.println(encrypt);
    }

}
