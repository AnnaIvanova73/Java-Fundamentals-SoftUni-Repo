import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Exercise_3_Race_01 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        List<String> participants = Arrays.stream(input.split("[, ]+"))
                .collect(Collectors.toList());


        String regex = "([a-z]+|[A-Z]+)([0-9])";
        Pattern myPattern = Pattern.compile(regex);

        String race = scan.nextLine();
        while (!"end of race".equals(race)) {
           String replacer= race.replaceAll("[^a-zA-Z0-9]+","");
            System.out.println("--------"+replacer );
            Matcher match = myPattern.matcher(replacer);
            StringBuilder currentPlayer = new StringBuilder();
            int currentPoints = 0;
            while (match.find()) {
                String currentLetter = match.group("letter");
                currentPlayer.append(currentLetter);

            }
            while (match.find()){
                int currentDigit = Integer.parseInt(match.group("number"));
                currentPoints+=currentDigit;
            }

            System.out.print(currentPlayer + " ");
            //System.out.print(currentPoints);

            race = scan.nextLine();
        }
    }
}
