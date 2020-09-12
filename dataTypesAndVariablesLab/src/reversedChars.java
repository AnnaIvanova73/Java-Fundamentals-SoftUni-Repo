import java.util.Scanner;

public class reversedChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char char1 = scan.nextLine().charAt(0);
        char char2 = scan.nextLine().charAt(0);
        char char3 = scan.nextLine().charAt(0);

        String a =  String.valueOf(char1);
        String b = String.valueOf(char2);
        String c = String.valueOf(char3);

        System.out.printf("%S %s %s",c,b,a);
    }
}
