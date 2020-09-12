import java.util.Scanner;

public class PascalTriangleMe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int row = Integer.parseInt(scan.nextLine());

        int number = 1;
        for (int i = 0; i < row ; i++) {
                 number = 1;
            for (int j = 0; j <=i ; j++) {
                System.out.print(number + " ");
                number=number * (i-j)/(j+1);
            }
            System.out.println();
        }


    }
}
