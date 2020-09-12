import java.util.Scanner;

public class ZigZagArraysInt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input = Integer.parseInt(scan.nextLine());

        int[] firstArr = new int[input];
        int[] secondArr = new int[input];

        for (int i = 0; i <secondArr.length ; i++) {

            if ( i % 2 == 0 ){
                firstArr[i] = scan.nextInt();
                secondArr[i]=scan.nextInt();

            }else{
                secondArr[i]=Integer.parseInt(scan.next());
                firstArr[i]=Integer.parseInt(scan.next());
            }

        }

        for (int i = 0; i < firstArr.length ; i++) {
            System.out.print(firstArr[i] + " ");
        }

        System.out.println();

        for (int elements : secondArr){
            System.out.print(elements + " ");
        }
    }
}
