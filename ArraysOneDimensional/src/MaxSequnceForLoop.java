import java.util.Scanner;

public class MaxSequnceForLoop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int[] numbersSequence = inputToArrayNumbers(input);

        int maxElement = 0;
        int maxCount = 0;

        int count = 0;
        for (int i = 0; i < numbersSequence.length - 1 ; i++) {

            int firstElement = numbersSequence[i];
            count = 1;

            for (int j = i + 1 ; j < numbersSequence.length ; j++) {

                int secondElement = numbersSequence[j];

                if(firstElement == secondElement){
                    count++;
                    if ( count > maxCount){
                        maxElement=numbersSequence[i];
                        maxCount=count;
                    }
                }else {
                    count=0;
                }
            }
        }
        for (int i = 0; i < maxCount ; i++) {
            System.out.print(maxElement + " ");
        }

    }

    private static int[] inputToArrayNumbers(String input) {
        String[] split = input.split("\\s+");
        int[] myArray = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            myArray[i] = Integer.parseInt(split[i]);
        }
        return myArray;
    }
}
