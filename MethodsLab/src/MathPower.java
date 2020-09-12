import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double number = Double.parseDouble(scan.nextLine());
        int pow = Integer.parseInt(scan.nextLine());
        double result = myMathPower(number, pow);

        System.out.println(new DecimalFormat("0.####").format(result));
    }

//    public static double myMathPower (double number,int pow){
//        double result = 1;
//        if(pow==0){
//            result=number;
//        }
//        while (pow !=0 ){
//            result*=number;
//            --pow;
//        }
//
//        return result;
//    }

    public static double myMathPower(double num, int pow) {
        double result = 1;
        for (int i = 1; i <= pow; i++) {
            result *= num;
        }
        if (pow == 0) {
            result = num;
        }
        return result;
    }
}


