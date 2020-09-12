import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MoreExercise_3_TreasureFinder_1_0 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> collect = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String regex = "&(?<type>.*)&(.*|\\S*)<(?<coordinates>.*)>";
        Pattern pattern = Pattern.compile(regex);

        String input = scan.nextLine();
        while(!"find".equals(input)){

            input = getMessages(input,collect);

            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                String type = matcher.group("type");
                String coordinates = matcher.group("coordinates");
                System.out.println("Found " + type + " at "+coordinates);
            }

            input = scan.nextLine();
        }
    }

    private static String getMessages(String input, List<Integer> collect) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            int currLetter = input.charAt(i);

            if (count == collect.size()) {
                count = 0;
            }
            int currentKey = collect.get(count);

            builder.append((char) (currLetter - currentKey));
            count++;
        }
        return builder.toString();
    }
}
