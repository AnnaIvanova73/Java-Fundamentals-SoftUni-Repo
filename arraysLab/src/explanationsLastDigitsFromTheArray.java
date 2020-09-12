import java.util.Scanner;

public class explanationsLastDigitsFromTheArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = new int[10];

        numbers[numbers.length - 1] = 42; // достъпвам последния елемент и му давам стойност 42;
        int num = numbers[numbers.length - 2]; //давам на променлива стойността на предпоследния елемент от масива.

        for (int i = 1; i <= 5; i++) {
            //  numbers [numbers.length - i]= 42; първия път достъпва последния символ и го прави на 42
            // и така до последния пети символ и им дава стойност
            System.out.println(numbers[numbers.length - i]);// ще изпринтира последните пет елемента
        }

        System.out.println(numbers[0]);//изпринтирай нулевия индекс, тоест първия елемент от масива


        // int [] array = new int [5];
        // for () int[] num = new int [10]; array=num; Новия масив приема стария масив и освобождаваме паметта от него
        
        int [] array = new int[5];
        for (int i = 0; i <array.length ; i++) {
            int[] nums = new int [10]; //nums масиви се зачиства във for цикъла, но array масива запасва стойностите на
            //променливите му
            array=nums;
        }


    }
}
