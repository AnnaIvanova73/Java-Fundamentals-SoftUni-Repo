import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_6_NesetedClass_VehicleType {

    static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int horsePower;

        public Vehicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsePower() {
            return horsePower;
        }

        @Override
        public String toString() {
            String type = "";
            if (this.type.equals("car")) {
                type = "Car";
            } else {
                type = "Truck";
            }

            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d"
                    , type, this.model, this.color, this.horsePower);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> catalogue = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {

            String[] tokens = input.split(" ");

            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsePower = Integer.parseInt(tokens[3].trim());

            Vehicle vehicle = new Vehicle(type, model, color, horsePower);

            catalogue.add(vehicle);

            input = scanner.nextLine();
        }

        String model = scanner.nextLine();

        while (!"Close the Catalogue".equals(model)) {

            for (Vehicle vehicle : catalogue) {

                if (model.equals(vehicle.getModel())) {
                    System.out.println(vehicle);
                }
            }
            model = scanner.nextLine();
        }

        int carsHorsePower = 0;
        int trucksHorsePower = 0;
        int carsCount = 0;
        int trucksCount = 0;

        for (Vehicle vehicle : catalogue) {
            if (vehicle.getType().equals("car")) {
                carsHorsePower = carsHorsePower + vehicle.getHorsePower();
                carsCount++;
            } else if (vehicle.getType().equals("truck")) {
                trucksHorsePower = trucksHorsePower + vehicle.getHorsePower();
                trucksCount++;
            }
        }

        double averageCarsHP = 0;
        double averageTrucksHP = 0;
        if (carsCount > 0) {
            averageCarsHP = 1.0 * carsHorsePower / carsCount;
        }
        if (trucksCount > 0) {
            averageTrucksHP = 1.0 * trucksHorsePower / trucksCount;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCarsHP);
        System.out.printf("Trucks have average horsepower of: %.2f.", averageTrucksHP);

    }
}
