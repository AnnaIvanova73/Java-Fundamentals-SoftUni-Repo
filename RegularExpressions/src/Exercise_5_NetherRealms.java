import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Exercise_5_NetherRealms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        List<String> demons = Arrays.stream(scan.nextLine().split("[, ]+"))
                .sorted(String::compareTo).collect(Collectors.toList());

        //List<String> demons = Arrays.stream(scan.nextLine().split("[, ]+"))
             //  .sorted((a,b)->a.compareTo(b)).collect(Collectors.toList());// сортиране по азбучен веднага

        //List<String> demons = Arrays.stream(scan.nextLine().split("[, ]+"))
              //  .sorted((a,b)->b.compareTo(a)).collect(Collectors.toList());// обратен ред

//        List<String> demons = Arrays.stream(scan.nextLine().split("[, ]+"))
//          .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//
        Pattern healthPattern = Pattern.compile("(?<health>[^\\d+\\-*.\\/])");//всима всичко без цифри и посочените символи
        Pattern damagePattern = Pattern.compile("(-?\\d+\\.?\\d*)");//взима всяка цифра double или int и минуса, ако е отрицателно
        Pattern operationPattern = Pattern.compile("[*/]"); //мачва операциите

        for (String currentName : demons) {
        Matcher matcher = healthPattern.matcher(currentName);

            int health = 0;
            while(matcher.find()){
                int digit = matcher.group().charAt(0);
                health+=matcher.group("health").charAt(0);

            }
            matcher=damagePattern.matcher(currentName);
            double damage = 0;
            while(matcher.find()){
                damage+=Double.parseDouble(matcher.group());
            }

            matcher = operationPattern.matcher(currentName);
            while (matcher.find()){
                if(matcher.group().equals("/") ){
                    damage/=2;
                }else{
                    damage*=2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n",currentName,health,damage);


        }

    }


}
