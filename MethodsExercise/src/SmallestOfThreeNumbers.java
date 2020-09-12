import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static int smallestOfThree(int num1, int num2, int num3){
        int result = 0;
        if(num1 <=num2 && num1 <=num3 ){
            result=num1;
        }else if(num2 < num1 && num2 < num3){
            result=num2;
        }else {
            result=num3;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int third = Integer.parseInt(scan.nextLine());

        int result = smallestOfThree(first,second,third);
        System.out.println(result);
    }
}
