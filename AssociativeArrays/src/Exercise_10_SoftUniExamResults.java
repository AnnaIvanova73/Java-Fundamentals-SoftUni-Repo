import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise_10_SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> allParticipants = new TreeMap<>();
        Map<String, Integer> submissions = new TreeMap<>();

        String input = scan.nextLine();
        while (!"exam finished".equals(input)) {
            String[] tokens = input.split("-+");
            String username = tokens[0];
            String language = tokens[1];

            if (language.equals("banned")) {
                allParticipants.remove(username);
                input = scan.nextLine();
                continue;
            }

            int points = Integer.parseInt(tokens[2]);
            allParticipants.putIfAbsent(username, points);

            if (allParticipants.containsKey(username) && allParticipants.get(username) < points) {
                allParticipants.put(username, points);
            }

            submissions.putIfAbsent(language, 0);
            int currSumbissions = submissions.get(language) + 1;
            submissions.put(language, currSumbissions);

            input = scan.nextLine();
        }

        System.out.println("Results:");
        allParticipants
                .entrySet()
                .stream()
                .sorted((u1, u2) -> {
                    int comp = Integer.compare(u2.getValue(), u1.getValue());
                    if (comp == 0) {
                        comp = u1.getKey().compareTo(u2.getKey());
                    }
                    return comp;
                })
                .forEach(c -> System.out.println(String.format("%s | %d", c.getKey(), c.getValue())));

        System.out.println("Submissions:");
        submissions
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int comp = Integer.compare(b.getValue(), a.getValue());
                    if (comp == 0) {
                        comp = a.getKey().compareTo(b.getKey());
                    }
                    return comp;
                })
                .forEach(c -> System.out.println(String.format("%s - %d", c.getKey(), c.getValue())));


    }
}
