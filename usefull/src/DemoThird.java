import java.util.Scanner;

public class DemoThird {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        int number = Integer.parseInt(scan.nextLine());//само стринг чете, символ по символ,
//        // като парснеш едно число,прочето от конзолата, то е просто един Index, една позиция, която дава размер,
//        // на инт масиви, защото го разпознава, като число
//
//        int[] numbersElement = new int[number];
//
//        for (int i = 0; i <numbersElement.length ; i++) {
//            numbersElement[i] = scan.nextInt();
//            numbersElement[i]=Integer.parseInt(scan.nextLine());
//            // за да напълниш,един масив със символи,подавани на един по един от конзолата
//            // Винаги четеш едно число от конзола,не няколко
//        }


        int num = 3;

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j + " ");
            }
                System.out.println();
        }

    }
}
