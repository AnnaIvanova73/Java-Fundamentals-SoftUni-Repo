import java.util.Scanner;

public class Task_1_DistanceCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int stepsMadeIt = Integer.parseInt(scan.nextLine());
        double lengthOneStepCm = Double.parseDouble(scan.nextLine());
        int distanceMeters = Integer.parseInt(scan.nextLine());

        int everyFifthSteps = stepsMadeIt/5;
        double shorterLength = lengthOneStepCm * 0.70;
        double allFifthsLength = everyFifthSteps * shorterLength;

        int countOtherSteps = stepsMadeIt - everyFifthSteps;
        double allOtherLength  = countOtherSteps * lengthOneStepCm;

        double totalLengthSteps = allOtherLength + allFifthsLength;

        double distanceInCm = distanceMeters * 100.0;

        double percent = totalLengthSteps /distanceInCm * 100;

        System.out.printf("You travelled %.2f%% of the distance!",percent);
    }
}
