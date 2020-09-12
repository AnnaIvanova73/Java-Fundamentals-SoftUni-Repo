import java.util.Scanner;

public class ZigZagExampleMarto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arraysExtent = Integer.parseInt(scan.nextLine());

        int[] firstArr = new int[arraysExtent];
        int[] secondArr = new int[arraysExtent];


        for (int i = 0; i < firstArr.length; i++) {
            if (i % 2 == 0) {
                firstArr[i] = Integer.parseInt(scan.next());
                secondArr[i] = Integer.parseInt(scan.next());
            } else {
                secondArr[i] = Integer.parseInt(scan.next());
                firstArr[i] = Integer.parseInt(scan.next());
            }
        }


        for (int i = 0; i < firstArr.length; i++) {
            System.out.print(firstArr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < secondArr.length; i++) {
            System.out.print(secondArr[i] + " ");
        }

    }
}
