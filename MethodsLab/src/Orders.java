import java.util.Scanner;

public class Orders {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String product = scan.nextLine();

        int quantity = Integer.parseInt(scan.nextLine());

        calculateAndPrint(product,quantity);

    }

    public static void calculateAndPrint(String input, double count) {

        switch (input) {
            case "coffee":
                count *= 1.50;
                break;
            case "water":
                count *= 1.00;
                break;
            case "coke":
                count *= 1.40;
                break;
            case "snacks":
                count *= 2.00;
                break;
        }
        System.out.printf("%.2f",count);

    }


}
