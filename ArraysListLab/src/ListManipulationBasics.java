import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = getLineAsNumbers(scan);


        String input = scan.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");
            int num = 0;
            switch (tokens[0]) {
                case "Add":
                    num = getNumber(tokens);
                    numbers.add(num);
                    break;
                case "Remove":
                    num = getNumber(tokens);
                    numbers.remove(Integer.valueOf(num));
                    break;
                case "RemoveAt":
                    num = getNumber(tokens);
                    numbers.remove(num);
                    break;
                case "Insert":
                    num = getNumber(tokens);
                    int index = Integer.parseInt(tokens[2]);
                    numbers.add(index, num);
                    break;

            }


            input = scan.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println(numbers.toString());

    }

    private static int getNumber(String[] splitInput) {
        int num = Integer.parseInt(splitInput[1]);
        return num;
    }

    private static List<Integer> getLineAsNumbers(Scanner scan) {
        String input = scan.nextLine();
        String[] split = input.split("\\s+");

        List<Integer> myArrayList = new ArrayList<>();
        for (String inputs : split) {
            int number = Integer.parseInt(inputs);
            myArrayList.add(number);
        }
        return myArrayList;
    }
}
