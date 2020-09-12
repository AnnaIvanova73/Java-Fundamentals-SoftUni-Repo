
import java.util.Scanner;

public class vendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        double totalMonney = 0;
        while (!"Start".equals(input)) {
            double insertCoins = Double.parseDouble(input);

            if (insertCoins == 0.1 || insertCoins == 0.20 || insertCoins == 0.50 ||
                    insertCoins == 1.0 || insertCoins == 2.0) {
                totalMonney += insertCoins;
            } else {
                System.out.printf("Cannot accept %.2f\n", insertCoins);
            }

            input = scan.nextLine();
        }

        String treatYourself = scan.nextLine();
        while (!"End".equals(treatYourself)) {
            String output = String.format("Purchased %s", treatYourself);
            String output1 = "Sorry, not enough money";
            switch (treatYourself) {
                case "Nuts":
                    if (totalMonney >= 2.0) {
                        totalMonney -= 2.0;
                        System.out.println(output);
                    } else {
                        System.out.println(output1);
                    }
                    break;
                case "Water":
                    if (totalMonney >= 0.7) {
                        totalMonney -= 0.7;
                        System.out.println(output);
                    } else {
                        System.out.println(output1);
                    }
                    break;
                case "Crisps":
                    if (totalMonney >= 1.5) {
                        totalMonney -= 1.5;
                        System.out.println(output);
                    } else {
                        System.out.println(output1);
                    }
                    break;
                case "Soda":
                    if (totalMonney >= 0.8) {
                        totalMonney -= 0.8;
                        System.out.println(output);
                    } else {
                        System.out.println(output1);
                    }
                    break;
                case "Coke":
                    if (totalMonney >= 1.0) {
                        totalMonney -= 1.0;
                        System.out.println(output);
                    } else {
                        System.out.println(output1);
                    }
                    break;
                default:
                    System.out.println("Invalid product");
            }


            treatYourself = scan.nextLine();
        }

        System.out.printf("Change: %.2f", totalMonney);
    }
}
