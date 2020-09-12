import java.util.Scanner;

public class division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int i = Integer.parseInt(scan.nextLine());

        String output = ("The number is divisible by");

        if (i % 10 == 0) {
            System.out.println(output + " 10");
        } else if (i % 7 == 0) {
            System.out.println(output + " 7");

        } else if (i % 6 == 0) {
            System.out.println(output + " 6");

        } else if (i % 3 == 0) {
            System.out.println(output + " 3");

        } else if (i % 2 == 0) {
            System.out.println(output + " 2");

        } else {
            System.out.println("Not divisible");
        }

    }
}
