import java.util.Scanner;

public class equalArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputFirst = scan.nextLine();
        String inputSecond = scan.nextLine();

        String[] arrToNum = inputFirst.split(" ");
        String[] arrToNumSecond = inputSecond.split(" ");

        int[] firstArray = new int[arrToNum.length];
        int[] secondArray = new int[arrToNumSecond.length];

        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = Integer.parseInt(arrToNum[i]);
        }
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = Integer.parseInt(arrToNumSecond[i]);
        }

        int arrSum1 = 0;
        int arrSum2=0;
        for (int i = 0; i <firstArray.length && i< secondArray.length ; i++) {
            arrSum1+=firstArray[i];
            arrSum2+=secondArray[i];

                if(firstArray[i] != secondArray[i]){
                    System.out.printf("Arrays are not identical. Found difference at %d index.",i);
                    break;
                }
        }

        if (arrSum1 == arrSum2){
            System.out.printf("Arrays are identical. Sum: %d",arrSum1);
        }







    }
}


