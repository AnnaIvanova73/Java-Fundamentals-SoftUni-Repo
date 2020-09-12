import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_1_ValidUserName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] userNames = scan.nextLine().split(", ");


        for (String username : userNames) {
            if (isValidUsername(username)) {
                System.out.println(username);
            }
        }

    }

    private static boolean isValidUsername(String username) {
        int lengthWord = username.length();
        if (lengthWord < 3 || lengthWord > 16) {
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            char letter = username.charAt(i);
            if (!Character.isLetterOrDigit(letter) && letter != '-' && letter != '_') {
                return false;
            }
        }
        return true;
    }
}
