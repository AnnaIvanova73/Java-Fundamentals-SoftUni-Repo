import java.util.Scanner;

public class Task_1_HuntingGames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        int countPLayers = Integer.parseInt(scan.nextLine());
        double groupEnergy = Double.parseDouble(scan.nextLine());
        double waterPerDayForOnePerson = Double.parseDouble(scan.nextLine());
        double foodPerDayForOnePerson = Double.parseDouble(scan.nextLine());

        double suppliesWater = countPLayers * days * waterPerDayForOnePerson;
        double suppliesFood = countPLayers * days * foodPerDayForOnePerson;

        boolean hasNoEnergy = false;
        double currentEnergy = groupEnergy;
        int currentDay = 0;
        while (days > 0) {
            currentDay++;
            double energyLost = Double.parseDouble(scan.nextLine());
            currentEnergy = currentEnergy - energyLost;
            if (currentEnergy < 1) {
                hasNoEnergy = true;
                break;
            }
            if (currentDay % 2 == 0) {
                double waterBoost = 1.05;
                currentEnergy *= waterBoost;
                double suppliesDrop = suppliesWater * 0.30;
                suppliesWater -= suppliesDrop;
            }

            if (currentDay % 3 == 0) {
                double foodBoost = 1.10;
                currentEnergy *= foodBoost;
                double suppliesDrop = suppliesFood / countPLayers * 1.0;
                suppliesFood -= suppliesDrop;
            }
            days--;
        }
        if (hasNoEnergy) {
            System.out.printf("You will run out of energy. You will be" +
                            " left with %.2f food and %.2f water."
                    , suppliesFood, suppliesWater);
        } else {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", currentEnergy);
        }

    }
}

