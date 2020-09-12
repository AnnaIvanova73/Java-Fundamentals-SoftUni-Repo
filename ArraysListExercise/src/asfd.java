import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class asfd {
    public static void main(String[] args) {
        int num= 5 % 2;
        int num2 = 5/2;

        int num3 = 4 % 3;
        int num4 = 4/3;

        System.out.println(num3+ " "+ num4);

        List<String> list = new ArrayList<>(Arrays.asList(
                "one", "two", "three", "four", "five", "six"));
        System.out.println(String.join("; ", list));

    }


}
