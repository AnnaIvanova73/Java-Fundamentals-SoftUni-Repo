import java.util.Scanner;

//минимална разлика между всички числа с другите числа
public class MinDistanceAbsoluteValue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rangeArray = Integer.parseInt(scan.nextLine());
        int[] numbersArray = new int[rangeArray];
        for (int index = 0; index < numbersArray.length;index++){
            numbersArray[index]=Integer.parseInt(scan.nextLine());
        }


    }
}
