import java.util.Scanner;

public class PasswordValidator {

    public static void checkPassword(String password) {

        boolean isValid = false;
        int passwordLength = password.length();

        if (passwordLength >= 6 && passwordLength <= 10) {
            isValid = true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");

        }


        boolean hasSymbols = false;

        int digitsCount = 0;
        boolean hasAboveTwoDigits = false;

        for (int i = 0; i < password.length(); i++) {

            int symbols = password.charAt(i);

            boolean hasLetter = (symbols >= 65 && symbols <= 90) || (symbols >= 97 && symbols <= 122);
            boolean hasNumber = (symbols >= 48 && symbols <= 57);


            if (hasLetter) {

            } else if (hasNumber) {
                digitsCount++;

                if (digitsCount >= 2) {
                    hasAboveTwoDigits = true;
                }
            } else {
                hasSymbols = true;
            }
        }

        if (!hasSymbols && (isValid && hasAboveTwoDigits)) {
            System.out.println("Password is valid");
        }
        if (hasSymbols) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!hasAboveTwoDigits) {
            System.out.println("Password must have at least 2 digits");
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String password = scan.nextLine();
        checkPassword(password);
    }
}
