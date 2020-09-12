package MoreExercise_2_RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int carsInput = Integer.parseInt(scan.nextLine());

        Map<String, List<ModelCar>> carsByCargo = new LinkedHashMap<>();

        for (int i = 0; i < carsInput; i++) {
            String[] cars = scan.nextLine().split("\\s+");
            String model = cars[0];
            int engineSpeed = Integer.parseInt(cars[1]);
            int enginePower = Integer.parseInt(cars[2]);
            int cargoWeight = Integer.parseInt(cars[3]);
            String cargoType = cars[4];
            double tireOnePressure = Double.parseDouble(cars[5]);
            int tireOneAge = Integer.parseInt(cars[6]);
            double tireTwoPressure = Double.parseDouble(cars[7]);
            int tireTwoAge = Integer.parseInt(cars[8]);
            double tire3Pressure = Double.parseDouble(cars[9]);
            int tire3Age = Integer.parseInt(cars[10]);
            double tire4Pressure = Double.parseDouble(cars[11]);
            int tire4Age = Integer.parseInt(cars[12]);

            Tires tires = new Tires(tireOnePressure, tireOneAge, tireTwoPressure, tireTwoAge, tire3Pressure,
                    tire3Age, tire4Pressure, tire4Age);
            Cargo cargo = new Cargo(cargoType, cargoWeight);
            Engine engine = new Engine(engineSpeed, enginePower);
            ModelCar car = new ModelCar(model, engine, cargo, tires);

            carsByCargo.putIfAbsent(cargoType, new ArrayList<>());
            carsByCargo.get(cargoType).add(car);

        }
        String command = scan.nextLine();

//        List<ModelCar> modelCars = carsByCargo
//                .entrySet()
//                .stream()
//                .filter(f -> f.getKey().equals(command))
//                .map(e -> e.getValue())
//                .findFirst()
//                .get();

        List<ModelCar> modelCars1 = carsByCargo.get(command);
        List<String> cars = getCars(command, modelCars1);
        cars.forEach(System.out::println);

    }

    private static List<String> getCars(String command, List<ModelCar> modelCars1) {
        List<String> list = new ArrayList<>();
        switch (command) {
            case "fragile":
                for (ModelCar modelCar : modelCars1) {
                    double tire1 = modelCar
                            .getTires()
                            .getTireOnePressure();
                    double tire2 = modelCar.getTires().getTireTwoPressure();
                    double tire3 = modelCar.getTires().getTire3Pressure();
                    double tire4 = modelCar.getTires().getTire4Pressure();

                    if (tire1 < 1 || tire2 < 1 || tire3 < 1 || tire4 < 1) {
                        list.add(modelCar.getCar());
                    }
                }
                break;
            case "flamable":
                for (ModelCar modelCar : modelCars1) {
                    double power = modelCar.getEngine().getEnginePower();
                    if (power > 250) {
                        list.add(modelCar.getCar());
                    }
                }
                break;
        }
        return list;
    }
}