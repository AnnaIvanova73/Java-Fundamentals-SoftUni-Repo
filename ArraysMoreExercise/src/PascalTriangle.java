import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int row = Integer.parseInt(scan.nextLine());

        int[] previous = {1,1};
        for (int r = 0; r < row ; r++) {
            int[] next = new int [r + 1];
            next [0] = 1;

            for (int i = 1; i < r ; i++) {
                next[i]=previous[i-1] + previous [i];
            }
            next[r]=1;
            previous=next;
        for (int num : previous){
            System.out.print(num + " " );
        }
            System.out.println();
        }


    }
}
