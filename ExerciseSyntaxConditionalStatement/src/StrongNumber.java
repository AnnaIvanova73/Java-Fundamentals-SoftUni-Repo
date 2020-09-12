import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String number = scan.nextLine();

        int sum = 0 ;
        for (int i = 0; i < number.length() ; i++) {
            int digit = Character.getNumericValue(number.charAt(i));
          int fact = 1;
            for (int j = 1; j <=digit ; j++) {
                fact= fact * j;// 4! = 1*2*3*4; 1*1 + 1*2 + 3*3 + 6 * 4
            }
          
          sum+=fact;
        }

        int stringToInt = Integer.parseInt(number);

        if (sum == stringToInt){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
