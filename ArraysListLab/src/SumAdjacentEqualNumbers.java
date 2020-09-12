import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String line = scan.nextLine();
        List<Double> numbers = parseLineOfNumbers(line);

        int index = 0;

        while (index < numbers.size() - 1) {
            double currentElement = numbers.get(index);
            double nextElement = numbers.get(index + 1);

            if (currentElement == nextElement) {
                double sum = currentElement + nextElement;
                numbers.set(index, sum);
                numbers.remove(index + 1);
                index = 0;
            } else {
                index++;
            }
        }
            String output = joinElementsByDelimiter(numbers, " ");
            System.out.println(output);
    }

    static String joinElementsByDelimiter(List <Double> numbers,String delimiter){
        String output = "";
        for (Double number : numbers) {
            output += (new DecimalFormat("0.#").format(number) + delimiter);
        }
        return output;
    }

    private static List<Double> parseLineOfNumbers(String line) {
        String[] split = line.split("\\s+");
        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            double num = Double.parseDouble(split[i]);
            numbers.add(num);
        }
        return numbers;
    }


}
