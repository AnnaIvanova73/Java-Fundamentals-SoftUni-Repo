import java.util.Scanner;

public class FloathingPointEquality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        double firstNumber = Double.parseDouble(scan.nextLine());
        double secondNumber = Double.parseDouble(scan.nextLine());

        double resultForCompare = Math.abs(firstNumber-secondNumber);

        if (resultForCompare < 0.000001){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}
