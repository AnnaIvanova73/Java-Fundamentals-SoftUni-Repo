import java.util.Scanner;

public class rageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //•	On the first input line - lost games count – integer in the range [0, 1000].
        //•	On the second line – headset price - floating point number in range [0, 1000].
        //•	On the third line – mouse price - floating point number in range [0, 1000].
        //•	On the fourth line – keyboard price - floating point number in range [0, 1000].
        //•	On the fifth line – display price - floating point number in range [0, 1000].
        int lostGamesPrice = Integer.parseInt(scan.nextLine());
        double headsetPrice = Double.parseDouble(scan.nextLine());
        double mousePrice = Double.parseDouble(scan.nextLine());
        double keyboardPrice = Double.parseDouble(scan.nextLine());
        double displayPrice = Double.parseDouble(scan.nextLine());


        double costOfRage = 0;
        int headsetBreaks = 0;
        int mouseBreaks = 0;
        int keyboardBreaks = 0;
        int displayBreaks = 0;

        for (int i = 1; i <= lostGamesPrice; i++) {

            if (i % 2 == 0) {
                headsetBreaks += 1;
            }
            if (i % 3 == 0) {
                mouseBreaks += 1;
            }
            if (i % 6 == 0) {
                keyboardBreaks += 1;
            }
            if (i % 12 == 0) {
                displayBreaks += 1;
            }
        }
        costOfRage = headsetBreaks * headsetPrice + mouseBreaks * mousePrice
                + keyboardBreaks * keyboardPrice + displayBreaks * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.",costOfRage);
    }
}
