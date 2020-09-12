import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WorkWithStrings {

        static String repeatString (String s, int repeatCount){
            String [] repetitions = new String [repeatCount];
            for (int i = 0; i < repeatCount ; i++) {
                repetitions[i] = s;
            }
            String result = String.join("",repetitions);

            return result;
        }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int size = numbers.size();
        for (int i = 0; i < size / 2; i++) {
            numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));

    }








}
