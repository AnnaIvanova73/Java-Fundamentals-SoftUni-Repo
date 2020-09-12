
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_2_HelloFrance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> items = getInput(scan);

        double budget = Double.parseDouble(scan.nextLine());

        double clothesPrice = 50.0;
        double shoesPrice = 35.00;
        double accessoriesPrice = 20.50;

        int countItems = 0;
        int countPrice = 1;
        boolean hasBudget = true;
        double profit = 0;
        while (countPrice <= items.size() - 1) {

            String item = items.get(countItems);
            double price = Double.parseDouble(items.get(countPrice));
            if ("Clothes".equals(item)) {
                if (price <= clothesPrice && budget >= price){
                    budget-=price;
                    double diff = (price*1.4)-price;
                    profit+=diff;
                    String set = String.valueOf(price*=1.40);
                    items.set(countPrice,set);
                    hasBudget = true;
                }  else{
                    items.remove(countItems);
                    items.remove(countItems);
                    hasBudget = false;
                }
            } else if ("Shoes".equals(item)) {
                if (price <= shoesPrice && budget >= price) {
                    budget-=price;
                    double diff = (price*1.4)-price;
                    profit+=diff;
                    String set = String.valueOf(price*=1.40);
                    items.set(countPrice,set);
                    hasBudget = true;
                } else {
                    items.remove(countItems);
                    items.remove(countItems);
                    hasBudget = false;
                }
            } else if ("Accessories".equals(item)) {
                hasBudget = true;
                if (budget >=price && price <= accessoriesPrice ){
                    budget-=price;
                    double diff = (price*1.4)-price;
                    profit+=diff;
                    String set = String.valueOf(price*=1.40);
                    items.set(countPrice,set);
                    hasBudget = true;
                }  else{
                    items.remove(countItems);
                    items.remove(countItems);
                    hasBudget = false;
                }

            }
            if (hasBudget) {
                countItems += 2;
                countPrice += 2;
            }

        }
        double saveMoney = budget;

        for (int i = 0; i <items.size() ; i++) {
            if(i % 2 != 0){
                double price = Double.parseDouble(items.get(i));
                saveMoney+=price;
                System.out.printf("%.2f ",price);
            }
        }
        System.out.println();
        System.out.printf("Profit: %.2f%n",profit);
        if(saveMoney >= 150 ){
            System.out.println("Hello, France!");
        }else{
            System.out.println("Time to go.");
        }


    }

    private static List<String> getInput(Scanner scan) {
        String input = scan.nextLine();
        String replace = input.replaceAll("[\\\\|\\- +>]", " ");
        String[] tokens = replace.split("\\s+");
        List<String> result = new ArrayList<>();

        for (String currentElement : tokens) {
            result.add(currentElement);
        }
        return result;

    }
}

