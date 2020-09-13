import java.util.Scanner;
public class August_9_Task_1_Username {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String wantedUsername = scan.nextLine();

        String input;
        while (!(input = scan.nextLine()).equals("Sign up")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Case":
                    String additionalCmd = tokens[1];
                    if (additionalCmd.equals("upper")) {
                        System.out.println(wantedUsername = wantedUsername.toUpperCase());
                    } else {
                        System.out.println(wantedUsername = wantedUsername.toLowerCase());
                    }
                    break;
                case "Reverse":
                    int indexFirst = Integer.parseInt(tokens[1]);
                    int indexSecond = Integer.parseInt(tokens[2]) + 1;
                    if(checkIndex(indexFirst,indexSecond,wantedUsername.length())){
                        String temp = wantedUsername.substring(indexFirst,indexSecond);
                        printReversedString(temp);
                    }
                    break;
                case "Cut":
                    String substring = tokens[1];
                    if(!wantedUsername.contains(substring)){
                        System.out.printf("The word %s doesn't contain %s.%n",wantedUsername,substring);
                        break;
                    }
                    wantedUsername = wantedUsername.replace(substring,"");
                    System.out.println(wantedUsername);
                    break;
                case "Replace":
                    String symbol = tokens[1];
                        wantedUsername  = wantedUsername.replace(symbol, "*");
                        System.out.println(wantedUsername);
                    break;
                case "Check":
                    char current = tokens[1].charAt(0);
                    if(wantedUsername.contains(String.valueOf(current))){
                        System.out.println("Valid");
                        break;
                    }
                    System.out.printf("Your username must contain %c.%n",current);
                    break;
            }
        }
    }
    private static boolean checkIndex(int indexFirst, int indexSecond,int length) {
        return indexFirst >= 0 && indexSecond <= length;
    }
    private static void printReversedString(String string) {
        StringBuilder reversedString = new StringBuilder();
        reversedString.append(string).reverse();
        System.out.println(reversedString.toString());
    }
}
