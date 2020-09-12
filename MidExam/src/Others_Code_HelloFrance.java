import java.util.*;
import java.util.stream.Collectors;


public class Others_Code_HelloFrance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        double budget = Double.parseDouble(scanner.nextLine());

        List<Double> purchased = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {

            String[] tokens = items.get(i).split("->");

            String item = tokens[0];
            double price = Double.parseDouble(tokens[1]);

            if (item.equals("Clothes") && price <= 50 && price <= budget) {
                purchased.add(price);
                budget = budget - price;
            } else if (item.equals("Shoes") && price <= 35 && price <= budget) {
                purchased.add(price);
                budget = budget - price;
            } else if (item.equals("Accessories") && price <= 20.50 && price <= budget) {
                purchased.add(price);
                budget = budget - price;
            }
        }

        double investment = 0.0;

        for (int i = 0; i < purchased.size(); i++) {
            investment = investment + purchased.get(i);
            purchased.set(i, purchased.get(i) * 1.4);
        }

        double total = 0.0;

        for (Double aDouble : purchased) {
            total = total + aDouble;
            System.out.printf("%.2f ", aDouble);
        }

        double profit = total - investment;
        System.out.printf("%nProfit: %.2f%n", profit);
        budget = budget + total;

        if (budget < 150) {
            System.out.println("Time to go.");
        } else {
            System.out.println("Hello, France!");
        }
    }
}