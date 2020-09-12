import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam_3_HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> fieldNeighborhood = getHouses(scan);

        String input = scan.nextLine();
        int index = 0;
        while (!"Love!".equals(input)) {
            String[] tokens = input.split("\\s+");
            int length = Integer.parseInt(tokens[1]);


            while (length > 0) {
                index += length;
                if (index >= fieldNeighborhood.size()) {
                    index = 0;
                }

                int heart = fieldNeighborhood.get(index);
                heart -= 2;
                fieldNeighborhood.set(index, heart);

                if (heart == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", index);
                    break;
                }
                if (heart < 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", index);
                    break;
                }
                if (heart >= 2) {
                    break;
                }
                index++;
                length--;
            }


            input = scan.nextLine();
        }

        int sumHouses = 0;
        int failed = 0;
        System.out.printf("Cupid's last position was %d.%n", index);

        for (int i = 0; i < fieldNeighborhood.size(); i++) {
            int currentPlace = fieldNeighborhood.get(i);
            if (currentPlace <= 0) {
                sumHouses++;
            } else {
                failed += 1;
            }
        }
        if (failed <= 0) {
            System.out.println("Mission was successful.");

        }
        if (failed > 0) {
            System.out.printf("Cupid has failed %d places.", failed);
        }
    }

    private static List<Integer> getHouses(Scanner scan) {
        List<Integer> myList = new ArrayList<>();
        String[] input = scan.nextLine().split("@+");
        for (String element : input) {
            int number = Integer.parseInt(element);
            myList.add(number);
        }
        return myList;
    }
}
