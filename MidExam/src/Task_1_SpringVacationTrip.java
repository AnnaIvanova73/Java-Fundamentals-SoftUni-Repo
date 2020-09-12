import java.text.CollationKey;
import java.util.Scanner;

public class Task_1_SpringVacationTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int totalDaysTrip = Integer.parseInt(scan.nextLine());
        double budgetForAll = Double.parseDouble(scan.nextLine());
        int totalCountPeople = Integer.parseInt(scan.nextLine());

        double fuelPricePerKM = Double.parseDouble(scan.nextLine());
        double expensesFoodPerPerson = Double.parseDouble(scan.nextLine());
        double pricePerSingleRoomOneNight = Double.parseDouble(scan.nextLine());


        if (totalCountPeople > 10) {
           pricePerSingleRoomOneNight*=0.75;
        }
        double temp = totalCountPeople * totalDaysTrip;

        boolean hasMoney = true;
        double expensesAsTotal = temp * (expensesFoodPerPerson + pricePerSingleRoomOneNight);
        for (int i = 1; i <= totalDaysTrip; i++) {
            int days = i;
            double kilometersADay = Double.parseDouble(scan.nextLine());

            expensesAsTotal += kilometersADay * fuelPricePerKM;

            if (days % 3 == 0 || days % 5 == 0) {
                expensesAsTotal *=1.4;
            }
            if (days % 7 == 0) {
                double moneyReceive = expensesAsTotal / totalCountPeople * 1.0;
                expensesAsTotal -= moneyReceive;
            }
                if(expensesAsTotal > budgetForAll){
                    hasMoney=false;
                    break;
                }
        }


        if(expensesAsTotal >= budgetForAll && !hasMoney){
            double moneyNeeded = expensesAsTotal - budgetForAll;
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.",moneyNeeded);
        }else{
            double moneyHave = budgetForAll - expensesAsTotal;
            System.out.printf("You have reached the destination. You have %.2f$ budget left.",moneyHave);
        }
    }
}
