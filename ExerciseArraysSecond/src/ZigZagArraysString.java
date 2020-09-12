import java.util.Scanner;

public class ZigZagArraysString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //input as int, arrays as string
        int extentArrays = Integer.parseInt(scan.nextLine());

        String[] firstArr = new String[extentArrays]; // приема дължина стойността на Int-i
        String[] secondArr = new String[extentArrays];

        for (int i = 0; i < firstArr.length  ; i++) {
            String[] input = scan.nextLine().split(" ");

            if (i % 2 == 0) {
                firstArr[i] = input[0];
                secondArr[i] = input[1];
            } else {
                firstArr[i] = input[1];
                secondArr[i] = input[0];
            }

        }
            for (String element : firstArr) {
                System.out.print(element + " ");
            }

            System.out.println();

            for (String elementSecond : secondArr) {
                System.out.print(elementSecond + " ");
            }



    }
}