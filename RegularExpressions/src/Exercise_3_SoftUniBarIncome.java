import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_3_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "%([A-Z][a-z]+)%" +
                "[^%|$.]*" +
                "<(\\w+)>" +
                "[^%|$.]*" +
                "\\|(\\d+)\\|" +
                "[^%|$.]*?" +
                "([\\d]+\\.?[\\d]+)\\$";
        Pattern myPattern = Pattern.compile(regex);
        double income = 0;
        String input = scan.nextLine();
        while (!"end of shift".equals(input)) {
            Matcher matchMe = myPattern.matcher(input);
            while (matchMe.find()) {
                String customer = matchMe.group(1);
                String product = matchMe.group(2);
                int quantity = Integer.parseInt(matchMe.group(3));
                double price = Double.parseDouble(matchMe.group(4));
                double currentIncome = quantity * 1.0 * price;
                income += currentIncome;
                System.out.printf("%s: %s - %.2f%n", customer, product, currentIncome);
            }
            input = scan.nextLine();
        }
        System.out.printf("Total income: %.2f%n", income);

    }
}
