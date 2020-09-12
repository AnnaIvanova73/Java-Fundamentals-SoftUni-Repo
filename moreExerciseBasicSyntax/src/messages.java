import java.util.Scanner;

public class messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int countLoops = Integer.parseInt(scan.nextLine());

        String message = "";
        for (int i = 1; i <= countLoops; i++) {
            String mobileInput = scan.nextLine();

            int length = mobileInput.length();//дължина дума
            int number = Character.getNumericValue(mobileInput.charAt(0));// числото

            int timesPushButton = 0;
            if (number == 8 || number == 9) {
                timesPushButton = ((number - 2) * 3) + 1;
            } else {
                timesPushButton = (number - 2) * 3;

            }

            timesPushButton = (timesPushButton + length) - 1;

            int ascii = 0;

            if (number == 0){
                ascii = 32;
            } else{
                ascii = timesPushButton + 97;
            }

            char finaL = (char) ascii;
            message += finaL;
        }

        System.out.println(message);
    }
}
