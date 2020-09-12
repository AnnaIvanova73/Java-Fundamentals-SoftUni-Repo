import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasure = Arrays.stream(scanner.nextLine()
                .split("\\|")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Yohoho!")) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Loot": {
                    for (int i = 1; i < tokens.length; i++) {
                        if (!treasure.contains(tokens[i])) {
                            treasure.add(0, tokens[i]);
                        }
                    }
                }
                break;
                case "Drop": {
                    int index = Integer.parseInt(tokens[1]);
                    if (isIndexValid(index, treasure)) {
                        treasure.add(treasure.get(index));
                        treasure.remove(index);
                    }
                }
                break;
                case "Steal": {
                    int count = Integer.parseInt(tokens[1]);
                    int min = Math.min(count, treasure.size());
                    List<String> stolenTreasure = treasure.stream().skip(treasure.size() - min).collect(Collectors.toList());
                    treasure = treasure.stream().limit(treasure.size() - min).collect(Collectors.toList());
                    System.out.println(String.join(", ", stolenTreasure));
                }
                break;
            }

            input = scanner.nextLine();
        }

        if (treasure.size() > 0) {
            double avgTreasure = treasure.stream().mapToInt(String::length).average().getAsDouble();
            System.out.printf("Average treasure gain: %.2f pirate credits.", avgTreasure);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }

    private static boolean isIndexValid(int index, List<String> treasure) {
        return index >= 0 && index < treasure.size();
    }
}