import java.util.Scanner;

public class Task_1_BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int piratingDays = Integer.parseInt(scan.nextLine());
        double dailyPlunder = Double.parseDouble(scan.nextLine());
        double expectedIncome = Double.parseDouble(scan.nextLine());

        double total = 0;
        int currentDay = 0;
        for (int i = 1; i <= piratingDays; i++) {

            currentDay = i;
            total += dailyPlunder;

            if (currentDay % 3 == 0) {
                double percentPlunderAttack = dailyPlunder * 0.50;
                total += percentPlunderAttack;

            }
            if (currentDay % 5 == 0) {
                double battlePercentLost = total * 0.30;
                total -= battlePercentLost;
            }


        }

        if (total >= expectedIncome) {
            System.out.printf("Ahoy! %.2f plunder gained.", total);
        } else {

            double percentLeft = total / expectedIncome * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percentLeft);
        }


    }
}
