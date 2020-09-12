import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        List<Integer> numbers = parseLineOfNumbers(line);


        List<Integer> modified = new ArrayList<>();
        for (int i = 0; i < numbers.size() / 2; i++) {
            int lastIndex = numbers.size() - 1;
            int sum = numbers.get(i) + numbers.get(lastIndex - i);
            modified.add(sum);
        }

        if ( numbers.size() % 2 != 0){
            int middleIndex = numbers.size()/2;
            modified.add(numbers.get(middleIndex));
        }

        numbers=modified;

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }

    private static List<Integer> parseLineOfNumbers(String line) {
        String[] split = line.split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String strings : split) {
            int number = Integer.parseInt(strings);
            numbers.add(number);
        }
        return numbers;
    }
}
