import java.util.Scanner;

public class lowerToUpper {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        char caseLowerOrUpper = scan.nextLine().charAt(0);


        if (Character.isLowerCase(caseLowerOrUpper)){
            System.out.println("lower-case");
        } else {
            System.out.println("upper-case");
        }
    }
}
