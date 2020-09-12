import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_4_Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, ArrayList<Double>> products = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!"buy".equals(input)) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            double quantity = Double.parseDouble(tokens[2]);

            if (products.containsKey(name)) {
                products.get(name).set(0, price);
                double currQuantity = products.get(name).get(1);
                products.get(name).set(1, quantity + currQuantity);
                input = scan.nextLine();
                continue;
            }

            products.putIfAbsent(name, new ArrayList<>());
            products.get(name).add(price);
            products.get(name).add(quantity);


            input = scan.nextLine();
        }

        products
                .forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value.get(0) * value.get(1)));
//        for (Map.Entry<String, ArrayList<Double>> entry : products.entrySet()) {
//            double result = entry.getValue().get(0) * entry.getValue().get(1);
//            System.out.printf("%s -> %.2f%n", entry.getKey(), result);
//        }
//        products
//                .entrySet()
//                .stream()
//                .forEach(c ->{
//                    System.out.printf("%s -> %.2f%n", c.getKey(), c.getValue().get(0) * c.getValue().get(1));
//
//                });

    }
}
