import java.util.Scanner;

public class FoldAndSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       // int[] allNumbers = new int[]{5, 2, 3, 6};

        String[] numbers = scan.nextLine().split(" ");
        int[] allNumbers = new int[numbers.length];
        for (int i = 0; i < allNumbers.length; i++) {
            allNumbers[i]=Integer.parseInt(numbers[i]);
        }

        int k = allNumbers.length/4;

        int[] outsideNumbers = new int[k*2];

        for (int index = 0; index <k ; index++) {
            int operationFirst =outsideNumbers[index];
            int operationSecond=allNumbers[k-1-index];

            outsideNumbers[index]=allNumbers[k-1-index];

            int operationThird = outsideNumbers[k+index];
            int operationFourth = allNumbers[4*k-1-index];

            outsideNumbers[k+index]=allNumbers[4*k-1-index];
        }

        int[] insideNumbers = new int[2*k];

        for (int i = 0; i < 2 * k ; i++) {
            int operation = allNumbers[k+i];
            insideNumbers[i]=allNumbers[k+i];
            outsideNumbers[i] +=insideNumbers[i];
            System.out.print(outsideNumbers[i] + " ");
        }

        System.out.println();
    }
}
