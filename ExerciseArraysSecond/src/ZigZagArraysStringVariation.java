import java.util.Scanner;

public class ZigZagArraysStringVariation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int extentArrays = Integer.parseInt(scan.nextLine());

        String[] firstArr = new String[extentArrays];
        String[] secondArr = new String[extentArrays];

        for (int i = 0; i < secondArr.length ; i++) {
            if ( i % 2 == 0){
                firstArr[i]=scan.next(); // защо не сканира space, а взима само числата
                secondArr[i]=scan.next();
            }else{
                secondArr[i]=scan.next();
                firstArr[i]=scan.next();
            }
        }

        for (String firstElements:firstArr) {
            System.out.print(firstElements + " ");
        }
        System.out.println();
        for (int i = 0; i < secondArr.length ; i++) {
            System.out.print(secondArr[i] + " ");

        }
    }
}
