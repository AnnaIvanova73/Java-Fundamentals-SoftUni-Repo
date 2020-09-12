import java.util.Scanner;

public class PrintingTriangle {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputNumber = Integer.parseInt(scan.nextLine());

        for (int indexFirst = 1; indexFirst <= inputNumber; indexFirst++) {
            printTriangle(indexFirst);
            System.out.println();
        }

        for (int indexSecond = inputNumber - 1; indexSecond >= 1; indexSecond--) {
            printTriangle(indexSecond);
            System.out.println();
        }

    }

    public static void printTriangle(int index) {
        for (int i = 1; i <= index; i++) {
            System.out.print(i + " ");
        }


    }
}
