import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_BossRush {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputCount = Integer.parseInt(scan.nextLine());
        Pattern pattern = Pattern.compile("(\\|)(?<name>[A-Z]{4,})\\1:?(\\#)(?<title>[A-Za-z]+ [A-Za-z]+)\\3");

        for (int i = 0; i < inputCount; i++) {
            String boss = scan.nextLine();

            Matcher matcher = pattern.matcher(boss);

            if (matcher.find()) {
                String name = matcher.group("name");
                String title = matcher.group("title");
                System.out.printf("%s, The %s\n" +
                        ">> Strength: %d\n" +
                        ">> Armour: %d\n", name, title, name.length(), title.length());
            } else {
                System.out.println("Access denied!");

            }
        }

    }
}
