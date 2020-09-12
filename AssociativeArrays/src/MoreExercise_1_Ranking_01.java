import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MoreExercise_1_Ranking_01 {
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


        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        String submission = scan.nextLine();
        while (!"end of submissions".equals(submission)) {
            String[] tokens = submission.split("=>");
            String contest = tokens[0];
            String password = tokens[1];


            if (contests.containsKey(contest)) {
                String passForCourse = contests.get(contest);

                if (passForCourse.equals(password)) {
                    String userName = tokens[2];
                    int userPoints = Integer.parseInt(tokens[3]);

                    LinkedHashMap<String, Integer> course = new LinkedHashMap<>();
                    course.put(contest, userPoints);// всеки път ми е нов лист, слагам го само, ако ми отговаря на проверките

                    if (users.containsKey(userName)) { // задължителна проверк, ако работя с putIfAbsent, а и иначе с if !contains else.
                        // Гърмят вътрешните if-ове, когато не намират стойност

                        if (users.get(userName).containsKey(contest)) {
                            int oldPoints = users.get(userName).get(contest);
                            if (userPoints > oldPoints) {
                                users.get(userName).put(contest, userPoints);

                            }

                        }
                        if (!users.get(userName).containsKey(contest)) {
                            users.get(userName).put(contest, userPoints);// така си добавя във вътрешния ми мап
                          // users.put(userName, course);// ще презаписва и ще остане последния ми курс, чупи кода
                        }
                    }
                    users.putIfAbsent(userName, course);
                }

            }
            submission = scan.nextLine();
        }

        String maxName = "";
        int maxSum = -1;
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            String name = user.getKey();
           int sum = user
                   .getValue()
                   .values()
                   .stream()
                   .mapToInt(e -> e)
                   .sum();
           if(sum > maxSum){
               maxSum=sum;
               maxName=name;
           }
        }

        System.out.printf("Best candidate is %s with total %d points.\n",maxName,maxSum);
        System.out.println("Ranking: ");
       users
               .forEach((key,value)->{
                   System.out.println(key);
                   value.entrySet()
                           .stream()
                           .sorted((p1,p2)-> p2
                                   .getValue()-p1
                                   .getValue())
                           .forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
               });



//        users.forEach((k, v) -> {
//            System.out.println(k + " "); //принтирам си ключа
//            v.forEach((m, a) -> System.out.println(m + " " + a));// за всеки елемент на вътрешни ми мап ключ и стойност
//        });
//
//
//        System.out.println("----------------");
//
//
//        users.values().stream().forEach((k) -> System.out.printf("kkkkkk%s\n----\naaaaaa%s\n ++++++++\nmmmmmmmm%s\n"
//                ,k.values(),k.entrySet(),k.keySet())); // принтира стойностите на вътрешния мап// принтира целия вътрешен мап
//        // принтира само ключа
//        //Всичко е със скоби за масив
//
//
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
//
//
//
//        users.forEach((k,v)->{
//            v.entrySet().stream().forEach(i->
//                System.out.printf("\n\n ,,,,,,,,,,,%s %d",i.getKey(),i.getValue()));//печата ми вътрешни мап, не става двубуквено
//        });


    }
}
