import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] copiedArray = {1, 10, 100, 1000};
        int a = 0;

        int[] exchangedArray = new int[copiedArray.length];


        int count = 0;
        for (int i = a + 1; i < copiedArray.length; i++) {

            exchangedArray[count] = copiedArray[i];
            count += 1;
        }


        int countSecond = 0;
        for (int i = count; i < copiedArray.length; i++) {
            exchangedArray[i] = copiedArray[countSecond];
            countSecond++;
        }
        for (int num:
             exchangedArray) {
            System.out.print(num + " ");
        }
    }


}
