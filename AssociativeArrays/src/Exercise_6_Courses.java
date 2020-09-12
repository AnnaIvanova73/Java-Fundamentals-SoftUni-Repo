import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_6_Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, ArrayList<String>> courses = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!"end".equals(input)) {
            String[] cmd = input.split(":");
            String course = cmd[0].trim();
            String student = cmd[1].trim();

            courses.putIfAbsent(course, new ArrayList<>());
            courses.get(course).add(student);

            input = scan.nextLine();
        }

        courses
                .entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    int first = c1.getValue().size();
                    int second = c2.getValue().size();
                    return Integer.compare(second, first);
                })
                .forEach(c -> {
                    System.out.println(String.format("%s: %d", c.getKey(),
                            c.getValue().size()));

                    c.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(s -> System.out.println(String.format("-- %s", s)));

                });
    }
}
