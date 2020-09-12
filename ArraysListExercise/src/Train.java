import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> wagons = getWagons(scan);
        int maxCapacity = Integer.parseInt(scan.nextLine());


        String input = scan.nextLine();
        while(!"end".equals(input)){
            String[] tokens = input.split("\\s+");
            if (tokens[0].equals("Add")){
                int addWagons = Integer.parseInt(tokens[1]);
                wagons.add(addWagons);
            } else {
                int newPassengers = Integer.parseInt(tokens[0]);
                int index = 0;
                for (Integer wagon : wagons) {
                    int passengers= wagon+newPassengers;
                    int result = maxCapacity - passengers;
                    if ( result >= 0){
                        wagons.set(index,passengers);

                        break;
                    }
                    index++;
                }
            }

            input=scan.nextLine();
        }
        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }

    }

    private static List<Integer> getWagons(Scanner scan) {
        List<Integer> myNumbers = new ArrayList<>();
        String[] input = scan.nextLine().split("\\s+");

        for (String numbers : input) {
            int number = Integer.parseInt(numbers);
            myNumbers.add(number);
        }


        return myNumbers;
    }
}
