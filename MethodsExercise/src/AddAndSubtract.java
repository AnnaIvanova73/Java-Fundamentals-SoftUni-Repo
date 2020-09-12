import java.util.Scanner;

public class AddAndSubtract {

    public static int sumTwoInteger (int num1, int num2){
        int result = num1+num2;
        return result;
    }
    public static int subtractIntOfTwoSumInt (int num1, int num2, int num3){

        int sumNumbers = sumTwoInteger(num1,num2);
        int result = sumNumbers-num3;

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstSum = Integer.parseInt(scan.nextLine());
        int secondSum = Integer.parseInt(scan.nextLine());

        int numSubtract = Integer.parseInt(scan.nextLine());

        int result = subtractIntOfTwoSumInt(firstSum,secondSum,numSubtract);
        System.out.println(result);

    }
}
