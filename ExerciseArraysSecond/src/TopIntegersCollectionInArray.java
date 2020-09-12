import java.util.Scanner;

public class TopIntegersCollectionInArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int[] numbers = inputToArrayNumbers(input);


        for (int index = 0; index <numbers.length ; index++) {
            int numberSearch= numbers[index];

            boolean isItBig = true;

            for (int indexSecond = 0; indexSecond <numbers.length ; indexSecond++) {

                int number = numbers[indexSecond];

                if(numberSearch <= number){
                    isItBig=false;
                }
            }

                if(isItBig){
                    System.out.println(numberSearch);
                }
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