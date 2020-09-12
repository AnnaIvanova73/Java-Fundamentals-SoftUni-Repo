package MoreExercise_3_CarSalesMan01;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        Map<String, List<String>> engineByModel = new LinkedHashMap<>();
        int engines = Integer.parseInt(scan.nextLine());

        boolean hasNumber;
        for (int i = 0; i < engines; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String engineModel = input[0].trim();
            String engPower = input[1].trim();
            String engDisplacement = "n/a";
            String engEfficiency = "n/a";

            if (input.length == 3) {
                String token = input[2];
                hasNumber = hasNumbers(token);
                if (hasNumber) {
                    engDisplacement = token;
                } else {
                    engEfficiency = token;
                }
            }
            if (input.length == 4) {
                engDisplacement = input[2];
                engEfficiency = input[3];
            }
            engineByModel.putIfAbsent(engineModel, new ArrayList<>());
            engineByModel.get(engineModel).add(engPower);
            engineByModel.get(engineModel).add(engDisplacement);
            engineByModel.get(engineModel).add(engEfficiency);


        }
        Map<String, List<String>> carByModel = new LinkedHashMap<>();

        int cars = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < cars; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String carModel = input[0].trim();
            String carEngine = input[1].trim();
            String carWeight = "n/a";
            String carColour = "n/a";
            if (input.length == 3) {
                String token = input[2].trim();
                hasNumber = hasNumbers(token);
                if (hasNumber) {
                    carWeight = token;
                } else {
                    carColour = token;
                }
            }
            if (input.length == 4) {
                carWeight = input[2].trim();
                carColour = input[3].trim();
            }

            carByModel.putIfAbsent(carModel, new ArrayList<>());
            carByModel.get(carModel).add(carModel);
            carByModel.get(carModel).add(carEngine);
            carByModel.get(carModel).add(carWeight);
            carByModel.get(carModel).add(carColour);
        }


        for (Map.Entry<String, List<String>> stringListEntry : carByModel.entrySet()) {
            System.out.println(String.format("%s:", stringListEntry.getKey()));
            String eng = stringListEntry.getValue().get(1);
            for (Map.Entry<String, List<String>> listEntry : engineByModel.entrySet()) {
                String key = listEntry.getKey();
                if (eng.equals(key)) {
                    System.out.println(String.format("  %s:\n" +
                                    "    Power: %s\n" +
                                    "    Displacement: %s\n" +
                                    "    Efficiency: %s",listEntry.getKey(), listEntry.getValue().get(0)
                            , listEntry.getValue().get(1), listEntry.getValue().get(2)
                           ));
                    break;
                }
            }

            System.out.println(String.format(
                    "  Weight: %s\n" +
                            "  Color: %s", stringListEntry.getValue().get(1), stringListEntry.getValue().get(2)));

        }
    }
// for (Map.Entry<String, List<Car>> s : carByModel.entrySet()) {
//        System.out.println(String.format("%s:", s.getKey()));
//        s.getValue().stream().forEach(f -> {
//        System.out.println(String.format("  %s:\n" +
//        "    Power: %s\n" +
//        "    Displacement: %s\n" +
//        "    Efficiency: %s\n" +
//        "  Weight: %s\n" +
//        "  Color: %s", f.getEngine().getEngineModel(),
//        f.getEngine().getEngPower(),
//        f.getEngine().getEngDisplacement(),
//        f.getEngine().getEngEfficiency(), f.getCarWeight(), f.getCarColour()
//        ));
//        });


    private static boolean hasNumbers(String token) {

        for (int i = 0; i < token.length(); i++) {
            int ascii = token.charAt(i);
            if (ascii > 47 && ascii < 58) {
                return true;
            }
        }
        return false;
    }
}
