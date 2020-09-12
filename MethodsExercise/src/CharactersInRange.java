import java.util.Scanner;

public class CharactersInRange {
    public static void printCharactersInRange(char first, char second) {

        StringBuilder symbols = new StringBuilder();

        if (first < second) {
            first += 1;

            for (char i = first; i < second; i++) {
                symbols.append(i).append(" ");
            }

        } else {

            second += 1;

            for (char i = second; i < first; i++) {
                symbols.append(i).append(" ");
            }
        }

        System.out.println(symbols);

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char first = scan.nextLine().charAt(0);
        char second = scan.nextLine().charAt(0);

        printCharactersInRange(first, second);

    }

}
