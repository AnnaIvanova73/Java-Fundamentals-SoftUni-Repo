import java.util.Scanner;

public class Task_1_Cozonacs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double myBudget = Double.parseDouble(scan.next());
        double priceForOneKgFlour = Double.parseDouble(scan.next());

        double priceEggsPack = priceForOneKgFlour * 0.75;
        double priceOneLitterMilk = priceForOneKgFlour * 1.25;
        double price250MlMilk = priceOneLitterMilk * 0.25;
        double totalPriceForOne = priceEggsPack + priceForOneKgFlour + price250MlMilk;


        int sumMyColoredEggs = 0;
        int sumMyCozonacs = 0;


        while (myBudget >= totalPriceForOne) {
            myBudget -= totalPriceForOne;

            sumMyCozonacs++;
            sumMyColoredEggs += 3;

            if (sumMyCozonacs % 3 == 0) {
                int calculatedLostEggs = sumMyCozonacs - 2;
                sumMyColoredEggs -= calculatedLostEggs;
            }

        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.", sumMyCozonacs,
                sumMyColoredEggs, myBudget);
    }
}
