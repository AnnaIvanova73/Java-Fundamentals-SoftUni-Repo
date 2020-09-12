import java.util.Scanner;

public class LargestCommonEndSecondWhileLoop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] firstArray = scan.nextLine().split(" ");

        String toArrays = scan.nextLine();
        String[] secondArray = toArrays.split(" ");

        int firstLength = firstArray.length;
        int secondLength = secondArray.length;

        int leftCount = 0;
        int rightCount = 0;

        while (rightCount < firstLength && rightCount < secondLength) {

            String first = firstArray[firstArray.length - rightCount - 1];
            String second = secondArray[secondArray.length - rightCount - 1];
            if (first.equals(second)) {
                rightCount++;
            } else {

                break;
            }

        }
        while(leftCount<firstLength && leftCount <secondLength){

            String first = firstArray[leftCount];
            String second = secondArray[leftCount];

            if(first.equals(second)){
                leftCount++;
            }else {
                break;
            }
        }

        if(leftCount>rightCount){
            System.out.println(leftCount);
        }else {
            System.out.println(rightCount);

        }


     }
}




