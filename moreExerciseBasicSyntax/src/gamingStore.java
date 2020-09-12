import java.util.Scanner;

public class gamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());

        double gamePrice = 0;
        double totalSpent = 0;
        boolean isItOutOfMoney = false;

        String input = scan.nextLine();
        while (!"Game Time".equals(input)) {
            String outputGame = String.format("Bought %s", input);

            switch (input) {
                case "OutFall 4":
                    gamePrice = 39.99;
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    input = scan.nextLine();
                    continue;
            }
            if (gamePrice > budget) {
                System.out.println("Too Expensive");

            } else {
                System.out.println(outputGame);
                totalSpent+=gamePrice;
                budget -= gamePrice;
            }
            if (budget == 0) {
                System.out.println("Out of mo-ney!");
                isItOutOfMoney=true;
                break;
            }

            input = scan.nextLine();
        }
        if (!isItOutOfMoney){

        System.out.println(String.format("Total spent: $%.2f. Remaining: $%.2f",totalSpent,budget));
        }
    }
}
