import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countWagons = Integer.parseInt(scan.nextLine());

        int[] arrPeople = new int [countWagons];

        int sumAllPeople = 0;
        for (int i = 0; i < arrPeople.length ; i++) {
            arrPeople[i] = Integer.parseInt(scan.nextLine());
            sumAllPeople+=arrPeople[i];
        }

        for (int arrPerson : arrPeople) {
            System.out.print(arrPerson + " ");
        }
        System.out.println();
        System.out.println(sumAllPeople);
    }
}
