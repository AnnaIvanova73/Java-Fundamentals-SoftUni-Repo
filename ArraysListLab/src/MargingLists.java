import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class MargingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firstNumbers =  parseLineInputToNumbers(scan);
        List<Integer> secondNumbers = parseLineInputToNumbers(scan);


        int index = 0;

        List <Integer> resultNumbers = new ArrayList<>();

        while (index < firstNumbers.size() && index < secondNumbers.size()){
            resultNumbers.add(firstNumbers.get(index));
            resultNumbers.add(secondNumbers.get(index));
            index++;
        }


        if ( index < firstNumbers.size()){
            resultNumbers.addAll(getLeftOvers(firstNumbers,index));
        }else {
            resultNumbers.addAll(getLeftOvers(secondNumbers,index));
        }

        for (int resultNumber : resultNumbers) {
            System.out.print(resultNumber + " ");
        }
    }

    private static List<Integer> getLeftOvers(List<Integer> firstNumbers, int afterIndex) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = afterIndex; i < firstNumbers.size(); i++) {
            numbers.add(firstNumbers.get(i));
        }
        return  numbers;
    }

    private static List<Integer> parseLineInputToNumbers(Scanner scanner) {
        String[] split = scanner.nextLine().split("\\s+");

        List<Integer> numbersFirst = new ArrayList<>();

        for (String inputLines : split) {
            int number = Integer.parseInt(inputLines);
            numbersFirst.add(number);
        }
        return numbersFirst;
    }
}
