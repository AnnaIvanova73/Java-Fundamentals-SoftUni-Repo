import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_3_TanksCollector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> listOfCars = getCars(scan);

        int commands = Integer.parseInt(scan.nextLine());


        for (int i = 0; i < commands; i++) {
            String[] tokens = scan.nextLine().split(", ");
            String cmdArgs = tokens[0];

            switch (cmdArgs) {
                case "Add": {
                    String tank = tokens[1];
                    if (listOfCars.contains(tank)) {
                        System.out.println("Tank is already bought");
                    } else {
                        listOfCars.add(tank);
                        System.out.println("Tank successfully bought");
                    }
                    break;
                }
                case "Remove": {
                    String tank = tokens[1];
                    if (listOfCars.contains(tank)) {
                        listOfCars.remove(tank);
                        System.out.println("Tank successfully sold");
                    } else {
                        System.out.println("Tank not found");
                    }
                    break;
                }
                case "Remove At": {
                    int index = Integer.parseInt(tokens[1]);
                    boolean isValid = checkExistence(index, listOfCars);
                    if (!isValid) {
                        System.out.println("Index out of range");
                    } else {
                        listOfCars.remove(index);
                        System.out.println("Tank successfully sold");
                    }
                    break;
                }
                case "Insert": {
                    int index = Integer.parseInt(tokens[1]);
                    String tankName = tokens[2];
                    boolean isValid = checkExistence(index, listOfCars);
                    if (!isValid) {
                        System.out.println("Index out of range");
                    }
                    if(isValid && !listOfCars.contains(tankName)){
                        listOfCars.add(index,tankName);
                        System.out.println("Tank successfully bought");
                    }else if(isValid && listOfCars.contains(tankName)){
                        System.out.println("Tank is already bought");
                    }
                    break;
                }

            }


        }
        for (int i = 0; i <listOfCars.size()-1 ; i++) {
            System.out.print(listOfCars.get(i)+", ");
        }
        if(listOfCars.size() > 0){
            System.out.println(listOfCars.get(listOfCars.size()-1));
        }

    }

    private static boolean checkExistence(int index, List<String> list) {
        if (index >= 0 && index < list.size()) {
            return true;
        }
        return false;
    }

    private static List<String> getCars(Scanner scan) {
        String[] input = scan.nextLine().split(", ");
        List<String> list = new ArrayList<>();
        for (String elements : input) {
            list.add(elements);
        }
        return list;
    }
}
