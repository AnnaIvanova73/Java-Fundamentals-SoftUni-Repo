import java.util.Scanner;

public class EqualSumCoolCode {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        int[] arrNum = new int [input.length];

        for (int i = 0; i <arrNum.length ; i++) {
            arrNum[i]=Integer.parseInt(input[i]);
        }

        int index = -1;
        for (int i = 0; i < arrNum.length ; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int left = i - 1; left >=0 ; left--) {
                leftSum+= arrNum[left];
            }

            for (int right = i + 1; right < arrNum.length ; right++) {
                rightSum+=arrNum[right];
            }


            if(leftSum==rightSum){
                index=i;
            }
        }
        if(index != -1){
            System.out.println(index);
        } else {
            System.out.println("no");
        }
    }
}
