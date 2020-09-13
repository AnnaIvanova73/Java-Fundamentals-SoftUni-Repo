import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class August_3_Group_2_Task_2_MessageEncrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countInputs = Integer.parseInt(scan.nextLine());
        String regex = "([*@])([A-Z][a-z]{2,})\\1: \\[([A-Za-z])]\\|\\[([A-Za-z])]\\|\\[([A-Za-z])]\\|$";
        Pattern pattern = Pattern.compile(regex);

        while(countInputs-- > 0){
            String message = scan.nextLine();
            Matcher matcher = pattern.matcher(message);

            if(!matcher.find()){
                System.out.println("Valid message not found!");
                continue;
            }
            StringBuilder concat = new StringBuilder();
            String groupOne = matcher.group(3);
            String groupTwo = matcher.group(4);
            String groupThird = matcher.group(5);
            concat.append(groupOne).append(groupTwo).append(groupThird);

            String decrypt = getAscii(concat.toString());
            System.out.println(matcher.group(2) + ": " + decrypt.trim());
        }
    }
    private static String getAscii(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <string.length() ; i++) {
            int ascii = string.charAt(i);
            result.append(ascii).append(" ");
        }
        return result.toString();
    }
}
