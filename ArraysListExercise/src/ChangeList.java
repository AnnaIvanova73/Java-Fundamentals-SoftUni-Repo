import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = getLineAsNumbers(scan);
        String input = scan.nextLine();
        while (!"end".equals(input)){

            List<Integer>modifiedNumbers =new ArrayList<>();
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Delete":
                    modifiedNumbers = deleteElements(tokens, numbers);
                    break;
                case "Insert":
                    modifiedNumbers = insertElements(tokens, numbers);
                    break;
            }

            numbers=modifiedNumbers;

            input=scan.nextLine();
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }


    }

    private static List<Integer> insertElements(String[] tokens, List<Integer> numbers) {
        int element = Integer.parseInt(tokens[1]);
        int index=Integer.parseInt(tokens[2]);
        if (index >= 0 && index <numbers.size()) {
            numbers.add(index, element);
        }
        return numbers;
    }

    private static List<Integer> deleteElements(String[] tokens, List<Integer> numbers) {
        List <Integer> myList = numbers;
        int element = Integer.parseInt(tokens[1]);
        for (int i = 0; i < myList.size() ; i++) {
            int currentElement = myList.get(i);
            if ( element == currentElement){
                myList.remove(Integer.valueOf(element));
                i-=1;
            }
        }
        return myList;
    }

    private static List<Integer> getLineAsNumbers(Scanner scan) {
        List<Integer> myNumbers = new ArrayList<>();
        String[] input = scan.nextLine().split("\\s+");
        for (int i = 0; i < input.length ; i++) {
            int number = Integer.parseInt(input[i]);
            myNumbers.add(number);
        }
        return myNumbers;
    }
}
