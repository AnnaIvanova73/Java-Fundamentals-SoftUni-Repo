import java.util.Scanner;

public class December_7_Group_2_Task_1_NikuldensCharity {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();

        String commands = scan.nextLine();
        while (!"Finish".equals(commands)) {
            String[] tokens = commands.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Replace":
                    char currentChar = tokens[1].charAt(0);
                    char newChar = tokens[2].charAt(0);
                    message = message.replace(currentChar, newChar);
                    System.out.println(message);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (!hasValidIndexes(startIndex, endIndex, message)) {
                        System.out.println("Invalid indexes!");
                        break;
                    }
                    message = substringAndPrint(message, startIndex, endIndex);
                    break;

                case "Make":
                    String additionalCondition = tokens[1];
                    if (additionalCondition.equals("Upper")) {
                        message = message.toUpperCase();
                        System.out.println(message);
                    } else {
                        message = message.toLowerCase();
                        System.out.println(message);
                    }
                    break;
                case "Check":
                    String string = tokens[1];
                    if (!message.contains(string)) {
                        System.out.println("Message doesn't contain " + string);
                        break;
                    }
                    System.out.println("Message contains " + string);
                    break;
                case "Sum":
                    int indexStart = Integer.parseInt(tokens[1]);
                    int indexEnd = Integer.parseInt(tokens[2]) + 1;
                    if (!hasValidIndexes(indexStart, indexEnd, message)) {
                        System.out.println("Invalid indexes!");
                        break;
                    }

                    String currentSubstring  = message.substring(indexStart,indexEnd);
                    int sum = getSum(currentSubstring);
                    System.out.println(sum);
                    break;
            }


            commands = scan.nextLine();

        }
    }

    private static int getSum(String message) {
        int sum = 0;
        for (int i = 0; i < message.length(); i++) {
            int ascii = message.charAt(i);
            sum += ascii;
        }
        return sum;
    }

    private static String substringAndPrint(String message, int startIndex, int endIndex) {
        String beginning = message.substring(0, startIndex );
        String ending = message.substring(endIndex+1);
        message = beginning + ending;
        System.out.println(message);
        return message;
    }

    private static boolean hasValidIndexes(int startIndex, int endIndex, String string) {
        return startIndex >= 0 && endIndex < string.length();
    }
}
