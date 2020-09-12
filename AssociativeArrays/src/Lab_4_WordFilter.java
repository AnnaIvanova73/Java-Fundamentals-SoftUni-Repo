import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab_4_WordFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


       String[] words = Arrays.stream(scan.nextLine().split("\\s+"))
               .filter(w -> w.length() %2 == 0)
               .toArray(String[]::new);

       Arrays.stream(words)
               .forEach(System.out::println);




    }


}
