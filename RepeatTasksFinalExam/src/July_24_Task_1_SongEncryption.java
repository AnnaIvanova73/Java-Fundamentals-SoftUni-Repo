import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class July_24_Task_1_SongEncryption {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "^([A-Z][a-z' ]+):([A-Z ]+)$";
        Pattern pattern = Pattern.compile(regex);
        String input;
        while (!"end".equals(input = scan.nextLine())) {
            Matcher matcher = pattern.matcher(input);

            if (!matcher.find()) {
                System.out.println("Invalid input!");
                continue;
            }

            String artist = matcher.group(1);
            String song = matcher.group(2);
            String finall = artist + "@" + song;
            String encrypted = getEncryption(artist.length(), finall);
            System.out.println("Successful encryption: " + encrypted);

        }
    }

    private static String getEncryption(int length, String finall) {
        StringBuilder encrypted = new StringBuilder();
        int key = length % ('a' - 'z' - 1);
        for (int i = 0; i < finall.length(); i++) {
            char ch = finall.charAt(i);
            if ((ch == '@') || (ch == ' ') || (ch == '\'')) {
                encrypted.append(ch);
                continue;
            }
            char encrypt = (char) (ch + key);

            if (Character.isUpperCase(ch) && encrypt > 'Z') {
                encrypt = (char) (encrypt - 26);
            }
            if (Character.isLowerCase(ch) && encrypt > 'z') {
                encrypt = (char) (encrypt - 26);
            }
            encrypted.append(encrypt);
        }
        return encrypted.toString();
    }
}
