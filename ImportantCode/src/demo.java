import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> list = new ArrayList<>(Arrays.asList(
                "one", "two", "three", "four", "five", "six"));
        for (int index = 0; index < list.size(); index++)
            System.out.printf
                    ("arr[%d] = %s%n", index, list.get(index));


        List<String> listTwo = new ArrayList<>(Arrays.asList(
                "one", "two", "three", "four", "five", "six"));
        System.out.println(String.join("; ", list));


    }
}
