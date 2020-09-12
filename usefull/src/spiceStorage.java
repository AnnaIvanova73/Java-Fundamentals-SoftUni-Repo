import java.util.Scanner;

public class spiceStorage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int yieldMinedMax = Integer.parseInt(scan.nextLine());

        int daysMining = 0;
        int spiceStorage = 0;

        while (yieldMinedMax > 99) {

            spiceStorage += yieldMinedMax - 26;
            yieldMinedMax -= 10;

            daysMining += 1;
        }

        if (yieldMinedMax > 26 && daysMining > 0 ){
            spiceStorage-=26;
        }

        System.out.printf("%d\n%d",daysMining,spiceStorage);

    }
}
