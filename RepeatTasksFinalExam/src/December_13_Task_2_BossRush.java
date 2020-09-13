import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class December_13_Task_2_BossRush {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputCount = Integer.parseInt(scan.nextLine());
        String regex = "^\\|(?<name>[A-Z]{4,})\\|:#(?<title>[A-Za-z]+ [a-zA-Z]+)#$";
        Pattern pattern = Pattern.compile(regex);

        while (inputCount > 0) {
            String lines = scan.nextLine();
            Matcher matcher = pattern.matcher(lines);

            if (!matcher.find()) {
                System.out.println("Access denied!");
                inputCount--;
                continue;
            }

            String boss = matcher.group("name");
            String title = matcher.group("title");
            System.out.println(boss + ", The " + title);
            System.out.println(">> Strength: " + boss.length());
            System.out.println(">> Armour: " + title.length());

            inputCount--;
        }
    }
}
