import java.util.Scanner;

public class explanationsArraysVsVariablesAuto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] numbers = new int[n]; // запазва числата при прочитане в себе си./динамична памет

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scan.nextInt();// четем и запазваме
        }
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.println(numbers[i]);// принтираме на обратно запазеното
        }


        int num = Integer.parseInt(scan.nextLine());// не може да запази числата// стекова памет
        //Мога да прочета числа наобратно или не и директно да ги принтирам, но не мога  прочетените вече числа
        // да ги обърна, защото не ги пазя никъде.
        for (int i = 0; i < num; i++) {
            System.out.println(i + "от нула");
        }

        for (int i = 1; i <= num; i++) {
            System.out.println(i + "от една");
        }

        for (int i = num; i > 0; i--) {
            System.out.println(i + "от числото до като е по- голяма от нула");
        }
        for (int i = num; i >= 1; i--) {
            System.out.println(i + "от числото до като е по- голяма от 1");
        }
    }
}
