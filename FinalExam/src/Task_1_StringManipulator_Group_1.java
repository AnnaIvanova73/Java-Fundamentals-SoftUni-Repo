import java.util.Scanner;

public class Task_1_StringManipulator_Group_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String workText = scan.nextLine();

        StringBuilder transformText = new StringBuilder();
        transformText.append(workText);

        String input = scan.nextLine();
        while (!"End".equals(input)) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Translate": {
                    char symbol = tokens[1].charAt(0);
                    char replacement = tokens[2].charAt(0);
                    String changeToString = transformText.toString();
                    int indexSymbol = changeToString.indexOf(symbol);
                    if (indexSymbol < 0) {
                        break;
                    }
                    changeToString = changeToString.replace(symbol, replacement);
                    transformText.setLength(0);
                    transformText.append(changeToString);
                    System.out.println(transformText);
                }
                break;
                case "Includes": {
                    String containsString = tokens[1];
                    String changeToString = transformText.toString();
                    if (changeToString.contains(containsString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                }
                break;
                case "Start": {
                    String containsString = tokens[1];
                    String changeToString = transformText.toString();
                        int indexBegin = transformText.indexOf(containsString);
                        int length = containsString.length();
                        if (indexBegin + length == length) {
                            System.out.println("True");
                        } else {
                            System.out.println("False");
                        }
                }
                break;
                case "Lowercase": {
                    String temporary = transformText.toString().toLowerCase();
                    transformText.setLength(0);
                    transformText.append(temporary);
                    System.out.println(transformText);
                }
                break;
                case "FindIndex": {
                    char symbol = tokens[1].charAt(0);
                    int lastIndex = transformText.lastIndexOf(String.valueOf(symbol));
                    System.out.println(lastIndex);

                    String temp = transformText.toString();
                    int index = temp.lastIndexOf(symbol);
                   // System.out.println(index);
                }
                break;
                case "Remove": {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);
                    int endIndex = startIndex+count;
                    transformText.delete(startIndex,endIndex);
                    System.out.println(transformText);
                }
                break;
            }
            input = scan.nextLine();
        }
    }
}
