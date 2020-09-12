import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String username = scan.nextLine();

        String password = "";
        boolean isItCorrect = true;

        for (int i = username.length() - 1; i >= 0; i--) {
            password = password + username.charAt(i);
        }

        String passwordConfirm = scan.nextLine();
        int counter = 0;//counter = 0

        while (!password.equals(passwordConfirm)) {
            counter++;

            if (counter == 4) {
                isItCorrect = false;
                System.out.print(String.format("User %s blocked!", username));
                break;
            }

            System.out.println("Incorrect password. Try again.");
            passwordConfirm = scan.nextLine();
        }


        if (isItCorrect) {
            System.out.print(String.format("User %s logged in.", username));
        }


    }
}
