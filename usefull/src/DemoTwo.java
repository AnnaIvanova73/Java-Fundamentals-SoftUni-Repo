import java.util.Scanner;

public class DemoTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println(4%1);
        int first = 5 % 2;
        int second = 11 % 2;
        int third = 11 % 5;
        int fourth = 22 % 5;
        int fifth = 17%5;

        int[] example = new int[]{ 0%4, 3%4, 4%2,2%4, 5%20,20%5};

        for (int value : example) {// мога ли обратен цикъл с for each
            System.out.print(value + " ");
        }
        System.out.println();
        for (int i = 0; i <example.length ; i++) {
            System.out.print(example[i] + " ");
        }
    }
}
