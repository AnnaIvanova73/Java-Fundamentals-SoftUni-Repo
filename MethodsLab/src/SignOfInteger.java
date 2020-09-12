import java.util.Scanner;

public class SignOfInteger {
    private static void printInteger(int number) {
        if(number>0){
            System.out.println(String.format("The number %d is positive.",number));
        }else if(number< 0){
            System.out.println(String.format("The number %d is negative.",number));
        }else{
            System.out.println(String.format("The number %d is zero.",number));
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        printInteger(number);

    }
}
