package Exercise_6_VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Vehicle> catalogue = new ArrayList<>();

        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsePower = Integer.parseInt(tokens[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsePower);
            catalogue.add(vehicle);

            input = scan.nextLine();
        }

        input = scan.nextLine();

        while (!"Close the Catalogue".equals(input)) {
            for (Vehicle vehicle : catalogue) {

                if (input.equals(vehicle.getModel())) {
                    System.out.printf("Type: %s\n" +
                                    "Model: %s\n" +
                                    "Color: %s\n" +
                                    "Horsepower: %d\n", vehicle.getType(),
                            vehicle.getModel(), vehicle.getColor(),
                            vehicle.getHorsePower());
                    break;
                }
            }
            input = scan.nextLine();
        }

        double trucksAverage = getAverageTrucks(catalogue);
        double carCountAverage = getAverageCars(catalogue);

        System.out.println(String.format("Cars have average horsepower of: %.2f.", carCountAverage));
        System.out.println(String.format("Trucks have average horsepower of: %.2f.", trucksAverage));


    }

    private static double getAverageCars(List<Vehicle> catalogue) {
        int count = 0;
        double sum = 0;
        for (Vehicle vehicle : catalogue) {
            if (vehicle.getType().equals("Car")) {
                int currentPower = vehicle.getHorsePower();
                sum += currentPower;
                count++;
            }
        }
        double average = 0;
        if (sum != 0) {
            return sum / count * 1.0;
        }
        return average;
    }

    private static double getAverageTrucks(List<Vehicle> catalogue) {
        int count = 0;
        double sum = 0;
        for (Vehicle vehicle : catalogue) {
            if (vehicle.getType().equals("Truck")) {
                int currentPower = vehicle.getHorsePower();
                sum += currentPower;
                count++;
            }
        }
        double average = 0;
        if (sum != 0) {
            return sum / count * 1.0;
        }
        return average;
    }
}



