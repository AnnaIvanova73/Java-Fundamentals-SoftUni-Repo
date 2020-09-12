import java.util.Scanner;

public class MaxSequenceLeftElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int[] numberSequence = inputToArrayNumbers(input);

        int currentCount = 1;
        int maxElement = 0;
        int maxCount = 1;
        for (int i = 0; i < numberSequence.length - 1 ; i++) {
            int firstElement= numberSequence[i];
            int subsequenceElement = numberSequence[i + 1];

            if (firstElement == subsequenceElement){
                currentCount+=1;
                if (currentCount >= maxCount){
                    maxCount=currentCount;
                    maxElement=numberSequence[i];
                }
            }else{
                currentCount=1;
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
