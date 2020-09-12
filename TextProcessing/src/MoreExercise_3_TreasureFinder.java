import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MoreExercise_3_TreasureFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> collect = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String text = scan.nextLine();
        while (!"find".equals(text)) {
            text = getMessage(collect, text);

            int typeStartIndex = text.indexOf('&');
            int typeEndIndex = text.lastIndexOf('&');
            String type = text.substring(typeStartIndex+1,typeEndIndex);

            int startCoordinates = text.indexOf('<');
            int endCoordinates = text.indexOf('>');
            String coordinates = text.substring(startCoordinates+1,endCoordinates);

            System.out.println("Found " + type + " at "+coordinates);

            text = scan.nextLine();
        }
    }

    private static String getMessage(List<Integer> collect, String text) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            int currLetter = text.charAt(i);

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
