import java.util.Scanner;

public class reverseArraysOfString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] elements = scan.nextLine().split(" ");

        for (int i = 0; i < elements.length / 2; i++) {
            String oldElements = elements[i];
            elements[i] = elements[elements.length - 1 - i];
            elements[elements.length - 1 - i] = oldElements;

        }
        System.out.println(String.join(" ",elements));
    }
}
