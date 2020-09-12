import javax.xml.namespace.QName;
import java.util.Scanner;

public class compile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String[] numbers = new String[]{"gosho","pesho"};
        String name = "";
        for (int i = 0; i <numbers.length ; i++) {
            name = numbers[numbers.length-1];
        }

        System.out.println(name);
    }
}
