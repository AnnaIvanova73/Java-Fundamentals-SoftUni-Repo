import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = getInputAsNumbers(scan);

        String[] tokens = scan.nextLine().split("\\s+");
        int bomb = Integer.parseInt(tokens[0]);
        int power = Integer.parseInt(tokens[1]);

        while (numbers.contains(bomb)) {
            int bombPlace = numbers.indexOf(bomb);

            int leftBlast = Math.max(bombPlace - power, 0);
            int rightBlast = Math.min(bombPlace + power, numbers.size() - 1);

            for (int i = rightBlast; i >= leftBlast; i--) {
                numbers.remove(i);
            }

        }
        int sum = 0;
        for (Integer number : numbers) {
            sum+=number;
        }
        System.out.println(sum);
}

    private static List<Integer> getInputAsNumbers(Scanner scan) {
        List<Integer> myNumbers = new ArrayList<>();
        String[] inputSplit = scan.nextLine().split("\\s+");
        for (String s : inputSplit) {
            int currNumber = Integer.parseInt(s);
            myNumbers.add(currNumber);
        }
        return myNumbers;
    }
}
