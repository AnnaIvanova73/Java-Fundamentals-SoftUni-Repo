import java.util.Scanner;
public class explanationScope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] numbers ; //декларирам, че ще имам масив с име Numbers.
        numbers= new int[n]; // инициализирам масив int и му дава стойност прочетена от конзолата n;
        // стани равен на нов Int от елементи n // размера на масива е n  и е фиксиран не може да се променя.

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scan.nextInt();
        }
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }
    //    numbers = new int[3];//стани равен на нов int от три елемента,
   //     System.out.println(numbers[1]);// и изпринтирай първия индекс,тоест първия елемент - от първия деклариран масив
        //стойността ще е никаква, защото стойността не се пренася output = 0

        int [] oldNumbers = numbers;
        numbers = new int [10];

        //вариант едно
//        for (int j = 0; j < numbers.length ;j++) { // ако е по малко саммо от новия масит
//            //ako n e три ще се опитам да достъпя елемент извън размера на масив
//            //голям на брой пъти
//            numbers[j]=oldNumbers[j];
//            System.out.println(numbers[j]); // гърми с грешка
//            //java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
//        }

        for (int j = 0; j < numbers.length && j < oldNumbers.length ;j++) { //за да спре до по-малкото от двете
            numbers[j]=oldNumbers[j];
            System.out.println(numbers[j]);
        }
        //вариант две
        for (int j = 0; j < Math.min(numbers.length, oldNumbers.length) ;j++) { // ако е по малко от стария и от новия масит
            //за да спре до по-малкото от двете
            numbers[j]=oldNumbers[j];
            System.out.println(numbers[j]);
        }



    }
}


