import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Exercise_4_StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int messages = Integer.parseInt(scan.nextLine());

        Pattern pattern = Pattern.compile("[star]*[STAR]*");
        List<String> decryptMess = new ArrayList<>();
        for (int i = 0; i < messages; i++) {
            String encryptedMessage = scan.nextLine();

            StringBuilder keyValue = new StringBuilder();
            Matcher match = pattern.matcher(encryptedMessage);
            int key = 0;

            while (match.find()) {
                keyValue.append(match.group());
                key = keyValue.length();
            }
            keyValue.setLength(0);

            String decrypted = getMessage(key, encryptedMessage);
            decryptMess.add(decrypted);
        }


        Pattern newPattern = Pattern.compile
                //("@(?<planet>[A-Za-z]+)[^@\\-!:>]*:([0-9]+)[^@\\-!:>]*!(?<attack>[AD])![^@\\-!:>]*->([0-9]*)");
                        ("@(?<planet>[A-Za-z]+)[^@\\-!:>]*:(?<population>[\\d]+)[^@\\-!:>]*!(?<attack>[AD]{1})![^@\\-!:>]*->(?<soldiers>[\\d]+)");

        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();
        for (String mess : decryptMess) {

            Matcher match = newPattern.matcher(mess);
            while (match.find()) {
                String name = match.group("planet");
                String attackPower = match.group("attack");

                if (attackPower.equals("A")) {
                    attacked.add(name);
                } else {
                    destroyed.add(name);
                }
            }

        }


        attacked.sort(Comparator.naturalOrder());
        destroyed.sort(Comparator.naturalOrder());
        System.out.printf("Attacked planets: %d%n", attacked.size());
        attacked.forEach(a -> System.out.printf("-> %s%n", a));
        System.out.printf("Destroyed planets: %d%n", destroyed.size());
        destroyed.forEach(a -> System.out.printf("-> %s%n", a));

    }

    private static String getMessage(int key, String string) {
        StringBuilder messages = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            int asciiValue = string.charAt(i);
            asciiValue -= key;
            String newValue = String.valueOf((char) asciiValue);
            messages.append(newValue);
        }
        return messages.toString();
    }
}
