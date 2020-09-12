import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> distances = getDistances(scan);

        int sumAllRemoveElements = 0;
        while (distances.size() - 1 >= 0) {


            int index = Integer.parseInt(scan.nextLine());
            int elementToCopy = 0;
            int elementToRemove = 0;

            if (index >= 0 && index < distances.size()) {
                elementToRemove = distances.get(index);
                sumAllRemoveElements += elementToRemove;
                distances.remove(index);
            } else if (index < 0) {
                elementToCopy = distances.get(distances.size() - 1);
                elementToRemove = distances.get(0);
                distances.set(0, elementToCopy);
                sumAllRemoveElements += elementToRemove;
            } else {
                elementToCopy = distances.get(0);
                elementToRemove = distances.get(distances.size() - 1);
                distances.set(distances.size() - 1, elementToCopy);
                sumAllRemoveElements += elementToRemove;
            }

            for (int i = 0; i < distances.size(); i++) {
                int currentElement = distances.get(i);
                int currentSum = 0;

                if (currentElement <= elementToRemove) {
                    currentSum = currentElement + elementToRemove;
                    distances.set(i, currentSum);
                } else {
                    currentSum = currentElement - elementToRemove;
                    distances.set(i, currentSum);
                }


            }


        }
        System.out.println(sumAllRemoveElements);
    }

    private static List<Integer> getDistances(Scanner scan) {
        String[] input = scan.nextLine().split("\\s+");
        List<Integer> arrayAsList = new ArrayList<>();

        for (String elements : input) {
            int currentNumber = Integer.parseInt(elements);
            arrayAsList.add(currentNumber);
        }
        return arrayAsList;
    }
}
