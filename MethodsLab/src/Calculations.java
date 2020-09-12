import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());

        switch (command){
            case"add":
                addNumbers(firstNumber,secondNumber,command);
                break;
            case"multiply":
                multiplyNumbers(command,firstNumber,secondNumber);
                break;
            case"subtract":
                subtractNumbers(command,firstNumber,secondNumber);
                break;
            case"divide":
                divideNumbers(command,firstNumber,secondNumber);
                break;

        }
    }

    public static void addNumbers (int firstNum,int secondNum,String print){
        int result = firstNum+secondNum;
        System.out.println(result);
    }
    public static void multiplyNumbers (String print,int num1,int num2){
        int result =num1+num2;
        System.out.println(result);
    }
    public static void subtractNumbers (String print,int num1,int num2){
        int result = num1-num2;
        System.out.println(result);
    }
    public static void divideNumbers (String print,int num1,int num2){
        int result = num1/num2;
        System.out.println(result);
    }




}
