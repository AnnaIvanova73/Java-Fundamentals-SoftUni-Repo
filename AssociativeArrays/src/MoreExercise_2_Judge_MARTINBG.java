// Това е твоето решение,
// като съм опростил прочитането на входните данни, сортирането и сумирането на точките за всеки участник:
import java.util.*;
import java.util.stream.Collectors;

public class MoreExercise_2_Judge_MARTINBG {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();

        String input;
        while (!"end of submissions".equals(input = scan.nextLine())) {
            String[] tokens = input.split("=>");
            String userName = tokens[2];
            String course = tokens[0];
            int userPoints = Integer.parseInt(tokens[3]);

            contests.putIfAbsent(course, new HashMap<>());
            contests.get(course)
                    .compute(userName, (user, oldPoints) ->
                            (oldPoints == null || oldPoints < userPoints) ? userPoints : oldPoints);
        }

        Comparator<Map.Entry<String, Integer>> participantsComparator = Map.Entry.<String, Integer>
                comparingByValue(Comparator.reverseOrder())
                .thenComparing(Map.Entry.comparingByKey());

        contests.forEach((contest, participants) -> {
            System.out.printf("%s: %d participants\n", contest, participants.size());
            final int[] count = {0};
            participants.entrySet()
                    .stream()
                    .sorted(participantsComparator)
                    .forEach(entry -> {
                        count[0] += 1;
                        System.out.printf("%d. %s <::> %d%n", count[0], entry.getKey(), entry.getValue());
                    });
        });

        System.out.println("Individual standings:");
        final int[] count = {0};
        contests.values()
                .stream()
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingInt(Map.Entry::getValue)))
                .entrySet()
                .stream()
                .sorted(participantsComparator)
                .forEach(entry -> {
                    count[0] += 1;
                    System.out.printf("%d. %s -> %d%n", count[0], entry.getKey(), entry.getValue());
                });
    }
}
//Като препоръки:
//стреми се да пишеш по-малко код в програмите си - ако за тривиален проблем си изписала много код (напр. прочитането на входа за тази задача), потърси в нета решения на сходни задачи
//избирай правилните структури от данни за конкретния проблем; колкото по-прости - толкова по-добре, стига да вършат работа
//старай се да преизползваш кода (в случая компаратора), вместо да го копираш
//запознай се с API-тата на класовете, които ползваш - често има готови методи, които спестяват време и проблеми
//използвай смислени имена дори и за променливи с кратък живот