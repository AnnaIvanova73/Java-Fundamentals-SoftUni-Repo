import java.util.Scanner;

public class Task_1_DisneylandJourney {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double costOfJourney = Double.parseDouble(scan.nextLine());
        int monthsPerSaving = Integer.parseInt(scan.nextLine());


        double moneySave = 0;
        double bonus = 0;

        int countMonths = 1;
        while (countMonths <= monthsPerSaving) {


            if (countMonths % 4 == 0) {
                bonus = moneySave * 0.25;
                moneySave+=bonus;
            }

            if (countMonths % 2 != 0) {
                moneySave *= 0.84;
            }


            moneySave += costOfJourney * 0.25;

            countMonths++;
        }

        if(moneySave >= costOfJourney){
            double forSouvenirs = moneySave-costOfJourney;
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.",forSouvenirs);
        } else {
            double neededMoney = costOfJourney-moneySave;
            System.out.printf("Sorry. You need %.2flv. more.",neededMoney);
        }
    }
}
