import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab_5_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        List<Integer> sorted = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((n1,n2) -> n2.compareTo(n1))
                .limit(3)
                .collect(Collectors.toList());

        sorted
               .forEach(k -> System.out.print(String.format("%s ",k)));


    }
}
