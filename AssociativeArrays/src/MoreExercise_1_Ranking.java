import java.util.*;

public class MoreExercise_1_Ranking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> contests = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!"end of contests".equals(input)) {
            String[] tokens = input.split(":+");
            String contest = tokens[0];
            String password = tokens[1];

            contests.putIfAbsent(contest, password);
            contests.put(contest, password);

            input = scan.nextLine();
        }
        Map<String, List<String>> users = new TreeMap<>();

        String submission = scan.nextLine();
        while (!"end of submissions".equals(submission)) {
            String[] tokens = submission.split("=>");
            String contestApply = tokens[0];
            String password = tokens[1];

            if (contests.containsKey(contestApply) && contests.containsValue(password)) {
                String user = tokens[2];
                String currentPoints = tokens[3];

                if (users.containsKey(user) && containsValue(contestApply, users)) {
                    int pointsNew = Integer.parseInt(currentPoints);
                    int findIndex = users.get(user).indexOf(contestApply);
                    int pointsNow = Integer.parseInt(users.get(user).get(findIndex + 1));
                    if (pointsNew > pointsNow) {
                        String points = String.valueOf(pointsNew);
                        int indexForChange = findIndex + 1;
                        users.get(user).set(indexForChange, points);
                    }
                    submission = scan.nextLine();
                    continue;
                }

                users.putIfAbsent(user, new ArrayList<>());
                users.get(user).add(contestApply);// 0 на четните (%2 == 0)index
                users.get(user).add(currentPoints);//1 на нечетните (%2 != 0) index за всеки потребител

            }
            submission = scan.nextLine();
        }

        String nameMax = "";
        int maxSum = -1;

        for (Map.Entry<String, List<String>> stringListEntry : users.entrySet()) {
            String name = stringListEntry.getKey();
            int sum = 0;
            for (String s : stringListEntry.getValue()) {
                 int index = stringListEntry.getValue().indexOf(s);
                 if(index % 2 != 0){
                     sum += Integer.parseInt(stringListEntry.getValue().get(index));
                 }
            }
            if(sum > maxSum){
                maxSum=sum;
                nameMax=name;
            }
        }

        System.out.printf("Best candidate is %s with total %d points.",nameMax,maxSum);


    }

    private static boolean containsValue(String contestApply, Map<String, List<String>> map) {

        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            String currUser = stringListEntry.getKey();
            int indexContest = stringListEntry.getValue().indexOf(contestApply);
            if (indexContest < 0) {
                return false;
            }
        }
        return true;
    }

}