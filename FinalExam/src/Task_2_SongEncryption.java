import java.util.Scanner;
import java.util.regex.Pattern;

public class Task_2_SongEncryption {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(":");
            boolean hasValidArtist = isValid(tokens[0]);
            boolean hasValidSong = isValidSong(tokens[1]);

            if (hasValidArtist && hasValidSong) {
                String artist = encryptMessage(tokens[0], tokens[0]);
                String song = encryptMessage(tokens[0],tokens[1]);
                System.out.println("Successful encryption: " + artist+"@"+song);
            } else {
                System.out.println("Invalid input!");
            }


            input = scan.nextLine();
        }
    }

    private static String encryptMessage(String token, String token1) {
        int key = token.length() % ('a' - 'z'-1);
        StringBuilder encrypt = new StringBuilder();

        for (int i = 0; i < token1.length(); i++) {
            char charr = token1.charAt(i);
            char encrypted;
            if (charr != ' ' && charr != '\'') {
                encrypted = (char) (charr + key);

                if (Character.isUpperCase(charr) && encrypted > 'Z') {
                    encrypted = (char) (encrypted - 26);
                }
                if (Character.isLowerCase(charr) && encrypted > 'z') {
                    encrypted = (char) (encrypted - 26);
                }
            }else{
                encrypted=charr;
            }
            encrypt.append(encrypted);
        }

        return encrypt.toString();

    }

    private static boolean isValidSong(String token) {
        return Pattern.compile("[A-Z ]+").matcher(token).matches();
    }

    private static boolean isValid(String token) {
        return Pattern.compile("[A-Z][a-z' ]+").matcher(token).matches();
    }


}
