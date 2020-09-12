import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_1_CountCharsInAString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] input = scan.nextLine().toCharArray();
        Map<Character,Integer> chars = new LinkedHashMap<>();


        for (char currentElement : input) {
            if(currentElement == ' '){
                continue;
            }
            chars.putIfAbsent(currentElement,0);
            int currValue = chars.get(currentElement);
            chars.put(currentElement,currValue + 1);
        }

            chars
                    .forEach((k,v) -> System.out.println(String.format("%s -> %d",k,v)));

    }
}