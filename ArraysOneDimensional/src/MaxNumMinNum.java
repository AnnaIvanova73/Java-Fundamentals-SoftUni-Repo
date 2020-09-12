import java.util.Scanner;

public class MaxNumMinNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input = Integer.parseInt(scan.nextLine());
        int[] numbers = new int[input];

        for (int index = 0; index<numbers.length;index++){
            numbers[index]=Integer.parseInt(scan.nextLine());
        }
       // int[] numbers = new int []{1,2,3,4};

        if(numbers.length  > 0){
            //само когато масива има стойности
        int min = numbers[0];//5
        for (int num:numbers){
            if (num < min){//6 5 ==5
                min=num;
            }
        }

        }else{
            System.out.println("noElements");
        }

        if (numbers.length >0){
            int max = numbers[0];//5
            for (int num :numbers){
                if(num > max){//6 5 ==6
                    max=num;
                }
            }

        }else{
            System.out.println("no elements");
        }
    }
}
