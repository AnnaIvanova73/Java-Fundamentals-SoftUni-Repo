package MoreExercise_3_CarSalesMan02;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Engine1>> engineParameters = new HashMap<>();
        int length = 0;
        int countEngines = Integer.parseInt(scan.nextLine());
        boolean hasNumber;
        for (int i = 0; i < countEngines; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String engineModel = tokens[0];
            String power = tokens[1];
            String displacement = "n/a";
            String efficiency = "n/a";

            length = tokens.length;
            if (length == 3) {
                String current = tokens[2];
                hasNumber = checkForNumbers(current);
                if (hasNumber) {
                    displacement = current;
                } else {
                    efficiency = current;
                }
            }

            if (length > 3) {
                displacement = tokens[2];
                efficiency = tokens[3];
            }

            Engine1 currentEngine = new Engine1(engineModel, power, displacement, efficiency);
            engineParameters.putIfAbsent(engineModel, new ArrayList<>());
            engineParameters.get(engineModel).add(currentEngine);
        }


        Map<Integer, List<Car1>> carParameters = new LinkedHashMap<>();

        int quantityCars = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < quantityCars; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            String engine = tokens[1];
            String weight = "n/a";
            String color = "n/a";
            length = tokens.length;
            if (length == 3) {
                String current = tokens[2];
                hasNumber = checkForNumbers(current);
                if (hasNumber) {
                    weight = current;
                } else {
                    color = current;
                }
            }

            if (length == 4) {
                weight = tokens[2];
                color = tokens[3];
            }

            Engine1 enginePerThisCar = getParticularEngine(engine, engineParameters);
            Car1 currentCar = new Car1(model, enginePerThisCar, weight, color);
            int position = i;
            carParameters.putIfAbsent(position, new ArrayList<>());
            carParameters.get(position).add(currentCar);
        }


        for (Map.Entry<Integer, List<Car1>> currentElement : carParameters.entrySet()) {
            currentElement.getValue().stream().forEach(f-> {
                System.out.println(String.format("%s:" + "\n" + "  %s:\n" +
        "    Power: %s\n" +
        "    Displacement: %s\n" +
        "    Efficiency: %s\n" +
        "  Weight: %s\n" +
        "  Color: %s",f.getModel(),
                        f.getEngine().getEngineModel(),
                        f.getEngine().getPower(),
                        f.getEngine().getDisplacement(),
                        f.getEngine().getEfficiency(),
                        f.getWeight(),f.getColor()));
            });
        }

//        for (List<Car1> value : carParameters.values()) {
//            System.out.println(value.
//                    toString().replace("[", "")
//                    .replace("]", "")
//                    .replace("=", ":"));
//        }
    }

    private static Engine1 getParticularEngine(String engine, Map<String, List<Engine1>> engineParameters) {
        List<Engine1> temp = new ArrayList<>();
        Engine1 engine1;
        for (Map.Entry<String, List<Engine1>> element : engineParameters.entrySet()) {
            String modelCurrent = element.getKey();
            if (modelCurrent.equals(engine)) {
                String specificModel = element
                        .getValue().get(0).getEngineModel();
                String power = element.getValue().get(0).getPower();
                String displacement = element.getValue().get(0).getDisplacement();
                String efficiency = element.getValue().get(0).getEfficiency();
                return engine1 = new Engine1(specificModel, power, displacement, efficiency);
            }
        }
        return null;
    }

    private static boolean checkForNumbers(String current) {
        for (int i = 0; i < current.length(); i++) {
            int ascii = current.charAt(i);
            if (ascii > 47 && ascii < 58) {
                return true;
            }
        }
        return false;
    }

}
