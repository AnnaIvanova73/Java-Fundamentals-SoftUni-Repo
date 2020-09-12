import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputArrays = scan.nextLine().split("\\|+");

        ArrayList<String> array = getElements(inputArrays);

        String result = "";
        for (int i = inputArrays.length-1; i >= 0 ; i--) {
            result += array.get(i) + " ";
        }

        result = result.trim().replaceAll("\\s+", " ");

        System.out.println(result);


    }

    private static ArrayList<String> getElements(String[] inputArrays) {
        ArrayList<String> myElement = new ArrayList<>();
        for (String inputArray : inputArrays) {
            String element = inputArray;
            myElement.add(inputArray);
        }
        return myElement;
    }
}
