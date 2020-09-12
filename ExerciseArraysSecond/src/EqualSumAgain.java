import java.util.Scanner;

public class EqualSumAgain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String[] input = scan.nextLine().split(" ");

        int[] arrNum = new int [input.length];

        for (int i = 0; i <arrNum.length ; i++) {
            arrNum[i]=Integer.parseInt(input[i]);
        }

        boolean hasEqual = false;

        for (int indexInitial = 0; indexInitial < arrNum.length ; indexInitial++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int numbersOnIndexLeft = 0; numbersOnIndexLeft < indexInitial ; numbersOnIndexLeft++) {
                leftSum+=arrNum[numbersOnIndexLeft];
            }

            for (int indexRightNumbers = indexInitial + 1; indexRightNumbers < arrNum.length ; indexRightNumbers++) {
                rightSum+=arrNum[indexRightNumbers];
            }


            if(leftSum==rightSum){
                System.out.println(indexInitial);
                hasEqual=true;
                break;
            }
        }

        if(!hasEqual){
            System.out.println("no");
        }

    }
}
