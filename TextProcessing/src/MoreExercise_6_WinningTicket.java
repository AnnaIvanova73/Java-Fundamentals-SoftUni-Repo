import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MoreExercise_6_WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        List<String> tickets = Arrays.stream(scan.nextLine().split(",\\s+")).collect(Collectors.toList());

        Pattern pattern = Pattern.compile("([$]{6,10}|[\\^]{6,10}|[#]{6,10}|[@]{6,10})");

        for (String ticket : tickets) {
            ticket = ticket.trim();
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }

            String leftPart = ticket.substring(0, 10);
            String rightPart = ticket.substring(10);

            Matcher matcher = pattern.matcher(leftPart);

            if (!matcher.find()) {
                System.out.printf("ticket \"%s\" - no match%n", ticket);
                continue;
            }
            leftPart = matcher.group();

            matcher = pattern.matcher(rightPart);
            if(!matcher.find()){
                System.out.printf("ticket \"%s\" - no match%n", ticket);
                continue;
            }
            rightPart=matcher.group();

            if(leftPart.charAt(0)!=rightPart.charAt(0)){
                System.out.printf("ticket \"%s\" - no match%n", ticket);
                continue;
            }

            int min = Math.min(rightPart.length(),leftPart.length());

            if (min == 10) {
                System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", ticket, min, leftPart.charAt(0));
            } else {
                System.out.printf("ticket \"%s\" - %d%c%n", ticket, min, leftPart.charAt(0));
            }

        }
    }
}
