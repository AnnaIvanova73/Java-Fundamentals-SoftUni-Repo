import java.util.Scanner;

public class LargestCommonEndForLoop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] firstArray = scan.nextLine().split(" ");

        String inputForArray = scan.nextLine();
        String[] secondArray = inputForArray.split(" ");

        String firstElement = "";
        String secondElement = "";
        int leftCount = 0;
        int rightCount = 0;
        int min = Math.min(secondArray.length, firstArray.length);

        for (int i = 1; i <=min ; i++) {
            firstElement = firstArray[firstArray.length-i];
            secondElement = secondArray[secondArray.length-i];
            if (firstElement.equals(secondElement)) {
                leftCount += 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < min ; i++) {
            firstElement=firstArray[i];
            secondElement=secondArray[i];
            if (firstElement.equals(secondElement)) {
                rightCount += 1;
            } else {
                break;
            }
        }

        if(rightCount>leftCount){
            System.out.println(rightCount);
        }else{
            System.out.println(leftCount);
        }
    }
}

