import java.util.Scanner;

public class NxNMatrix {

    public static void nxnMatrixInt (int num){

        for (int i = 1; i <=num ; i++) {
            for (int j = 1; j <=num ; j++) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        nxnMatrixInt(number);
    }
}
