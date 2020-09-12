import java.util.Scanner;

public class Task_1_GiftBoxCoverage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double sizeSide = Double.parseDouble(scan.nextLine());
        int countSheetsPaper = Integer.parseInt(scan.nextLine());
        double sheetsCoverage = Double.parseDouble(scan.nextLine());

        double areaGiftBox = (sizeSide * sizeSide) * 6;

        double countEveryThirdSheet = Math.floor(countSheetsPaper * 1.0 / 3);
        countSheetsPaper -= countEveryThirdSheet;
        double sheetsStandardCover = countSheetsPaper * sheetsCoverage;

        double percentAreaThirdSheets = sheetsCoverage * 0.25;
        double thirdListCoverage = countEveryThirdSheet * percentAreaThirdSheets;

        double coverage = sheetsStandardCover + thirdListCoverage;

        double percentBoxCover = coverage / areaGiftBox * 100;

        System.out.printf("You can cover %.2f%% of the box.", percentBoxCover);
    }
}