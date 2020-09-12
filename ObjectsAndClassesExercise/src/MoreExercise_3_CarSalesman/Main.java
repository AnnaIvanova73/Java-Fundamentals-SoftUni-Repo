//package MoreExercise_3_CarSalesman;
//
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//
//        Map<String, List<Engine>> engineByModel = new LinkedHashMap<>();
//        int engines = Integer.parseInt(scan.nextLine());
//
//        boolean hasNumber;
//        for (int i = 0; i < engines; i++) {
//            String[] input = scan.nextLine().split("\\s+");
//            String engineModel = input[0].trim();
//            String engPower = input[1].trim();
//            String engDisplacement = "n/a";
//            String engEfficiency = "n/a";
//
//            if (input.length == 3) {
//                String token = input[2];
//                hasNumber = hasNumbers(token);
//                if (hasNumber) {
//                    engDisplacement = token;
//                } else {
//                    engEfficiency = token;
//                }
//            }
//            if (input.length == 4) {
//                engDisplacement = input[2];
//                engEfficiency = input[3];
//            }
//            Engine currentEngine = new Engine(engineModel, engPower, engDisplacement, engEfficiency);
//            engineByModel.putIfAbsent(engineModel, new ArrayList<>());
//            engineByModel.get(engineModel).add(currentEngine);
//
//        }
//        Map<String, List<Car>> carByEngine = new LinkedHashMap<>();
//
//        int cars = Integer.parseInt(scan.nextLine());
//
//        for (int i = 0; i < cars; i++) {
//            String[] input = scan.nextLine().split("\\s+");
//            String carModel = input[0].trim();
//            String carEngine = input[1].trim();
//            String carWeight = "n/a";
//            String carColour = "n/a";
//            if (input.length == 3) {
//                String token = input[2].trim();
//                hasNumber = hasNumbers(token);
//                if (hasNumber) {
//                    carWeight = token;
//                } else {
//                    carColour = token;
//                }
//            }
//            if (input.length == 4) {
//                carWeight = input[2].trim();
//                carColour = input[3].trim();
//            }
//
//            List<Engine> engineCurrModel = engineByModel.get(carEngine);
//            Engine currEngine = getCurrentEngine(engineCurrModel);
//            Car currentCar = new Car(carModel, currEngine, carWeight, carColour);
//            carByEngine.putIfAbsent(carEngine, new ArrayList<>());
//            carByEngine.get(carEngine).add(currentCar);
//        }
//
//        for (Map.Entry<String, List<Car>> stringListEntry : carByEngine.entrySet()) {
//            String key = stringListEntry.getKey();
//            System.out.println(String.format("%s:", stringListEntry.getKey()));
//           if(engineByModel.containsKey(key)){
//               for (Map.Entry<String, List<Engine>> entry : engineByModel.entrySet()) {
//                   System.out.println(String.format("  %s:\n" +
//                           "    Power: %s\n" +
//                           "    Displacement: %s\n" +
//                           "    Efficiency: %s",entry.getKey(),entry.getValue().)
//               }
//           }
//
//        }
////        for (Map.Entry<String, List<String>> stringListEntry : carByModel.entrySet()) {
////            System.out.println(String.format("%s:", stringListEntry.getKey()));
////            String eng = stringListEntry.getValue().get(1);
////            for (Map.Entry<String, List<String>> listEntry : engineByModel.entrySet()) {
////                String key = listEntry.getKey();
////                if (eng.equals(key)) {
////                    System.out.println(String.format("  %s:\n" +
////                                    "    Power: %s\n" +
////                                    "    Displacement: %s\n" +
////                                    "    Efficiency: %s",listEntry.getKey(), listEntry.getValue().get(0)
////                            , listEntry.getValue().get(1), listEntry.getValue().get(2)
////                    ));
////                    break;
////                }
////            }
////
////            System.out.println(String.format(
////                    "  Weight: %s\n" +
////                            "  Color: %s", stringListEntry.getValue().get(1), stringListEntry.getValue().get(2)));
////
////        }
////    }
//
//    }
//
//
//    private static Engine getCurrentEngine(List<Engine> engineCurrModel) {
//        String engineModel = "";
//        String engPower = "";
//        String engDisplacement = "";
//        String engEfficiency = "";
//        for (Engine engine : engineCurrModel) {
//            engineModel = engine.getEngineModel();
//            engPower = engine.getEngPower();
//            engDisplacement = engine.getEngDisplacement();
//            engEfficiency = engine.getEngEfficiency();
//        }
//
//
//        return new Engine(engineModel, engPower, engDisplacement, engEfficiency);
//    }
//
//    private static boolean hasNumbers(String token) {
//
//        for (int i = 0; i < token.length(); i++) {
//            int ascii = token.charAt(i);
//            if (ascii > 47 && ascii < 58) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
//
//
////
//
////        for (Map.Entry<String, List<MoreExercise_3_CarSalesman.Car>> stringListEntry : carByModel.entrySet()) {
////            System.out.println(stringListEntry.
////                    toString().replace("[", "")
////                    .replace("]", "")
////                    .replace("=", ":"));
////        }
//
//
//// for (Map.Entry<String, List<Car>> s : carByModel.entrySet()) {
////        System.out.println(String.format("%s:", s.getKey()));
////        s.getValue().stream().forEach(f -> {
////        System.out.println(String.format("  %s:\n" +
////        "    Power: %s\n" +
////        "    Displacement: %s\n" +
////        "    Efficiency: %s\n" +
////        "  Weight: %s\n" +
////        "  Color: %s", f.getEngine().getEngineModel(),
////        f.getEngine().getEngPower(),
////        f.getEngine().getEngDisplacement(),
////        f.getEngine().getEngEfficiency(), f.getCarWeight(), f.getCarColour()
////        ));
////        });