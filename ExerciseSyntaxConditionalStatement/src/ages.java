import java.util.Scanner;

public class ages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int age = Integer.parseInt(scan.nextLine());

        if (age < 3) {
            System.out.println("baby");
        } else if (age <14 ) {
            System.out.println("child");
        } else if (age < 20) {
            System.out.println("teenager");
        } else if (age < 66) {
            System.out.println("adult");
        } else  {
            System.out.println("elder");
        }

    }
}
