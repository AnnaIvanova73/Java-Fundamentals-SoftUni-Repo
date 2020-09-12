import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Мога ли да ползвам трети масив за принтирането, как?
        String[] firstArr = scan.nextLine().split(" ");
        String[] secondArr = scan.nextLine().split(" ");


        for (int i = 0; i < firstArr.length ; i++) {
            String compareElement = firstArr[i];

            for (int j = 0; j < secondArr.length ; j++) {
                String secondCompareElements = secondArr[j];
                if (compareElement.equals(secondCompareElements)){
                    System.out.print(secondCompareElements + " ");
                }
            }
        }

    }
}
