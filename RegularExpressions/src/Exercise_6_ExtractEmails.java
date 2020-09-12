import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_6_ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();

        Pattern emailPattern = Pattern.compile("(^| )[A-Za-z0-9]+[A-Za-z.\\-_0-9]*@{1}[A-Za-z._-]+(\\.[a-z]+)+");

        Matcher match = emailPattern.matcher(message);
        while (match.find()){
            System.out.println(match.group());
        }
    }
}
