import java.util.Scanner;

public class MathOperations {

    public static double calculate (int a, String operator, int b){

        double result = 0.0;

        switch (operator){

            case"/":
                result=(a* 1.0)/b;
                break;
            case"*":
                result=(a* 1.0)*b;
                break;
            case"+":
                result=(a* 1.0)+b;
                break;
            case"-":
                result=(a* 1.0)-b;
                break;

        }

        return result;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scan.nextLine());
        String operator = scan.nextLine();
        int secondNumber = Integer.parseInt(scan.nextLine());

        double result = calculate(firstNumber,operator,secondNumber);
        System.out.printf("%.0f",result);
    }





















}
