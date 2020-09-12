import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aegdea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countInputs = Integer.parseInt(scan.nextLine());
        String regex = "@(?<name>[\\s\\S]*?)\\|[^@\\|#*].*#(?<age>[\\s\\S]*?)\\*";
        //  String ageRegex = "#(?<age>[\\s\\S]*?)\\*";


        for (int i = 0; i < countInputs; i++) {
            String input = scan.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);


            if (matcher.find()) {
                String name = matcher.group("name");
                String age = matcher.group("age");
                System.out.println(name + " is " + age + " years old.");
            }


        }
    }
}
//@(?<name>[\s\S]*?)\|[\s\S]*?#(?<age>[\s\S]*?)*