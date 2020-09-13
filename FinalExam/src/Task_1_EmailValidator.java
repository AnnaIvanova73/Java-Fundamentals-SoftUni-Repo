import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task_1_EmailValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String email = scan.nextLine();

        StringBuilder stringManipulator = new StringBuilder();
        stringManipulator.append(email);

        String input = scan.nextLine();
        while (!"Complete".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            String additional;
            switch (command) {
                case "Make":
                    additional = tokens[1];
                    switch (additional) {
                        case "Upper":
                            additional = stringManipulator.toString().toUpperCase();
                            System.out.println(additional);
                            stringManipulator.setLength(0);
                            stringManipulator.append(additional);
                            break;
                        case "Lower":
                            additional = stringManipulator.toString().toLowerCase();
                            System.out.println(additional);
                            stringManipulator.setLength(0);
                            stringManipulator.append(additional);
                            break;
                    }
                    break;
                case "GetDomain":
                    int lastIndex = stringManipulator.lastIndexOf(".");
                    String substringDomain = stringManipulator.substring(lastIndex + 1);
                    System.out.println(substringDomain);
                    break;
                case "GetUsername":
                    String currentStageMeil = stringManipulator.toString();
                    if (currentStageMeil.contains("@")) {
                        int indMonkeyA = stringManipulator.indexOf("@");
                        String substringUsername = stringManipulator.substring(0, indMonkeyA);
                        System.out.println(substringUsername);
                    } else {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", currentStageMeil);
                    }
                    break;
                case "Replace":
                    String current = tokens[1];
                    int index = stringManipulator.indexOf(current);


                    while (index != -1) {
                        stringManipulator.setCharAt(index, '-');
                        index = stringManipulator.indexOf(current);
                    }

                    System.out.println(stringManipulator);

                    break;
                case "Encrypt":
                    List<String> printValue = getValue(stringManipulator);
                    System.out.println(String.join(" ", printValue));
            }
            input = scan.nextLine();

        }

    }
    private static List<String> getValue(StringBuilder string) {
        String symbols = string.toString();

        List<String> valuesSymbols = new ArrayList<>();
        for (int i = 0; i < symbols.length(); i++) {
            int ascii = symbols.charAt(i);
            String valueAsString = String.valueOf(ascii);
            valuesSymbols.add(valueAsString);
        }
        return valuesSymbols;
    }
}
