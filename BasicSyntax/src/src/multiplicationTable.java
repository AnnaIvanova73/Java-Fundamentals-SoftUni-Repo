import java.util.Scanner;

public class multiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number =Integer.parseInt(scan.nextLine());

        int result = 0;
        for (int i = 1; i <=10 ; i++) {
            result = number*i;
            System.out.println(String.format("%d X %d = %d",number,i,result));
        }
    }
}
