import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoreExercise_1_ExtractPersonInformation_1_0 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countInputs = Integer.parseInt(scan.nextLine());
        String nameRegex = "@(?<name>[\\s\\S]*?)\\|";
        String ageRegex = "#(?<age>[\\s\\S]*?)\\*";


        for (int i = 0; i < countInputs; i++) {
            String input = scan.nextLine();
            Pattern pattern = Pattern.compile(nameRegex);
            Matcher matcher = pattern.matcher(input);

            String name = "";
            if (matcher.find()) {
                name = matcher.group("name");
            }

            pattern = Pattern.compile(ageRegex);
            matcher = pattern.matcher(input);
            String age = "";
            if (matcher.find()) {
                age = matcher.group("age");
            }
                System.out.println(name + " is " + age + " years old.");

        }
    }
}
//@(?<name>[\s\S]*?)\|[\s\S]*?#(?<age>[\s\S]*?)*