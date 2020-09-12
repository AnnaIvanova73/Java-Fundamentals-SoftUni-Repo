import java.util.Scanner;

public class demo5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] stringToNumbers = scan.nextLine().split(" ");
        int[] numbers = new int [stringToNumbers.length];

        for (int i = 0; i < numbers.length ; i++) {
            numbers[i] =Integer.parseInt(stringToNumbers[i]);
        }
        for (int result:numbers) {
            System.out.print(result + " ");
        }


        for (int i = 0; i < numbers.length;i++){

        }
        for (int i = numbers.length-1; i>= 0;i--){

        }
        }
    }

