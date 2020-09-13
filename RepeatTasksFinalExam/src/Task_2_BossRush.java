import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Task_2_BossRush {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "^\\|([A-Z]{4,})\\|:#([A-Za-z]+ [a-zA-z]+)#$";
        Pattern pattern = Pattern.compile(regex);

        int inputCounter = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < inputCounter ; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);

            if(!matcher.find()){
                System.out.println("Access denied!");
                continue;
            }
            String name = matcher.group(1);
            String title = matcher.group(2);
            System.out.println(name + ", The " + title);
            System.out.println(">> Strength: " + name.length());
            System.out.println(">> Armour: " + title.length());

        }
    }
}
