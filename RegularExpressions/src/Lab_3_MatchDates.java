import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab_3_MatchDates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String regex = "\\b(?<date>\\d{2})([-./])(?<month>[A-Z][a-z]+)\\2(?<year>[\\d]{4})\\b";
        String dates = scan.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dates);


        while(matcher.find()){
           String date =  matcher.group("date");
                  String month =   matcher.group("month");
                  String year =   matcher.group("year");
            System.out.printf("Day: %s, Month: %s, Year: %s%n",date,month,year);
        }

    }
}
