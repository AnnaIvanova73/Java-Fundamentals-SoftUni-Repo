import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

public class Task_1_NikuldensCharity {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String encryptedMsg = scan.nextLine();

        StringBuilder decrypt = new StringBuilder();
        decrypt.append(encryptedMsg);
        String input = scan.nextLine();
        while (!"Finish".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int strBuildLength = decrypt.length();
            switch (command) {
                case "Replace":
                    String current = tokens[1];
                    String newChar = tokens[2];
                    int indexCurrent = decrypt.indexOf(current);

                    String checker = decrypt.toString();
                    while (indexCurrent != -1) {
                        decrypt.setCharAt(indexCurrent, newChar.charAt(0));
                        indexCurrent = decrypt.indexOf(current);
                    }
                    if (!checker.equals(decrypt.toString())) {
                        System.out.println(decrypt);
                    }

                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]) + 1;
                    if (startIndex >= 0 && endIndex <= decrypt.length()) {
                        decrypt.delete(startIndex, endIndex);
                        System.out.println(decrypt);
                    } else {
                        System.out.println("Invalid indexes!");
                    }
                    break;

                case "Make":
                    String currStateMsg = decrypt.toString();
                    if (tokens[1].equals("Upper")) {
                        decrypt.setLength(0);
                        decrypt.append(currStateMsg.toUpperCase());
                    } else {
                        decrypt.setLength(0);
                        decrypt.append(currStateMsg.toLowerCase());
                    }
                    System.out.println(decrypt);
                    break;
                case "Check":
                    String currString = tokens[1];
                    String presentSet = decrypt.toString();
                    if (presentSet.contains(currString)) {
                        System.out.printf("Message contains %s%n", currString);
                    } else {
                        System.out.printf("Message doesn't contain %s%n", currString);
                    }
                    break;
                case "Sum":
                    int indexOne = Integer.parseInt(tokens[1]);
                    int indexTwo = Integer.parseInt(tokens[2]) + 1;
                    if (!isInBounds(indexOne, strBuildLength) || !isInBounds(indexTwo, strBuildLength)) {
                        System.out.println("Invalid indexes!");
                        break;
                    }

                    int sum = getSumAscii(indexOne, indexTwo, decrypt);
                    System.out.println(sum);
                    break;

            }


            input = scan.nextLine();
        }
    }

    private static int getSumAscii(int indexOne, int indexTwo, StringBuilder decrypt) {
        String substring = decrypt.substring(indexOne, indexTwo);

        int sum = 0;
        for (int i = 0; i < substring.length(); i++) {
            int ascii = substring.charAt(i);
            sum += ascii;
        }
        return sum;
    }

    private static boolean isInBounds(int index, int length) {
        return index >= 0 && index < length;
    }
}
