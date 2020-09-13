import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_MessageDecrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countOfInputs = Integer.parseInt(scan.nextLine());

        Pattern patternRegex = Pattern.compile
                ("^([$%])([A-Z]{1}[a-z]{2,})\\1: \\[([0-9]+)]\\|\\[([0-9]+)]\\|\\[([0-9]+)]\\|$");


        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < countOfInputs; i++) {
            String input = scan.nextLine();

            Matcher match = patternRegex.matcher(input);

            if (!match.find()) {
                System.out.println("Valid message not found!");
            } else {
                System.out.print(match.group(2) + ": ");

                String sequence = match.group(3);
                String letter = getLetter(sequence);
                decryptedMessage.append(letter);

                sequence = match.group(4);
                letter = getLetter(sequence);
                decryptedMessage.append(letter);

                sequence = match.group(5);
                letter = getLetter(sequence);
                decryptedMessage.append(letter);

                System.out.println(decryptedMessage);
                decryptedMessage.setLength(0);

            }
        }
    }

    private static String getLetter(String sequence) {

        int valueAscii = Integer.parseInt(sequence);
        char letter = (char) valueAscii;
        String result = Character.toString(letter);
        return result;
    }
}
