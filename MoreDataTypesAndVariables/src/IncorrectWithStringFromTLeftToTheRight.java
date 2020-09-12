import java.util.Scanner;

public class IncorrectWithStringFromTLeftToTheRight { // runtime error judge 25 От 100

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countLinesOfInput = Integer.parseInt(scan.nextLine());


        for (int i = 1; i <= countLinesOfInput; i++) {
            String numbers = scan.nextLine();
            boolean isItFirst = true;
            double sumFirstNum = 0;
            double sumSecondNum = 0;
            String num1 = "";
            String num2 = "";
            double num1Parse = 0;
            double num2Parse = 0;

            for (int j = 0; j < numbers.length(); j++) {

                if (isItFirst) {
                    num1 += numbers.charAt(j);// субирам чаровете на първата дума
                    num1Parse = Double.parseDouble(num1);//парсвам ги
                    double valueAscii = numbers.charAt(j);// проверявам по символи за интервал
                    if (valueAscii == 32) {
                        isItFirst = false;
                        continue;
                    } else {
                        double realValue = Character.getNumericValue(numbers.charAt(j)); // парсвам реалната сума на
                        //чаровете
                        sumFirstNum += realValue;
                    }
                }

                if (!isItFirst) {
                    double realValue = Character.getNumericValue(numbers.charAt(j));
                    if (realValue >= 0) {
                        num2 += numbers.charAt(j);
                        num2Parse = Double.parseDouble(num2);
                        sumSecondNum += realValue;
                    }

                }
            }

                if (num1Parse>num2Parse){
                    System.out.printf("%.0f\n",sumFirstNum);
                } else{
                    System.out.printf("%.0f\n",sumSecondNum);
                }
        }
    }
}
