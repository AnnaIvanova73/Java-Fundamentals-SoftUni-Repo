import java.util.Scanner;

public class charToString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char symbol1 = scan.nextLine().charAt(0);
        char symbol2 = scan.nextLine().charAt(0);
        char symbol3 = scan.nextLine().charAt(0);

       String a =  String.valueOf(symbol1);
       String b = String.valueOf(symbol2);
       String c = String.valueOf(symbol3);


       int you = 10610;
        System.out.println(you
        );
        System.out.println(a+b+c);
    }
}
