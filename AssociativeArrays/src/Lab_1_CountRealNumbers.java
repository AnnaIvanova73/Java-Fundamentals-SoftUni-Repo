import java.util.*;
import java.util.stream.Collectors;

public class Lab_1_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
            //stream четене при лист пример
//        String values = scan.nextLine();
//        List<String> items = Arrays.stream(values.split("\\s+"))
//                .collect(Collectors.toList());

        TreeMap<Double, Integer> counts = new TreeMap<>();

        for (double number : numbers) {
            if (!counts.containsKey(number)) {
                counts.putIfAbsent(number, counts.put(number, 1));
            } else {
                counts.put(number, counts.get(number) + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
