import java.util.Scanner;

public class ninthEqualSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int[] arr = inputToArrayNumbers(input);


        int num = -1;
        for (int i = 0; i < arr.length; i++) {
            int rightSum = 0;
            int leftSum = 0;


            // right Indexes
            for (int j = i + 1; j < arr.length; j++) {
                rightSum += arr[j];
            }
            //left Indexes
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            if (leftSum == rightSum) {
                num = i;
                break;

            }

        }
        if(num != -1){
            System.out.println(num);
        }else {
            System.out.println("no");
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
