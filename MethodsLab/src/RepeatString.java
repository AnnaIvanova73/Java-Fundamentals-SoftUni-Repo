import java.util.Scanner;

public class RepeatString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input =scan.nextLine();

        int attach = Integer.parseInt(scan.nextLine());

        String result = repeat(input,attach);

        System.out.println(result);

    }
    public static String repeat (String symbols, int counter){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < counter ; i++) {
            result.append(symbols);
        }

        return result.toString();
    }






}
