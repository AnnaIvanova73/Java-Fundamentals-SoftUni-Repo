import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputLine = scan.nextLine().split(" ");
        //String element= inputLine[2];
        int[] numbersArr = new int [inputLine.length];

        for (int i = 0; i < numbersArr.length ; i++) {
            numbersArr[i]=Integer.parseInt(inputLine[i]);
        }
       // System.out.println(numbersArr [3]);

        int rotations = Integer.parseInt(scan.nextLine());
        rotations= rotations % numbersArr.length;

        for (int i = 0; i <rotations; i++) {
            int saveSymbolsAtIndexZero = numbersArr[0];

            for (int j = 0; j <numbersArr.length - 1 ; j++) {// минус, защото презаписвам стойности,
                // не мога да презапиша стойността на несъществуваш Index
                numbersArr[j] = numbersArr[j + 1];
            }

            numbersArr[numbersArr.length-1] = saveSymbolsAtIndexZero;
        }
        for (int elements:numbersArr) {
            System.out.print(elements+ " ");
        }
    }
}
