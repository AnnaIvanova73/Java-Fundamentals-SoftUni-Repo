import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoreExercise_2_RageQuit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String chochkoGibberish = scan.nextLine();

        String consistGibberish = "(?<gibberish>[^0-9]+)(?<count>[0-9]+)";
        Pattern patternGibberish = Pattern.compile(consistGibberish);
        Matcher match = patternGibberish.matcher(chochkoGibberish);

        StringBuilder gibberishAutomate = new StringBuilder();
        while (match.find()) {

            String currentGibberish = match.group("gibberish").toUpperCase();
            int repeatCount = Integer.parseInt(match.group("count"));
            gibberishAutomate.append(currentGibberish.repeat(Math.max(0, repeatCount)));
        }

       // IntSummaryStatistics asda = gibberishAutomate.chars().summaryStatistics();
       // System.out.println(asda);
        long count = gibberishAutomate.chars().distinct().count();//правим го на Стринг, разбиваме го по чарове,махаме еднаквите и сумираме остатналите
        System.out.println("Unique symbols used: " + count);
        System.out.println(gibberishAutomate.toString());
    }

}
