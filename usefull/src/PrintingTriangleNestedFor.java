import java.util.Scanner;

public class PrintingTriangleNestedFor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = 3;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        for (int i = num-1; i >= 1; i--) {
            for (int j = 1; j <=i; j++) {
                System.out.print(j +" ");
            }
            System.out.println();
        }
    }
}
